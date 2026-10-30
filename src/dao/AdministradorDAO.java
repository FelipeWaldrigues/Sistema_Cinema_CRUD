package dao;

import model.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class AdministradorDAO {

    public void salvar(Administrador admin) throws SQLException {
        String sql = "INSERT INTO administrador (nome, login, senha) VALUES (?, ?, ?)";

        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getLogin());
            stmt.setString(3, admin.getSenha());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    admin.setId(rs.getLong(1));
                }
            }
        }
    }

    public Optional<Administrador> buscarPorLogin(String login) throws SQLException {
        String sql = "SELECT * FROM administrador WHERE login = ?";

        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearAdministrador(rs));
                }
            }
        }

        return Optional.empty();
    }

    public Optional<Administrador> autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM administrador WHERE login = ? AND senha = ?";
        
        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearAdministrador(rs));
                }
            }
        }

        return Optional.empty();
    }

    private Administrador mapearAdministrador(ResultSet rs) throws SQLException {
        Administrador admin = new Administrador();
        admin.setId(rs.getLong("id"));
        admin.setNome(rs.getString("nome"));
        admin.setLogin(rs.getString("login"));
        admin.setSenha(rs.getString("senha"));
        return admin;
    }
}
