package Pack;
import java.util.Scanner;

public class Pr {
    static String A(String str){
        str = str.replaceAll("[0-9]","");
        str = str.replace("+","++");
        str = str.replace("-","--");
        return str;
    }

    static String B(String str){
        str = str.replaceAll("\\+(?=\\d)","");
        return str;
    }

    static String V(String str){
        String s="";
        boolean flag = false;
        for (int i = 0;i<str.length();++i){
            Character c = str.charAt(i);
            if (c.equals('c')){
                flag = true;
                s += String.valueOf(str.charAt(i));
                continue;
            }
            if (flag && c.equals('b')){
                flag = false;
                continue;
            }
            s += String.valueOf(str.charAt(i));
            flag = false;
        }
        return s;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(V(str));
    }
}
