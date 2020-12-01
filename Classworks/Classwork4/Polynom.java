package Classwork4;

class Polynom{
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
