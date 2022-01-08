package net.larr4k.emerald.database;

import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import net.larr4k.emerald.Main;
import net.larr4k.emerald.prison.PlayerData;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.StringJoiner;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class MySQL {

    @Getter
    private final HikariDataSource hikariDataSource;
    @Getter
    String database;
    @Getter
    static Main plugin;

    public MySQL(@NonNull Main plugin, @NonNull String host, @NonNull String database, @NonNull String user, @NonNull String password) {
        MySQL.plugin = plugin;
        this.database = database;
        this.hikariDataSource = new HikariDataSource();
        this.hikariDataSource.setMaximumPoolSize(10);
        this.hikariDataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        this.hikariDataSource.addDataSourceProperty("serverName", "localhost");
        this.hikariDataSource.addDataSourceProperty("port", "3306");
        this.hikariDataSource.addDataSourceProperty("databaseName", database);
        this.hikariDataSource.addDataSourceProperty("user", "root");
        this.hikariDataSource.addDataSourceProperty("password", "123124124124");
    }

    public HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }

    public void createDatabase() {
        StringBuilder tableConstructor = new StringBuilder();
        tableConstructor.append("CREATE TABLE IF NOT EXISTS ");
        tableConstructor.append(this.database + ".PRISON_PLAYERS");
        tableConstructor.append(" (");
        tableConstructor.append("player_name varchar(20) NOT NULL,");
        tableConstructor.append("balance varchar(300),");
        tableConstructor.append("blocks varchar(150)");
        tableConstructor.append("level varchar(20)");
        tableConstructor.append("PRIMARY KEY (player_name))");

        Connection con = null;
        PreparedStatement prepared = null;
        try {
            con = this.hikariDataSource.getConnection();
            prepared = con.prepareStatement(tableConstructor.toString());
            prepared.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {

            if (prepared != null) {
                try {
                    prepared.close();
                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
            }

        }

    }

    public synchronized PlayerData getPlayerData(@NonNull String name, Player player) {
        Connection connection = null;
        Statement state = null;
        ResultSet res = null;

        PlayerData playerData = null;

        try {
            connection = this.hikariDataSource.getConnection();
            state = connection.createStatement();
            res = state.executeQuery("SELECT  * FROM " + this.database + ".PRISON_PLAYERS WHERE player_name = '" + name + "';");


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return playerData;
    }

    public synchronized PlayerData setPrisonStats(@NonNull PlayerData data) {
        Connection connection = null;
        Statement state = null;
        ResultSet res = null;

        try {
            connection = this.hikariDataSource.getConnection();
            state = connection.createStatement();
            res = state.executeQuery("SELECT  * FROM " + this.database + ".PRISON_PLAYERS WHERE player_name = '" + data.getPlayer() + "';");
            StringJoiner cultures = new StringJoiner(",");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return data;
    }
}
