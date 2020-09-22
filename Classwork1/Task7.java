package Classwork1;
import java.util.Scanner;
//num 3.3
public class Task7 {
    public  static String instr(int m){
        return switch (m) {
            case 1 -> "Januar";
            case 2 -> "Februar";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "Juny";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Error";
        };
    }
    public static boolean checker(int d,int m,int y) {
        switch (m) {
            case 1:
                return true;
            case 2:
                if (y%4==0){
                    if(d<=29)
                    {
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if(d<=28)
                    {
                        return true;
                    }
                    else{
                        return false;
                    }
                }

            case 3:
                return true;
            case 4:
                if(d!=31){
                    return true;
                }
                else {
                    return false;
                }
            case 5:
                return true;
            case 6:
                if (d != 31) {
                    return true;
                } else {
                    return false;
                }
            case 7:
                return true;
            case 8:
                return true;
            case 9:
                if (d != 31) {
                    return true;
                } else {
                    return false;
                }
            case 10:
                return true;
            case 11:
                if (d != 31) {
                    return true;
                } else {
                    return false;
                }
            case 12:
                return true;
            default:
                return false;
        }

    }


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Input day: ");
        int d = sc.nextInt();
        System.out.println("Input month: ");
        int m = sc.nextInt();
        System.out.println("Input year: ");
        int y = sc.nextInt();
        if(0>d||31<d||0>m||12<m||1999>y||2100<y){
            System.out.println("Incorrect Input!");
            System.exit(0);
        }
        if(checker(d,m,y)){
            String str_m=instr(m);
            System.out.println("Data is "+d+" "+str_m+" of " + y+ " year.");
        }
        else
        {
            System.out.println("Incorrect Input!");
        }


    }
}
