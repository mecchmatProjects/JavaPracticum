package Homework2;
import java.util.Scanner;
//6.6
public class Task2 {
    public static int Am(int arr[][], int n){
        int[] tmp = new int[n];
        for(int i=0;i<n;i++) {
            tmp[i]=0;
            for (int j = 0; j < n; j++) {
                tmp[i] += Math.abs(arr[i][j]);
            }
        }
        int max= 0;
        for(int i=0;i<n;i++) {
            if(max<tmp[i]){
                max=tmp[i];
            }
        }
        return max;

    }
    public static int AL(int arr[][], int n){
        int[] tmp = new int[n];
        for(int i=0;i<n;i++) {
            tmp[i]=0;
            for (int j = 0; j < n; j++) {
                tmp[i] += Math.abs(arr[j][i]);
            }
        }
        int max= 0;
        for(int i=0;i<n;i++) {
            if(max<tmp[i]){
                max=tmp[i];
            }
        }
        return max;
    }

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
        System.out.println("Norms: ");
        System.out.println("||A||m = "+Am(arr,n));
        System.out.println("||A||L = "+AL(arr,n));
    }
}
