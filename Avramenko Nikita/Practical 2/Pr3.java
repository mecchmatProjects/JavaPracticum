import java.util.Scanner;

public class Pr3 {
    public static void main(String[] args){
        int in=1, sum=0, i=0;

        System.out.println("Введіть масив: ");
        Scanner scan = new Scanner(System.in);
        while (in != 0){
            System.out.printf("a[%d] = ",i++);
            in = scan.nextInt();
            sum+= in;
        }

        System.out.println("Сума чисел: " + sum);

    }
}