package classes;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public final class Neural {

    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static double[][] suffle(double[][] table, double[] exits) {
        Random gen = new Random();
        for (int i = 0; i < table.length; i++) {
            int index = gen.nextInt(table.length);
            double[] temp = table[i];
            table[i] = table[index];
            table[index] = temp;
            double temp2 = exits[i];
            exits[i] = exits[index];
            exits[index] = temp2;
        }
        return table;
    }

    public static double sum(double[] entries, double[] weigths, double bias, double biasWeigth) {
        double sum = bias * biasWeigth;
        for (int i = 0; i < entries.length; i++) {
            sum += entries[i] * weigths[i];
        }
        return sum;
    }

    public static double doRandomWeigth(double[] weigths, int randomSeed) {
        Random gen = new Random(randomSeed);
        for (int i = 0; i < weigths.length; i++) {
            weigths[i] = (double) gen.nextDouble() * 2 - 1;
        }
        return (double) gen.nextDouble() * 2 - 1;
    }

    public static boolean compare(double saida, double wait, double acceptence) {
        return Math.abs(saida - wait) <= acceptence;
    }

    public static String weightToString(double biasWeigth, double[] weigths) {
        df.setRoundingMode(RoundingMode.UP);
        String result = "Bias Peso atual: " + df.format(biasWeigth);
        result += "\tPesos: ";
        for (double p : weigths) {
            result += df.format(p) + " ";
        }
        return result;
    }

    public static double calculateError(double wait, double calculated) {
        return wait - calculated;
    }
}
