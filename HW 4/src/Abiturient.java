import java.util.ArrayList;

/**
 * 
 * @author �������� ������. �������� 26/10/2020
 *
 */
public class Abiturient {

	/**
	 * ����, �� ����������������.
	 * �� ����� ����������� ������� private ��� ������������.
	 * ���� ������� ������� ������ ����, ������� ��� ����� ������� ������ �����.
	 */
	private String name = "", second_name = "", last_name = "";
	private String adress = "", phone_number = "";
	private ArrayList <String> points = new ArrayList <>();
	private static int normPoint = 60, semiPassPoint = 59;
	
	/**
	 * �����������
	 * @param _name ��'� ��������
	 * @param _second_name ������� ��������
	 * @param _last_name �� ������� ��������
	 * @param _adress ������ ��������
	 * @param _phone_number �������� ������� ��������
	 */
	Abiturient (String _name, String _second_name, String _last_name, String _adress, String _phone_number){
		name = _name;
		second_name = _second_name;
		last_name = _last_name;
		adress = _adress;
		phone_number = _phone_number;
	}
	
	/**
	 * ����� ��� ���� ��������� ������
	 * @param newPoint ���� ��������� ������
	 */
	protected static void setNormPoint(int newPoint) {
		normPoint = newPoint;
	}
	
	/**
	 * ����� ��� ���� ������������ �������� ������
	 * @param newPoint
	 */
	protected static void setSemiPassPoint(int newPoint) {
		semiPassPoint = newPoint;
	}
	
