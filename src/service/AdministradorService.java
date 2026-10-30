package service;

import dao.AdministradorDAO;
import model.Administrador;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Reúne as validações do cadastro de administrador antes de chamar o DAO.
 */
public class AdministradorService {

    private final AdministradorDAO administradorDAO;

    public AdministradorService(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    public void cadastrar(String nome, String sobrenome, String login, String senha,
                          String confirmacaoSenha) throws SQLException {
        // 1. Validar campos obrigatórios
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (sobrenome == null || sobrenome.trim().isEmpty()) {
            throw new IllegalArgumentException("Sobrenome é obrigatório.");
        }
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login é obrigatório.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória.");
        }

        // 2. Verificar se senha e confirmação são iguais
        if (!senha.equals(confirmacaoSenha)) {
            throw new IllegalArgumentException("Senha e confirmação não conferem.");
        }

        // 3. Verificar se o login já existe
        Optional<Administrador> adminExistente = administradorDAO.buscarPorLogin(login);
        if (adminExistente.isPresent()) {
            throw new IllegalArgumentException("Login já cadastrado. Escolha outro.");
        }

        // 4. Salvar no banco (a tabela administrador guarda o nome completo)
        administradorDAO.salvar(new Administrador(nome + " " + sobrenome, login, senha));
    }
}
