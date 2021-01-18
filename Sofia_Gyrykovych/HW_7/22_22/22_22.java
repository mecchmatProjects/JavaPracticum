import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

  public static void main(String[] args) throws Exception {
    String text = Files.readString(Path.of("input.txt"));

    Map<Character, Integer> chars = new HashMap<>();

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c != ' ') {
        chars.put(c, chars.getOrDefault(c, 0) + 1);
      }
    }

    List<Map.Entry<Character, Integer>> entries = new ArrayList<>(chars.entrySet());
    entries.sort(Comparator.comparing(Map.Entry::getValue));

    System.out.println("min char: '" + entries.get(0).getKey() + "'");
    System.out.println("max char: '" + entries.get(entries.size() - 1).getKey() + "'");
  }
}
