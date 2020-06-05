package Model.DAO;

import Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCPlayerGameSessionDAO implements PlayerGameSessionDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCPlayerGameSessionDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //records the SqlRowSet Data into list
    List<PlayerGameSession> recordData(SqlRowSet sessions) {
        List<PlayerGameSession> recordedSessions = new ArrayList<>();
        PlayerGameSession thisSession;
        while(sessions.next()) {
            thisSession = new PlayerGameSession();
            thisSession.setStanding(sessions.getInt("standing"));
            thisSession.setScore(sessions.getInt("score"));
            thisSession.setPoints(sessions.getInt("points"));
            thisSession.setChoseGame(sessions.getBoolean("chose_game"));
            thisSession.setOnTeam(sessions.getBoolean("on_team"));
           recordedSessions.add(thisSession);
        }
        return recordedSessions;
    }

    @Override
    public void createNewPlayerGameSession(Player player, GameSession gameSession, PlayerGameSession playerSession) {
        String newSqlRow = "INSERT INTO player_game_session (game_session_id, player_id, standing, points, score" +
                    "on_team, chose_game) VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(newSqlRow, gameSession.getGameSessionId(), player.getPlayerId(), playerSession.getStanding(), playerSession.getPoints(), playerSession.getScore(), playerSession.isOnTeam(), playerSession.didChooseGame());
    }

    @Override
    public List<PlayerGameSession> getAllGameSessionsByPlayer(Player player) {
        String sqlPlayerSessions = "SELECT * FROM player_game_session WHERE player_id = ?;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlPlayerSessions, player.getPlayerId());
        List<PlayerGameSession> playerSessions = recordData(sessions);

        return playerSessions;
    }

    @Override
    public List<PlayerGameSession> getGameSessionStandingsByGame(Player player, Game game) {
        String sqlPlayerSessions = "SELECT * FROM player_game_session pgs INNER JOIN game_session gs ON pgs.game_session_id = gs.game_session_id WHERE player_id = ? AND game_id = ?;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlPlayerSessions, player.getPlayerId(), game.getGameId());
        List<PlayerGameSession> playerSessions = recordData(sessions);

        return playerSessions;
    }

    @Override
    public int getTotalPlayerPoints(Player player) {
        String sqlPlayerPoints = "SELECT SUM(points) FROM player_game_session WHERE player_id = ?;";
        SqlRowSet totalPointCalc = jdbcTemplate.queryForRowSet(sqlPlayerPoints, player.getPlayerId());
        int playerPointTotal = totalPointCalc.getInt("SUM(points)");

        return playerPointTotal;
    }

    @Override
    public int getPlayerPointsByGroup(Player player, GamingGroup group) {
        String sqlPlayerGroupPoints = "SELECT SUM(points) FROM player_game_session pgs INNER JOIN player p ON pgs.player_id = p.player_id INNER JOIN player_group pg ON p.player_id = pg.player_id INNER JOIN gaming_group gg ON pg.group_id = gg.group_id WHERE player_id = ? AND group_id = ?;";
        SqlRowSet totalPointCalc = jdbcTemplate.queryForRowSet(sqlPlayerGroupPoints, player.getPlayerId(), group.getGroupId());
        int playerPointTotal = totalPointCalc.getInt("SUM(points)");
        return playerPointTotal;
    }

    @Override
    public List<PlayerGameSession> getAllSessionsWonByPlayer(Player player) {
        String sqlAllSessionsWon = "SELECT * FROM player_game_session WHERE player_id = ? AND standing = 1;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlAllSessionsWon, player.getPlayerId());
        List<PlayerGameSession> firstPlaceSessions = recordData(sessions);

        return firstPlaceSessions;
    }

    @Override
    public List<PlayerGameSession> getPlayerWinsWhenChosenGameTrue(Player player) {
        String sqlWonChosenGames = "SELECT * FROM player_game_session WHERE player_id = ? AND standing = 1 AND chose_game = true;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlWonChosenGames, player.getPlayerId());
        List<PlayerGameSession> chosenFirstPlace = recordData(sessions);

       return chosenFirstPlace;
    }

    @Override
    public void updatePlayerGameSession(Player player, PlayerGameSession playerSession, GameSession gameSession) {
    jdbcTemplate.update("BEGIN TRANSACTION; UPDATE player_game_session SET standing = ?, score = ?, points = ?, " +
            "chose_game = ?, on_team = ? WHERE player_id = ? AND game_session_id = ?; COMMIT;",
            playerSession.getStanding(), playerSession.getScore(), playerSession.getPoints(), playerSession.didChooseGame(), playerSession.isOnTeam(),
            player.getPlayerId(), gameSession.getGameSessionId());
    }

    @Override
    public void deletePlayerGameSessionById(Player player, GameSession gameSession) {
    jdbcTemplate.update("BEGIN TRANSACTION; DELETE * FROM player_game_session WHERE player_id = ? and game_session_id = ?;",
            player.getPlayerId(), gameSession.getGameSessionId());
    }
}
