package Classwork11;

import java.util.ArrayDeque;

public class task1 {
    public static void main(String[] args) {
        Ship sh1 = new Ship(2000);
        Ship sh2 = new Ship(8000);
        Ship sh3 = new Ship(1000);
        ArrayDeque<Ship> ships = new ArrayDeque<>();
        ships.add(sh1);
        ships.add(sh2);
        ships.add(sh3);
        Port port = new Port(ships);
        port.run();
    }
}
