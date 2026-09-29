package br.edu.unifebe.cinema.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Centraliza a criação de conexões JDBC.
 *
 * A classe não depende de um banco específico. O driver JDBC do banco
 * escolhido deverá ser adicionado ao projeto posteriormente.
 */
public final class ConnectionFactory {

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        String url = System.getenv("CINEMA_DB_URL");
        String usuario = System.getenv("CINEMA_DB_USER");
        String senha = System.getenv("CINEMA_DB_PASSWORD");

        if (url == null || url.trim().isEmpty()) {
            throw new SQLException(
                "Banco não configurado. Defina a variável CINEMA_DB_URL antes de conectar."
            );
        }

        return DriverManager.getConnection(url, usuario, senha);
    }
}
