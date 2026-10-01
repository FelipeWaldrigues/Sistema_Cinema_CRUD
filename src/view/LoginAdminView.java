package view;

import dao.AdministradorDAO;
import dao.UsuarioDAO;
import model.Administrador;
import service.LoginService;

import java.util.Optional;
import java.util.Scanner;

/**
 * Tela/fluxo de login administrativo.
 */
public class LoginAdminView {

    private final Scanner scanner;
    private final LoginService loginService;

    public LoginAdminView() {
        this.scanner = new Scanner(System.in);
        this.loginService = new LoginService(new UsuarioDAO(), new AdministradorDAO());
    }

    public void exibir() {
        System.out.println("\n=== LOGIN - ADMINISTRATIVO ===");

        try {
            System.out.print("Login: ");
            String login = scanner.nextLine().trim();

            System.out.print("Senha: ");
            String senha = scanner.nextLine().trim();

            Optional<Administrador> admin = loginService.autenticarAdministrador(login, senha);

            if (admin.isPresent()) {
                System.out.println("\n✓ Login administrativo efetuado com sucesso!");
                System.out.println("Bem-vindo(a), " + admin.get().getNome() + "!\n");
                new MenuAdminView().exibir();
            } else {
                System.out.println("\n✗ Login ou senha incorretos.");
            }

        } catch (Exception e) {
            System.out.println("\n✗ Erro ao efetuar login: " + e.getMessage());
        }
    }
}
