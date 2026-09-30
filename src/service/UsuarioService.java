package service;

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;

/**
 * Reúne as validações do cadastro antes de chamar o DAO.
 */
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void cadastrar(Usuario usuario, String confirmacaoSenha) throws SQLException {
        // TODO Parte 1:
        // 1. validar campos obrigatórios;
        // 2. verificar se senha e confirmação são iguais;
        // 3. verificar se o login já existe;
        // 4. chamar usuarioDAO.salvar(usuario).
        throw new UnsupportedOperationException("Validações de cadastro ainda não implementadas.");
    }
}
