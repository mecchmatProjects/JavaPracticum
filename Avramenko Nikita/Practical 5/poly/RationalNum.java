package poly;

import java.util.Scanner;

public class RationalNum {
    private int n,m;

    public RationalNum(){
        this.n=0;
        this.m=1;
    }


    public RationalNum(int numerator, int denominator){
        if (denominator==0)
            denominator = 1;
        if (denominator<0){
            numerator*=-1;
            denominator*=-1;
        }
        this.n = numerator;
        this.m = denominator;
        reduce();
    }

    public RationalNum(String str){
        String num[] = str.split("/");
        if (num.length ==2){
            n = Integer.parseInt(num[0]);
            m = Integer.parseInt(num[1]);
        }
        else {
            n = Integer.parseInt(num[0]);
            m = 1;
        }
    }

    private void reduce(){
        if (n!=0){
            int common = gcd(Math.abs(n),m);
            n = n/common;
            m = m/common;
        }
    }

    private int gcd(int x, int y){
        while (x!=y){
            if (x>y)
                x = x-y;
            else
                y = y-x;
        }
        return x;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public RationalNum add(RationalNum other){
        int commonNumerator = n * other.getM() + other.getN() * m;
        int commonDenominator  = m * other.getM();
        reduce();
        return new RationalNum(commonNumerator, commonDenominator);
    }

    public RationalNum sub(RationalNum other){
        int commonNumerator = n * other.getM() - other.getN() * m;
        int commonDenominator  = m * other.getM();
        reduce();
        return new RationalNum(commonNumerator, commonDenominator);
    }

    public RationalNum mul(RationalNum other){
        int commonNumerator = n * other.getN();
        int commonDenominator  = m * other.getM();
        reduce();
        return new RationalNum(commonNumerator, commonDenominator);
    }

    public void input(Scanner in){
        System.out.print("n=");
        n = in.nextInt();
        System.out.print("m=");
        m = in.nextInt();
    }

    @Override
    public String toString (){
        return n + "/" + m;
    }

    static public void main(String[] args){
        RationalNum arr[] = new RationalNum[5];
        Scanner in = new Scanner(System.in);

        for (int i=0;i<arr.length;i++){
            arr[i] = new RationalNum();
            arr[i].input(in);
        }
        for (int i=0;i<arr.length-1;i++){
            arr[i] = arr[i].add(arr[i+1]);
        }
        System.out.println("Новий массив:");
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
