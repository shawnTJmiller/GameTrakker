package Model.DAO;

import Model.Player;

public interface PlayerDAO {
    public void savePlayer(int playerId, String userName);
    public Player getPlayerByPlayerId(int playerId);
    public Player getPlayerByUserName(String userName);
    public void updatePlayer(Player player);
    public void deletePlayer(Player player);
}
