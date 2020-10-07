import java.util.Scanner;

public class Pr2 {
    public static void main(String[] args){
        System.out.println("Введіть кількість значень: ");
        int n;
        double sum=0f;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        double[] numArray = new double[n];

        for (int i=0; i<n; i++){
            numArray[i] = in.nextDouble();
            sum += numArray[i];
        }
        double mean = sum/n, standardDeviation = 0.0;
        System.out.println("Mean: " + mean);
        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        System.out.println("standardDeviation: " + standardDeviation);
    }
}
