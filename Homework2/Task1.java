package Homework2;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input amount of numbers: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int inputer = sc.nextInt();
            arr[i] = inputer;
        }
        int checker = 0;
        int answer = 0;
        for(int i=0;i<n;i++){
            if (checker==2){
                break;
            }
            String nik = Integer.toString(arr[i]);
            char[] charArray = nik.toCharArray();
            boolean tester = true;
            for (int j = 0;j<charArray.length; j++){
                if(charArray[j]!=charArray[charArray.length-j-1]){
                    tester=false;
                    break;
                }
            }
            if (tester){
                checker+=1;
                answer=arr[i];
            }
        }
        if (answer==0) {
            System.out.println("There is not any polindroms!");
        }
        else{
            System.out.println("Anser: "+answer);
        }
    }
}
