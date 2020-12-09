package DZ7_Task_1_15;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class Task_1_15 {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.println("Input raw A : ");

        String A = in.nextLine();

        System.out.println("Max count : " + getMaxCounterInLine(A));
    }

    public static int getMaxCounterInLine(String line){

        /*
        "1234567890" in bytes :
            [49, 50, 51, 52, 53, 54, 55, 56, 57, 48]
         */

        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        byte[] r;
        r = line.getBytes();
        for (int i=0; i<line.length(); i++){
            if ((48 <= r[i])&&(r[i] <= 57)){
                count += 1;
            }
            else {
                if (maxCount < count){
                    maxCount = count;
                }
                count = 0;
            }
        }

        if (maxCount < count){
            maxCount = count;
        }

        return maxCount;
    }
}
