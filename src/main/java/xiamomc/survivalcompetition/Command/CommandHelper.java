package xiamomc.survivalcompetition.Command;

import org.bukkit.Bukkit;
import xiamomc.survivalcompetition.Annotations.Initializer;
import xiamomc.survivalcompetition.Misc.PluginObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CommandHelper extends PluginObject
{
    public CommandHelper()
    {
        commands = new ArrayList<IPluginCommand>(Arrays.asList(
                new JoinGameCommand(),
                new CareerCommand(),
                new GMCommand()
        ));
    }

    private final ArrayList<IPluginCommand> commands;

    @Initializer
    private void initializeCommands()
    {
        for (var c : commands)
        {
            if (!this.registerCommand(c))
                Logger.error("未能注册指令：" + c.getCommandName());
        }
    }

    public boolean registerCommand(IPluginCommand command)
    {
        if (Objects.equals(command.getCommandName(), ""))
            return false;

        var cmd = Bukkit.getPluginCommand(command.getCommandName());
        if (cmd != null && cmd.getExecutor() == Plugin)
        {
            cmd.setExecutor(command);
            return true;
        }
        else
            return false;
    }
}
