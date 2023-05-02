import classes.Perceptron;
import ui.Menu;
import utils.Functions;
import utils.TruthTable;

public class Main {
    private static Menu menu = new Menu();
    private final static double RATE_KNOWLEDGE = 0.0001;
    private final static double ACCEPTENCE = 0.00001;
    private final static int EPOCHS = 10000;
    private final static int RANDOM_SEED = -1;
    private static Perceptron perceptron = null;

    public static void main(String[] args) {
        try {
            startApp();
        } catch (Exception e) {
            System.err.println("Error at the Main Thread: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void startApp() {
        int opcao = menu.showMenu();
        while (opcao != 0) {
            switch (opcao) {
                case 0:
                    System.out.println("Finalizado!");
                    break;
                case 1:
                    menuAnd();
                    break;
                case 2:
                    menuOr();
                    break;
                case 3:
                    menuXor();
                    break;
                case 4:
                    menuTeste();
                    break;
                default:
                    System.err.println("Opção inválida!");
                    break;
            }
            if (trained) {
                System.out.println("Perceptron treinado com " + door);
            }
            opcao = menu.showMenu();
        }
    }

    public static void menuAnd() {
        entries = menu.entradasAnd();
        table = TruthTable.getTruthTable(entries);
        exit = TruthTable.getExit(entries, '&');
        TruthTable.printTable(table, exit);
        System.out.println("Treinando o perceptron...");
        perceptron = new Perceptron(entries, RATE_KNOWLEDGE, ACCEPTENCE, RANDOM_SEED, Functions::BinaryStep);
        perceptron.trainEpoch(table, exit, EPOCHS, 0);
        trained = true;
        door = "AND";
    }

    public static void menuOr() {
        entries = menu.entradasOr();
        table = TruthTable.getTruthTable(entries);
        exit = TruthTable.getExit(entries, '|');
        TruthTable.printTable(table, exit);
        System.out.println("--- Treinando o perceptron no momento ---");
        perceptron = new Perceptron(entries, RATE_KNOWLEDGE, ACCEPTENCE, RANDOM_SEED,
                Functions::BinaryStep);
        perceptron.trainEpoch(table, exit, EPOCHS, 0);
        trained = true;
        door = "OR";
    }

    public static void menuXor() {
        entries = 2;
        table = TruthTable.getTruthTable(entries);
        exit = TruthTable.getExit(entries, '&');
        TruthTable.printTable(table, exit);
        System.out.println("--- Treinando o perceptron ---");
        perceptron = new Perceptron(entries, RATE_KNOWLEDGE, ACCEPTENCE, RANDOM_SEED,
                Functions::BinaryStep);
        perceptron.trainEpoch(table, exit, EPOCHS, 0);
        trained = true;
        door = "XOR";
    }

    public static void menuTeste() {
        if (!trained) {
            System.out.println("!Perceptron não trainado!");
        }
        System.out.println("Digite as entradas:");
        double[] entradasTeste = new double[entries];
        for (int i = 0; i < entradasTeste.length; i++) {
            System.out.print(i + ": ");
            entradasTeste[i] = menu.getEntrada();
        }
        double exitTeste = perceptron.predict(entradasTeste);
        System.out.println("Saída: " + exitTeste);
    }

    // variaveis
    private static int entries = 0;
    private static double[][] table = null;
    private static double[] exit = null;
    private static boolean trained = false;
    private static String door = "";
}