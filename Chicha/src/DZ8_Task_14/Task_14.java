/*
Чича Олександр

Дано рядок A, що містить послідовність слів. Скласти програми, що визначають:
а) кількість усіх слів;
б) кількість слів, що починаються із цифри та вивести їх
в) кількість слів, що закінчуються з тризначного числа та вивести їх всіх
г) кількість слів, що починаються й закінчуються одним символом
ґ) кількість слів, що є електронною поштою
 */

package DZ8_Task_14;

import java.util.Scanner;

public class Task_14 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input raw A : ");

        String A = in.nextLine();

        String[] arrOfStr;
        arrOfStr = A.split(" ");

        System.out.println(getWordsCount(arrOfStr));
        System.out.println(getStartByNumber(arrOfStr));
        System.out.println(getEndByTheeNumber(arrOfStr));
        System.out.println(getStartEndSame(arrOfStr));
        System.out.println(getEmail(arrOfStr));
    }

    public static int getWordsCount(String[] words){
        return words.length;
    }

    public static String getStartByNumber(String[] words){
        int count = 0;
        String wordsStr = "";
        for (String word : words){
            if (isChrNumber(word.charAt(0))){
                count += 1;
                wordsStr += word + " ";
            }
        }
        return "Count words that starts by number : " + count + "\nWords: " + wordsStr;
    }

    public static String getEndByTheeNumber(String[] words){
        int n;
        int count = 0;
        String wordsStr = "";
        for (String word : words){
            n = word.length();
            if (n >= 3){
                if ((isChrNumber(word.charAt(n-1)))&&
                        (isChrNumber(word.charAt(n-2)))&&
                        (isChrNumber(word.charAt(n-3)))) {

                    count += 1;
                    wordsStr += word + " ";
                }
            }
        }
        return "Count words that end by three number : " + count + "\nWords: " + wordsStr;
    }

    public static String getEmail(String[] words){
        int count = 0;
        String wordsStr = "";
        for (String word : words){
            String[] arrOfStr1 = word.split("@");
            if (arrOfStr1.length == 2) {
                String[] arrOfStr2 = arrOfStr1[1].split("\\.");
                if (arrOfStr2.length == 2) {

                    count += 1;
                    wordsStr += word + " ";

                }
            }
        }
        return "Count words that are emails : " + count + "\nWords: " + wordsStr;
    }

    public static String getStartEndSame(String[] words){
        int n;
        int count = 0;
        String wordsStr = "";
        for (String word : words){
            n = word.length();
            if (word.charAt(0) == word.charAt(n-1)){
                count += 1;
                wordsStr += word + " ";
            }
        }

        return "Count words that starts and ends by the same char : " + count + "\nWords: " + wordsStr;
    }


    public static boolean isChrNumber(char a){
        return (48 <= (int) a) && ((int) a <= 57);
    }
}
