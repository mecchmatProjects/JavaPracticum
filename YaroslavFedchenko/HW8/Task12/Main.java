package Task12;

import java.lang.reflect.Array;
import java.util.*;
// task 12(strings2) Fedchenko Yaroslav
// Виділити з рядка найбільший монотонний підрядок, коди послідовних символів якого відрізняються на 1.
public class Main {

    public static String findSubstring(String inputLine) {
        ArrayList<String> substrings = new ArrayList<>();
        int stateOfSubstring = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char[] characters = inputLine.toCharArray();
        int startIndex = characters[0];
        for (int i = 1; i < characters.length; i++) {
            int indexOfChar = characters[i];
            if (stateOfSubstring == 0)
                stringBuilder.append(characters[i - 1]);

            if (startIndex - indexOfChar == -1 ||
                    startIndex - indexOfChar == 0 ||
                    startIndex - indexOfChar == 1) {
                stringBuilder.append(characters[i]);
                stateOfSubstring = 1;
            } else {
                if (stateOfSubstring != 0) {
                    substrings.add(new String(stringBuilder));
                    stateOfSubstring = 0;
                }
                startIndex = characters[i];
                stringBuilder = new StringBuilder();
            }
        }

        try {
            return Collections.max(substrings, Comparator.comparingInt(String::length));
        } catch (NoSuchElementException e) {
            return null;

        }
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("sdfdgdfgdfdfgabbasdkfsakdfks"));
    }

}
