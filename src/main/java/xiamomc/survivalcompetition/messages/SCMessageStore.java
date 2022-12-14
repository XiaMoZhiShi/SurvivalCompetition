package xiamomc.survivalcompetition.messages;

import xiamomc.pluginbase.Messages.IStrings;
import xiamomc.pluginbase.Messages.MessageStore;
import xiamomc.survivalcompetition.SurvivalCompetition;

import java.util.ArrayList;
import java.util.List;

public class SCMessageStore extends MessageStore
{
    private static SCMessageStore instance;

    public static SCMessageStore getInstance()
    {
        return instance;
    }

    public SCMessageStore()
    {
        instance = this;
    }

    private final List<Class<IStrings>> cachedClassList = new ArrayList<>();

    private final List<Class<?>> rawClassList = List.of(
            CommandStrings.class
    );

    @Override
    protected List<Class<IStrings>> getStrings()
    {
        if (cachedClassList.size() == 0)
        {
            rawClassList.forEach(c -> cachedClassList.add((Class<IStrings>) c));
        }

        return cachedClassList;
    }

    @Override
    protected String getPluginNamespace()
    {
        return SurvivalCompetition.instance.getNameSpace();
    }
}
