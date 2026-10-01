package view;

import dao.AdministradorDAO;
import dao.UsuarioDAO;
import model.Usuario;
import service.LoginService;

import java.util.Optional;
import java.util.Scanner;

/**
 * Tela/fluxo de login do cliente.
 *
 * O PDF exige login + senha. No Figma o campo aparece como
 * "E-mail, Telefone ou CPF". Essa diferença deve ser alinhada antes da
 * implementação definitiva.
 */
public class LoginUsuarioView {

    private final Scanner scanner;
    private final LoginService loginService;

    public LoginUsuarioView() {
        this.scanner = new Scanner(System.in);
        this.loginService = new LoginService(new UsuarioDAO(), new AdministradorDAO());
    }

    public void exibir() {
        System.out.println("\n=== LOGIN - USUÁRIO ===");

        try {
            System.out.print("Login: ");
            String login = scanner.nextLine().trim();

            System.out.print("Senha: ");
            String senha = scanner.nextLine().trim();

            Optional<Usuario> usuario = loginService.autenticarUsuario(login, senha);

            if (usuario.isPresent()) {
                System.out.println("\n✓ Login efetuado com sucesso!");
                System.out.println("Bem-vindo(a), " + usuario.get().getNome() + "!\n");
                new MenuClienteView().exibir();
            } else {
                System.out.println("\n✗ Login ou senha incorretos.");
            }

        } catch (Exception e) {
            System.out.println("\n✗ Erro ao efetuar login: " + e.getMessage());
        }
    }
}
