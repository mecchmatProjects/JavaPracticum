package DZ4;

import java.text.ParseException;

public class Task27 {
    public static void main(String[] args) throws ParseException {
        Triangle[] triangles = new Triangle[]{
                new Triangle(1,2,2),
                new Triangle(3,4,5),
                new Triangle(4,5,6),
                new Triangle(4,4,6),
                new Triangle(4,4,4),
                new Triangle(11,12,14),
                new Triangle(9,12,15),
                new Triangle(1,1,1),
                new Triangle(12,12,11)
        };

        int countRivnost = 0;
        int countRivnob = 0;
        int countPryamok = 0;
        int countDov = 0;

        double maxAreaRivnost = Double.MIN_VALUE;
        double maxAreaRivnob = Double.MIN_VALUE;
        double maxAreaPryamok = Double.MIN_VALUE;
        double maxAreaDov = Double.MIN_VALUE;

        double minAreaRivnost = Double.MAX_VALUE;
        double minAreaRivnob = Double.MAX_VALUE;
        double minAreaPryamok = Double.MAX_VALUE;
        double minAreaDov = Double.MAX_VALUE;

        double minPerimeterRivnost = Double.MAX_VALUE;
        double minPerimeterRivnob = Double.MAX_VALUE;
        double minPerimeterPryamok = Double.MAX_VALUE;
        double minPerimeterDov = Double.MAX_VALUE;

        double maxPerimeterRivnost = Double.MIN_VALUE;
        double maxPerimeterRivnob = Double.MIN_VALUE;
        double maxPerimeterPryamok = Double.MIN_VALUE;
        double maxPerimeterDov = Double.MIN_VALUE;
        double s = 0;
        double p = 0;

        for (Triangle triangle : triangles) {
            if (triangle.checkTriangle()) {
                countDov += 1;
                s = triangle.squareOfTriangle();
                p = triangle.perimetrOfTriangle();
                if (s > maxAreaDov)
                    maxAreaDov = s;
                if (s < minAreaDov)
                    minAreaDov = s;
                if (p < minPerimeterDov)
                    minPerimeterDov = p;
                if (p > maxPerimeterDov)
                    maxPerimeterDov = p;

                if (triangle.checkPyamok()) {
                    countPryamok += 1;
                    if (s > maxAreaPryamok)
                        maxAreaPryamok = s;
                    if (s < minAreaPryamok)
                        minAreaPryamok = s;
                    if (p < minPerimeterPryamok)
                        minPerimeterPryamok = p;
                    if (p > maxPerimeterPryamok)
                        maxPerimeterPryamok = p;
                }

                if (triangle.checkRivnob()) {
                    countRivnob += 1;
                    if (s > maxAreaRivnob)
                        maxAreaRivnob = s;
                    if (s < minAreaRivnob)
                        minAreaRivnob = s;
                    if (p < minPerimeterRivnob)
                        minPerimeterRivnob = p;
                    if (p > maxPerimeterRivnob)
                        maxPerimeterRivnob = p;
                }

                if (triangle.checkRivnost()) {
                    countRivnost += 1;
                    if (s > maxAreaRivnost)
                        maxAreaRivnost = s;
                    if (s < minAreaRivnost)
                        minAreaRivnost = s;
                    if (p < minPerimeterRivnost)
                        minPerimeterRivnost = p;
                    if (p > maxPerimeterRivnost)
                        maxPerimeterRivnost = p;
                }
            }
            }
        System.out.printf("DOVILNUY: count=%d, maxArea=%.2f," + "minArea=%.2f," +
                    " minPerimeter=%.2f, maxPerimeter=%.2f", countDov, maxAreaDov, minAreaDov,
                minPerimeterDov, maxPerimeterDov);

        System.out.printf("\nPRYAMOKUTNUY: count=%d, maxArea=%.2f," + "minArea=%.2f," +
                " minPerimeter=%.2f, maxPerimeter=%.2f", countPryamok, maxAreaPryamok, minAreaPryamok,
                minPerimeterPryamok, maxPerimeterPryamok);

        System.out.printf("\nRIVNOBEDRENNUY: count=%d, maxArea=%.2f," + "minArea=%.2f," +
                " minPerimeter=%.2f, maxPerimeter=%.2f", countRivnob, maxAreaRivnob, minAreaRivnob,
                minPerimeterRivnob, maxPerimeterRivnob);

        System.out.printf("\nRIVNOSTORONNIY: count=%d, maxArea=%.2f," + "minArea=%.2f," +
                " minPerimeter=%.2f, maxPerimeter=%.2f", countRivnost, maxAreaRivnost, minAreaRivnost,
                minPerimeterRivnost, maxPerimeterRivnost);
    }
}

class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double squareOfTriangle() {
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double perimetrOfTriangle() {
        return a + b + c;
    }

    public boolean checkRivnost(){
        return ((a == b) && (a == c) && (b == c));
    }

    public boolean checkPyamok(){
        return (a * a + c * c == b * b) || (a * a + b * b == c * c) || (b * b + c * c == a * a);
    }

    public boolean checkRivnob(){
        return ((a==c)||(a==b)||(b==c));
    }

    public boolean checkTriangle(){
        return ((a+b>c)&&(a+c>b)&&(b+c>a));
    }

    @Override
    public String toString() {
        return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
    }

}
