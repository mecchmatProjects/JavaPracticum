import java.util.Scanner;

public class Pr11 {
    public static void main(String[] args){
        double a,b,c,D,d,t1,t2;
        boolean flag = false;

        System.out.println("Введіть коєфіціенти де а!=0: ");

        Scanner scan = new Scanner(System.in);
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        D = (b * b - 4 * a * c);
        if (D<0)
            System.out.printf("Немає розв'язків");
        else if (D == 0){
            t1 = -b/(2*a);
            if (t1 > 0) System.out.printf("x1=%f; \nx2=%f; ",Math.sqrt(t1),-Math.sqrt(t1));
        }
        else {
            d = Math.sqrt(D);
            t1=( - b + d )/2.0 / a;
            t2=( - b - d )/2.0 / a;

            if (t1 > 0){
                System.out.printf("x1=%f; \nx2=%f; ",Math.sqrt(t1),-Math.sqrt(t1));
                flag = true;
            }
            if (t2 > 0){
                if (flag == true) System.out.printf("\nx3=%f; \nx4=%f; ",Math.sqrt(t2),-Math.sqrt(t2));
                else System.out.printf("x1=%f; \nx2=%f; ",Math.sqrt(t2),-Math.sqrt(t2));
            }
        }
    }
}
