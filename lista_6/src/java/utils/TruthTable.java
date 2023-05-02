package utils;

public final class TruthTable {
    public static double[][] getTruthTable(int nEntradas){
        double[][] tabela = new double[(int)Math.pow(2,nEntradas)][];
        for(int i = 0; i < tabela.length; i++){
            tabela[i] = new double[nEntradas];
        }
        for(int i = 0; i < tabela.length; i++){
            for(int j = 0; j < tabela[i].length; j++){
                tabela[i][j] = (i / (int)Math.pow(2,j)) % 2;
            }
        }
        return tabela;
    }

    public static double[] getExit(int nEntradas, char operation){
        double[] saida = new double[(int)Math.pow(2,nEntradas)];
        if(operation == '&'){
            for(int i = 0; i < saida.length - 1; i++){
                saida[i] = 0;
            }
            saida[saida.length - 1] = 1;
        }
        else if(operation == '|'){
            saida[0] = 0;
            for(int i = 1; i < saida.length; i++){
                saida[i] = 1;
            }
        }
        else if(operation == '+' && nEntradas == 2){
            for(int i = 0; i < saida.length; i++){
                saida[i] = 0;
            }
            saida[0] = 1;
            saida[saida.length - 1] = 1;
        }
        else{
            System.out.println("Operação inválida!");
        }
        return saida;
    }

    public static void printTable(double[][] tabela, double[] saida){

        for(int i = 0; i < tabela[0].length; i++){
            System.out.print("IN" + i + " | ");
        }
        System.out.println("OUT");

        for(int i = 0; i < tabela.length; i++){
            
            for(int j = 0; j < tabela[i].length; j++){
                System.out.print(" " + tabela[i][j] + "  | ");
            }
            System.out.println(saida[i]);
        }
    }
}
