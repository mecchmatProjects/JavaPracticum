package multithreadingTasks.task1;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        Ship ship1 = new Ship(5, 30);
        Ship ship2 = new Ship(20, 30);
        Ship ship3 = new Ship(12, 30);

        ArrayDeque<Ship> ships = new ArrayDeque<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);

        Port p = new Port(40, 5, ships);
        p.startDocks();
    }
}
