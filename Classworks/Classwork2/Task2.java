package Classwork2;
import java.util.Scanner;
//5.2
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input amount of numbers: ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i=0;i<n;i++) {
            double inputer = sc.nextDouble();
            arr[i] = inputer;
        }
        double mean = 0;
        for(int i=0;i<n;i++) {
            mean+=arr[i];

        }
        mean = mean/n;
        System.out.println("Mean= "+mean);
        double sum = 0;
        for(int i=0;i<n;i++) {
            sum += Math.pow(arr[i]-mean,2);
        }
        double sd = Math.sqrt(sum/(n-1));
        System.out.println("Sample standard deviation: "+sd);

    }
}
