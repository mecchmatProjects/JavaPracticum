import java.util.Scanner;

public class Lesson3_Min_Max{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Print your numbers in string:");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (in.hasNextInt()){
            int x = in.nextInt();
            if (x < min)
                min = x;
            if (x > max)
                max = x;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
