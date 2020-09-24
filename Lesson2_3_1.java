import java.util.Scanner; 
import static java.lang.Math.*; 

public class Lesson2_3_1 { 
    public static void find_my_roots(int a, int b, int c){
     if (a == 0){ 
        System.out.println("Invalid"); 
        return; 
     } 
     int d = b*b - 4*a*c; 
     double my_sqrt = sqrt(abs(d)); 
   
     if (d > 0){ 
        double ans1 = (-b + my_sqrt) / (2*a);
        double ans2 = (-b - my_sqrt) / (2*a);
        System.out.println("Roots are real and different"); 
        System.out.println("First anwer: " + ans1 + "\n" + "Second anwer: " + ans2); 
     } 
     else{ 
        double ans = -b / (2*a);
        System.out.println("Roots are complex"); 
        System.out.println("First anwer: " + ans + " + i * " + my_sqrt + "\n"  
                            + "Second anwer: " + ans + " - i * " + my_sqrt); 
        } 
    } 
   
 public static void main(String args[]){ 
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter a: ");
        int a = in.nextInt(); 
        System.out.println("Enter b: ");
        int b = in.nextInt();
        System.out.println("Enter c: ");
        int c = in.nextInt();
        find_my_roots(a, b, c); 
    } 
} 
