package multithreadingTasks.task1;

import java.util.ArrayDeque;

public class Port {
    final int maxCapacity;
    int curCapacity;
    ArrayDeque<Ship> shipsQueue;

    Port(int m, int c, ArrayDeque<Ship> ships){
        maxCapacity = m;
        curCapacity = c;
        shipsQueue = new ArrayDeque<>(ships);
    }

    void startDocks(){
        int i = 1;
        while (!shipsQueue.isEmpty()) {
            Dock dock = new Dock(i++, shipsQueue.remove(), maxCapacity, curCapacity);
        }

        curCapacity = Dock.curPC;
    }
}
