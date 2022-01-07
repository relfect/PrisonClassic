package net.larr4k.emerald.database;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.NonNull;
import net.larr4k.emerald.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
    }
}
