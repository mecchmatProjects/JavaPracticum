/*
Чича Олександр

12)Виділити з рядка найбільший монотонний підрядок, коди послідовних символів якого відрізняються на 1.
 */

package DZ8_Task_2_12;

import java.util.Scanner;

public class Task_2_12 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input raw A : ");

        String A = in.nextLine();

        System.out.println(theBiggerRaw(A));
    }

    static String theBiggerRaw(String raw){

        char currentChar;
        int currentCharInt;
        String currentRaw = "";
        String ansRaw = "";
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < raw.length();i++){
            currentChar = raw.charAt(i);
            currentCharInt = currentChar;
            int n = currentRaw.length();
            if (n == 0) currentRaw += currentChar;
            else{
                if (Math.abs(currentCharInt - (int) currentRaw.charAt(n - 1)) == 1){
                    currentRaw += currentChar;
                }
                else {
                    if (n > maxLen){
                        maxLen = n;
                        ansRaw = currentRaw;
                    }
                    currentRaw = "" + currentChar;
                }
            }
        }

        if (currentRaw.length() > maxLen){
            ansRaw = currentRaw;
        }

        return ansRaw;
    }

}
