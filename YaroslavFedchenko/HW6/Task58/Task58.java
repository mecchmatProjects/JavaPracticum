import MyPack.*;
import java.util.Scanner;
// task 5.8(OOP) Транспорт. Визначити ієрархію рухомого складу залізничного транспорту.
// Створити пасажирський поїзд. Підрахувати загальну чисельність пасажирів і багажу.
// Провести сортування вагонів поїзда на базі рівню комфортності.
// Знайти в потягу вагони, відповідні заданому діапазону параметрів кількості пасажирів.
public class Task58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Train r = new Train("Потяг");

        System.out.println(r.print());
        System.out.println(r.full_bag());
        System.out.println(r.full_pas());

        System.out.print("діапазон пассажирів \n від: ");
        int t = in.nextInt();
        System.out.print(" до: ");
        int d = in.nextInt();
        System.out.println(r.printIn(t, d));

    }
}