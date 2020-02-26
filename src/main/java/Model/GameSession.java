package Model;

import Model.Game;

public class GameSession {

    PlaySession session = new PlaySession();
    int sessionId = session.getSessionId();
    Game game = new Game();
    int gameId = game.getGameId();

    private int gameSessionId;
    private String gameSelectionType;

    public GameSession(int gameSessionId, int gameId, int sessionId){
        this.gameSessionId = gameSessionId;
        this.sessionId = sessionId;
        this.gameId = gameId;
    }

    public GameSession(){

    }

    public int getGameSessionId() {
        return gameSessionId;
    }
    public String getGameSelectionType() {
        return gameSelectionType;
    }

    public void setGameSessionId(int gameSessionId) {
        this.gameSessionId = gameSessionId;
    }
    public void setGameSelectionType(String gameSelectionType) {
        this.gameSelectionType = gameSelectionType;
    }
}
