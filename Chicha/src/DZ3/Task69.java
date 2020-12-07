/*
    Чича Олександр

    Завдання 6.9

*/

package DZ3;

import java.util.Random;
import java.util.Scanner;

public class Task69 {

    static void printMatrix(int[][] matrix){
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void printMatrix(double[][] matrix){
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
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

    static int[][] getMatrixFromConsole(int size, Scanner scanner){
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    static double getMediumValue(int[][] matrix){
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                sum += matrix[i][j];
            }
        }
        return sum/(n*n);
    }

    public static double[][] getNewMatrix(int[][] matrix){
        int n = matrix.length;
        double med = getMediumValue(matrix);
        double[][] newMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                newMatrix[i][j] = matrix[i][j] - med;
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input size of matrix : ");
        int n = in.nextInt();
        int[][] matrix = getMatrixFromConsole(n, in);
        printMatrix(matrix);
        double[][] newMatrix = getNewMatrix(matrix);
        printMatrix(newMatrix);
    }
}
