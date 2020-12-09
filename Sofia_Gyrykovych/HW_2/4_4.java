import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int prev = 0;
        int count = 0;

        while (true) {
            System.out.print("enter next number: ");
            int x = scanner.nextInt();

            if (x == 0) {
                break;
            }

            if ((prev < 0 && x > 0) || (prev > 0 && x < 0)) {
                count++;
            }

            prev = x;
        }

        System.out.println("result: " + count);
    }
}