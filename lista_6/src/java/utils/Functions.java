package utils;

public class Functions {
    public static double Sigmoid(double x){
        return 1 / (1 + Math.exp(-x));
    }
    public static double TanH(double x){
        return Math.tanh(x);
    }
    public static double ReLu(double x){
        return Math.max(0, x);
    }
    public static double LeakyReLu(double x){
        return Math.max(0.01 * x, x);
    }
    public static double BinaryStep(double x){
        if(x < 0)
            return 0;
        else
            return 1;
    }
    public static double SoftPlus(double x){
        return Math.log(1 + Math.exp(x));
    }
    //Derivatives of the Activation Functions
    public static double DSigmoid(double x){
        return x * (1 - x);
    }
    public static double DTanH(double x){
        return 1 - (x * x);
    }
    public static double DReLu(double x){
        if(x > 0)
            return 1;
        else
            return 0;
    }
    public static double DLeakyReLu(double x){
        if(x > 0)
            return 1;
        else
            return 0.01;
    }
    public static double DBinaryStep(double x){
        return 0;
    }
    public static double DSoftPlus(double x){
        return 1 / (1 + Math.exp(-x));
    }
}
