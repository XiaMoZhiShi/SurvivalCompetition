package xiamomc.survivalcompetition.managers;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xiamomc.survivalcompetition.careers.AbstractCareer;

import java.util.List;

public interface ICareerManager
{
    /**
     * 获取职业列表
     *
     * @return 职业列表
     */
    List<AbstractCareer> getCareerList();

    /**
     * 清空所有玩家的职业
     */
    void clear();

    /**
     * 添加某一玩家到职业中
     *
     * @param playerName   目标玩家名
     * @param identifier 职业的ID
     * @return 添加过程是否成功
     */
    boolean applyCareerFor(String playerName, NamespacedKey identifier);

    /**
     * 获取某一玩家的职业
     *
     * @param player 目标玩家
     * @return 职业信息（可能返回null）
     */
    @Nullable
    AbstractCareer getPlayerCareer(Player player);
}
