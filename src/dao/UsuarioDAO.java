package dao;

import model.Usuario;

import java.sql.SQLException;
import java.util.Optional;

/**
 * DAO responsável pelo acesso aos dados de usuários.
 */
public class UsuarioDAO {

    public void salvar(Usuario usuario) throws SQLException {
        // TODO Parte 1: INSERT do usuário usando PreparedStatement.
        throw new UnsupportedOperationException("Cadastro de usuário ainda não implementado.");
    }

    public Optional<Usuario> buscarPorLogin(String login) throws SQLException {
        // TODO Parte 1: SELECT do usuário pelo login.
        throw new UnsupportedOperationException("Busca de usuário ainda não implementada.");
    }

    public Optional<Usuario> autenticar(String login, String senha) throws SQLException {
        // TODO Parte 1: validar login e senha no banco de dados.
        throw new UnsupportedOperationException("Login de usuário ainda não implementado.");
    }
}
