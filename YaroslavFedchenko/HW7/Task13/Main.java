package HW7.Task13;
import java.util.HashMap;
import java.util.Scanner;
// task 13(strings) Fedchenko Yaroslav
// Скласти програму видалення із рядка А всіх входжень заданої групи символів.
public class Main {
    static String removeCharsFromString(String word1, String word2)
    {
        StringBuilder sb = new StringBuilder(word1);

        System.out.println(sb);
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();

        for (int i = 0; i < word2.length(); i++)
        {
            table.put(word2.charAt(i), 1);

        }

        int p = 0;
        for (int i = 0; i < word1.length(); i++)
        {

            if (table.containsKey(word1.charAt(i)))
            {
                if (p == 0)
                {
                    sb.deleteCharAt(i);
                }
                else
                {
                    sb.deleteCharAt(i - p);
                }
                p++;
            }

        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println("Enter your string");
        Scanner sc = new Scanner(System.in);
        String originalword = sc.nextLine();

        System.out.println("Enter the remove string");
        Scanner sc1 = new Scanner(System.in);
        String removecharacters = sc1.nextLine();

        String result = removeCharsFromString(originalword, removecharacters);

        System.out.println(result);
    }
}
