package Homework7;

import java.util.Scanner;

public class task_20 {
    public static int ord(char c){
        return (int) c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input line: ");
        String str = sc.nextLine();
        char [] ch = str.toCharArray();
        boolean res = true;
        for(int i = 1;i<ch.length;i++){
            if(ord(ch[i])<ord(ch[i-1])){
                res = false;
                break;
            }
        }
        if(res){
            System.out.println("The string is monotonous");
        }
        else{
            System.out.println("The string is not monotonous");
        }
    }
}
