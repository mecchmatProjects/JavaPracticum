import java.util.Scanner;
import java.util.ArrayList;
public class Lesson2_4_2{
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        int number;
        int i = 0;
        System.out.print("Enter " + "a[" + (i)+ "]" + " number: ");
        while ((number = in.nextInt()) != 0){
            i++;
            System.out.print("Enter " + "a[" + (i)+ "]" + " number: ");
        	list.add(number);
        	i++;
        }
        for(int k = 0; k < list.size(); k++){
        	sum = sum + list.get(k);
        }
        System.out.println("Thank you! Got your sum: " + sum);
    }
}

