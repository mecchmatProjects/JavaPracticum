import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

class Main {

  public static void main(String[] args) throws Exception {
    List<String> lines = Files.readAllLines(Path.of("input.txt"));

    Collections.sort(lines);

    System.out.println("result:");
    for (String line : lines) {
      System.out.println(line);
    }
  }
}
