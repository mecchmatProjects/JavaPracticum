package Classwork1;
import java.util.Scanner;
//num4.1
public class Task8 {
    public static int fact(int n,int answ){
        if (n==1) return answ;
        return fact(n-1,answ*n);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");
        int n = sc.nextInt();
        System.out.println("Is number natural?");
        if(n<=0){
            System.out.println("No, Bue!");
            System.exit(0);
        }
        else{
            System.out.println("Yes");
        }
        System.out.println("Cycle: ");
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        System.out.println(fact);
        System.out.println("Recursion: ");
        System.out.println(fact(n,1));
    }
}
