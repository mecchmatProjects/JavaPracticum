import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter n: ");
        int n = scanner.nextInt();

        System.out.print("random? (y/n): ");

        int[][] mat;
        if (scanner.next().equals("y")) {
            mat = randomInput(n);
        } else {
            mat = consoleInput(n, scanner);
        }

        System.out.println();
        System.out.println("before:");
        printMatrix(mat);

        mat = transpose(mat);

        System.out.println();
        System.out.println("after:");
        printMatrix(mat);
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int x : row) {
                System.out.printf("%2d ", x);
            }
            System.out.println();
        }
    }

    private static int[][] transpose(int[][] mat) {
        int n = mat.length;
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = mat[j][i];
            }
        }

        return ret;
    }

    private static int[][] randomInput(int n) {
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = ThreadLocalRandom.current().nextInt(-n, n + 1);
            }
        }

        return ret;
    }

    private static int[][] consoleInput(int n, Scanner scanner) {
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("enter mat[%d][%d]: ", i, j);
                ret[i][j] = scanner.nextInt();
            }
        }

        return ret;
    }
}