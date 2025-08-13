package br.com.dio.persistence.config;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {

    @SuppressWarnings("java:S2095")
    public static Connection getConnection() throws SQLException {
        // Read from environment variables with defaults
        var url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/board?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        var user = System.getenv().getOrDefault("DB_USER", "board");
        var password = System.getenv().getOrDefault("DB_PASSWORD", "board");
        var connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        return connection;
    }

}
