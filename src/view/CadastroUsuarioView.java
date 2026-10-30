package view;

import dao.AdministradorDAO;
import dao.UsuarioDAO;
import model.Usuario;
import service.AdministradorService;
import service.UsuarioService;

import java.util.Scanner;

public class CadastroUsuarioView {
    private final Scanner scanner;
    private final UsuarioService usuarioService;
    private final AdministradorService administradorService;

    public CadastroUsuarioView() {
        this.scanner = Entrada.SCANNER;
        this.usuarioService = new UsuarioService(new UsuarioDAO());
        this.administradorService = new AdministradorService(new AdministradorDAO());
    }

    public void exibir() {
        System.out.println("\n=== CADASTRO DE NOVO USUÁRIO ===");
        System.out.println("Tipo de conta:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Administrador");
        System.out.print("Escolha uma opção: ");
        String tipo = scanner.nextLine().trim();

        if (!tipo.equals("1") && !tipo.equals("2")) {
            System.out.println("\n✗ Tipo de conta inválido.");
            return;
        }
        boolean administrador = tipo.equals("2");

        try {
            System.out.print("\nNome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Sobrenome: ");
            String sobrenome = scanner.nextLine().trim();

            System.out.print("Login: ");
            String login = scanner.nextLine().trim();

            System.out.print("Senha: ");
            String senha = scanner.nextLine().trim();

            System.out.print("Confirmação de Senha: ");
            String confirmacaoSenha = scanner.nextLine().trim();

            if (administrador) {
                administradorService.cadastrar(nome, sobrenome, login, senha, confirmacaoSenha);
                System.out.println("\n✓ Administrador cadastrado com sucesso!");
            } else {
                Usuario usuario = new Usuario(nome, sobrenome, login, senha);
                usuarioService.cadastrar(usuario, confirmacaoSenha);
                System.out.println("\n✓ Usuário cadastrado com sucesso!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("\n✗ Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n✗ Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}
