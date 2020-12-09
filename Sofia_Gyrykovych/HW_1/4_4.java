public class Task4_4 {
    public Task4_4() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sign = 1;
        int counter = 0;

        for(int i = 0; i > -1; ++i) {
            System.out.print("a[" + i + "]= ");
            int n = input.nextInt();
            if (n == 0) {
                break;
            }

            if (i == 0) {
                if (n > 0) {
                    sign = 1;
                } else {
                    sign = -1;
                }
            }

            if (n > 0 & sign == -1) {
                sign = 1;
                ++counter;
            } else if (n < 0 & sign == 1) {
                sign = -1;
                ++counter;
            }
        }

        System.out.print("Changes count = " + counter);
        input.close();
    }
}
