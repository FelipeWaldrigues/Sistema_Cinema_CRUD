package service;

import dao.AdministradorDAO;
import model.Administrador;

import java.sql.SQLException;
import java.util.Optional;

public class AdministradorService {
    private final AdministradorDAO administradorDAO;

    public AdministradorService(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    public void cadastrar(String nome, String sobrenome, String login, String senha,
                          String confirmacaoSenha) throws SQLException {
        // Valida campos obrigatórios
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

        // Verifica se senha e confirmação batem
        if (!senha.equals(confirmacaoSenha)) {
            throw new IllegalArgumentException("Senha e confirmação não conferem.");
        }

        // Verifica se login já existe
        Optional<Administrador> adminExistente = administradorDAO.buscarPorLogin(login);
        if (adminExistente.isPresent()) {
            throw new IllegalArgumentException("Login já cadastrado. Escolha outro.");
        }

        // Salva no banco (nome completo)
        administradorDAO.salvar(new Administrador(nome + " " + sobrenome, login, senha));
    }
}
