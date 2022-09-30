package xiamomc.survivalcompetition.Managers;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerListManager implements IPlayerListManager
{
    private static final List<Player> playerList = new ArrayList<>();

    @Override
    public List<Player> getList()
    {
        return playerList;
    }

    @Override
    public boolean add(Player player)
    {
        if (player == null) return false;

        return playerList.add(player);
    }

    @Override
    public boolean remove(Player player)
    {
        if (player == null) return false;

        return playerList.remove(player);
    }

    @Override
    public boolean contains(Player player)
    {
        return playerList.contains(player);
    }

    @Override
    public boolean checkExistence()
    {
        playerList.removeIf(p -> !p.isOnline());
        return true;
    }

    @Override
    public boolean isEmpty()
    {
        return playerList.isEmpty();
    }

    @Override
    public int listAmount()
    {
        return playerList.size();
    }

    @Override
    public boolean clear()
    {
        playerList.clear();
        return true;
    }
}