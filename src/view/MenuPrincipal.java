package view;

import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner scanner;

    public MenuPrincipal() {
        this.scanner = Entrada.SCANNER;
    }

    public void exibir() {
        while (true) {
            System.out.println("\n=================================");
            System.out.println("       SISTEMA CINEMA CRUD       ");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar Novo Usuário");
            System.out.println("2 - Efetuar Login - Usuário");
            System.out.println("3 - Efetuar Login - Administrativo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    new CadastroUsuarioView().exibir();
                    break;
                case "2":
                    new LoginUsuarioView().exibir();
                    break;
                case "3":
                    new LoginAdminView().exibir();
                    break;
                case "0":
                    System.out.println("Encerrando sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
