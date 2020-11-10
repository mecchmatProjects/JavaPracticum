package Classwork8;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;

public class task1str {
    public static String RemoveSpaces(String str){
        String clear = str.replaceAll("^(\\s)*", "");
        clear = clear.replaceAll("(\\s)*$", "");
        clear = clear.replaceAll("(\\s){2,}", " ");
        return clear;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Input line: ");
        String str = sc.nextLine();
        String cl_str = RemoveSpaces(str);
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(cl_str);
        ArrayList<String> words = new ArrayList<>();
        while (matcher.find()){
            words.add(cl_str.substring(matcher.start(), matcher.end()));
        }
        int max_l = 0;
        String max_str = "";
        for(String i:words){
            if(i.length()>max_l){
                max_l = i.length();
                max_str = i;
            }
        }
        System.out.println("The longest word is "+max_str+", with "+max_l+" letters");
        System.out.println("Words amount: "+words.size());
        String noone_str = cl_str.replaceAll("\\s\\w\\s", " ");
        System.out.println("Line for task3: "+noone_str);

    }
}
