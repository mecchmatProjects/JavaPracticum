import java.util.Scanner;

public class Lesson2_4_1{
    static int factorial1(int n) { 
        if (n == 0) 
          return 1; 
        return n*factorial1(n-1); 
    } 
    
    static int factorial2(int n) { 
        int res = 1, i; 
        for (i=2; i<=n; i++) 
            res *= i; 
        return res; 
    } 
    
    public static void main(String[] args){ 
        Scanner in = new Scanner(System.in);  
        
        System.out.print("Input num: ");
        String num = in.nextLine(); 
        try {
            int x = Integer.parseInt(num); 
            System.out.println("Valid input");
        }catch(NumberFormatException e) {
            System.out.println("Your input is not an int value"); 
 } 
        int x = Integer.parseInt(num); 
        System.out.println("Recurcive factorial of "+ num + " is " + factorial1(x)); 
        System.out.println("Iterative factorial of "+ num + " is " + factorial2(x)); 
    } 
}

