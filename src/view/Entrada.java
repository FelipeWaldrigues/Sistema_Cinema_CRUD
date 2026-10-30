package view;

import java.util.Scanner;

// Scanner compartilhado pra evitar conflito de leitura
public final class Entrada {
    public static final Scanner SCANNER = new Scanner(System.in);

    private Entrada() {
    }
}
