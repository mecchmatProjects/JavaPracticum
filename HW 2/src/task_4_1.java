import java.util.Scanner;

/**
 * 
 * @author �������� ������. �������� 24/10/2020. �������� 4.1
 *
 */
public class task_4_1 {
	
	/**
	 * �����, �� �������� �������� ������
	 * @param n ������ �����
	 * @return �������� �������� �����
	 */
	private static int loop_factorial(int n) {
		
		int f = 1;
		for(int i = 1; i < n + 1; i ++) {
			f *= i;
		}
		return f;
	}
	
	/**
	 * �����, �� �������� �������� �������
	 * @param n ������ �����
	 * @return �������� �������� �����
	 */
	private static int recursion_factorial(int n) {
		
		if (n == 1 | n == 0) {
			return 1;
		}
		else {
			return n * recursion_factorial(n-1);
		}	
	}
	
	/**
	 * �������� ����� main �������� 4.1
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double a = input.nextDouble();
		input.close();
		int b = (int) a;
		double c = (double) b;
		boolean eq = (a == c);
		if(eq) {
			System.out.println("������� ����� � �����!");
			//long t1 = System.currentTimeMillis();
			int lf = loop_factorial(b);
			//long t2 = System.currentTimeMillis();
			//long t3 = System.currentTimeMillis();
			int rf = recursion_factorial(b);
			//long t4 = System.currentTimeMillis();
			//long t_lf = t2 - t1, t_rf = t4 - t3;
			System.out.println("�������� ���������:");
			//System.out.println("�������� �������� - " + lf + " � ����� " + t_lf);
			//System.out.println("����������� �������� - " + rf + " � ����� " + t_rf);
			System.out.println("�������� �������� - " + lf);
			System.out.println("����������� �������� - " + rf);
			
		}
		else {
			System.out.println("������� ����� �� � �����!");
		}
		System.out.println("Naumenko, task 4.1");
	}
}
