package utils;

public final class TruthTable {
    public static double[][] getTruthTable(int entries) {
        double[][] table = new double[(int) Math.pow(2, entries)][];
        for (int i = 0; i < table.length; i++) {
            table[i] = new double[entries];
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i / (int) Math.pow(2, j)) % 2;
            }
        }
        return table;
    }

    public static double[] getExit(int entries, char operation) {
        double[] exit = new double[(int) Math.pow(2, entries)];
        if (operation == '&') {
            for (int i = 0; i < exit.length - 1; i++) {
                exit[i] = 0;
            }
            exit[exit.length - 1] = 1;
        } else if (operation == '|') {
            exit[0] = 0;
            for (int i = 1; i < exit.length; i++) {
                exit[i] = 1;
            }
        } else if (operation == '+' && entries == 2) {
            for (int i = 0; i < exit.length; i++) {
                exit[i] = 0;
            }
            exit[0] = 1;
            exit[exit.length - 1] = 1;
        } else {
            System.out.println("Operação inválida!");
        }
        return exit;
    }

    public static void printTable(double[][] table, double[] exit) {

        for (int i = 0; i < table[0].length; i++) {
            System.out.print("IN" + i + " | ");
        }
        System.out.println("OUT");

        for (int i = 0; i < table.length; i++) {

            for (int j = 0; j < table[i].length; j++) {
                System.out.print(" " + table[i][j] + "  | ");
            }
            System.out.println(exit[i]);
        }
    }
}
