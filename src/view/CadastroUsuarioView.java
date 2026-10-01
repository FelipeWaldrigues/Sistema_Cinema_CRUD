package view;

import dao.UsuarioDAO;
import model.Usuario;
import service.UsuarioService;

import java.util.Scanner;

/**
 * Tela/fluxo de cadastro de novo usuário.
 *
 * Requisitos mínimos do PDF:
 * - Nome
 * - Sobrenome
 * - Login
 * - Senha
 * - Confirmação de senha
 *
 * O Figma também prevê e-mail, CPF, endereço e caixa postal.
 */
public class CadastroUsuarioView {

    private final Scanner scanner;
    private final UsuarioService usuarioService;

    public CadastroUsuarioView() {
        this.scanner = new Scanner(System.in);
        this.usuarioService = new UsuarioService(new UsuarioDAO());
    }

    public void exibir() {
        System.out.println("\n=== CADASTRO DE NOVO USUÁRIO ===");

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Sobrenome: ");
            String sobrenome = scanner.nextLine().trim();

            System.out.print("Login: ");
            String login = scanner.nextLine().trim();

            System.out.print("Senha: ");
            String senha = scanner.nextLine().trim();

            System.out.print("Confirmação de Senha: ");
            String confirmacaoSenha = scanner.nextLine().trim();

            Usuario usuario = new Usuario(nome, sobrenome, login, senha);
            usuarioService.cadastrar(usuario, confirmacaoSenha);

            System.out.println("\n✓ Usuário cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("\n✗ Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n✗ Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}
