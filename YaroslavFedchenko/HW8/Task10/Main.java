package Task10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// task 10(strings2) Fedchenko Yaroslav
// Визначити процедуру пошуку в рядку підрядків, фрагментом яких є заданий регулярний вираз.
public class Main {


    public static void parseByRegular(String inputLine, String regularExpression) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(inputLine);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        parseByRegular("Hello Java! Hello JavaScript! JavaSE 8.","Java(\\w*)");
    }
}
