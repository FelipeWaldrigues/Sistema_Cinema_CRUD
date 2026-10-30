package dao;

import model.Usuario;
import java.sql.SQLException;
import java.util.Optional;

public interface IUsuarioDAO {
    void salvar(Usuario usuario) throws SQLException;
    Optional<Usuario> buscarPorLogin(String login) throws SQLException;
    Optional<Usuario> autenticar(String login, String senha) throws SQLException;
}
