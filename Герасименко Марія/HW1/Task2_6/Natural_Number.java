import java.math.*;
import java.util.Scanner;

public class Natural_Number {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 'k' num: ");
        byte k = in.nextByte();
        System.out.println("Enter 'm' num: ");
        long m = in.nextByte();
        int result = (int) Math.pow(m, k);
        System.out.println("Result: " + result);
    }


}