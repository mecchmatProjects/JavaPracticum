package Pack;

import java.util.Scanner;

public class Pr2 {
    static int parse(String str){
        String[] s = str.split("[+]|(?=-)");
        int sum = 0;
        for (String num :
                s) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(parse(str));
    }
}
