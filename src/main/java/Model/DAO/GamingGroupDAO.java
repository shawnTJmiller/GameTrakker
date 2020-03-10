package Model.DAO;

import Model.GamingGroup;
import Model.Player;

import java.util.List;

public interface GamingGroupDAO {
    GamingGroup createNewGroupSolo(String groupName, Player player);
    GamingGroup createNewGroupMulti(String groupName, List<Player> players);
    List<GamingGroup> getGroupsByUserName(String userName);
    List<Player> getPlayersByGroupName(String groupName);
    void addPlayerToGroup(Player player, GamingGroup group);
    void removePlayerFromGroup(Player player, GamingGroup group);
    void deleteGamingGroup(GamingGroup group);
}
