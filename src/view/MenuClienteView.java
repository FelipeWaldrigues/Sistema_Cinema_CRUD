package view;

import dao.FilmeDAO;
import model.Filme;
import service.FilmeService;

import java.util.List;
import java.util.Scanner;

/**
 * Menu apresentado depois do login de um cliente.
 */
public class MenuClienteView {

    private final Scanner scanner;
    private final FilmeService filmeService;

    public MenuClienteView() {
        this.scanner = new Scanner(System.in);
        this.filmeService = new FilmeService(new FilmeDAO());
    }

    public void exibir() {
        while (true) {
            System.out.println("\n=== ÁREA DO CLIENTE ===");
            System.out.println("1 - Buscar filme");
            System.out.println("2 - Adicionar ao carrinho / efetuar reserva");
            System.out.println("3 - Retirar do carrinho / remover reserva");
            System.out.println("4 - Confirmar compra / reserva");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    buscarFilme();
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

    private void buscarFilme() {
        System.out.println("\n=== BUSCAR FILME ===");
        System.out.print("Digite o código (ID) ou nome do filme: ");
        String termo = scanner.nextLine().trim();

        if (termo.isEmpty()) {
            System.out.println("\nTermo de busca não pode ser vazio.");
            return;
        }

        try {
            List<Filme> filmes = filmeService.buscar(termo);

            if (filmes.isEmpty()) {
                System.out.println("\nProduto Não Encontrado");
            } else {
                System.out.println("\n--- Resultados ---");
                for (Filme filme : filmes) {
                    System.out.println("\nID: " + filme.getId());
                    System.out.println("Título: " + filme.getTitulo());
                    System.out.println("Gênero: " + filme.getGenero());
                    System.out.println("Classificação: " + filme.getClassificacaoEtaria());
                    System.out.println("Nota: " + filme.getNota());
                    System.out.println("Em Cartaz: " + (filme.isEmCartaz() ? "Sim" : "Não"));
                    if (filme.getSinopse() != null && !filme.getSinopse().isEmpty()) {
                        System.out.println("Sinopse: " + filme.getSinopse());
                    }
                    System.out.println("------------------");
                }
            }

        } catch (Exception e) {
            System.out.println("\n✗ Erro ao buscar filme: " + e.getMessage());
        }
    }
}
