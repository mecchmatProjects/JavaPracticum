package Classwork1;
import java.util.Scanner;
//num 1.5
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your line: ");
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        for(int i =ch.length-1;i>=0;i--){
            System.out.print(ch[i]);
        }
    }
}
