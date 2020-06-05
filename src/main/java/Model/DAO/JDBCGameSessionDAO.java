package Model.DAO;

import Model.Game;
import Model.GameSession;
import Model.PlaySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCGameSessionDAO implements GameSessionDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCGameSessionDAO(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    @Override
    public void startNewGameSession(PlaySession session, Game game, String gameSelectionType) {
        String newSqlRow = "INSERT INTO game_session (session_id, game_id, game_selection_type) VALUES (?,?,?);";
        jdbcTemplate.update(newSqlRow, session.getSessionId(), game.getGameId(), gameSelectionType);
    }

    @Override
    public List<GameSession> getGameSessionByGame(Game game) {
        String getSessionsByGame = "SELECT * FROM game_session WHERE game_id = ?;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(getSessionsByGame, game.getGameId());
        List<GameSession> sessionsWithGameX = new ArrayList<>();
        GameSession thisSession;
        while (sessions.next()) {
            thisSession = new GameSession();
            thisSession.setGameSessionId(sessions.getInt("game_session_id"));
            thisSession.setPlaySessionId(sessions.getInt("session_id"));
            thisSession.setGameId(sessions.getInt("game_id"));
            thisSession.setGameSelectionType(sessions.getString("game_selection_type"));
            sessionsWithGameX.add(thisSession);
        }
        return sessionsWithGameX;
    }

    @Override
    public List<GameSession> getGameSessionBySelectionType(String gameSelectionType) {
        String sqlGetSessionsBySelection = "SELECT * FROM game_session WHERE game_selection_type = ?;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlGetSessionsBySelection, gameSelectionType);
        List<GameSession> sessionsBySelection = new ArrayList<>();
        GameSession thisSession;
        while (sessions.next()) {
            thisSession = new GameSession();
            thisSession.setGameSessionId(sessions.getInt("game_session_id"));
            thisSession.setPlaySessionId(sessions.getInt("session_id"));
            thisSession.setGameId(sessions.getInt("game_id"));
            thisSession.setGameSelectionType(sessions.getString("game_selection_type"));
            sessionsBySelection.add(thisSession);
        }
        return sessionsBySelection;
    }

    @Override
    public void updateGameSession(GameSession gameSession) {
        jdbcTemplate.update("BEGIN TRANSACTION; UPDATE game_session SET session_id = ?, game_id = ?, game_selection_type = ?; COMMIT;" +
                "WHERE game_session_id = ?;", gameSession.getPlaySessionId(), gameSession.getGameId(), gameSession.getGameSelectionType(),
        gameSession.getGameSessionId());
    }

    @Override
    public void deleteGameSession(GameSession gameSession) {
        jdbcTemplate.update("DELETE * FROM game_session WHERE game_session_id = ?;", gameSession.getGameSessionId());
    }
}
