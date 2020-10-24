package poly;

import java.util.Arrays;

public class Polynomial {
    public static int maxLen;
    public RationalNum[] coef;
    private int size;

    Polynomial(int size){
        this.coef = new RationalNum[size];
        this.size = size;
        if (size>maxLen)
            maxLen = size;
        for (int i=0; i<size;i++)
            this.coef[i] = new RationalNum(0,1);
    }

    Polynomial(String args){
        String str[] = args.split(" ");
        size = str.length;
        if (size > maxLen)
            maxLen = size;

        coef = new RationalNum[size];
        for (int i=0; i<size;i++){
            coef[i] = new RationalNum(str[i]);
        }
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "coef=" + Arrays.toString(coef) +
                ", size=" + size +
                '}';
    }

    public static Polynomial add(Polynomial p1, Polynomial p2){
        int max_len = Math.max(p1.size,p2.size);
        Polynomial new_ploy = new Polynomial(max_len);

        for (int i=0; i<max_len;i++){
            if (i < p1.size)
                new_ploy.coef[i] = new_ploy.coef[i].add(p1.coef[i]);
            if (i < p2.size)
                new_ploy.coef[i] = new_ploy.coef[i].add(p2.coef[i]);
        }
        return new_ploy;
    }

    public static Polynomial sumPolinomial(Polynomial[] array){
        Polynomial sumPoly = new Polynomial(Polynomial.maxLen);
        for(Polynomial poly: array) {
            sumPoly = add(sumPoly, poly);
        }
        return sumPoly;
    }

    public static void main(String[] args){
        int n = 4;
        Polynomial[] array = new Polynomial[n];
        array[0] = new Polynomial("1/2 2 4/2 5/3");
        array[1] = new Polynomial("1/2 1/2 1/2 1/2");
        array[2] = new Polynomial("1/2 1/4 1/8 1/16");
        array[3] = new Polynomial("1 1/8 1/16 1/32");
        Polynomial sumPoly = sumPolinomial(array);
        System.out.print(sumPoly);
    }
}
