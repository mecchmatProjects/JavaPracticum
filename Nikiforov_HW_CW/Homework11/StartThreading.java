package Homework11;

import java.util.ArrayDeque;

public class StartThreading extends Thread{
    ArrayDeque<Train> trains1;
    ArrayDeque<Train> trains2;
    StartThreading(ArrayDeque<Train> trains1, ArrayDeque<Train> trains2){
        this.trains1=trains1;
        this.trains2=trains2;
        start();
    }

    @Override
    public void run() {
//        Tunnels tunnels = null, tunnels2 = null;
        Tunnels tunnels1 = new Tunnels(trains1);
        Tunnels tunnels2 = new Tunnels(trains2);

//        while (!trains2.isEmpty() && !trains1.isEmpty()) {
//            tunnels = new Tunnels(trains1.remove(), 1);
//            tunnels2 = new Tunnels(trains2.remove(), 2);
//            try {
//                tunnels.join();
//                tunnels2.join();
//            } catch (InterruptedException iex){
//                iex.printStackTrace();
//            }
//        }

    }
}
