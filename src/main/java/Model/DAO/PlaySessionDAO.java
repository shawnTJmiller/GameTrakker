package Model.DAO;

import Model.GamingGroup;
import Model.PlaySession;

import java.time.LocalDate;
import java.util.List;

public interface PlaySessionDAO {
    void startNewPlaySession(PlaySession session, GamingGroup group);
    List<PlaySession> getPlaySessionsByGroup(GamingGroup group);
    List<PlaySession> getPlaySessionsByLocation(String sessionLocation);
    List<PlaySession> getPlaySessionsByDate(LocalDate date);
    void updatePlaySession(PlaySession session);
    void deletePlaySession(PlaySession session); // need this as part of game_session CRUD
}
