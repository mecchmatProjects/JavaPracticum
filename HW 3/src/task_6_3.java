import java.util.Scanner;

/**
 * 
 * @author �������� ������. �������� 25/10/2020. �������� 6.3
 *
 */
public class task_6_3 {

	/**
	 * �������� ����� main �������� 6.3
	 * @param args
	 */
	public static void main(String[] args) {
		
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
		input.close();
		
		int maxi = 0, counter = 1;
		for(int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if(j == n-1 & i != m-1) {
					if (matrix[i][j] < matrix[i+1][0]) {
						counter ++;
					}
					else {
						if (counter > maxi) {
							maxi = counter;
						}
						counter = 1;
					}
				}
				else if (j == n-1 & i == m-1) {
					if (counter > maxi) {
						maxi = counter;
					}
					counter = 1;
				}
				else {
					if (matrix[i][j] < matrix[i][j+1]) {
						counter ++;
					}
					else {
						if (counter > maxi) {
							maxi = counter;
						}
						counter = 1;
					}
				}
			}
		}
		System.out.println("ʳ������: " + maxi);
		System.out.println("Naumenko, task 6.3");
	}
}
