import java.util.Scanner;

/**
 * 
 * @author �������� ������. �������� 25/10/2020. �������� 6.2
 *
 */
public class task_6_2 {

	/**
	 * �������� ����� main �������� 6.2
	 * @param rags
	 */
	public static void main(String[] rags) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("������ ������� ���������");
		int n = input.nextInt();
		System.out.println("������ ������� �����");
		int m = input.nextInt();
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				matrix[i][j] = input.nextInt();
			}
		}
		System.out.println("������ ������� ������� ��� ����� ������: ");
		int k = input.nextInt();
		input.close();
		
		System.out.println("������ �������:");
		showMatrix(matrix);
		for(int i = 0; i < m; i ++) {
			matrix[i] = rightCyc(matrix[i], k);
		}
		System.out.println("������� �������:");
		showMatrix(matrix);
		
	}
	
	/**
	 * �����, �� �������� ������� �� �������
	 * @param matrix ������ �������
	 */
	protected static void showMatrix(int[][] matrix) {
		String s = "";
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				if (j == n-1) {
					s += Integer.toString(matrix[i][j]) + " " + System.lineSeparator();
				}
				else {
					s += Integer.toString(matrix[i][j]) + " ";
				}
			}
		}
		System.out.println(s);
	}
	
	/**
	 * �����, �� ������� �������� ���� �� ������ ������
	 * @param arr �����
	 * @param k ������� �������, �� ��� ���� �������� �����
	 * @return ���������� �����
	 */
	protected static int[] rightCyc(int[] arr, int k) {
		int n = arr.length;
		int s = n - k;
		int[] res = new int[n];
		for(int i = n - 1; i > s - 1; i --) {
			res[n - 1 - i] = arr[i];
		}
		for(int i = 0; i < s; i ++) {
			res[k + i] = arr[i];
		}
		return res;
	}
}
