package Model.DAO;

import Model.Game;
import Model.GamingGroup;
import Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JDBCGamingGroupDAO implements GamingGroupDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCGamingGroupDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createNewGroup(String groupName, Player player) {
        GamingGroup group = new GamingGroup();

        jdbcTemplate.update("INSERT INTO gaming_group (group_name) VALUES ?;" +
                "INSERT INTO player_group (group_id, player_id) VALUES (?, ?)", groupName, group.getGroupId(), player.getPlayerId() );
    }

    @Override
    public List<GamingGroup> getGroupsByUserName(String userName) {
        String sqlSearchForGroups = "SELECT g.group_name " +
                "FROM gaming_group gg " +
                "INNER JOIN player_group pg ON gg.group_id = pg.group_id" +
                "INNER JOIN player p ON pg.player_id = p.player_id" +
                "WHERE user_name = ?;";
        SqlRowSet groups = jdbcTemplate.queryForRowSet(sqlSearchForGroups, userName);
        List<GamingGroup> activeGroups = new ArrayList<>();
        GamingGroup thisGroup = null;
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
                "WHERE group_name = ?;";
        SqlRowSet players = jdbcTemplate.queryForRowSet(sqlSearchForPlayers, groupName);
        List<Player> groupMembers = new ArrayList<>();
        Player thisPlayer = null;
        while (players.next()) {
            thisPlayer = new Player();
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
    public Set<Game> getGamesByGroup(String groupName) {
        String sqlGetListOfGames = "SELECT gm.name " +
                "FROM game gm " +
                "INNER JOIN player_inventory pi ON gm.game_id = pi.game_id " +
                "INNER JOIN player p ON p.player_id = pi.player_id " +
                "INNER JOIN player_group pg ON pg.player_id = p.player_id " +
                "INNER JOIN gaming_group gg ON pg.group_id = gg.group_id " +
                "WHERE group_name = ?;";
        SqlRowSet games = jdbcTemplate.queryForRowSet(sqlGetListOfGames, groupName);
        Set<Game> groupGames = new HashSet<>();
        Game thisGame = null;
        while (games.next()) {
            thisGame = new Game();
            thisGame.setGameId(games.getInt("game_id"));
            thisGame.setName(games.getString("name"));
            thisGame.setMinPlayers(games.getInt("min_num_players"));
            thisGame.setMaxPlayers(games.getInt("max_num_players"));
            thisGame.setMinTime(games.getInt("min_play_time"));
            thisGame.setMaxTime(games.getInt("max_play_time"));
            thisGame.setAgesUp(games.getInt("recommended_age_min"));
            thisGame.setGenre(games.getString("genre"));
            thisGame.setSubGenre(games.getString("sub_genre"));
            thisGame.setHasDice(games.getBoolean("has_dice"));
            thisGame.setHasCards(games.getBoolean("has_cards"));
            thisGame.setHasBoard(games.getBoolean("has_board"));
            thisGame.setHasTiles(games.getBoolean("has_tiles"));
            thisGame.setHasFigurines(games.getBoolean("has_figurines"));
            thisGame.setHasTimer(games.getBoolean("has_timer"));
            groupGames.add(thisGame);
        }
        return groupGames;
    }

    @Override
    public void addPlayerToGroup(String userName, String groupName) {
        String sqlNewPlayerAdd = "INSERT INTO player_group (player_id, group_id) VALUES (" +
                "(SELECT player_id FROM player WHERE user_name = ?), " +
                "(SELECT group_id FROM gaming_group WHERE group_id = ?)" +
                ");";
        jdbcTemplate.update(sqlNewPlayerAdd, userName, groupName);
    }

    @Override
    public void removePlayerFromGroup(String userName, String groupName) {
        jdbcTemplate.update("DELETE * " +
                            "FROM player_group " +
                            "WHERE player_id = " +
                                "(SELECT player_id FROM player WHERE user_name = ?)" +
                            "AND group_id = " +
                                "(SELECT group_id FROM gaming_group WHERE group_name = ?);",
                userName, groupName);
    }

    @Override
    public void deleteGamingGroup(String groupName) {
        jdbcTemplate.update("DELETE * " +
                            "FROM player_group " +
                            "WHERE group_id = " +
                                "(SELECT group_id FROM gaming_group WHERE group_name = ?);" +
                            "DELETE * " +
                            "FROM gaming_group " +
                            "WHERE group_id = " +
                                "(SELECT group_id FROM gaming_group WHERE group_name = ?);",
                 groupName, groupName);
    }
}
