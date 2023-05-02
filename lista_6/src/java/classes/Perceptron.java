package classes;

import java.util.function.Function;
import utils.Functions;

public class Perceptron implements Neuralable {

    private double[] weigths;
    private double rateKnown;
    private double bias;
    private double biasWeigth;
    private Function<Double, Double> activateFunction = null;
    private static final double BIAS_PERCEPTRON = 1;

    public Perceptron(int entries, double rateKnown, double bias, int randomSeed, Function<Double, Double> function) {
        this.bias = BIAS_PERCEPTRON;
        if (randomSeed == -1) {
            randomSeed = (int) new java.util.Date().getTime();
        }
        this.weigths = new double[entries];
        this.biasWeigth = Neural.doRandomWeigth(this.weigths, randomSeed);
        if (function == null) {
            function = Functions::DSigmoid;
        }
        this.activateFunction = function;
        if (rateKnown > 0.031) {
            rateKnown = 0.031;
        } else if (rateKnown < 0.00000001) {
            rateKnown = 0.00000001;
        }
        this.rateKnown = rateKnown;
    }

    @Override
    public double train(double[][] table, double[] exits, double acceptence) {
        double totalError = 0;
        for (int i = 0; i < table.length; i++) {
            double sum = Neural.sum(table[i], weigths, bias, biasWeigth);
            sum = activateFunction.apply(sum);
            if (Neural.compare(sum, exits[i], acceptence) == false) {
                double error = Neural.calculateError(exits[i], sum);
                totalError += Math.abs(error);
                weightAdjust(error, table[i]);
            }
        }
        return totalError;
    }

    @Override
    public void trainEpoch(double[][] table, double[] exits, int epochs, double acceptence) {
        int qtdEpochs = 0;
        for (int i = 0; i < epochs; i++) {
            double error = train(table, exits, acceptence);
            qtdEpochs = i;
            Neural.suffle(table, exits);
            if (error == 0) {
                i = epochs;
            }
        }
        System.out.println("Training time: " + qtdEpochs + " epochs");
    }

    @Override
    public void weightAdjust(double error, double[] expected) {
        biasWeigth += bias * rateKnown * error;
        for (int j = 0; j < weigths.length; j++) {
            weigths[j] += rateKnown * error * expected[j];
        }
    }

    @Override
    public double predict(double[] entries) {
        double sum = Neural.sum(entries, weigths, bias, biasWeigth);
        return activateFunction.apply(sum);
    }

    @Override
    public double[] predict(double[][] testTable) {
        double[] result = new double[testTable.length];
        for (int i = 0; i < testTable.length; i++) {
            result[i] = predict(testTable[i]);
        }
        return result;
    }

}