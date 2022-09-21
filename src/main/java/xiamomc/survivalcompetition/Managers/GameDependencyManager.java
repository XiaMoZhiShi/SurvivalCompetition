package xiamomc.survivalcompetition.Managers;

import org.jetbrains.annotations.Nullable;
import xiamomc.survivalcompetition.Exceptions.DependencyAlreadyRegistedException;
import xiamomc.survivalcompetition.Exceptions.NullDependencyException;
import xiamomc.survivalcompetition.Misc.SingleInstanceObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameDependencyManager extends SingleInstanceObject
{
    //region 实例相关
    private static GameDependencyManager instance;
    public static GameDependencyManager GetInstance()
    {
        return instance;
    }

    public GameDependencyManager()
    {
        instance = this;
    }
    //endregion 实例相关

    //注册表
    private final Map<Class<?>, Object> registers = new ConcurrentHashMap<>();

    /**
     * 注册一个对象到依赖表中
     * @param obj 要注册的对象
     * @throws DependencyAlreadyRegistedException 该对象所对应的Class是否已被注册
     */
    public void Cache(Object obj) throws DependencyAlreadyRegistedException
    {
        CacheAs(obj.getClass(), obj);
    }

    /**
     * 将一个对象作为某个Class类型注册到依赖表中
     * @param classType 要注册的Class类型
     * @param obj 要注册的对象
     * @throws DependencyAlreadyRegistedException 是否已经注册过一个相同的classType了
     */
    public void CacheAs(Class<?> classType, Object obj) throws DependencyAlreadyRegistedException
    {
        synchronized (registers)
        {
            if (registers.containsKey(classType))
                throw new DependencyAlreadyRegistedException("已经注册过一个" + classType + "的依赖了");

            registers.put(classType, obj);
        }
    }

    /**
     * 反注册一个对象
     * @param obj 要反注册的对象
     * @return 是否成功
     */
    public Boolean UnCache(Object obj)
    {
        if (!registers.containsValue(obj))
            return false;

        registers.remove(obj.getClass(), obj);
        return true;
    }

    /**
     * 反注册所有对象
     */
    public void UnCacheAll()
    {
        registers.clear();
    }

    /**
     * 从依赖表获取classType所对应的对象
     * @param classType 目标Class类型
     * @return 找到的对象，返回null则未找到
     * @throws NullDependencyException 依赖未找到时抛出的异常
     */
    //todo: 实现类似于C#中 public T Get<T>(...) where T : object 的用法，这样获取之后就不用再cast一遍了
    public Object Get(Class<?> classType)
    {
        return this.Get(classType, true);
    }

    @Nullable
    public Object Get(Class<?> classType, boolean throwOnNotFound)
    {
        if (registers.containsKey(classType))
            return registers.get(classType);

        if (throwOnNotFound) throw new NullDependencyException("依赖的对象（" + classType + "）未找到");
        else return null;
    }
}
