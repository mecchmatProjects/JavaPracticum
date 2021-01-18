package HW5.Task49;

import java.util.Objects;
// task 4.9(OOP) Fedchenko Yaroslav Створити об'єкт класу Коло, використовуючи класи Точка, Окружність.
// Методи: завдання розмірів, зміна радіуса, визначення приналежності точки даного кола.
class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(double x, double y) {
        return new Point(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return point.x == x && point.y == y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + "}";
    }
}

class Circumference
 {

    private final Point a;
    private final int r;

    private Circumference
(Point a, int r) {
        this.a = a;
        this.r = r;
    }

    public static Circumference
 of(Point a, int r) {
        return new Circumference
(a, r);
    }

    public Point getA() {
        return a;
    }

    public int getR() {
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Circumference)) {
            return false;
        }Circumference Circumference = (Circumference) obj;
        return Circumference.a.equals(a) && Circumference.r == r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, r);
    }

    @Override
    public String toString() {
        return "Circumference {" + "center=" + a + ", r=" + r + "}";
    }

}

class Circle {

    private Circumference c;

    public Circle(double x, double y, int r) {
        this.c = Circumference.of(Point.of(x, y), r);
    }

    public double getSize() {
        return c.getR();
    }

    public void setSize(Point newP, int r) {
        this.c = Circumference.of(Point.of(newP.getX(), newP.getY()), r);
    }


    public void changeR(int newR) {
        this.c = Circumference.of(c.getA(), newR);
    }

    public boolean check(Point oth) {
        return Math.pow(oth.getX() - c.getA().getX(), 2) + Math.pow(oth.getY() - c.getA().getY(), 2) < Math.pow(c.getR(), 2);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Circle)) {
            return false;
        }
        Circle Circle = (Circle) obj;
        return
                Circle.c.equals(c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }

    @Override
    public String toString() {
        return "Circle{" + "c=" + c;
    }
}

class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(0.0, 0.0, 5);
        System.out.println(circle);
        circle.changeR(2);
        System.out.println();
        System.out.println(circle);
        Point point = new Point(1.0, 1.0);
        System.out.println(circle.check(point));
    }
}
