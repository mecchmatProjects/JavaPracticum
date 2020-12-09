import java.util.Objects;

class Main {

    public static void main(String[] args) {
        Square square = new Square(3.0, 3.0, 4.0, "white");

        System.out.println("before:");
        System.out.println(square);

        square.scaleUp(3.0);
        square.scaleDown(2.0);
        square.rotate(30.0);
        square.setColor("green");

        System.out.println();
        System.out.println("after:");
        System.out.println(square);
    }
}

class Point {

    private final double x;
    private final double y;

    private Point(double x, double y) {
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
        return "" +
                "Point{" +
                "x=" + x +
                ", y=" + y +
                "}";
    }
}

class Line {

    private final Point a;
    private final Point b;

    private Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public static Line of(Point a, Point b) {
        return new Line(a, b);
    }

    public double getLength() {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Line)) {
            return false;
        }
        Line line = (Line) obj;
        return line.a.equals(a) && line.b.equals(b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "" +
                "Line{" +
                "a=" + a +
                ", b=" + b +
                "}";
    }
}

class Square {

  /*
          r
      __ __
  s  |     |
     |__ __|  q

      p

  */

    private Line p, q, r, s;
    private String color;
    private double angle;

    public Square(double x, double y, double size, String color) {
        this.p = Line.of(Point.of(x, y), Point.of(x + size, y));
        this.color = color;
        setSize(size);
    }

    public double getSize() {
        return p.getLength();
    }

    public void setSize(double size) {
        double x = p.getA().getX();
        double y = p.getA().getY();
        p = Line.of(Point.of(x, y), Point.of(x + size, y));
        q = Line.of(Point.of(x + size, y), Point.of(x + size, y + size));
        r = Line.of(Point.of(x + size, y + size), Point.of(x, y + size));
        s = Line.of(Point.of(x, y + size), Point.of(x, y));
    }

    public void scaleUp(double v) {
        setSize(getSize() * v);
    }

    public void scaleDown(double v) {
        setSize(getSize() / v);
    }

    public void rotate(double angle) {
        this.angle += angle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Square)) {
            return false;
        }
        Square square = (Square) obj;
        return
                square.p.equals(p) &&
                        square.q.equals(q) &&
                        square.r.equals(r) &&
                        square.s.equals(s) &&
                        square.color.equals(color) &&
                        square.angle == angle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, q, r, s, color, angle);
    }

    @Override
    public String toString() {
        return "" +
                "Square{" +
                "p=" + p +
                ", q=" + q +
                ", r=" + r +
                ", s=" + s +
                ", color='" + color + "'" +
                ", angle=" + angle +
                "}";
    }
}