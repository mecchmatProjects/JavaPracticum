package HW1;
import java.io.*;
// task 1.7 Fedchenko Yaroslav
public class  hw1 {

    public static void main(String[] args)  {
        int p = 1;
        for(int i=0; i < args.length; i++)
        {
            int x = Integer.parseInt(args[i]);
            p *= x;
        }
        System.out.println("multiplication = "+ p);
    }
}
