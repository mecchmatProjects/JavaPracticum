package Task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;
// task 9 Fedchenko Yaroslav У вхідному файлі розташовані два набору позитивних чисел; між наборами є негативне число. Побудувати два списки C1 і С2, елементи яких містять відповідно числа 1-го і 2-го набору таким чином, щоб усередині одного списку числа були впорядковані по зростанню.
// Потім об'єднати списки C1 і С2 в один впорядкований список,
// змінюючи тільки значення полів референтного типу.
public class Main {

    private static void sortList(LinkedList<Integer> c1) {
        Collections.sort(c1);
    }

    public static void creatingLists(String filePath, LinkedList<Integer> c1, LinkedList<Integer> c2) {
        File inputFile = new File(filePath);
        int negativeNumberState = 0;
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                int[] allNumbers = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int allNumber : allNumbers) {
                    if (negativeNumberState == 0) {
                        if (allNumber < 0) {
                            negativeNumberState = 1;
                            continue;
                        }
                        c1.add(allNumber);
                    } else {
                        c2.add(allNumber);
                    }
                }

            }
            sortList(c1);
        } catch (FileNotFoundException e) {
            Logger.getLogger("File not found");
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> c1 = new LinkedList<>();
        LinkedList<Integer> c2 = new LinkedList<>();

        creatingLists("res/Task9/Task9.txt", c1, c2);
        c1.forEach(x-> System.out.print(x+ "->"));
        System.out.println();
        c2.forEach(x-> System.out.print(x + "->"));
    }
}
