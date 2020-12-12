/**
 * 
 * @author �������� ������. �������� 26/10/2020
 *
 */

public class Engine {

	/**
	 * ������������� ����
	 * ������ ����� ����� ���� ������
	 * ������������ ���������� �������
	 */
	private int volume = 20000;
	private int maxRev = 40000;
	private int power = 5000;
	
	/**
	 * �����������
	 * @param _volume ��'��
	 * @param _maxRev ���������� �������
	 * @param _power ���������
	 */
	Engine(int _volume, int _maxRev, int _power){
		volume = _volume;
		maxRev = _maxRev;
		power = _power;
	}
	
	/**
	 * �����������
	 */
	Engine(){
		
	}
	
	/**
	 * �����, �� ������� ��'�� �������
	 * @return ��'��
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * �����, �� ������� ���������� ������� �������
	 * @return �������
	 */
	public int getMaxRev() {
		return maxRev;
	}
	
	/**
	 * �����, �� ������� ��������� �������
	 * @return ���������
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * �����, �� ���������� ��'�� �������
	 * @param _volume ��'��
	 */
	public void setVolume(int _volume) {
		volume = _volume;
	}
	
	/**
	 * �����, �� ���������� ���������� ������� �������
	 * @param _maxRev �������
	 */
	public void setMaxRev(int _maxRev) {
		maxRev = _maxRev;
	}
	
	/**
	 * �����, �� ���������� ��������� �������
	 * @param _power ���������
	 */
	public void setPower(int _power) {
		power = _power;
	}
}
