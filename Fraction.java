
import java.util.Scanner;

public class Fraction {
	
	
	private int nom;
	
	private int den;
	
	Scanner scan = new Scanner(System.in);
	
	Fraction(){
		this.nom = 0;
		this.den = 1;
	}
	
	Fraction(int n, int m){
		
		if(m==0) {
			System.out.println("M=0!!!");
		}
		
		this.nom = n;
		this.den = m;
		
		reduce();
	}
	
	public Fraction add(Fraction x){
		
		int a = x.nom * den + x.den * nom;
		int b = x.den * den;
		
		return new Fraction(a,b);
	}
	
	@Override
	public String toString(){
		
		return " " + nom + "/" + den;
	}
	
	public boolean input(){
		System.out.println("input:");
		
		try{
		nom = scan.nextInt();
		den = scan.nextInt();
		}
		catch(Exception e){
			return false;
		}
		return true;
	} 
	

	public static Fraction add(Fraction[] mas, Fraction start, int k){
		
		if(mas.length == k + 1){
			//System.out.println("res" + start + k);
			return start.add(mas[k]);
		}
		
		Fraction F1 = start.add(mas[k]);
		
		return add(mas,F1, k+1);
		
	}
	
	public static int gcd(int x, int y){
		if (y==0) return x;
		return gcd(y,x%y);
	}
	
	public void reduce(){
		
		int max1 = nom>den?nom:den;
		int min1 = nom<=den?nom:den;
		
		int nsd = gcd(max1,min1);
		
		nom /= nsd;
		den /= nsd;
		
	}
	
	public static void main(String[] args) {
	
		Fraction[] mas = new Fraction[3];
		
		for(int i=0; i<mas.length; ++i){
			
			System.out.print("i="+i);
			mas[i] = new Fraction();
			
			while (!mas[i].input()){;}
		}
		
		Fraction st= new Fraction();
		
		Fraction res = add(mas,st, 0);
		
		System.out.println("res" + res);
		
	}

}
