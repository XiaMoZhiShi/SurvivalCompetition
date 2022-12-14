package xiamomc.survivalcompetition.commands;

import xiamomc.pluginbase.Command.SubCommandHandler;
import xiamomc.survivalcompetition.SurvivalCompetition;

public abstract class SCSubCommandHandler extends SubCommandHandler<SurvivalCompetition>
{
    @Override
    protected String getPluginNamespace()
    {
        return SurvivalCompetition.getSCNameSpace();
    }
}
