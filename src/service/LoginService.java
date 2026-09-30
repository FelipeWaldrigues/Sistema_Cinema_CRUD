package service;

import dao.AdministradorDAO;
import dao.UsuarioDAO;
import model.Administrador;
import model.Usuario;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Centraliza os dois tipos de autenticação pedidos no enunciado.
 */
public class LoginService {

    private final UsuarioDAO usuarioDAO;
    private final AdministradorDAO administradorDAO;

    public LoginService(UsuarioDAO usuarioDAO, AdministradorDAO administradorDAO) {
        this.usuarioDAO = usuarioDAO;
        this.administradorDAO = administradorDAO;
    }

    public Optional<Usuario> autenticarUsuario(String login, String senha) throws SQLException {
        return usuarioDAO.autenticar(login, senha);
    }

    public Optional<Administrador> autenticarAdministrador(String login, String senha) throws SQLException {
        return administradorDAO.autenticar(login, senha);
    }
}
