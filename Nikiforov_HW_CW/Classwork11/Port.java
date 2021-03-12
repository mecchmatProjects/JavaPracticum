package Classwork11;

import java.util.ArrayDeque;

public class Port extends  Thread{
    ArrayDeque<Ship> ships;
    Port(ArrayDeque<Ship> Ships){
        this.ships=Ships;
    }

    @Override
    public void run() {
        while (!ships.isEmpty()) {
            Dock dock = new Dock(ships.remove());
        }
    }

}
