package Homework1;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Input n = ");
        int n = sc.nextInt();
        String s = Integer.toBinaryString(n);
        char[] ch = s.toCharArray();
        for (int i = 1;i < ch.length;i++){
            ch[i-1]=ch[i];
        }
        ch[ch.length-1]='1';
        s = String.valueOf(ch);
        System.out.println(Integer.parseInt(s, 2));
    }
}
