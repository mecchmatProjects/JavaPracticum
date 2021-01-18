import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {

  public static void main(String[] args) throws Exception {
    String F = "input.txt";
    int n = 5;

    String G = "output.txt";

    try (Scanner scanner = new Scanner(new File(F))) {
      try (PrintWriter writer = new PrintWriter(new File(G))) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        while (scanner.hasNext()) {
          max = Math.max(scanner.nextInt(), max);
          count++;

          if (count == n) {
            writer.println(max);
            max = Integer.MIN_VALUE;
            count = 0;
          }
        }

        if (count != 0) {
          writer.println(max);
        }
      }
    }

    System.out.println("done");
  }
}
