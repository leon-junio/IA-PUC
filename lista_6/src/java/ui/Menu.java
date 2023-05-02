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
}
