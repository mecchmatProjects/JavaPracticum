import java.util.Scanner;

public class Pr1 {
    public static void main(String[] args){
        System.out.println("Введіть числа у рядок:");
        Scanner in = new Scanner(System.in);
        int x,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;

        while (in.hasNextInt()){
            x = in.nextInt();
            if (x > max)
                max = x;
            if (x < min)
                min = x;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
