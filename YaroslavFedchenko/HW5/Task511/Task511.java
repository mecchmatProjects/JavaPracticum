import MyPack.*;
import java.util.Scanner;
// task 5.11(OOP) Страхування. Визначити ієрархію страхових зобов'язань.
// Зібрати із зобвязань дериватив. Підрахувати вартість.
// Провести сортування зобовязань у в деріватіві на базі зменшення ступеня ризику.
// Знайти зобов'язання в деривативах, що  відповідне заданому діапазону параметрів.
public class Task511 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Ins r = new Ins("Страховка");

        System.out.println(r.print());
        System.out.println(r.full_price());

        System.out.print("діапазон \n від: ");
        int t = in.nextInt();
        System.out.print(" до: ");
        int d = in.nextInt();
        System.out.println(r.printIn(t, d));

    }
}