	/**
	 * �����, �� ����������, �� �� ������� ����������� ������
	 * @return �� �� ������� ����������� ������
	 */
	protected boolean hasLessThanNormPoint() {
		int n = points.size();
		for(int i = 0; i < n; i ++) {
			if (Integer.parseInt(points.get(i)) < normPoint) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����, �� ���������� �� � ����� ���� �������� ������ �� ������
	 * @param num ������� ���
	 * @return � ����� ���� �������� ������ �� ������
	 */
	protected boolean isPointsSumGraterThen(double num) {
		if(pointsSum() > num) {
			return true;
		}
		return false;
	}
	
	/**
	 * �����, �� ������� ���� ���� ��������
	 * @return ���� ����
	 */
	protected int pointsSum() {
		int n = points.size();
		int s = 0;
		for(int i = 0; i < n; i ++) {
			s += Integer.parseInt(points.get(i));
		}
		return s;
	}
	
	/**
	 * �����, �� ���������� �� � ������� ��� �������������
	 * @return �� � ������� ��� �������������
	 */
	protected boolean meanPointIsSemiPass() {
		if(((double) pointsSum()) / ((double) points.size()) == (double) semiPassPoint) {
			return true;
		}
		return false;
	}
	
	/**
	 * ��������������� �����, �� ������� ����� ������ �������� ���, � ���� � ���������� ������
	 * @param abiturients ������ ��������
	 * @return ������ ���, � ���� � ������ ����� �� ���������
	 */
	private static Abiturient[] getNotNormalPointList(Abiturient[] abiturients) {
		int n = abiturients.length;
		ArrayList <Abiturient> res = new ArrayList<>();
		for(int i = 0; i < n; i ++) {
			if (abiturients[i].hasLessThanNormPoint()) {
				res.add(abiturients[i]);
			}
		}
		int m = res.size();
		Abiturient[] outres = new Abiturient[m];
		if (m < 1) {
			return outres;
		}
		for(int i = 0; i < m; i ++) {
			outres[i] = res.get(i);
		}
		return outres;
	}
	
	/**
	 * �����, �� ���� ������ ��������
	 * @param newPoint ���� ������, ���� �����
	 */
	protected void addPoint(int newPoint) {
		points.add(Integer.toString(newPoint));
	}
	
	/**
	 * �����, �� ���� ������ ��������
	 * @param newPoint ���� ������, ������
	 */
	protected void addPoint(String newPoint) {
		points.add(newPoint);
	}
	
	/**
	 * ��������������� �����, ���� ������� ����� � ������
	 * @return �����, �� ������ �� ������
	 */
	private String getPointsString() {
		String s = "";
		int n = points.size();
		for(int i = 0; i < n; i ++) {
			if (i == n-1) {
				s += points.get(i);
			}
			else {
				s += points.get(i) + ", ";
			}
		}
		return s;
	}
	
	/**
	 * �������������� ����� toString(), ��� ������� ��� ��� �������� �� �������
	 */
	public String toString(){
		String s = getPointsString();
		return "������� " + second_name + " " + name + " " + last_name + ", ������: "
				+ adress + ", " + phone_number + ", ������: " + s + ".";
	}
	
	/**
	 * �����, �� �������� �� ������� ��� ��������, �� ����� ����������� ������
	 * @param abiturients ������ ��������
	 */
	protected static void showNotNormalPointAbiturients(Abiturient[] abiturients) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getNotNormalPointList(abiturients);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		int n = to_show.length;
		System.out.println("������ ��������, �� ����� ���������� ������:");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
	
	/**
	 * ��������������� �����, �� ����������, �� �������� ����� ����� ���� ���� �� ������
	 * @param abiturients ������ ��������
	 * @param num ������� ���
	 * @return ������ ���, � ���� ���� ���� ���� �� ������
	 */
	private static Abiturient[] getAbiturientsPointsSumGraterThen(Abiturient[] abiturients, double num) {
		ArrayList <Abiturient> res = new ArrayList<>();
		int n = abiturients.length;
		for(int i = 0; i < n; i ++) {
			if (abiturients[i].isPointsSumGraterThen(num)) {
				res.add(abiturients[i]);
			}
		}
		int m = res.size();
		Abiturient[] outres = new Abiturient[m];
		if (m < 1) {
			return outres;
		}
		for(int i = 0; i < n; i ++) {
			outres[i] = res.get(i);
		}
		return outres;
	}
	
	/**
	 * �����, �� �������� �� ������� ��� ��������, �� ����� ���� ���� ���� �� ������
	 * @param abiturients ������ ��������
	 * @param num ������� ���
	 */
	protected static void showAbiturientsPointsSumGraterThen(Abiturient[] abiturients, double num) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getAbiturientsPointsSumGraterThen(abiturients, num);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		int n = to_show.length;
		System.out.println("������ ��������, �� ����� ����� ���� ���� �� " + num + ":");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
	
	/**
	 * ��������������� �����, �� ����������, �� �������� ����� ������������� ������� ���
	 * @param abiturients ������ ��������
	 * @return ������ ��� ��������, �� ����� ������������� ������� ���
	 */
	private static Abiturient[] getAbiturientsMeanPointIsSemiPass(Abiturient[] abiturients) {
		ArrayList <Abiturient> res = new ArrayList<>();
		int n = abiturients.length;
		for(int i = 0; i < n; i ++) {
			if (abiturients[i].meanPointIsSemiPass()) {
				res.add(abiturients[i]);
			}
		}
		int m = res.size();
		Abiturient[] outres = new Abiturient[m];
		if (m < 1) {
			return outres;
		}
		for(int i = 0; i < n; i ++) {
			outres[i] = res.get(i);
		}
		return outres;
	}
	
	/**
	 * �����, �� �������� �� ������� ��� ��������, �� ����� ������� ������������� ���
	 * @param abiturients
	 */
	protected static void showAbiturientsMeanPointIsSemiPass(Abiturient[] abiturients) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getAbiturientsMeanPointIsSemiPass(abiturients);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		int n = to_show.length;
		System.out.println("������ ��������, �� ����� ������������� ������� ���:");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
	
	/**
	 * ��������������� �����, �� ��������� ����������� ���������� �� ������ ��������
	 * ����� �� ������� �������� ����� ����
	 * @param abiturients ������ ��������
	 * @return ������������ ������ ��������
	 */
	private static Abiturient[] bubbleSortBySum(Abiturient[] abiturients) {
		int n = abiturients.length;
		for(int pass_num = n-1; pass_num>0; pass_num--) {
			for(int i = 0; i < pass_num; i++) {
				if(abiturients[i].pointsSum() < abiturients[i+1].pointsSum()) {
					Abiturient t = abiturients[i];
					abiturients[i] = abiturients[i+1];
					abiturients[i+1] = t;
				}
			}
		}
		return abiturients;
	}
	
	/**
	 * ��������������� �����, �� ���������� ������ �������� � �������� ������ ����
	 * @param abiturients ������ ��������
	 * @param n ������� ������ ��������
	 * @return ������ � ������ n ��������
	 */
	private static Abiturient[] getFirstAbiturientsWithHighestPointsSum(Abiturient[] abiturients, int n) {
		Abiturient[] sorted = Abiturient.bubbleSortBySum(abiturients);
		Abiturient[] outres = new Abiturient[n];
		for(int i = 0; i < n; i ++) {
			outres[i] = sorted[i];
		}
		return outres;
	}
	
	/**
	 * �����, �� �������� �� ������� ������ �������� � �������� ����� ����
	 * @param abiturients ������ ��������
	 * @param n ������� ������ ��������
	 */
	protected static void showFirstAbiturientsWithHighestPointsSum(Abiturient[] abiturients, int n) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getFirstAbiturientsWithHighestPointsSum(abiturients, n);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		System.out.println("������ ������ " + n + " ��������, �� ����� ������� ���� ����:");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
}