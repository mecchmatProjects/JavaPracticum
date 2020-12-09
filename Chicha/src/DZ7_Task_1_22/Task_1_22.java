package DZ7_Task_1_22;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Task_1_22 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Input raw A : ");

        String A = in.nextLine();

        System.out.println(minMaxCountChars(A));
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
        return "Max char : '" + maxChar + "'   Count : " + maxCount + "\n" +
                "Min char : '" + minChar + "'   Count : " + minCount;
    }
}
