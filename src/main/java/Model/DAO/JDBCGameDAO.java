package Model.DAO;

import Model.Game;
import Model.GamingGroup;
import Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JDBCGameDAO implements GameDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCGameDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Game saveNewGameFullData(Game game) {
        String newSqlRow = "INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, " +
                "recommended_age_min, genre, sub_genre, has_dice, has_cards, has_board, has_tiles, has_figurines, has_timer)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(newSqlRow, game.getName(), game.getMinPlayers(), game.getMaxPlayers(), game.getMinTime(),
            game.getMaxTime(), game.getAgesUp(), game.isHasDice(), game.isHasCards(), game.isHasBoard(), game.isHasTiles(),
            game.isHasFigurines(), game.isHasTimer());
        return game;
    }

    @Override
    public Game saveNewGameBaseData(Game game) {
        String newSqlRow = "INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, " +
                "recommended_age_min) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(newSqlRow, game.getName(), game.getMinPlayers(), game.getMaxPlayers(), game.getMinTime(),
                game.getMaxTime(), game.getAgesUp());
        return game;
    }

    @Override
    public void addGameToInventory(Player player, Game game) {
        String sqlNewGameAdd = "INSERT INTO player_inventory (player_id, game_id) VALUES (?, ?)";
        jdbcTemplate.update(sqlNewGameAdd, player.getPlayerId(), game.getGameId());
    }

    @Override
    public List<Game> getGamesByPlayer(Player player) {
        String sqlGetPlayerGame = "SELECT * " +
                                "FROM game g " +
                                "INNER JOIN player_inventory pi " +
                                "ON g.game_id = pi.game_id " +
                                "INNER JOIN player p " +
                                "ON pi.player_id = p.player_id " +
                                "WHERE p.player_id = ?;";
        SqlRowSet games = jdbcTemplate.queryForRowSet(sqlGetPlayerGame, player.getPlayerId());
        List<Game> inv = new ArrayList<>();
        Game thisGame; // initialize as null
        while (games.next()) {
            thisGame = new Game();
            thisGame.setGameId(games.getInt("game_id"));
            thisGame.setName(games.getString("name"));
            thisGame.setMinPlayers(games.getInt("min_num_players"));
            thisGame.setMaxPlayers(games.getInt("max_num_players"));
            thisGame.setMinTime(games.getInt("min_play_time"));
            thisGame.setMaxTime(games.getInt("max_play_time"));
            thisGame.setAgesUp(games.getInt("recommended_age_min"));
            thisGame.setGenre(games.getString("genre"));
            thisGame.setSubGenre(games.getString("sub_genre"));
            thisGame.setHasDice(games.getBoolean("has_dice"));
            thisGame.setHasCards(games.getBoolean("has_cards"));
            thisGame.setHasBoard(games.getBoolean("has_board"));
            thisGame.setHasTiles(games.getBoolean("has_tiles"));
            thisGame.setHasFigurines(games.getBoolean("has_figurines"));
            thisGame.setHasTimer(games.getBoolean("has_timer"));
            inv.add(thisGame);
        }
        return inv;
    }

    @Override
    public Set<Game> getGamesByGroup(GamingGroup group) {
        String sqlGetListOfGames = "SELECT gm.name " +
                "FROM game gm " +
                "INNER JOIN player_inventory pi ON gm.game_id = pi.game_id " +
                "INNER JOIN player p ON p.player_id = pi.player_id " +
                "INNER JOIN player_group pg ON pg.player_id = p.player_id " +
                "INNER JOIN gaming_group gg ON pg.group_id = gg.group_id " +
                "WHERE group_name = ?;";
        SqlRowSet games = jdbcTemplate.queryForRowSet(sqlGetListOfGames, group.getGroupName());
        Set<Game> groupGames = new HashSet<>();
        Game thisGame; // initialize as null
        while (games.next()) {
            thisGame = new Game();
            thisGame.setGameId(games.getInt("game_id"));
            thisGame.setName(games.getString("name"));
            thisGame.setMinPlayers(games.getInt("min_num_players"));
            thisGame.setMaxPlayers(games.getInt("max_num_players"));
            thisGame.setMinTime(games.getInt("min_play_time"));
            thisGame.setMaxTime(games.getInt("max_play_time"));
            thisGame.setAgesUp(games.getInt("recommended_age_min"));
            thisGame.setGenre(games.getString("genre"));
            thisGame.setSubGenre(games.getString("sub_genre"));
            thisGame.setHasDice(games.getBoolean("has_dice"));
            thisGame.setHasCards(games.getBoolean("has_cards"));
            thisGame.setHasBoard(games.getBoolean("has_board"));
            thisGame.setHasTiles(games.getBoolean("has_tiles"));
            thisGame.setHasFigurines(games.getBoolean("has_figurines"));
            thisGame.setHasTimer(games.getBoolean("has_timer"));
            groupGames.add(thisGame);
        }
        return groupGames;
    }

    @Override
    public void updateGameInfo(Game game) {
        jdbcTemplate.update("UPDATE game SET name = ?, min_num_players = ?, max_num_players = ?, min_play_time = ?, " +
                "max_play_time = ?, recommended_age_min = ?, genre = ?, sub_genre = ?, has_dice = ? has_cards = ?, has_board = ?, " +
                "has_tiles = ?, has_figurines = ?, has_timer = ? WHERE game_id = ?;",
                game.getName(), game.getMinPlayers(), game.getMaxPlayers(), game.getMinTime(), game.getMaxTime(), game.getAgesUp(),
                game.getGenre(), game.getSubGenre(), game.isHasDice(), game.isHasCards(), game.isHasBoard(), game.isHasTiles(),
                game.isHasFigurines(), game.isHasTimer(), game.getGameId());
    }

    @Override
    public void updateGameGenre(Game game) {
        jdbcTemplate.update("UPDATE game SET genre = ?, sub_genre = ? WHERE game_id = ?;",
                game.getGenre(), game.getSubGenre(), game.getGameId());
    }

    @Override
    public void updateGameBooleans(Game game) {
        jdbcTemplate.update("UPDATE game SET has_dice = ? has_cards = ?, has_board = ?, has_tiles = ?, has_figurines = ?, has_timer = ? " +
                        "WHERE game_id = ?;",
                game.isHasDice(), game.isHasCards(), game.isHasBoard(), game.isHasTiles(), game.isHasFigurines(), game.isHasTimer(),
                game.getGameId());
    }

    @Override
    public void removeGameFromInventory(Game game, Player player) {
        jdbcTemplate.update("DELETE * FROM player_inventory WHERE game_id = ? AND player_id = ?;",
                game.getGameId(), player.getPlayerId());
    }
}
