package Model.DAO;

import Model.GamingGroup;
import Model.PlaySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCPlaySessionDAO implements PlaySessionDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCPlaySessionDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void startNewPlaySession(PlaySession session, GamingGroup group) {
        String newSqlRow = "INSERT INTO play_session (session_name, session_date, session_location, has_prize, group_id) " +
                "VALUES (?,?,?,?,?);";
        jdbcTemplate.update(newSqlRow, session.getSessionName(), session.getSessionDate(), session.getSessionLocation(),
                session.isHasPrize(), group.getGroupId());
        if (session.isHasPrize()) {
            String newPrizeEntry = "INSERT INTO play_session (prize, money_prize) Values (?,?);";
            jdbcTemplate.update(newPrizeEntry, session.getPrize(), session.getMoneyPrize());
        }
    }

    @Override
    public List<PlaySession> getPlaySessionsByGroup(GamingGroup group) {
        String sqlGetGroupSessions = "SELECT * FROM play_session WHERE group_id = ?;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlGetGroupSessions, group.getGroupId());
        List<PlaySession> groupSessions = new ArrayList<>();
        PlaySession thisSession; // initialize as null
        while (sessions.next()) {
            thisSession = new PlaySession();
            thisSession.setSessionId(sessions.getInt("session_id"));
            thisSession.setSessionName(sessions.getString("session_name"));
            thisSession.setSessionDate(sessions.getDate("session_date").toLocalDate());
            thisSession.setSessionLocation(sessions.getString("session_location"));
            thisSession.setHasPrize(sessions.getBoolean("has_prize"));
            thisSession.setPrize(sessions.getString("prize"));
            thisSession.setMoneyPrize(sessions.getBigDecimal("money_prize"));
            thisSession.setGroupId(sessions.getInt("group_id"));
            groupSessions.add(thisSession);
        }
        return groupSessions;
    }

    @Override
    public List<PlaySession> getPlaySessionsByLocation(String sessionLocation) {
        String sqlGetLocationSessions = "SELECT * FROM play_session WHERE session_location LIKE '%'?'%';";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlGetLocationSessions, sessionLocation);
        List<PlaySession> locationSessions = new ArrayList<>();
        PlaySession thisSession; // initialize as null
        while (sessions.next()) {
            thisSession = new PlaySession();
            thisSession.setSessionId(sessions.getInt("session_id"));
            thisSession.setSessionName(sessions.getString("session_name"));
            thisSession.setSessionDate(sessions.getDate("session_date").toLocalDate());
            thisSession.setSessionLocation(sessions.getString("session_location"));
            thisSession.setHasPrize(sessions.getBoolean("has_prize"));
            thisSession.setPrize(sessions.getString("prize"));
            thisSession.setMoneyPrize(sessions.getBigDecimal("money_prize"));
            thisSession.setGroupId(sessions.getInt("group_id"));
            locationSessions.add(thisSession);
        }
        return locationSessions;
    }

    @Override
    public List<PlaySession> getPlaySessionsByDate(LocalDate date) {
        String sqlGetSessionsByDate = "SELECT * FROM play_session WHERE session_date = ?;";
        SqlRowSet sessions = jdbcTemplate.queryForRowSet(sqlGetSessionsByDate, date);
        List<PlaySession> dateSessions = new ArrayList<>();
        PlaySession thisSession; // initialize as null
        while (sessions.next()) {
            thisSession = new PlaySession();
            thisSession.setSessionId(sessions.getInt("session_id"));
            thisSession.setSessionName(sessions.getString("session_name"));
            thisSession.setSessionDate(sessions.getDate("session_date").toLocalDate());
            thisSession.setSessionLocation(sessions.getString("session_location"));
            thisSession.setHasPrize(sessions.getBoolean("has_prize"));
            thisSession.setPrize(sessions.getString("prize"));
            thisSession.setMoneyPrize(sessions.getBigDecimal("money_prize"));
            thisSession.setGroupId(sessions.getInt("group_id"));
            dateSessions.add(thisSession);
        }
        return dateSessions;
    }

    @Override
    public void updatePlaySession(PlaySession session) {
        jdbcTemplate.update("BEGIN TRANSACTION; UPDATE play_session SET session_name = ?, session_date = ?, " +
                "session_location = ?, has_prize = ?, prize = ?, money_prize = ?, group_id = ? WHERE session_id = ?;" +
                        "COMMIT;",
                session.getSessionName(), session.getSessionDate(), session.getSessionLocation(), session.isHasPrize(),
                session.getPrize(), session.getMoneyPrize(), session.getGroupId(), session.getSessionId());

    }
    // Move this to JDBCGameSessionDAO to be able to delete data from tables
    @Override
    public void deletePlaySession(PlaySession session) {
        jdbcTemplate.update("DELETE * FROM game_session WHERE session_id = ?; " +
                "DELETE * FROM play_session WHERE session_id = ?;",
                session.getSessionId(), session.getSessionId());

    }
}
