import java.util.Scanner;

/*  ����� ������� ����������� �������, �� ��������� ��� ���� �����
 *  ������ ��������� ���, � 10101 << 2 = 1010100, �� ��-���� ������ ���  */

//  �� ���� ������ ����� � ���������� �������

/**
 * 
 * @author �������� ������. �������� 24/10/2020. �������� 2.3
 *
 */
public class task {
	
	/**
	 * 
	 * @param args
	 * �������� ����� main �������� 2.3
	 */
	public static void main(String[] args){
		int a, counter = 0;
		String a2;
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		input.close();
		a2 = Integer.toBinaryString(a);
		int l = a2.length();
		for (int i=0; i<l-1; i++) {
			if(a2.charAt(i) == a2.charAt(i+1) & a2.charAt(i) == '1') {
				counter ++;
			}
		}
		System.out.println(counter);

	}
	
}
