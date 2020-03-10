package Functions;

import Model.Game;
import Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSelection {

    public List<Game> getGamesByGenre(List<Game> games, String genre, String subGenre) {
        List<Game> genreFilteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getGenre().contains(genre) || game.getSubGenre().contains(subGenre)){
                genreFilteredGames.add(game);
            }
        }
        return genreFilteredGames;
    }

    public List<Game> getAgeAppropriateGames(List<Game> games, List<Player> players) {
        List<Game> ageFilteredGames = new ArrayList<>();
        for (Game game : games) {
            for (Player player : players) {
                if (game.getAgesUp() <= player.getAge()) {
                    ageFilteredGames.add(game);
                }
            }
        }
        return ageFilteredGames;
    }

    public List<Game> getGameByPlayerSize(List<Game> games, List<Player> players) {
        List<Game> sizeFilteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getMinPlayers() <= players.size() && game.getMaxPlayers() >= players.size()) {
                sizeFilteredGames.add(game);
            }
        }
        return sizeFilteredGames;
    }

    public List<Game> getGamesWithCards(List<Game> games) {
        List<Game> gamesWithCards = new ArrayList<>();
        for (Game game : games) {
            if (game.isHasCards()) {
                gamesWithCards.add(game);
            }
        }
        return gamesWithCards;
    }

    public List<Game> getGamesWithBoard(List<Game> games) {
        List<Game> gamesWithBoard = new ArrayList<>();
        for (Game game : games) {
            if (game.isHasBoard()) {
                gamesWithBoard.add(game);
            }
        }
        return gamesWithBoard;
    }

    public List<Game> getGamesWithDice(List<Game> games) {
        List<Game> gamesWithDice = new ArrayList<>();
        for (Game game : games) {
            if (game.isHasDice()) {
                gamesWithDice.add(game);
            }
        }
        return gamesWithDice;
    }

    public List<Game> getGamesWithTiles(List<Game> games) {
        List<Game> gamesWithTiles = new ArrayList<>();
        for (Game game : games) {
            if (game.isHasTiles()) {
                gamesWithTiles.add(game);
            }
        }
        return gamesWithTiles;
    }

    public List<Game> getGamesWithFigurines(List<Game> games) {
        List<Game> gamesWithFigurines = new ArrayList<>();
        for (Game game : games) {
            if (game.isHasFigurines()) {
                gamesWithFigurines.add(game);
            }
        }
        return gamesWithFigurines;
    }

    public List<Game> getGamesWithTimer(List<Game> games) {
        List<Game> gamesWithTimer = new ArrayList<>();
        for (Game game : games) {
            if (game.isHasTimer()) {
                gamesWithTimer.add(game);
            }
        }
        return gamesWithTimer;
    }

    public Game getRandomGameFromList(List<Game> games) {
        int min = 1;
        int max = games.size();
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return games.get(r.nextInt((max - min) + 1) + min);
    }
}


