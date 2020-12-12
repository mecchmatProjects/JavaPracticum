import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author �������� ������. �������� 25/10/2020. �������� 5.2
 *
 */
public class task_5_2 {

	/**
	 * �������� ����� main �������� 5.2
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		input.close();
		String[] nums = line.split(" ");
		int[] int_nums = Arrays.asList(nums).stream().mapToInt(Integer::parseInt).toArray();
		double mean = mean_(int_nums), ssd = ssd_(int_nums);
		System.out.println("Mean = " + mean + ";");
		System.out.println("Sample standart deviation = " + ssd + ".");
		System.out.println("Naumenko, task 5.2");
	}
	
	/**
	 * �����, �� ���� ����� ������
	 * @param arr ������
	 * @return ������
	 */
	private static double mean_(int[] arr) {
		
		double s = 0, n = arr.length;
		for(int i = 0; i < n; i ++) {
			s += arr[i];
		}
		double res = s / n;
		return res;
	}
	
	/**
	 * �����, �� ���� ��������� sample standart deviation
	 * @param arr ������
	 * @return ���������
	 */
	private static double ssd_(int[] arr) {
		
		double x_ = mean_(arr);
		double n = arr.length;
		double s = 0;
		for(int i = 0; i < n; i ++) {
			s = s + Math.pow(arr[i] - x_, 2);
		}
		double res = Math.sqrt(s / (n - 1));
		return res;
	}
}
