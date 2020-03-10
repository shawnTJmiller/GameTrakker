package Model;

import java.util.ArrayList;
import java.util.List;

public class GamingGroup {

    private int groupId;
    private String groupName;
    private List<Player> players = new ArrayList<>();

    public GamingGroup(String groupName, List<Player> players){
        this.groupName = groupName;
        this.players = players;
    }

    public GamingGroup(String groupName, Player player){
        this.groupName = groupName;
        addNewPlayer(player);
    }

    public GamingGroup() {
    }

    public int getGroupId() {
        return groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> addNewPlayer(Player player) {
        this.players.add(player);
        return players;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
