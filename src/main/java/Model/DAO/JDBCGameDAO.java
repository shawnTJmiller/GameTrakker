package Model.DAO;

import Model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JDBCGameDAO implements GameDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCGameDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Game saveGame(Game game) {
        String newSqlRow = "INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, " +
                "recommended_age_min, has_dice, has_cards, has_board, has_tiles, has_figurines, has_timer)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(newSqlRow, game.getName(), game.getMinPlayers(), game.getMaxPlayers(), game.getMinTime(),
            game.getMaxTime(), game.getAgesUp(), game.isHasDice(), game.isHasCards(), game.isHasBoard(), game.isHasTiles(),
            game.isHasFigurines(), game.isHasTimer());
        return game;
    }

    @Override
    public void addGameToInventory(String userName, String name) {
        String sqlNewGameAdd = "INSERT INTO player_inventory (player_id, game_id) VALUES (" +
                    "(SELECT player_id FROM player WHERE user_name = ?), (SELECT game_id FROM game WHERE name = ?))";
        jdbcTemplate.update(sqlNewGameAdd, userName, name);
    }

    @Override
    public Game getGameByName(String name) {
        return null;
    }

    @Override
    public List<Game> getGamesByGenre(String genre, String subGenre) {
        return null;
    }

    @Override
    public List<Game> getGamesByAgeMin(int age) {
        return null;
    }

    @Override
    public List<Game> getGameByPlayerSize(int numPlayers) {
        return null;
    }

    @Override
    public List<Game> getGamesWithCards(boolean hasCards) {
        return null;
    }

    @Override
    public List<Game> getGamesWithFigurines(boolean hasFigurines) {
        return null;
    }

    @Override
    public void updateGameInfo(String name) {

    }

    @Override
    public void removeGameFromInventory(String name, String userName) {

    }
}
