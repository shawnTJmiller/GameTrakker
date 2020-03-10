package Model.DAO;

import Model.Game;
import Model.GamingGroup;
import Model.Player;

import java.util.List;
import java.util.Set;

public interface GameDAO {
    Game saveNewGameFullData(Game game);
    Game saveNewGameBaseData(Game game);
    void addGameToInventory(Player player, Game game);
    List<Game> getGamesByPlayer(Player player);
    Set<Game> getGamesByGroup(GamingGroup group);
    void updateGameInfo(Game game);
    void updateGameGenre(Game game);
    void updateGameBooleans(Game game);
    void removeGameFromInventory(Game game, Player player);

}
