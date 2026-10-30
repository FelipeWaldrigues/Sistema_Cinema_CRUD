package view;

import java.util.Scanner;

/**
 * Scanner único compartilhado por todas as telas.
 *
 * Criar vários Scanner sobre o mesmo System.in faz um "roubar" a entrada
 * já lida pelo outro, então todas as telas usam este.
 */
public final class Entrada {

    public static final Scanner SCANNER = new Scanner(System.in);

    private Entrada() {
    }
}
