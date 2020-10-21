package Homework4;

class ComplexNumber {
    private int n;
    private int[][] arr;
    private int amount;

    public ComplexNumber(int n, int[] arr) {
        this.n = n;
        this.amount = n / 2;
        this.arr = new int[amount][2];
        int counter = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < 2; j++) {
                this.arr[i][j] = arr[counter];
                counter++;
            }
        }
    }

    public void Sum() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < this.amount; i++) {
            a += arr[i][0];
            b += arr[i][1];
        }
        if (b >= 0) {
            System.out.println("Sum is: " + a + "+" + b + "*i");
        } else {
            System.out.println("Sum is: " + a + b + "*i");
        }
    }

    public void Multiply() {
        int a = arr[0][0];
        int b = arr[0][1];
        for (int i = 1; i < this.amount; i++) {
            int tmpa = a * arr[i][0] - b * arr[i][1];
            int tmpb = a * arr[i][1] + b * arr[i][0];
            b = tmpb;
            a = tmpa;
        }
        if (b >= 0) {
            System.out.println("Multiplication is: " + a + "+" + b + "*i");
        } else {
            System.out.println("Multiplication is: " + a + b + "*i");
        }
    }


}
