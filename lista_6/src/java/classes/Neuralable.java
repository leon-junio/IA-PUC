package classes;

public interface Neuralable {
    public double train(double[][] tabela, double[] saidas, double tolerancia);

    public void trainEpoch(double[][] table, double[] exits, int epochs, double acceptence);

    public double predict(double[] entries);

    public double[] predict(double[][] testTable);

    public void weightAdjust(double error, double[] expected);
}
