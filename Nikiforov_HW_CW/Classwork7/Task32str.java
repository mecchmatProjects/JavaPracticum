package Classwork7;
import java.util.ArrayList;
import java.util.Scanner;

public class Task32str {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input word: ");
        String inp = sc.nextLine();
        System.out.println("Input key: ");
        ArrayList<Character> new_char = new ArrayList<Character>();
        int key = sc.nextInt();
        for (int i = 0; i < inp.length(); i++){
            char new_symbol = (char)(((int)inp.charAt(i) + key - 97) % 26 + 97);
            new_char.add(new_symbol);
        }
        System.out.println("Result: ");
        for(char x: new_char){
            System.out.print(x);
        }
    }
}
