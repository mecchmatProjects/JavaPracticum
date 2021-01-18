import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

  public static void main(String[] args) throws Exception {
    String text = Files.readString(Path.of("input.txt"));
    Pattern pattern = Pattern.compile(".*?[.,!?]");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      System.out.println("next: " + matcher.group());
    }
  }
}
