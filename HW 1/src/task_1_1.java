import java.util.Scanner;

/**
 * 
 * @author �������� ������. �������� 24/10/2020. �������� 1.1
 * 
 * 
 * 
 */
public class task_1_1 {
	
	/**
	 * 
	 * @param args
	 * �������� ����� main �������� ����� 1.1
	 */
	public static void main(String[] args) {
		System.out.println("Enter Your Name");
		String s;
		Scanner input = new Scanner(System.in);
		s = input.nextLine();
		input.close();
		System.out.println("Hello, " + s);
	}
}
