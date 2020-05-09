package Model;

public class GameSession {

    //PlaySession session;
    private int playSessionId;
    private int gameId;
    private int gameSessionId;

    private String gameSelectType;

    public GameSession(int gameSessionId, int gameId, String gameSelectType){
        this.gameSessionId = gameSessionId;
        this.gameId = gameId;

    }


    public GameSession(){

    }

    public int getPlaySessionId() { return playSessionId; }
    public int getGameId() { return gameId; }
    public int getGameSessionId() {
        return gameSessionId;
    }
    public String getGameSelectionType() {
        return gameSelectType;
    }

    public void setPlaySessionId(int playSessionId) { this.playSessionId = playSessionId; }
    public void setGameId(int gameId) { this.gameId = gameId; }
    public void setGameSessionId(int gameSessionId) {
        this.gameSessionId = gameSessionId;
    }
    public void setGameSelectionType(String gameSelectionType) {
        this.gameSelectType = gameSelectionType;
    }

    /// Arraylist of ints that represent the gameIds that can be pulled from JDBC
}
