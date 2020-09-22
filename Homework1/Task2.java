package Homework1;
import java.util.Scanner;

public class Task2 {
    public static float Ermit(int n, float x){
        if(n==0){
            return 1;
        }
        else if(n==1){
            return 2*x;
        }
        else{
            return 2*x*Ermit(n-1,x) - 2*(n-1)*Ermit(n-2,x);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n = ");
        int n = sc.nextInt();
        System.out.print("Input x = ");
        float x = sc.nextFloat();
        System.out.println("Answer: "+ Ermit(n,x));
    }
}
