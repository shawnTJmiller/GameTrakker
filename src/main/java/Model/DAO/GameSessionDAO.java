package Model.DAO;

import Model.Game;
import Model.GameSession;
import Model.PlaySession;

import java.util.List;

public interface GameSessionDAO {
    void startNewGameSession(PlaySession sessionId, Game game, String gameSelectionType);
    List<GameSession> getGameSessionByGame(Game game);
    List<GameSession> getGameSessionBySelectionType(String gameSelectionType);
    void updateGameSession(GameSession gameSession);
    void deleteGameSession(GameSession gameSession);

}
