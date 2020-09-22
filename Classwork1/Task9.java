package Classwork1;
import java.util.Scanner;
//num 4.2
public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputer = 1;
        int counter=0;
        int sum = 0;
        while (inputer!=0){
            System.out.println("Input a["+counter+"]: ");
            inputer = sc.nextInt();
            sum+=inputer;
            counter+=1;
        }
        System.out.println("Sum = "+sum);

    }
}
