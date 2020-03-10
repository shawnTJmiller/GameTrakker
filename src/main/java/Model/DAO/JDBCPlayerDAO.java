package Model.DAO;

import Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JDBCPlayerDAO implements PlayerDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCPlayerDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void savePlayer(int playerId, String userName) {
        jdbcTemplate.update("INSERT INTO player(first_name) VALUES(?)", userName);
    }

    @Override
    public Player getPlayerByPlayerId(int playerId) {
        String sqlSearchForPlayerId = "SELECT * FROM player WHERE playerId = ?";
        SqlRowSet player = jdbcTemplate.queryForRowSet(sqlSearchForPlayerId, playerId);
        Player thisPlayer = null;
        if (player.next()) {
            thisPlayer = new Player();
            thisPlayer.setUserName(player.getString("user_name"));
            thisPlayer.setFirstName(player.getString("first_name"));
            thisPlayer.setLastName(player.getString("last_name"));
            thisPlayer.setNickName(player.getString("nick_name"));
            thisPlayer.setAge(player.getInt("age"));
        }
        return thisPlayer;
    }

    @Override
    public Player getPlayerByUserName(String userName) {
        String sqlSearchForFirstName = "SELECT first_name FROM player WHERE user_name = ?";
        SqlRowSet player = jdbcTemplate.queryForRowSet(sqlSearchForFirstName, userName);
        Player thisPlayer = null;
        if (player.next()) {
            thisPlayer = new Player();
            thisPlayer.setUserName(player.getString("user_name"));
            thisPlayer.setFirstName(player.getString("first_name"));
            thisPlayer.setLastName(player.getString("last_name"));
            thisPlayer.setNickName(player.getString("nick_name"));
            thisPlayer.setAge(player.getInt("age"));
        }
        return thisPlayer;
    }

    @Override
    public void updatePlayer(Player player) {
        jdbcTemplate.update("UPDATE player SET first_name = ?, last_name = ?, nick_name = ?, age = ? WHERE playerId = ?",
                player.getFirstName(), player.getLastName(), player.getNickName(), player.getAge(), player.getPlayerId());
    }

    @Override
    public void deletePlayer(Player player) {
        jdbcTemplate.update("DELETE * FROM player_group WHERE player_id = ?;"
                    + "DELETE * FROM player_inventory WHERE player_id = ?;"
                    + "DELETE * FROM player_game_session WHERE player_id = ?;"
                    + "DELETE * FROM player WHERE player_id = ?;",
                player.getPlayerId(), player.getPlayerId(), player.getPlayerId(), player.getPlayerId(), player.getPlayerId());
    }

}
