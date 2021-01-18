package Task16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
// task 16(col2) Fedchenko Yaroslav Заданий файл з текстом англійською мовою. Виділити все різні слова.
// Слова, що відрізняються тільки регістром літер, вважати однаковими. Використовувати клас HashSet.
public class Main {
    private static HashSet<String> vocabulary = new HashSet<String>();

    public static void parseText(String filePath) throws FileNotFoundException {
        File inputFile = new File(filePath);
        File outputFile = new File("res/Task16/uniqueWords");
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine().toLowerCase();
            String[] array = data.split(" ");
            vocabulary.addAll(Arrays.asList(array));

            System.out.println();
        }

        try (FileWriter writer = new FileWriter(outputFile, false)) {
            StringBuilder stringBuilder = new StringBuilder();

            for (String str : vocabulary) {
                stringBuilder.append(str);
                stringBuilder.append(" ");
            }


            writer.append(new String(stringBuilder));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        parseText("res/Task16/Task16");
    }
}
