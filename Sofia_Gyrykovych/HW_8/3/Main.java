import java.nio.file.Files;
import java.nio.file.Path;

class Main {

  public static void printAllLines(String filename) throws Exception {
    for (String line : Files.readAllLines(Path.of(filename))) {
      System.out.println(line);
    }
  }

  public static void printLinesWithLengthMoreThan60(String filename) throws Exception {
    for (String line : Files.readAllLines(Path.of(filename))) {
      if (line.length() > 60) {
        System.out.println(line);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("all lines:");
    printAllLines("input.txt");

    System.out.println();

    System.out.println("lines with length > 60:");
    printLinesWithLengthMoreThan60("input.txt");
  }
}
