package Homework11;

import java.util.ArrayDeque;

public class Tunnels extends Thread {
    ArrayDeque<Train> trains;
    Tunnels(ArrayDeque<Train> trains){
        this.trains = trains;
        start();
    }



    @Override
    public void run() {
        for (Train tr: trains){
            tr.run();
        }
    }
}
