package HW10.Task14;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
// task 14(col) Fedchenko Yaroslav  Ввести рядки з файлу, записати в список ArrayList.
// виконати сортування рядків, використовуючи метод sort () з класу Collections.
class Main {

    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Path.of("res/Task14/task14.txt"));
        Collections.sort(lines);
        System.out.println("result:");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
