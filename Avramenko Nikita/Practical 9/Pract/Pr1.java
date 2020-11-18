package Pract;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Pr1 {
    public static String A(String str){
        String[] aa = str.split("\\s+");
        return Arrays.stream(aa).max(Comparator.comparingInt(String::length)).orElse(null);
    }

    public static int B(String str){
        return str.split("\\s+").length;
    }

    public static void main(String[] args){
        String str;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        System.out.println(A(str));
        System.out.println(B(str));
    }
}
