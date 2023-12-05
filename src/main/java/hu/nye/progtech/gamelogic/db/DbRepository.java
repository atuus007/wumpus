package hu.nye.progtech.gamelogic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.models.Direction;
import hu.nye.progtech.models.Hero;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class DbRepository {

    private final String url;

    DbRepository()  {
       try {
           Class.forName("org.h2.Driver");
           url = "jdbc:h2:mem:test;INIT=runscript from 'classpath:create.sql'\\;runscript from 'classpath:init.sql'"
           ;
            connection = DriverManager.getConnection(url);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e.getMessage());
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }

    Connection connection = null;

    List<Hero> getHeros() {
        List<Hero> heroes = new ArrayList<>();
            try (
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hero")) {
                // Lekérdezés végrehajtása
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Eredmény feldolgozása
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String shortcut = resultSet.getString("shortcut");
                        int heroColumn = resultSet.getInt("h_column");
                        int heroRow = resultSet.getInt("h_row");
                        int startColumn = resultSet.getInt("start_column");
                        int startRow = resultSet.getInt("start_row");
                        int arrowCount = resultSet.getInt("arrow_count");
                        int direction = resultSet.getInt("direction");
                        String name = resultSet.getString("name");
                        int step = resultSet.getInt("step");
                        int gold = resultSet.getInt("gold");
                        int matrixLength = resultSet.getInt("matrix_length");
                        heroes.add(new Hero(
                                id,
                                shortcut.toCharArray()[0],
                                (char) heroColumn,
                                heroRow,
                                Direction.values()[direction],
                                arrowCount,
                                name,
                                step,
                                (char) startColumn,
                                startRow,
                                gold > 0,
                                matrixLength
                        ));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return  heroes;
    }


    String deleteHero(int databaseUserID) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM hero WHERE id = ?")) {
            statement.setInt(1, databaseUserID);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                return "A hős sikeresen törölve.";
            } else {
                return "A hős nem található az adatbázisban.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    String insertHero(Hero hero) {
        // SQL beszúrási lekérdezés
        String sql = "INSERT INTO hero (shortcut, h_column, h_row, start_column, start_row, arrow_count, " +
                "direction, name, step, gold, matrix_length) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Paraméterek beállítása
            preparedStatement.setString(1, String.valueOf(hero.getShortCut()));
            preparedStatement.setInt(2, hero.getColumn());
            preparedStatement.setInt(3, hero.getRow());
            preparedStatement.setInt(4, hero.getStartColumn());
            preparedStatement.setInt(5, hero.getStartRow());
            preparedStatement.setInt(6, hero.getArrowCount());
            preparedStatement.setInt(7, hero.getDirection().ordinal());
            preparedStatement.setString(8, hero.getName());
            preparedStatement.setInt(9, hero.getStep());
            preparedStatement.setInt(10, hero.hasGold() ? 1 : 0);
            preparedStatement.setInt(11, hero.getMatrixLength());
            // Beszúrás végrehajtása
            int affectedRows = preparedStatement.executeUpdate();
            // Ellenőrzés, hogy sikeres volt-e a beszúrás
            if (affectedRows > 0) {
                return "A hős sikeresen rögzítve.";
            } else {
               return  "A hős beszúrása sikertelen.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    String updateHero(Hero hero) {
        // SQL frissítési lekérdezés
        String sql = "UPDATE hero SET shortcut=?, h_column=?, h_row=?, start_column=?, start_row=?, " +
                "arrow_count=?, direction=?, name=?, step=?, gold=?, matrix_length=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Paraméterek beállítása
            preparedStatement.setString(1, String.valueOf(hero.getShortCut()));
            preparedStatement.setInt(2, hero.getColumn());
            preparedStatement.setInt(3, hero.getRow());
            preparedStatement.setInt(4, hero.getStartColumn());
            preparedStatement.setInt(5, hero.getStartRow());
            preparedStatement.setInt(6, hero.getArrowCount());
            preparedStatement.setInt(7, hero.getDirection().ordinal());
            preparedStatement.setString(8, hero.getName());
            preparedStatement.setInt(9, hero.getStep());
            preparedStatement.setInt(10, hero.hasGold() ? 1 : 0);
            // Az utolsó paraméter az id, ahol a frissíteni kívánt rekordot azonosítjuk
            preparedStatement.setInt(12, hero.getId());
            preparedStatement.setInt(11, hero.getMatrixLength());
            // Frissítés végrehajtása
            int affectedRows = preparedStatement.executeUpdate();
            // Ellenőrzés, hogy sikeres volt-e a frissítés
            if (affectedRows > 0) {
                return "A hős sikeresen frissítve.";
            } else {
                return "A hős frissítése sikertelen.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
