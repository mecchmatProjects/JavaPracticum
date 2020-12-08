package Task67;

import java.util.Random;
import java.util.Scanner;
// task 6.7 Fedchenko Yaroslav  Повернути матрицю на 90  градусів проти годинникової стрілки.
public class Main{

    static void printMatrix(int[][] matrix){
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
        }
    }

    static int[][] getMatrixFromConsole(int size, Scanner scanner){
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static int [][] RandomMatrix(int size){
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = Math.abs(rand.nextInt() % 10);
            }
        }

        return matrix;
    }

    public static void rotateMatrix(int[][] matrix){
        int N = matrix.length;

        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][N - 1 - i];
                matrix[j][N - i - 1] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[N - 1 -j][i];
                matrix[N - 1 -j][i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix size: ");
        int n = scanner.nextInt();
        int[][] matrix = RandomMatrix(n);

        printMatrix(matrix);
        rotateMatrix(matrix);
        printMatrix(matrix);


    }
}