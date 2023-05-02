package ui;

import java.util.Scanner;
import java.util.Arrays;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] options = {
            "1 - Treinar porta AND",
            "2 - Treinar porta OR",
            "3 - Treinar porta XOR",
            "4 - Testar",
            "0 - Sair"
    };

    public int showMenu() {
        int option = 0;
        System.out.println("O que deseja fazer:");
        Arrays.asList(options).forEach(System.out::println);
        System.out.println("Opção: ");
        option = scanner.nextInt();
        return option;
    }

    public int entradasAnd() {
        System.out.print("Digite o número de entradas da AND: ");
        int nEntradas = 0;
        nEntradas = scanner.nextInt();
        return nEntradas;
    }

    public int entradasOr() {
        System.out.print("Digite o número de entradas da OR: ");
        int nEntradas = 0;
        nEntradas = scanner.nextInt();
        return nEntradas;
    }

    public int entradasXor() {
        System.out.print("Digite o número de entradas da XOR: ");
        int nEntradas = 0;
        nEntradas = scanner.nextInt();
        return nEntradas;
    }

    public double getEntrada() {
        double entrada = 0;
        entrada = scanner.nextDouble();
        return entrada;
    }
}
