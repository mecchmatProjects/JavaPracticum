package multithreadingTasks.task1;

public class Dock extends Thread {
    int id;
    String dockName;
    Ship curShip;

    public static int maxPC, curPC;

    Dock(int id, Ship curShip, int maxC, int curC){
        super("Dock " + id);
        dockName = "Dock " + id;
        System.out.println(dockName + " created!");

        this.id = id;
        this.curShip = curShip;

        curPC = curC;
        maxPC = maxC;

        start();
    }

    public void run() {
        unloadShip();
        System.out.println("Unloading from " + dockName + " completed!!!");
        loadShip();
        System.out.println("Loading to " + dockName + " completed!!!");
    }

    void unloadShip() {
        int curC = curShip.curC;
        int maxC = curShip.maxC;
        try {
            while (curShip.curC-- > 0 && curPC < maxPC) {
                System.out.println(dockName + " ship unloading...");
                curPC++;
                Thread.sleep(2000);
            }
            System.out.println(dockName + " ship current capacity: " + curC);
        } catch (InterruptedException iex) {
            System.out.println("U :)");
        }
    }

    void loadShip() {
        try {
            while (curShip.curC++ < curShip.maxC && curPC > 0) {
                System.out.println(dockName + " ship loading...");
                curPC--;
                Thread.sleep(2000);
            }
            System.out.println(dockName + " ship current capacity: " + curShip.curC);
        } catch (InterruptedException iex) {
            System.out.println("L :)");
        }
    }
}
