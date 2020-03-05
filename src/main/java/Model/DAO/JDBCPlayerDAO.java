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
    public void savePlayer(int playerId, String firstName) {
        jdbcTemplate.update("INSERT INTO player(first_name) VALUES(?)", firstName);
    }

    @Override
    public Object getPlayerByPlayerId(int playerId) {
        String sqlSearchForPlayerId = "SELECT * FROM player WHERE playerId = ?";
        SqlRowSet player = jdbcTemplate.queryForRowSet(sqlSearchForPlayerId, playerId);
        Player thisPlayer = null;
        if (player.next()) {
            thisPlayer = new Player();
            thisPlayer.getFirstName(player.getString("first_name"));
            thisPlayer.getLastName(player.getString("last_name"));
            thisPlayer.getNickName(player.getString("nick_name"));
            thisPlayer.getAge(player.getInt("age"));
        }
        return thisPlayer;
    }

    @Override
    public Object getPlayerByFirstName(String firstName) {
        String sqlSearchForFirstName = "SELECT first_name FROM player WHERE first_name = ?";
        SqlRowSet player = jdbcTemplate.queryForRowSet(sqlSearchForFirstName, firstName);
        Player thisPlayer = null;
        if (player.next()) {
            thisPlayer = new Player();
            thisPlayer.getFirstName(player.getString("first_name"));
            thisPlayer.getLastName(player.getString("last_name"));
            thisPlayer.getNickName(player.getString("nick_name"));
            thisPlayer.getAge(player.getInt("age"));
        }
        return thisPlayer;
    }

    @Override
    public void updatePlayer(String lastName, String nickName, int age, int playerId) {
        jdbcTemplate.update("UPDATE player SET last_name = ?, nick_name = ?, age = ? WHERE playerId = ?",
                lastName, nickName, age, playerId);
    }

    @Override
    public void removePlayerByPlayerId(int playerId) {
        jdbcTemplate.update("DELETE * FROM player_group WHERE player_id = ?;"
                    + "DELETE * FROM player_inventory WHERE player_id = ?;"
                    + "DELETE * FROM player_game_session WHERE player_id = ?;"
                    + "DELETE * FROM player WHERE player_id = ?;",
                playerId, playerId, playerId, playerId, playerId);
    }

    public void removePlayerByUserName(String userName) {
        jdbcTemplate.update("DELETE * FROM player_group WHERE player_id = " +
                                "(SELECT player_id FROM player WHERE user_name = ?);" +
                            "DELETE * FROM player_inventory WHERE player_id = " +
                                "(SELECT player_id FROM player WHERE user_name = ?);" +
                            "DELETE * FROM player_game_session WHERE player_id = " +
                                "(SELECT player_id FROM player WHERE user_name = ?);" +
                            "DELETE * FROM player WHERE user_name = ?;",
                userName, userName, userName, userName, userName);
    }
}
