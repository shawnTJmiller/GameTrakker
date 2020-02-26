package Model.DAO;

public interface PlayerDAO {
    public void savePlayer(int playerId, String firstName);
    public Object getPlayerByPlayerId(int playerId);
    public Object getPlayerByFirstName(String firstName);
    public void updatePlayer(String lastName, String nickName, int age, int playerId);
    public void removePlayerByPlayerId(int playerId);
    public void removePlayerByUserName(String UserName);
}
