import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOnlyEven = 0;
        int countEqual = 0;

        while (true) {
            System.out.print("enter next number: ");
            int x = scanner.nextInt();

            if (x == 0) {
                break;
            }

            int even = 0;
            int odd = 0;

            while (x != 0) {
                int d = x % 10;

                if (d % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }

                x /= 10;
            }

            if (odd == 0) {
                countOnlyEven++;
            } else if (even == odd) {
                countEqual++;
            }
        }

        System.out.println("numbers with only even digits: " + countOnlyEven);
        System.out.println("numbers with equal number of even and odd digits: " + countEqual);
    }
}