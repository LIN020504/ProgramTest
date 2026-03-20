package Method;

public class Arcsin {
    public static double arcsin(double x,int items){
        if (x > 1 || x < -1 ){
            throw new IllegalArgumentException("The domain of arcsin is [-1,1]");
        }

        double numerator = 0;
        double denominator = 0;

        double result = 0;

        if (x == 1){
            result = Math.PI / 2;
        } else if (x == -1) {
            result = Math.PI / -2;
        } else {
            for (int n = 0; n < items; n++){
                numerator = factorial(2 * n);
                denominator = Math.pow(4,n) * Math.pow(factorial(n),2) * (2 * n + 1);
                result += numerator / denominator * Math.pow(x,(2 * n + 1));
            }
        }
        return result;
    }

    public static double factorial(int n){
        double start = 1;
        for (int i = 2; i <= n; i++){
            start = start * i;
        }
        return start;
    }
}
