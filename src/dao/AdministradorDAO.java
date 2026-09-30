package dao;

import model.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * DAO responsável pela autenticação administrativa.
 */
public class AdministradorDAO {

    public Optional<Administrador> autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM administrador WHERE login = ? AND senha = ?";
        
        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Administrador admin = new Administrador();
                    admin.setId(rs.getLong("id"));
                    admin.setNome(rs.getString("nome"));
                    admin.setLogin(rs.getString("login"));
                    admin.setSenha(rs.getString("senha"));
                    return Optional.of(admin);
                }
            }
        }
        
        return Optional.empty();
    }
}
