package Model.DAO;

import Model.Game;

import java.util.List;

public interface GameDAO {
    public Game saveGame(Game game);
    public void addGameToInventory(String userName, String name);
    public Game getGameByName(String name);
    public List<Game> getGamesByGenre(String genre, String subGenre);
    public List<Game> getGamesByAgeMin(int age);
    public List<Game> getGameByPlayerSize(int numPlayers);
    public List<Game> getGamesWithCards(boolean hasCards);
    public List<Game> getGamesWithFigurines(boolean hasFigurines);
    public void updateGameInfo(String name);
    public void removeGameFromInventory(String name, String userName);

}
