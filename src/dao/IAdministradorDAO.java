package dao;

import model.Administrador;
import java.sql.SQLException;
import java.util.Optional;

public interface IAdministradorDAO {
    void salvar(Administrador admin) throws SQLException;
    Optional<Administrador> buscarPorLogin(String login) throws SQLException;
    Optional<Administrador> autenticar(String login, String senha) throws SQLException;
}
