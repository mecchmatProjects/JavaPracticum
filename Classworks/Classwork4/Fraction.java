package Classwork4;

class Fraction {
    private int n;
    private int m;

    public Fraction(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }


    public int gcd() {
        int a = n;
        int b = m;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public void check() {
        int checker = gcd();
        if (n % m == 0) {
            n = n / m;
            m = 1;
        } else if (checker != 1) {
            n = n / checker;
            m = m / checker;
        }
    }

    public void add(Fraction other) {
        if (this.m == other.m) {
            this.n += other.n;

        } else {
            int a = this.n * other.m + this.m * other.n;
            int b = this.m * other.m;
            this.n = a;
            this.m = b;
        }
        check();
    }

    @Override
    public String toString() {
        return n + "/" + m;
    }
}
