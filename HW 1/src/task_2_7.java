import java.util.Scanner;
import java.math.BigInteger;


/**
 * 
 * @author �������� ������. �������� 24/10/2020. �������� 2.7
 *
 */
public class task_2_7 {
	
	/**
	 * 
	 * @param args
	 * �������� ����� main �������� 2.7
	 * 
	 * � ������ ���� ��������������� ������ ��������� bigNum, ��� ���� �� �� ����
	 * ��������� ����� Substract (����� ������� ����), ���� ���� �� ��������������� 
	 * ��������� ���������.
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		input.close();
		String[] sline = line.split(", ");
		BigInteger num1 = new BigInteger(sline[0]), num2 = new BigInteger(sline[1]);
		BigInteger n = num1.add(num2), m = num1.subtract(num2);
		System.out.println("����� �����: " + n);
		System.out.println("�������� �����: " + m);
	}
}
