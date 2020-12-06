/*
    8.Определіть клас Чотирикутник на площині. Визначити площу і періметр
    чотирикутника. Створити масив / список / множину об`єктів і підрахуйте кількість
    чотирикутників різного типу (квадрат, прямокутник, ромб, довільний). Визначити для
    кожної групи найбільший і найменший за площею (периметром) об`єкт.
 */

package Homework4;


enum Type {
    Square,
    Rectangle,
    Rhombus,
    Any
}

class Quadrangle {
    Type type;
    int a;
    int b;
    double sin;

    Quadrangle(Type type, int a) {
        this.a = a;
        this.type = type;
    }

    Quadrangle(Type type, int a, int b) {
        this.a = a;
        this.b = b;
        this.type = type;
    }

    Quadrangle(Type type, int a, int b, double sin) {
        this.a = a;
        this.b = b;
        this.sin = sin;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public double getArea() {
        if (type == Type.Square) {
            return a * a;
        } else if (type == Type.Rectangle | type == Type.Rhombus) {
            return a * b;
        } else if (type == Type.Any) {
            return a * b * sin;
        }

        return 0;
    }

    public int getPerimeter() {
        if (type == Type.Square | type == Type.Rhombus) {
            return 4 * a;
        } else if (type == Type.Rectangle | type == Type.Any) {
            return 2 * (a + b);
        }
        return 0;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Quadrangle[] lst = new Quadrangle[]{
                new Quadrangle(Type.Square, 4),
                new Quadrangle(Type.Rectangle, 4, 6),
                new Quadrangle(Type.Square, 10),
                new Quadrangle(Type.Rhombus, 4, 10),
                new Quadrangle(Type.Any, 12, 5, 0.33)
        };

        int countSq = 0;
        int countRec = 0;
        int countRh = 0;
        int countAn = 0;
        double maxAreaSq = Double.MIN_VALUE;
        double maxAreaRec = Double.MIN_VALUE;
        double maxAreaRh = Double.MIN_VALUE;
        double maxAreaAn = Double.MIN_VALUE;
        double minPerimeterSq = Double.MAX_VALUE;
        double minPerimeterRec = Double.MAX_VALUE;
        double minPerimeterRh = Double.MAX_VALUE;
        double minPerimeterAn = Double.MAX_VALUE;
        for (Quadrangle quadrangle : lst) {
            if (quadrangle.getType() == Type.Square) {
                countSq++;
                double area = quadrangle.getArea();
                if (area > maxAreaSq) {
                    maxAreaSq = area;
                }

                double perimeter = quadrangle.getPerimeter();
                if (area < minPerimeterSq) {
                    minPerimeterSq = perimeter;
                }
            } else if (quadrangle.getType() == Type.Rectangle) {
                double area = quadrangle.getArea();
                if (area > maxAreaRec) {
                    maxAreaRec = area;
                }
                double perimeter = quadrangle.getPerimeter();
                if (area < minPerimeterRec) {
                    minPerimeterRec = perimeter;
                }
                countRec++;
            } else if (quadrangle.getType() == Type.Any) {
                double area = quadrangle.getArea();
                if (area > maxAreaAn) {
                    maxAreaAn = area;
                }
                double perimeter = quadrangle.getPerimeter();
                if (area < minPerimeterAn) {
                    minPerimeterAn = perimeter;
                }
                countAn++;
            } else if (quadrangle.getType() == Type.Rhombus) {
                double area = quadrangle.getArea();
                if (area > maxAreaRh) {
                    maxAreaRh = area;
                }
                double perimeter = quadrangle.getPerimeter();
                if (area < minPerimeterRh) {
                    minPerimeterRh = perimeter;
                }
                countRh++;
            }
        }

        System.out.printf("Square: count=%d, maxArea=%.2f, minPerimeter=%.2f", countSq, maxAreaSq, minPerimeterSq);
        System.out.printf("\nRectangle: count=%d, maxArea=%.2f, minPerimeter=%.2f", countRec, maxAreaRec, minPerimeterRec);
        System.out.printf("\nRhombus: count=%d, maxArea=%.2f, minPerimeter=%.2f", countRh, maxAreaRh, minPerimeterRh);
        System.out.printf("\nAny: count=%d, maxArea=%.2f, minPerimeter=%.2f", countAn, maxAreaAn, minPerimeterAn);
    }
}
