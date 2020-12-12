/**
 * 
 * @author �������� ������. �������� 26/10/2020
 *
 */

public class Chassis {

	/**
	 * ������������� ����
	 * ������ ����� ����� ���� ������
	 * ������������ ���������� ����
	 */
	private double weight = 100;
	private double time_in = 10;
	private double time_out = 15;
	private boolean is_out = false;
	
	/**
	 * �����������
	 * @param _weight ���� ����
	 * @param _time_in ��� ������ ����
	 * @param _time_out ��� ������ ����
	 */
	Chassis(double _weight, double _time_in, double _time_out){
		weight = _weight;
		time_in = _time_in;
		time_out = _time_out;
		is_out = false;
	}
	
	/**
	 * �����, �� ������� ���� ����
	 * @return ����
	 */
	protected double getWeight() {
		return weight;
	}
	
	/**
	 * �����, �� ������� ���, �� ���� ��� ���� ���������� � ����
	 * @return ���
	 */
	protected double getTimeIn() {
		return time_in;
	}
	
	/**
	 * �����, �� ������� ��� ������ ����
	 * @return ���
	 */
	protected double getTimeOut() {
		return time_out;
	}
	
	/**
	 * �����, �� ������� ����� ����
	 */
	protected void chassisOut() {
		if (!is_out) {
			is_out = true;
		}
	}
	
	/**
	 * �����, �� ������� ����� ����
	 */
	protected void chassisIn() {
		if (is_out) {
			is_out = true;
		}
	}
}
