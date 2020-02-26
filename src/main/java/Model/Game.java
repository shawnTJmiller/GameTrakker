package Model;

public class Game {

    private int gameId;
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

    //Constructors
    public Game(String name) {
        this.name = name;
    }

    public Game() {
        //Need to get previous ^Model.Game to resolve in Model.PlaySession
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
}
