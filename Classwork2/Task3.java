package Classwork2;
import java.util.Scanner;
//6.2
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inpunt n= ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.println("Input value of ["+i+"]["+j+"]");
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("If you want shift left enter 1\nIf you want shift right enter 2\nIf you want shift up enter 3\nIf you want shift down enter 4");
        int inputer = sc.nextInt();
        System.out.print("Input k= ");
        int k = sc.nextInt();
        k = k%n;
        if(inputer==1){
            k = n-k;
            for (int m = 0;m<k;m++) {
                for (int i = 0; i < n; i++) {
                    int tmp = arr[i][n-1];
                    for (int j = n-1; j >0; j--) {
                        arr[i][j]=arr[i][j-1];

                    }
                    arr[i][0] = tmp;
                }
            }

        }
        else if(inputer==2){
            for (int m = 0;m<k;m++) {
                for (int i = 0; i < n; i++) {
                    int tmp = arr[i][n-1];
                    for (int j = n-1; j >0; j--) {
                        arr[i][j]=arr[i][j-1];

                    }
                    arr[i][0] = tmp;
                }
            }

        }
        else if(inputer==3) {
            k = n-k;
            for (int m = 0; m < k; m++) {
                for (int i = 0; i < n; i++) {
                    int tmp = arr[n - 1][i];
                    for (int j = n - 1; j > 0; j--) {
                        arr[j][i] = arr[j - 1][i];

                    }
                    arr[0][i] = tmp;
                }
            }
        }
        else if(inputer==4){
            for (int m = 0;m<k;m++) {
                for (int i = 0; i < n; i++) {
                    int tmp = arr[n-1][i];
                    for (int j = n-1; j >0; j--) {
                        arr[j][i]=arr[j-1][i];

                    }
                    arr[0][i] = tmp;
                }
            }

        }

        else{
            System.out.println("Incorrect input");
            System.exit(0);
        }
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print("\t" + value);
            }
            System.out.println();
        }
    }
}
