/**
 * 
 * @author �������� ������. �������� 26/10/2020
 *
 */
public class Wing {

	/**
	 * ������������� ����
	 * ������ ����� ����� ���� ������
	 * ������������ ���������� �����
	 */
	private double wingLengths = 10.0;
	private boolean right = true, left = false;
	private double subWingAngle = 15;
	
	/**
	 * �����������
	 * @param _wingLengths ������� �����
	 * @param side ����� �� ��� �����
	 */
	Wing(double _wingLengths, String side){
		if(side.equals("right")) {
			right = true;
			left = false;
		}
		else if (side.equals("left")) {
			right = false;
			left = true;
		}
		wingLengths = _wingLengths;
	}
	
	/**
	 * �����, �� ����������, �� � ����� ������
	 * @return �� � ����� ������
	 */
	protected boolean isRight() {
		return right;
	}
	
	/**
	 * �����, �� ����������, �� � ����� ����
	 * @return �� � ����� ����
	 */
	protected boolean isLeft() {
		return left;
	}
	
	/**
	 * �����, �� ����� ����� �����������
	 * @param _subWingAngle ���
	 */
	protected void changeAngle(double _subWingAngle) {
		subWingAngle = _subWingAngle;
	}
	
	/**
	 * �����, �� ������� ��� �����������
	 * @return ���
	 */
	protected double getAngle() {
		return subWingAngle;
	}
	
	/**
	 * �����, �� ������� ������� �����
	 * @return �������
	 */
	protected double getLength() {
		return wingLengths;
	}
}
