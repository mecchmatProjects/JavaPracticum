import java.util.ArrayList;

/**
 * 
 * @author �������� ������. �������� 26/10/2020.
 *
 */
public class Polynom {

	/**
	 * ����, �� ������� ���������
	 * �������������, ������ �� ��� ���� ��� ������ �������� ���� ����� ������� ������
	 */
	private int deg = 0;
	private int[] coefs = null;
	
	/**
	 * �����������
	 * @param coefs_ ��'��� ArrayList, ����������� ����������
	 */
	Polynom (ArrayList<String> coefs_){
		deg = coefs_.size() - 1;
		int[] coefs = new int[deg];
		for(int i = 0; i < deg; i ++) {
			coefs[i] = Integer.parseInt(coefs_.get(i));
		}
	}
	
	/**
	 * �����������
	 * @param coefs_ ����� ����� �����, �����������
	 */
	Polynom(int[] coefs_){
		deg = coefs_.length - 1;
		coefs = coefs_;
	}
	
	/**
	 * �����, �� ����������, �� � ��������� �������� �����
	 * @return �� � ��������� �������� �����
	 */
	protected boolean isZero() {
		if(deg == 0 & coefs[0] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * ��������� �����, �� ����������, �� � ��������� �����
	 * @param g ���������
	 * @return �� � ��� ��������� �����
	 */
	protected static boolean isZero(Polynom g) {
		if(g.deg == 0 & g.coefs[0] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * �����, �� ���� 2 ����������
	 * @param f ������ ���������
	 * @param g ������ ���������
	 * @return ���� ����������
	 */
	protected static Polynom polySum(Polynom f, Polynom g) {
		int fd = f.deg, gd = g.deg;
		int deg = Math.max(fd, gd);
		int _deg = Math.min(fd, gd);
		int[] coefs_ = new int[deg + 1];
		for(int i = 0; i < _deg + 1; i++) {
			coefs_[deg - i] = f.coefs[fd - i] + g.coefs[gd - i];
		}
		if (fd > gd) {
			for(int i = 0; i < deg - _deg; i ++) {
				coefs_[i] = f.coefs[i];
			}
		}
		else {
			for(int i = 0; i < deg - _deg; i ++) {
				coefs_[i] = g.coefs[i];
			}
		}
		return new Polynom(coefs_);
	}
	
	/**
	 * �����, �� ���� 2 ���������� � ������
	 * @param polynoms ����� ����������
	 * @param i ������ ������� ����������
	 * @param j ������ ������� ����������
	 * @return ���� ��� ���� ����������
	 */
	protected static Polynom sumOfTwoPolynoms(Polynom[] polynoms, int i, int j) {
		return Polynom.polySum(polynoms[i-1], polynoms[j-1]);
	}
	
	/**
	 * �����, �� ���� �� ���������� � ������ ����������
	 * @param polynoms ����� ����������
	 * @return ���� ��� ���������� � ������
	 */
	protected static Polynom sumOfAllPolynoms(Polynom[] polynoms) {
		int l = polynoms.length;
		for(int i = 2; i < l + 1; i ++) {
			polynoms[0] = Polynom.sumOfTwoPolynoms(polynoms, 1, i);
		}
		return polynoms[0];
	}
	
	/**
	 * �������������� ����� toString()
	 * �������� �� ������� ���������
	 */
	public String toString() {
		String s = "";
		
		if (deg > 1) {
			s += Integer.toString(coefs[0]) + "x^" + Integer.toString(deg);
		}
		else if(deg == 1) {
			s += Integer.toString(coefs[0]) + "x";
			return s;
		}
		else {
			return Integer.toString(coefs[0]);
		}
		
		for(int i = 1; i < deg + 1; i ++) {
			if (i == deg - 1) {
				if(coefs[i] > 0) {
					s += " + " + Integer.toString(coefs[i]) + "x";
				}
				else {
					s += " - " + Integer.toString(-coefs[i]) + "x";
				}
			}
			if(i == deg) {
				if(coefs[i] > 0) {
					s += " + " + Integer.toString(coefs[i]);
				}
				else {
					s += " - " + Integer.toString(-coefs[i]);
				}
			}
			else {
				if (coefs[i] != 0 & i < deg - 1) {
					if(coefs[i] > 0) {
						s += " + " + Integer.toString(coefs[i]) + "x^" + Integer.toString(deg - i);
					}
					else {
						s += " - " + Integer.toString(-coefs[i]) + "x^" + Integer.toString(deg - i);
					}
				}
			}
		}
		return s;
	}
}
