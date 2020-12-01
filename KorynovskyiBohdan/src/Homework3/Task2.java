/*
    Домашня робота №3. Батовинмірні масиви
    Завдання 6.10

    Знайти максимальний елемент(ти) в матриці і видалити з матриці всі рядки і стовпці, що містять його.
*/


package Homework3;

import java.util.Arrays;

public class Task2 {
    static int[][] max(int[][] m) {
        int max = Integer.MIN_VALUE;
        int[][] ij = new int[m.length * m[0].length][2];
        int k = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > max) {
                    ij = new int[m.length * m[0].length][2];
                    k = 0;

                    max = m[i][j];
                    ij[k][0] = i;
                    ij[k][1] = j;
                    k++;
                } else if (m[i][j] == max) {
                    ij[k][0] = i;
                    ij[k][1] = j;
                    k++;
                }
            }
        }
        return ij;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ij = max(matrix);

        int[][] result = new int[3][3];

        for (int k = 0; k < ij.length; k++) {
            if (ij[k][0] == 0 & ij[k][1] == 0 & k != 0) {
                break;
            }

            for (int i = 0; i < matrix.length; i++) {
                if (i == ij[k][0]){
                    continue;
                }
                for (int j = 0; j < matrix[i].length; j++) {
                    if (j == ij[k][1]) {
                        continue;
                    }
                    result[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < (result.length); i++){
            System.out.println(Arrays.toString(result[i]));
        }

    }

}
