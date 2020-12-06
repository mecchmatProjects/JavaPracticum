package HW3;

import java.util.Scanner;
// task 5.8 Fedchenko Yaroslav
public class hw3 {
    static boolean check(int number){
        StringBuilder s = new StringBuilder();
        for(int i=number; i>0; i/=10)
            s.insert(0, i%10);
        String s1 = s.toString();

        for (int i = 0; i < s1.length(); i++) {
            long counter = count(s1, s1.charAt(i));
            if (counter > 1){
                return false;
            }
        }

        return true;
    }

   static long count(String s, char c){
        return s.chars().filter(x->x==c).count();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Insert array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 0; i < size; i++){
            if (check(array[i])){
                System.out.println(array[i]);
            }
        }
    }
}