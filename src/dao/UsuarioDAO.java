package dao;

import model.Usuario;

import java.sql.*;
import java.util.Optional;

/**
 * DAO responsável pelo acesso aos dados de usuários.
 */
public class UsuarioDAO {

    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, sobrenome, login, senha, email, telefone, cpf, endereco, caixa_postal) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getCpf());
            stmt.setString(8, usuario.getEndereco());
            stmt.setString(9, usuario.getCaixaPostal());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId(rs.getLong(1));
                }
            }
        }
    }

    public Optional<Usuario> buscarPorLogin(String login) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE login = ?";
        
        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearUsuario(rs));
                }
            }
        }
        
        return Optional.empty();
    }

    public Optional<Usuario> autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        
        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearUsuario(rs));
                }
            }
        }
        
        return Optional.empty();
    }
    
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getLong("id"));
        usuario.setNome(rs.getString("nome"));
        usuario.setSobrenome(rs.getString("sobrenome"));
        usuario.setLogin(rs.getString("login"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setEmail(rs.getString("email"));
        usuario.setTelefone(rs.getString("telefone"));
        usuario.setCpf(rs.getString("cpf"));
        usuario.setEndereco(rs.getString("endereco"));
        usuario.setCaixaPostal(rs.getString("caixa_postal"));
        return usuario;
    }
}
