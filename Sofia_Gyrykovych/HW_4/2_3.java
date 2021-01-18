import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static void main(String[] args) {
        List<Double> roots = new ArrayList<>();

        for (QuadraticEquation eq : QuadraticEquation.createEquations()) {
            roots.addAll(eq.getRoots());
        }

        Collections.sort(roots);

        System.out.println("min root: " + roots.get(0));
        System.out.println("max root: " + roots.get(roots.size() - 1));
    }
}

class QuadraticEquation {

    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double b, double c) {
        this(1.0, b, c);
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static List<QuadraticEquation> createEquations() {
        return List.of(
                new QuadraticEquation(-12, 32), //  8, 4
                new QuadraticEquation(-2, 35),  // -5, 7
                new QuadraticEquation(-5, 4),   //  4, 1
                new QuadraticEquation(-3, 2),   //  2, 1
                new QuadraticEquation(4, -32),  // -8, 4
                new QuadraticEquation(5, -14),  // -7, 2
                new QuadraticEquation(-13, 42)  //  6, 7
        );
    }

    public List<Double> getRoots() {
        double D = b * b - 4 * a * c;

        if (D > 0) {
            return List.of(
                    (-b + Math.sqrt(D)) / (2 * a),
                    (-b - Math.sqrt(D)) / (2 * a)
            );
        } else if (D == 0) {
            return List.of(
                    (-b) / (2 * a)
            );
        } else {
            return List.of(
            );
        }
    }

    public double[] getExtremumPoint() {
        return new double[]{
                (-b) / (2 * a),
                (4 * a * c - b * b) / (4 * a)
        };
    }

    public double[][] getDecreasingAndIncreasingIntervals() {
        return new double[][]{
                { (-b) / (2 * a), Double.POSITIVE_INFINITY },
                { Double.NEGATIVE_INFINITY, (-b) / (2 * a) },
        };
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        if (a != 1) {
            ret.append(a);
        }
        ret.append("x^2");

        if (b != 0) {
            if (b > 0) {
                ret.append("+");
            }
            if (b != 1) {
                ret.append(b);
            }
            ret.append("x");
        }

        if (c != 0) {
            if (c > 0) {
                ret.append("+");
            }
            ret.append(c);
        }

        ret.append("=0.0");

        return ret.toString();
    }
}