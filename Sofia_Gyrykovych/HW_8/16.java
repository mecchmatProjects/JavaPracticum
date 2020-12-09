class Main {

  public static void main(String[] args) throws Exception {
    final String letters = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    final String text = "" +
      "А й правда, крилатим ґрунту не треба." +
      "Землі немає, то буде небо." +
      "Немає поля, то буде воля." +
      "Немає пари, то будуть хмари.";

    System.out.println("valid letters:");

    for (int i = 0; i < text.length(); i++) {
      if (letters.indexOf(text.charAt(i)) != -1) {
        System.out.print(text.charAt(i) + " ");
      }
    }
  }
}
