/*
    5.2.Новогодній подарунок. Визначити ієрархію цукерок та інших солодощів. Створити
    кілька об`єктів-цукерок. Зібрати дитячий подарунок з урахуванням його ваги.
    Провести сортування цукерок в подарунок на основі одного з параметрів. Знайти
    цукерку в подарунок, відповідну заданому діапазону вмісту цукру.
 */

package Homework6.Task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Sweet> createSomeSweets() throws IOException {
        return Utils.readFile("./src/Homework6/Task1/task1.txt");
    }

    public static Present makePresent(ArrayList<Sweet> sweets, int maxWeight) {
        Present present = new Present(maxWeight);

        for (Sweet sweet : sweets) {
            present.addSweet(sweet);
        }

        return present;
    }

    public static Sweet findSweet(ArrayList<Sweet> sweets, double from, double to) {
        for (Sweet sweet : sweets) {
            if (sweet.sugar <= to & sweet.sugar >= from) {
                return sweet;
            }
        }

        return null;
    }

    public static void sortBySugar(Present present) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < present.sweets.size(); i++) {
                if (present.sweets.get(i).sugar < present.sweets.get(i - 1).sugar) {
                    Collections.swap(present.sweets, i, i - 1);
                    needIteration = true;
                }
            }
        }
    }

    public static void sortByWeight(Present present) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < present.sweets.size(); i++) {
                if (present.sweets.get(i).weight < present.sweets.get(i - 1).weight) {
                    Collections.swap(present.sweets, i, i - 1);
                    needIteration = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Sweet> sweets = createSomeSweets();

        Present present = makePresent(sweets, 100);

        Sweet requestedSweet = findSweet(sweets, 0.3, 0.5);

        assert requestedSweet != null;
        System.out.println(requestedSweet.toString());

        System.out.println("Sorted by percent of sugar");

        sortBySugar(present);
        for (Sweet sweet : present.sweets) {
            System.out.println("\n");
            System.out.println(sweet.toString());
        }

        System.out.println("Sorted by weight");

        sortByWeight(present);
        for (Sweet sweet : present.sweets) {
            System.out.println("\n");
            System.out.println(sweet.toString());
        }
    }
}
