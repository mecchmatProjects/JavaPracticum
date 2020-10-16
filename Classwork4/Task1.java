package Classwork4;


public class Task1 {
    static class Fraction{
        private int n;
        private int m;
        public Fraction(int n,int m){
            this.n = n;
            this.m=m;
        }

        public int getM() {
            return m;
        }

        public int getN(){
            return n;
        }


        public int gcd(){
            int a= n;
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

        public void check(){
            int checker = gcd();
            if (n%m==0){
                n = n/m;
                m = 1;
            }
            else if(checker!=1){
                n = n/checker;
                m = m/checker;
            }
        }

        public void add(Fraction other){
            if (this.m==other.m){
                this.n+=other.n;

            }
            else{
                int a = this.n* other.m+this.m*other.n;
                int b = this.m*other.m;
                this.n = a;
                this.m=b;
            }
            check();
        }

        @Override
        public String toString() {
            return n + "/" + m;
        }
    }


    static class Polynom{
        private Fraction[] coeffs;
        private int size;
        public Polynom(int size){
            this.size = size;
            this.coeffs = new Fraction[size];
            for (int i = 0; i < size; i++) coeffs[i] = new Fraction(0, 1);
        }

        public Polynom(Integer... args){
            this.size = args.length / 2;
            coeffs = new Fraction[size];
            for (int i = 0; i < args.length; i+=2){
                int n1 = args[i];
                int m1 = args[i + 1];
                coeffs[size - i/2 - 1] = new Fraction(n1, m1);
            }
        }

        @Override
        public String toString(){
            String res = "";
            for (int i = size-1; i >= 0; i--) {
                if (coeffs[i].getN() == 0) continue;
                res += coeffs[i] + "x^" + i;
                if (i!=0){
                    res+="+";
                }
            }
            return res;
        }

        public static Polynom Add(Polynom poly1, Polynom poly2){
            int new_size = Math.max(poly1.size, poly2.size);
            Polynom res = new Polynom(new_size);

            for (int i = 0; i < new_size; i++){
                if (i < poly1.size) res.coeffs[i].add(poly1.coeffs[i]);
                if (i < poly2.size) res.coeffs[i].add(poly2.coeffs[i]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Polynom[] polys = new Polynom[4];
        polys[0] = new Polynom(1, 2, 3, 4);
        polys[1] = new Polynom(1, 2, 1, 4);
        polys[2] = new Polynom(1,3);
        polys[3] = new Polynom(1,4,1,3,1,3);
        Polynom pSum = Polynom.Add(polys[0], polys[1]);
        pSum = Polynom.Add(pSum, polys[2]);
        pSum = Polynom.Add(pSum, polys[3]);
        System.out.println(pSum);
    }
}
