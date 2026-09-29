package br.edu.unifebe.cinema.service;

import br.edu.unifebe.cinema.dao.AdministradorDAO;
import br.edu.unifebe.cinema.dao.UsuarioDAO;
import br.edu.unifebe.cinema.model.Administrador;
import br.edu.unifebe.cinema.model.Usuario;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Centraliza os dois tipos de autenticação pedidos no enunciado.
 */
public class AutenticacaoService {

    private final UsuarioDAO usuarioDAO;
    private final AdministradorDAO administradorDAO;

    public AutenticacaoService(UsuarioDAO usuarioDAO, AdministradorDAO administradorDAO) {
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
