import java.util.Scanner;



/*
�ʲ�� �������� �� ������ � �����˲!!! NEXTLINE �� ���� �������� �����.
� ��� ��в�� �� ��������, ��� ������ ����Բ��ֲ� � ��Ͳ ������ �������� � �����.
�� ��������� �� ��, ���� ABITURIENT ����ު ���������.
*/

/**
 * 
 * @author �������� ������. �������� 26/10/2020. �������� 1.4
 *
 */
public class task_1_4 {

	/**
	 * �������� ����� main �������� 1.4
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		//System.out.println("������ ������� ��������:");
		//int n = input.nextInt();
		//System.out.println("������ ������� ��������:");
		//int m = input.nextInt();
		int n = 1;
		Abiturient[] abiturients = new Abiturient[n];
		/*String name = "", second_name = "", last_name = "", adress = "", phone_number = "";
		for(int i = 1; i < n + 1; i ++) {
			System.out.println("������ ��'� �������� " + i + ":");
			name = input.nextLine();
			System.out.println("������ ������� �������� " + i + ":");
			second_name = input.nextLine();
			System.out.println("������ ��-������� �������� " + i + ":");
			last_name = input.nextLine();
			System.out.println("������ ������ �������� " + i + ":");
			adress = input.nextLine();
			System.out.println("������ ����� ��������� �������� �������� " + i + ":");
			phone_number = input.nextLine();
			abiturients[i-1] = new Abiturient(name, second_name, last_name, adress, phone_number);
			for(int j = 1; j < m + 1; j ++) {
				System.out.println("������ ������ " + j + " �������� " + i + ":");
				abiturients[i-1].addPoint(input.nextInt());
			}
		}
		System.out.println("������ ������ ���� ����� ������: ");
		int num = input.nextInt();
		System.out.println("������ ������� ������ ��������: ");
		int _n = input.nextInt();*/
		
		String line = input.nextLine();
		input.close();
		String[] data = line.split(", ");
		abiturients[0] = new Abiturient(data[0], data[1], data[2], data[3], data[4]);
		int num = 250;
		int _n = 1;
		for(int i = 0; i < 5; i++){
			abiturients[0].addPoint(90);
		}
		
		Abiturient.showAbiturientsMeanPointIsSemiPass(abiturients);
		Abiturient.showAbiturientsPointsSumGraterThen(abiturients, num);
		Abiturient.showFirstAbiturientsWithHighestPointsSum(abiturients, _n);
		Abiturient.showNotNormalPointAbiturients(abiturients);
		
		System.out.println("Naumenko, task 1.4");
	}
}
