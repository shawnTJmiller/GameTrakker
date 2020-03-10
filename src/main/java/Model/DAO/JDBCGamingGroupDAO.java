package Model.DAO;

import Model.GamingGroup;
import Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCGamingGroupDAO implements GamingGroupDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCGamingGroupDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public GamingGroup createNewGroupSolo(String groupName, Player player) {
        GamingGroup group = new GamingGroup(groupName, player);
        jdbcTemplate.update("INSERT INTO gaming_group (group_name) VALUES ?;" +
                "INSERT INTO player_group (group_id, player_id) VALUES ((SELECT group_id FROM gaming_group WHERE group_name = ?), ?)", groupName, groupName, player.getPlayerId());
        return group;
    }

    @Override
    public GamingGroup createNewGroupMulti(String groupName, List<Player> players) {
        GamingGroup group = new GamingGroup(groupName, players);
        jdbcTemplate.update("INSERT INTO gaming_group (group_name) VALUES ?;", groupName);
        for (Player player : players) {
            jdbcTemplate.update("INSERT INTO player_group (group_id, player_id) VALUES ((SELECT group_id FROM gaming_group WHERE group_name = ?), ?)", groupName, player.getPlayerId());
        }
        return group;
    }

    @Override
    public List<GamingGroup> getGroupsByUserName(String userName) {
        String sqlSearchForGroups = "SELECT gg.group_name " +
                "FROM gaming_group gg " +
                "INNER JOIN player_group pg ON gg.group_id = pg.group_id" +
                "INNER JOIN player p ON pg.player_id = p.player_id" +
                "WHERE user_name LIKE '%'?'%';";
        SqlRowSet groups = jdbcTemplate.queryForRowSet(sqlSearchForGroups, userName);
        List<GamingGroup> activeGroups = new ArrayList<>();
        GamingGroup thisGroup; // initialize as null
        while (groups.next()) {
            thisGroup = new GamingGroup();
            thisGroup.setGroupName(groups.getString("group_name"));
            thisGroup.setGroupId(groups.getInt("group_id"));
            activeGroups.add(thisGroup);
        }
        return activeGroups;
    }

    @Override
    public List<Player> getPlayersByGroupName(String groupName) {
        String sqlSearchForPlayers = "SELECT p.first_name, p.last_name " +
                "FROM player p " +
                "INNER JOIN player_group pg ON p.player_id = pg.player_id " +
                "INNER JOIN gaming_group gg ON pg.group_id = gg.group_id " +
                "WHERE group_name LIKE '%'?'%';";
        SqlRowSet players = jdbcTemplate.queryForRowSet(sqlSearchForPlayers, groupName);
        List<Player> groupMembers = new ArrayList<>();
        Player thisPlayer; // initialize as null
        while (players.next()) {
            thisPlayer = new Player();
            thisPlayer.setUserName(players.getString("user_name"));
            thisPlayer.setFirstName(players.getString("first_name"));
            thisPlayer.setLastName(players.getString("last_name"));
            thisPlayer.setNickName(players.getString("nick_name"));
            thisPlayer.setAge(players.getInt("age"));
            thisPlayer.setPlayerId(players.getInt("player_id"));
            groupMembers.add(thisPlayer);
        }
        return groupMembers;
    }

    @Override
    public void addPlayerToGroup(Player player, GamingGroup group) {
        String sqlNewPlayerAdd = "INSERT INTO player_group (player_id, group_id) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sqlNewPlayerAdd, player.getPlayerId(), group.getGroupId());

        group.addNewPlayer(player);
    }

    @Override
    public void removePlayerFromGroup(Player player, GamingGroup group) {
        jdbcTemplate.update("DELETE * FROM player_group " +
                        "WHERE player_id = ? AND group_id = ?;",
                player.getPlayerId(), group.getGroupId());
    }

    @Override
    public void deleteGamingGroup(GamingGroup group) {
        jdbcTemplate.update("DELETE * FROM player_group WHERE group_id = ?;" +
                        "DELETE * FROM gaming_group WHERE group_id = ?;",
                        group.getGroupId(), group.getGroupId());
    }
}
