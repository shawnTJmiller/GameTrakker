package Model;

public class PlayerGameSession {

    Player player = new Player();
    int playerId = player.getPlayerId();
    GameSession gameSession = new GameSession();
    int gameSessionId = gameSession.getGameSessionId();



    private Integer standing;
    private Integer points;
    private Integer score;
    private Boolean onTeam;
    private Boolean choseGame;

    public PlayerGameSession() {

    }

    public PlayerGameSession(int playerId, int gameSessionId) {

    }

    public int getStanding() {
        return standing;
    }
    public int getPoints() {
        return points;
    }
    public int getScore() {
        return score;
    }
    public boolean isOnTeam() {
        return onTeam;
    }
    public boolean didChooseGame() {
        return choseGame;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setOnTeam(boolean onTeam) {
        this.onTeam = onTeam;
    }
    public void setChoseGame(boolean choseGame) {
        this.choseGame = choseGame;
    }

}
