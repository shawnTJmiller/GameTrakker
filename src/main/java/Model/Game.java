package Model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Game {

    private int gameId;
    @NotNull @NotEmpty @NotBlank
    private String name;
    private int minPlayers;
    private int maxPlayers;
    private int minTime;
    private int maxTime;
    private int agesUp;
    private String genre;
    private String subGenre;
    private boolean hasBoard;
    private boolean hasCards;
    private boolean hasDice;
    private boolean hasFigurines;
    private boolean hasTiles;
    private boolean hasTimer;

    //Constructors
    public Game(String name) {
        this.name = name;
    }

    public Game() {
    }

    public Game(String name, int minPlayers, int maxPlayers, int minTime, int maxTime, int agesUp) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.agesUp = agesUp;
    }

    //Getters
    public int getGameId() { return gameId; }
    public String getName() {
        return name;
    }
    public int getMinPlayers() {
       return minPlayers;
    }
    public int getMaxPlayers() {
        return maxPlayers;
    }
    public int getMinTime() {
        return minTime;
    }
    public int getMaxTime() {
        return maxTime;
    }
    public int getAgesUp() {
        return agesUp;
    }
    public String getGenre() {
        return genre;
    }
    public String getSubGenre() {
        return subGenre;
    }
    public boolean isHasBoard() {
        return hasBoard;
    }
    public boolean isHasCards() {
        return hasCards;
    }
    public boolean isHasDice() {
        return hasDice;
    }
    public boolean isHasFigurines() {
        return hasFigurines;
    }
    public boolean isHasTiles() {
        return hasTiles;
    }
    public boolean isHasTimer() { return hasTimer; }

    //Setters
    public void setGameId(int gameId) {this.gameId = gameId; }
    public void setName(String name) {
        this.name = name;
    }
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }
    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }
    public void setAgesUp(int agesUp) {
        this.agesUp = agesUp;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }
    public void setHasBoard(boolean hasBoard) {
        this.hasBoard = hasBoard;
    }
    public void setHasCards(boolean hasCards) {
        this.hasCards = hasCards;
    }
    public void setHasDice(boolean hasDice) {
        this.hasDice = hasDice;
    }
    public void setHasFigurines(boolean hasFigurines) {
        this.hasFigurines = hasFigurines;
    }
    public void setHasTiles(boolean hasTiles) {
        this.hasTiles = hasTiles;
    }
    public void setHasTimer(boolean has_timer) { this.hasTimer = hasTimer; }

    //toString, equals, hashCode  methods
    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", name='" + name + '\'' +
                ", minPlayers=" + minPlayers +
                ", maxPlayers=" + maxPlayers +
                ", minTime=" + minTime +
                ", maxTime=" + maxTime +
                ", agesUp=" + agesUp +
                ", genre='" + genre + '\'' +
                ", subGenre='" + subGenre + '\'' +
                ", hasBoard=" + hasBoard +
                ", hasCards=" + hasCards +
                ", hasDice=" + hasDice +
                ", hasFigurines=" + hasFigurines +
                ", hasTiles=" + hasTiles +
                ", hasTimer=" + hasTimer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;

        Game game = (Game) o;

        if (getGameId() != game.getGameId()) return false;
        if (getMinPlayers() != game.getMinPlayers()) return false;
        if (getMaxPlayers() != game.getMaxPlayers()) return false;
        if (getMinTime() != game.getMinTime()) return false;
        if (getMaxTime() != game.getMaxTime()) return false;
        if (getAgesUp() != game.getAgesUp()) return false;
        if (isHasBoard() != game.isHasBoard()) return false;
        if (isHasCards() != game.isHasCards()) return false;
        if (isHasDice() != game.isHasDice()) return false;
        if (isHasFigurines() != game.isHasFigurines()) return false;
        if (isHasTiles() != game.isHasTiles()) return false;
        if (isHasTimer() != game.isHasTimer()) return false;
        if (!getName().equals(game.getName())) return false;
        if (!getGenre().equals(game.getGenre())) return false;
        return getSubGenre().equals(game.getSubGenre());
    }

    @Override
    public int hashCode() {
        int result = getGameId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getMinPlayers();
        result = 31 * result + getMaxPlayers();
        result = 31 * result + getMinTime();
        result = 31 * result + getMaxTime();
        result = 31 * result + getAgesUp();
        result = 31 * result + getGenre().hashCode();
        result = 31 * result + getSubGenre().hashCode();
        result = 31 * result + (isHasBoard() ? 1 : 0);
        result = 31 * result + (isHasCards() ? 1 : 0);
        result = 31 * result + (isHasDice() ? 1 : 0);
        result = 31 * result + (isHasFigurines() ? 1 : 0);
        result = 31 * result + (isHasTiles() ? 1 : 0);
        result = 31 * result + (isHasTimer() ? 1 : 0);
        return result;
    }
}
