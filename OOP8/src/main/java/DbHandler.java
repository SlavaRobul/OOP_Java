import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DbHandler {
    private static final String CON_STR = "jdbc:sqlite:" + DbHandler.class.getClassLoader();
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    private Connection connection;

    private DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<String> getAllProducts() {
        try (Statement statement = this.connection.createStatement()) {
            List<String> results = new ArrayList<String>();
            ResultSet resultSet = statement.executeQuery("SELECT city, localDate, weatherText, temperature FROM Weather");
            while (resultSet.next()) {
                results.add(resultSet.getString("city") + " " +
                        resultSet.getString("localDate") + " " +
                        resultSet.getString("weatherText") + " " +
                        resultSet.getString("temperature"));
            }
            return results;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addItem(WeatherInfo weatherList) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Weather(`city`, `localDate`, `weatherText`, `temperature`) " +
                        "VALUES(?, ?, ?, ?)")) {
            for (DayInfo item: weatherList.forecasts) {
                statement.setObject(1, weatherList.info.tzinfo.name);
                statement.setObject(2, item.date);
                statement.setObject(3, item.parts.day_short.condition);
                statement.setObject(4, item.parts.day_short.temp);
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() throws SQLException {
        Statement stmt = this.connection.createStatement();
        stmt.executeUpdate("CREATE TABLE Weather (city, localDate, weatherText, temperature);");
    }

    public void closeConnection() throws SQLException {this.connection.close();}
}
