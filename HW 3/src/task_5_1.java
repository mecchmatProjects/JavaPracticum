import java.util.Scanner;
import java.util.Arrays;

/**
 * 
 * @author �������� ������. �������� 25/10/2020. �������� 5.1
 *
 */
public class task_5_1 {

	/**
	 * �������� ����� main �������� 5.1
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		input.close();
		String[] nums = line.split(" ");
		int[] int_nums = Arrays.asList(nums).stream().mapToInt(Integer::parseInt).toArray();
		int[] array = bubble_sort(int_nums);
		System.out.println("��������: " + array[array.length-1]);
		System.out.println("̳����: " + array[0]);
		System.out.println("Naumenko, task 5.1");
	}
	
	/**
	 * �����, �� ������� ����������� ����������� ������� ����� �����
	 * @param arr ������� ������
	 * @return ������������ ������
	 */
	private static int[] bubble_sort(int[] arr){
		
		int n = arr.length;
		for(int pass_num = n-1; pass_num>0; pass_num--) {
			for(int i = 0; i < pass_num; i++) {
				if(arr[i] > arr[i+1]) {
					int t = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = t;
				}
			}
		}
		return arr;
	}
}
