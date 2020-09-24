import java.util.Scanner;
public class Lesson3_Deriviation{
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("N?");
        int n = scanner.nextInt();
        double[] arr = new double[n];
        double sum = 0;

        for(int i=0; i<arr.length; i++){
        	System.out.print("Enter "+ (i+1) +" number: ");
        	arr[i] = scanner.nextDouble();
        }
        scanner.close();
        
        for(int i=0; i<arr.length; i++){
        	sum = sum + arr[i];
        }
        double average = sum / arr.length;
        double standardDeviation = 0;
        for(int i=0; i<arr.length; i++) {
            standardDeviation += Math.pow(arr[i] - average, 2);
        }
        System.out.println("Standard deviation: ");
        System.out.println(Math.sqrt(standardDeviation/arr.length));
        System.out.format("Answer: %.2f", average);
    }
}
