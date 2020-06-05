package Model.DAO;

import Model.*;

import java.util.List;

public interface PlayerGameSessionDAO {
    /*
    * 1. all games played by player
    * 2. player standings for a game session played
    * 3. total player points (player - points)
    * 4. total player points by group (group [player - points])
    * 5. games won by a player where they chose the game (game - player - standing - date)
    * 6. games won by a player (game - player - standing - date)
    */

    void createNewPlayerGameSession(Player player, GameSession session, PlayerGameSession playerSession);
    List<PlayerGameSession> getAllGameSessionsByPlayer(Player player); //(player [date  - game - standing - score - points - on team - chose game])
    List<PlayerGameSession> getGameSessionStandingsByGame (Player player, Game game); //(game [standing - player - score])
    int getTotalPlayerPoints (Player player);
    int getPlayerPointsByGroup(Player player, GamingGroup group); //(Group - Player - PlayerGameSession)
    List<PlayerGameSession> getAllSessionsWonByPlayer (Player player); //(Game - Player - PlayerGameSession)
    List<PlayerGameSession> getPlayerWinsWhenChosenGameTrue(Player player); //(Game - Player - PlayerGameSession)
    void updatePlayerGameSession (Player player, PlayerGameSession playerSession, GameSession gameSession);
    void deletePlayerGameSessionById (Player player, GameSession gameSession);
}
