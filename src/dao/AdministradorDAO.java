package dao;

import model.Administrador;

import java.sql.SQLException;
import java.util.Optional;

/**
 * DAO responsável pela autenticação administrativa.
 */
public class AdministradorDAO {

    public Optional<Administrador> autenticar(String login, String senha) throws SQLException {
        // TODO Parte 1: validar login e senha do administrador no banco.
        throw new UnsupportedOperationException("Login administrativo ainda não implementado.");
    }
}
