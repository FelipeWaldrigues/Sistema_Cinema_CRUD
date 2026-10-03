package view;

import java.util.Scanner;

/**
 * Menu apresentado depois do login administrativo.
 */
public class MenuAdminView {

    private final Scanner scanner;

    public MenuAdminView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        while (true) {
            System.out.println("\n=== ÁREA ADMINISTRATIVA ===");
            System.out.println("1 - Cadastrar novo filme");
            System.out.println("2 - Buscar filme");
            System.out.println("3 - Remover filme");
            System.out.println("4 - Atualizar filme");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    System.out.println("\nFuncionalidade será implementada na próxima etapa.");
                    break;
                case "2":
                    System.out.println("\nFuncionalidade será implementada na próxima etapa.");
                    break;
                case "3":
                    System.out.println("\nFuncionalidade será implementada na próxima etapa.");
                    break;
                case "4":
                    System.out.println("\nFuncionalidade será implementada na próxima etapa.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }
}
