import java.util.Random;
import java.util.Scanner;

public class Matr {

	/**
	 * @param args
	 */
	
	static int[][] getRandom(int n){
		Random r=new Random();
		  int[][] a=new int[n][n];
		  for(int i=0;i<n;i++){
		      for(int j=0;j<n;j++){
		         a[i][j]=r.nextInt(30);
		         System.out.print(a[i][j]+"\t");
		      }
		  
		     System.out.print("\n");
		  }
		  
		return a;
	}
	
	static int[][] getConsole(int n, Scanner sc){
		 int[][] a=new int[n][n];
        
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){

                a[i][j] = sc.nextInt();

            }

        }
		return a;
		
	}
	
	static void print(int[][] mat){
		for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++){

               System.out.print("\t" + mat[i][j]);
            }
            System.out.println();

        }
	}
	
	public static void main(String[] args) {

		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt(); 
		 
		 int [][] a = getRandom(n);

		 int m = sc.nextInt();
		 
		 int[][] b = new int[n][n];
		 
			for (int i = 0; i < n; i++) {
	            for (int j = m; j < n; j++){
                                     //  System.out.print("t" + i + j);


	                b[i][j] = a[i][j-m];

	            }
	            for (int j = 0; j < m; j++){

	                b[i][j] = a[i][n+j-m];

	            }

	        } 
			
			print(b);

	}

}

