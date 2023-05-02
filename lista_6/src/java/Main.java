import classes.Perceptron;
import ui.Menu;

public class Main {
    private static Menu menu = new Menu();
    private static int nEntradas = 0;
    private static double[][] tabela = null;
    private static double[] saida = null;
    private static double taxaAprendizagem = 0.0001;
    private static double tolerancia = 0.00001;
    private static int epochs = 10000;
    private static int randomSeed = -1;
    private static boolean treinado = false;
    private static String porta = "";
    private static Perceptron p = new Perceptron(nEntradas, taxaAprendizagem, tolerancia, randomSeed, funcao:Perceptron.Functions.BinaryStep);

    public static void main(String[] args) {
        try {
            startApp();
        } catch (Exception e) {
            System.err.println("Error at the Main Thread: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void startApp(){
        int opcao = menu.showMenu();
        while (opcao != -1){
            switch (opcao)
            {
                case -1:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.print("Digite o número de entradas da AND: ");
                    nEntradas = int.Parse(System.Console.ReadLine()!);
                    tabela = geraTabelaVerdade(nEntradas);
                    saida = geraSaidaEsperada(nEntradas, '&');
                    printaTabela(tabela, saida);
                    System.out.println("Treinando o perceptron...");
                    p = new Perceptron(nEntradas, taxaAprendizagem, tolerancia, randomSeed, funcao:Perceptron.Functions.BinaryStep);
                    p.TrainEpoch(tabela, saida, epochs);
                    treinado = true;
                    porta = "AND";
                    break;
                case 2:
                    System.out.print("Digite o número de entradas da OR: ");
                    nEntradas = int.Parse(System.Console.ReadLine()!);
                    tabela = geraTabelaVerdade(nEntradas);
                    saida = geraSaidaEsperada(nEntradas, '|');
                    printaTabela(tabela, saida);
                    System.out.println("Treinando o perceptron...");
                    p = new Perceptron(nEntradas, taxaAprendizagem, tolerancia, randomSeed, funcao:Perceptron.Functions.BinaryStep);
                    p.TrainEpoch(tabela, saida, epochs);
                    treinado = true;
                    porta = "OR";
                    break;
                case 3:
                    nEntradas = 2;
                    tabela = geraTabelaVerdade(nEntradas);
                    saida = geraSaidaEsperada(nEntradas, '&');
                    printaTabela(tabela, saida);
                    System.out.println("Treinando o perceptron...");
                    p = new Perceptron(nEntradas, taxaAprendizagem, tolerancia, randomSeed, funcao:Perceptron.Functions.BinaryStep);
                    p.TrainEpoch(tabela, saida, epochs);
                    treinado = true;
                    porta = "XOR";
                    break;
                case 4:
                    if(!treinado){
                        System.out.println("Perceptron não treinado!");
                        break;
                    }
                    System.out.println("Digite as entradas:");
                    double[] entradasTeste = new double[nEntradas];
                    for(int i = 0; i < entradasTeste.Length; i++){
                        Console.Write(i + ": ");                        
                        entradasTeste[i] = double.Parse(System.Console.ReadLine()!);
                    }
                    double saidaTeste = p.Predict(entradasTeste);
                    System.out.println("\n/*****************/");
                    System.out.println("Saída: " + saidaTeste);
                    System.out.println("/*****************/\n");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            if(treinado){
                System.out.println("Treinado com " + porta);
            }
            opcao = menu.showMenu();
        }
    }
}