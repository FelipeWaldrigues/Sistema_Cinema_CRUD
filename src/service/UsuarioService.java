package service;

import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Reúne as validações do cadastro antes de chamar o DAO.
 */
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void cadastrar(Usuario usuario, String confirmacaoSenha) throws SQLException {
        // 1. Validar campos obrigatórios
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
        
        // 2. Verificar se senha e confirmação são iguais
        if (!usuario.getSenha().equals(confirmacaoSenha)) {
            throw new IllegalArgumentException("Senha e confirmação não conferem.");
        }
        
        // 3. Verificar se o login já existe
        Optional<Usuario> usuarioExistente = usuarioDAO.buscarPorLogin(usuario.getLogin());
        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("Login já cadastrado. Escolha outro.");
        }
        
        // 4. Salvar no banco
        usuarioDAO.salvar(usuario);
    }
}
