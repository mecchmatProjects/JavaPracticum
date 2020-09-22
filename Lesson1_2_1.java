import java.util.Scanner;
public class Lesson1_2_1{
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input 1 number: ");
        int num1 = in.nextInt();
        System.out.print("Input 2 number: ");
        int num2 = in.nextInt();
        System.out.println("Ans: " + (num1^1<<num2));
	}
}
