package Model;

import java.util.ArrayList;
import java.util.List;

public class GamingGroup {

    private int groupId;
    private String groupName;
    private List<Player> players = new ArrayList<Player>();

    public GamingGroup(String groupName, List<Player> players){
        this.groupName = groupName;
        this.players = players;
    }

    public GamingGroup(int groupId){
        this.groupId = groupId;
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

}
