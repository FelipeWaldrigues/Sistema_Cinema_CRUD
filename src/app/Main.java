package app;

import view.MenuPrincipal;

/**
 * Ponto de entrada do Sistema Cinema.
 *
 * Nesta etapa o projeto está apenas estruturado. Os fluxos serão ligados
 * aos DAOs e services nas próximas etapas.
 */
public class Main {

    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.exibir();
    }
}
