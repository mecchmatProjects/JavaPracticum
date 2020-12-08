package HW7.Task16;
import java.util.HashMap;
import java.util.Scanner;
// task 16(strings) Fedchenko Yaroslav
// Скласти  програму підрахунку числа входжень у рядок А заданої послідовності літер.
public class Main {
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    public static void main(String[] args)
    {
        System.out.println("Enter your string");
        Scanner sc = new Scanner(System.in);
        String originalStr= sc.nextLine();

        System.out.println("Enter the remove string");
        Scanner sc1 = new Scanner(System.in);
        String strToCount = sc1.nextLine();

        System.out.println(count(originalStr, strToCount));
    }
}
