package service;

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.Optional;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void cadastrar(Usuario usuario, String confirmacaoSenha) throws SQLException {
        // Valida campos obrigatórios
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (usuario.getSobrenome() == null || usuario.getSobrenome().trim().isEmpty()) {
            throw new IllegalArgumentException("Sobrenome é obrigatório.");
        }
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("Login é obrigatório.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória.");
        }
        
        // Verifica se senha e confirmação batem
        if (!usuario.getSenha().equals(confirmacaoSenha)) {
            throw new IllegalArgumentException("Senha e confirmação não conferem.");
        }
        
        // Verifica se login já existe
        Optional<Usuario> usuarioExistente = usuarioDAO.buscarPorLogin(usuario.getLogin());
        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("Login já cadastrado. Escolha outro.");
        }
        
        // Salva no banco
        usuarioDAO.salvar(usuario);
    }
}
