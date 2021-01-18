import java.util.TreeSet;

class Main {

  public static void main(String[] args) throws Exception {
    MyIntegerCollection coll = new MyIntegerCollection();

    coll.addInt(0);
    coll.addInt(5);
    coll.addInt(10);
    coll.addInt(20);
    coll.addInt(30);
    coll.addInt(50);
    coll.addInt(100);

    System.out.println("coll.findClosest( 6): " + coll.findClosest(6));
    System.out.println("coll.findClosest(23): " + coll.findClosest(23));
    System.out.println("coll.findClosest(42): " + coll.findClosest(42));
    System.out.println("coll.findClosest(70): " + coll.findClosest(70));
    System.out.println("coll.findClosest(80): " + coll.findClosest(80));
  }
}

class MyIntegerCollection {

  private final TreeSet<Integer> ints;

  public MyIntegerCollection() {
    this.ints = new TreeSet<>();
  }

  public void addInt(int x) {
    ints.add(x);
  }

  public void removeInt(int x) {
    ints.remove(x);
  }

  public int findClosest(int x) {
    if (ints.isEmpty()) {
      throw new IllegalStateException();
    }

    Integer a = ints.ceiling(x);
    Integer b = ints.floor(x);

    if (a == null) {
      return b;
    }

    if (b == null) {
      return a;
    }

    if ((a - x) < (x - b)) {
      return a;
    } else {
      return b;
    }
  }
}
