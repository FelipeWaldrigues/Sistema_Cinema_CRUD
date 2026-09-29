package br.edu.unifebe.cinema.service;

import br.edu.unifebe.cinema.dao.UsuarioDAO;
import br.edu.unifebe.cinema.model.Usuario;

import java.sql.SQLException;

/**
 * Reúne as validações do cadastro antes de chamar o DAO.
 */
public class CadastroUsuarioService {

    private final UsuarioDAO usuarioDAO;

    public CadastroUsuarioService(UsuarioDAO usuarioDAO) {
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
