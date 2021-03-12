package Homework11;

import java.util.ArrayDeque;
import java.util.Deque;

public class task7 {
    public static void main(String[] args) {
        Train t1 = new Train(1000, 1);
        Train t2 = new Train(2000, 1);
        Train t3 = new Train(8000, 1);
        Train t4 = new Train(9000, 1);
        ArrayDeque<Train> trains1 = new ArrayDeque<>();
        trains1.add(t1);
        trains1.add(t2);
        trains1.add(t3);
        trains1.add(t4);


        Train t5 = new Train(2000, 2);
        Train t6 = new Train(3000, 2);
        Train t7 = new Train(5000, 2);
        Train t8 = new Train(8000, 2);
        Train t9 = new Train(7000, 2);
        ArrayDeque<Train> trains2 = new ArrayDeque<>();
        trains2.add(t5);
        trains2.add(t6);
        trains2.add(t7);
        trains2.add(t8);
        trains2.add(t9);

        StartThreading st = new StartThreading(trains1,trains2);
    }
}
