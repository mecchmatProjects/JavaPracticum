package multithreadingTasks.task12;

public class Waiter extends Person{
    static int carryingTime = 1500;

    Waiter(){
        super(carryingTime);
        start();
    }

    void carried(int curr, int dish) {
        System.out.println("Waiter: I carried dish " + dish + " to customer " + curr);
    }

    @Override
    public void run() {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
