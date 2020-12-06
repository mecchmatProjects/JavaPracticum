package HW4;

import java.util.Scanner;
// task 2.5(OOP) Fedchenko Yaroslav
public class task2 {
    public static class Interval{
        private double l, r;
        private boolean incll, inclr;

        Interval(){ }

        Interval(double a, double b) {
            this.l = (a < b) ? a : b;
            this.r = (a < b) ? b : a;
            this.incll = true;
            this.inclr = true;
        }

        Interval(double a, double b, boolean incll, boolean inclr) {
            this.l = (a < b) ? a : b;
            this.r = (a < b) ? b : a;
            this.incll = incll;
            this.inclr = inclr;
        }

        public Interval getIntersection(Interval other){
            if (this.r < other.l || this.l > other.r){
                return null;
            }

            double l, r;
            boolean lIncluded, rIncluded;

            if (this.l > other.l){
                l = this.l;
                lIncluded = this.incll;
            } else {
                l = other.l;
                lIncluded = other.incll;
            }

            if (this.r < other.r){
                r = this.r;
                rIncluded = this.inclr;
            } else {
                r = other.r;
                rIncluded = other.inclr;
            }

            return new Interval(l, r, lIncluded, rIncluded);
        }

        public Interval getUnion(Interval other){
            if (this.r < other.l || this.l > other.r){
                return null;
            }

            double l, r;
            boolean lIncluded, rIncluded;

            if (this.l < other.l){
                l = this.l;
                lIncluded = this.incll;
            } else {
                l = other.l;
                lIncluded = other.incll;
            }

            if (this.r > other.r){
                r = this.r;
                rIncluded = this.inclr;
            } else {
                r = other.r;
                rIncluded = other.inclr;
            }

            return new Interval(l, r, lIncluded, rIncluded);
        }

        @Override
        public String toString() {
            String result = "";
            if (incll) result += "[";
            result += l + ", " + r;
            if (inclr) result += "]";

            return result;
        }
    }

    public static double findDist(Interval[] intervals){
        double l = intervals[0].l;
        double r = intervals[0].r;

        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].l < l){
                l = intervals[i].l;
            }
            if (intervals[i].r > r){
                r = intervals[i].r;
            }
        }

        if ((l < 0) && (r > 0)){
            return Math.abs(l) + Math.abs(r);
        } else {
            return Math.abs(r - l);
        }
    }

    public static Interval findMax(){
        return new Interval();
    }

    public static void main(String[] args) {
        Interval interval_1 = new Interval(0, 4);
        Interval interval_2 = new Interval(-10, 2);
        System.out.println(interval_1.getIntersection(interval_2));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Кількість інтервалів:");
        int n = Integer.parseInt(scanner.nextLine());
        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++){
            String[] strInterval = scanner.nextLine().split(" ");
            double a, b;
            boolean ai = true, bi = true;

            a = Double.parseDouble(strInterval[0]);
            b = Double.parseDouble(strInterval[1]);

            if (strInterval.length == 4){
                ai = strInterval[2].equals("1");
                bi = strInterval[3].equals("1");
            }

            intervals[i] = new Interval(a, b, ai, bi);
        }

        System.out.println("відстань між найбільш віддаленеми точками:");
        double dist = findDist(intervals);
        System.out.println(dist);
    }
}