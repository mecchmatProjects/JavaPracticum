import java.util.ArrayList;

/**
 * 
 * @author �������� ������. �������� 26/10/2020.
 * ����� ���������� �� �������, �� �� ���, ���� �� ��� ���� � ����������, �� � ������
 */
public class Plane extends Engine {

	/**
	 * ������������� ����
	 * ������ ����� ����� ���� ������
	 * ������������ ���������� �������
	 */
	private ArrayList <String> route = new ArrayList<>();
	private int maxSpeed = 800;
	private int currentIndex = 0;
	private int routeLength = route.size();
	
	/**
	 * �����������
	 * @param _volume ��'��
	 * @param _maxRev ���������� �������
	 * @param _power ���������
	 * @param _route ������� (��������� ArrayList)
	 * @param _maxSpeed ����������� ��������
	 */
	Plane(int _volume, int _maxRev, int _power, ArrayList <String> _route, int _maxSpeed) {
		super(_volume, _maxRev, _power);
		route = _route;
		maxSpeed = _maxSpeed;
	}
	
	/**
	 * �����������
	 * @param _volume ��'��
	 * @param _maxRev ���������� �������
	 * @param _power ���������
	 * @param _route ������� (��������� String[])
	 * @param _maxSpeed ����������� ��������
	 */
	Plane(int _volume, int _maxRev, int _power, String[] _route, int _maxSpeed) {
		super(_volume, _maxRev, _power);
		maxSpeed = _maxSpeed;
		ArrayList <String> arr = new ArrayList<>();
		int l = _route.length;
		for(int i = 0; i < l; i ++) {
			arr.add(_route[i]);
		}
		route = arr;
	}
	
	/**
	 * �����������
	 * @param _route ������� (��������� String[])
	 */
	Plane(String[] _route){
		super();
		ArrayList <String> arr = new ArrayList<>();
		int l = _route.length;
		for(int i = 0; i < l; i ++) {
			arr.add(_route[i]);
		}
		route = arr;
	}
	
	/**
	 * �����������
	 * @param _route ������� (��������� Arraylist)
	 */
	Plane (ArrayList <String> _route){
		super();
		route = _route;
	}

	/**
	 * �����, �� ������� ����������� ��������
	 * @return ����������� ��������
	 */
	protected int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 * �����, �� ������� �������
	 * @return �������
	 */
	protected ArrayList <String> getRoute() {
		return route;
	}
	
	/**
	 * �������������� ����� toString(). ��������� �� ������� �������
	 */
	public String toString() {
		String s = "";
		for(int i = 0; i < routeLength; i ++) {
			s += route.get(i);
		}
		return s;
	}
	
	/**
	 * �����, �� ���� �������� �� ��������
	 * @param place ��������
	 */
	protected void addToRoute(String place) {
		route.add(place);
	}
	
	/**
	 * �����, �� ������� ������ �� ��������� ��������� �� ����������
	 */
	protected void fly() {
		if (!isOver()) {
			System.out.println("������ � ��������� " + route.get(currentIndex));
			currentIndex ++;
			System.out.println("������ � �������� " + route.get(currentIndex));
		}
		else {
			System.out.println("������� ���������");
		}
	}
	
	/**
	 * �����, �� ������� ����� ��������� ���������
	 * @return �������� ��������
	 */
	protected String getCurrentPlace() {
		return route.get(currentIndex);
	}
	
	/**
	 * �����, �� ����������, �� �������� ���� �������
	 * @return �� ��������� �������
	 */
	protected boolean isOver() {
		if (currentIndex == routeLength - 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * �����, �� ������� ������� ��������
	 * @return ������� ��������� � �������
	 */
	protected int getRouteLength() {
		return routeLength;
	}
}
