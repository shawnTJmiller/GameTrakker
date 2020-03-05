package Model;

import java.util.ArrayList;
import java.util.List;

public class GamingGroup {

    private int groupId;
    private String groupName;
    private List<Player> players = new ArrayList<Player>();
    Player player = new Player();

    public GamingGroup(String groupName, List<Player> players){
        this.groupName = groupName;
        this.players = players;
    }

    public GamingGroup(Player player){
        this.player = player;
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

    public List<Player> addNewPlayer() {
        Player newPlayer = new Player();
        players.add(newPlayer);
        return players;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
