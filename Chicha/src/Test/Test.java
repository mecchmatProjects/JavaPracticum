package Test;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class Test {
    public static void main(String[] args){

        System.out.println(minMaxCountChars("123aadsxc"));
    }
    static String minMaxCountChars(String line) {
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        char maxChar = ' ';
        char minChar = ' ';

        for (char key : map.keySet()) {
            if (key != ' ') {
                int value = map.get(key);
                if (value > maxCount) {
                    maxCount = value;
                    maxChar = key;
                }
                if (value < minCount) {
                    minCount = value;
                    minChar = key;
                }
            }
        }
        return "Max char : " + maxChar + " Count : " + maxCount + "\n" +
                "Min char : " + minChar + " Count : " + minCount;
    }
}