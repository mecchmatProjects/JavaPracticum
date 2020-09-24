import java.util.Scanner; 
import java.util.Random; 

public class Lesson3_Matrix{ 
    
     static void shiftMatrixByK(int [][]mat, int n, int k){ 
        if (k > n) { 
            System.out.print("Shifting is not possible"); 
            return; 
        } 
        int j = 0; 
        System.out.print("Shift Matrix\n"); 
        while (j < n) { 
            for (int i = k; i < n; i++) 
                System.out.print(mat[j][i] + "  "); 
            for (int i = 0; i < k; i++) 
                System.out.print(mat[j][i] + "  "); 
            System.out.println(); 
            j++; 
        } 
    } 
    
    public static void readMatrix(){ 
        int n, i, j; 
        Scanner in = null; 
         
        in = new Scanner(System.in); 
        System.out.println("Enter n"); 
        n = in.nextInt(); 
        int first[][] = new int[n][n]; 
  
        System.out.println("Enter the elements of the matrix"); 
        for (i = 0; i < n; i++) 
            for (j = 0; j < n; j++) 
                first[i][j] = in.nextInt(); 
        
        System.out.println("Enter k"); 
        int k = in.nextInt();
        shiftMatrixByK(first, n, k);
        System.out.println("Matrix"); 
        for (i = 0; i < n; i++) { 
            for (j = 0; j < n; j++) 
                System.out.print(first[i][j] + "  "); 
            System.out.println(); 
        } 
    } 
    
    public static void randomMatrix(){ 
        int n, i, j; 
        Scanner in = null;
        Random rand = new Random(); 
         
        in = new Scanner(System.in); 
        System.out.println("Enter n"); 
        n = in.nextInt(); 
        int first[][] = new int[n][n]; 
  
        for (i = 0; i < n; i++) 
            for (j = 0; j < n; j++) 
                first[i][j] = rand.nextInt(100);  
  
        System.out.println("Matrix"); 
        for (i = 0; i < n; i++) { 
            for (j = 0; j < n; j++) 
                System.out.print(first[i][j] + "  "); 
            System.out.println(); 
        } 
    } 
  
    public static void main(String[] args) { 
        readMatrix(); 
        randomMatrix();
    } 
} 
