package xiamomc.survivalcompetition.Careers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public abstract class AbstractCareer
{
    /**
     * 应用职业效果到玩家
     * @param playerName 目标玩家名
     * @return 是否成功
     */
    public Boolean ApplyToPlayer(String playerName)
    {
        return ApplyToPlayer(Bukkit.getPlayer(playerName));
    }

    /**
     * 应用职业效果到玩家
     * @param player 目标玩家
     * @return 是否成功
     */
    public Boolean ApplyToPlayer(Player player)
    {
        return player != null;
    }

    /**
     * 移除某一玩家的职业效果
     * @param playerName 目标玩家名
     * @return 是否成功
     */
    public Boolean ResetFor(String playerName) { return ResetFor(Bukkit.getPlayer(playerName)); }

    /**
     * 移除某一玩家的职业效果
     * @param player 目标玩家
     * @return 是否成功
     */
    public Boolean ResetFor(Player player) { return player != null; }

    /**
     * 获取这一职业的显示文本
     * @return 用来显示的文本
     */
    public Component GetNameAsComponent()
    {
        return careerNameAsComponent;
    }

    /**
     * 初始化职业
     */
    protected void Initialize()
    {
        careerNameAsComponent = Component.text(DisplayName).style(b ->
                b.decorate(TextDecoration.BOLD)
                 .decorate(TextDecoration.UNDERLINED)
                 .color(TextColor.color(16755200))
                 .hoverEvent(HoverEvent.showText(Component.text(Description)))
                 .clickEvent(ClickEvent.runCommand("/setcareer" + " " + InternalName))
        );
    }

    /**
     * 职业的显示名
     */
    protected String DisplayName = "Dummy";

    private Component careerNameAsComponent;

    /**
     * 职业的内部名<br>
     * PS: 为方便从其他地方从GetInternalName获取设置为了static
     */
    protected static String InternalName = "dummy";

    /**
     * 获取职业的内部名<br>
     * PS: 不要直接调用AbstractCareer.GetInternalNameStatic()，请使用xxx.GetInternalNameStatic()<br>
     * PSS: 如果可以，请优先使用GetInternalName()
     * @return 职业的内部名
     */
    public static String GetInternalNameStatic() { return InternalName; }

    /**
     * 获取职业的内部名
     * @return 职业的内部名
     */
    public String GetInternalName() { return InternalName; }

    /**
     * 职业描述
     */
    protected String Description = "虚拟职业";
}
