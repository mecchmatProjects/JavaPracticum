import java.util.Scanner;

public class Lesson1_1_2{
    static float harmonicMean(float arr[]){ 
        int n = 2;
        float sum = 0; 
        for (int i = 0; i < n; i++) 
            sum = sum + (float)1 / arr[i]; 
        return (float)n/sum; 
    } 
    
    static void getCountsOfDigits(int number) {
        int a = String.valueOf(Math.abs(number)).length();
        System.out.println("Number of digits (string method): " + a);
    }
    
    static int getCountsOfDigitslog(int number) {
        return(number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        System.out.print("Input first number: ");
        int num1 = in.nextInt();
        
        System.out.print("Input second number: ");
        int num2 = in.nextInt();
        
        getCountsOfDigits(num1);
        getCountsOfDigits(num2);
        System.out.println("Number of digits (log method): " + getCountsOfDigitslog(num1));
        System.out.println("Number of digits (log method): " + getCountsOfDigitslog(num2));
        
        float arr[] = {(float)num1, (float)num2};
        System.out.println("Harmonic mean: ");
        System.out.format("%-10.2f%n", harmonicMean(arr));
  }
}
