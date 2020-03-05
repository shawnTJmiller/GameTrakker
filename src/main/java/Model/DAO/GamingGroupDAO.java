package Model.DAO;

import Model.Game;
import Model.GamingGroup;
import Model.Player;

import java.util.List;
import java.util.Set;

public interface GamingGroupDAO {
    public void createNewGroup(String groupName, Player player);
    public List<GamingGroup> getGroupsByUserName(String userName);
    public List<Player> getPlayersByGroupName(String groupName);
    public Set<Game> getGamesByGroup(String groupName);
    public void addPlayerToGroup(String userName, String groupName);
    public void removePlayerFromGroup(String userName, String groupName);
    public void deleteGamingGroup(String groupName);
}
