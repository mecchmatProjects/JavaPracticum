package Classwork11;

public class Dock extends Thread{
    private static int id = 1;
    Ship sh;
    int num;

    Dock (Ship sh){
        this.num = id++;
        this.sh = sh;
        start();
    }


    @Override
    public void run() {
        try {
            sleep(sh.time);
            System.out.println("Unloaded to dock " + num + " complete");
            sleep(sh.time);
            System.out.println("Loaded from dock " + num + " complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
