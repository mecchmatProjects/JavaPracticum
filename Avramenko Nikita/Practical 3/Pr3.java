import java.util.Random;
import java.util.Scanner;

public class Pr3 {
    public static void main(String[] args) {
        System.out.println("Введіть число n: ");
        int n;
        char str;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[][] mtr = new int[n][n];
        System.out.println("Оберіть формат вводу r/c(random/console): ");
        str = in.next().charAt(0);

        if (str == 'r')
            mtr = rand(n);
        if (str == 'c')
            mtr = con(n);

        //show(mtr, n);

        ShiftRight(mtr,n,3);


    }

    static int[][] rand(int n){
        Random r = new Random();
        int[][] mtr=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                mtr[i][j]=r.nextInt(2*n+1)-n;
                System.out.print(mtr[i][j]+"\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        return mtr;
    }

    static int[][] con(int n){
        Scanner scan = new Scanner(System.in);
        int[][] mtr=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                mtr[i][j]=scan.nextInt();
            }
        }
        return mtr;
    }

    static void show(int[][] mtr, int n){                   //функция (метод) вывода массива на консоль
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mtr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ShiftRight(int[][] mtr, int n, int k) {
        int i,j;
        for (i = 0; i < n; i++){
            int tmp = mtr[i][Math.abs(n - k)%n];
            for (j = n - 1; j >= 1; j--){
                mtr[i][j] = mtr[i][Math.abs(j - k)%n];
            }
            mtr[i][j] = tmp;
        }
        show(mtr, n);
    }

}
