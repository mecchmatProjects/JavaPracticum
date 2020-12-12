import java.util.Scanner;

/**
 * 
 * @author �������� ������. �������� 24/10/2020. �������� 4.7
 *
 */
public class task_4_7 {
	
	/**
	 * �����, �� �������� ��������� �������� ��������� ������������ �����
	 * @param n �����, �������� ����� ������������
	 * @return �������� �����
	 */
	private static int factorial(double n) {
		
		int f = 1;
		for(int i = 1; i < n + 1; i ++) {
			f *= i;
		}
		return f;
	}

	/**
	 * �������� ����� main �������� 4.7
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("������ �������:");
		double eps = input.nextDouble();
		System.out.println("������ �����:");
		double x = input.nextDouble();
		input.close();
		
		double res = 1.0, inc = x;
		double count = 1.0;
		while(Math.abs(inc) > eps) {
			inc = Math.pow(x, count)/ factorial(count);
			res += inc;
			count ++;
		}
		
		System.out.println(res);
	}
}
