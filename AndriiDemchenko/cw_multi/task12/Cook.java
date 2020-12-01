package multithreadingTasks.task12;

public class Cook extends Person{
    static int cookingTime = 2200;

    Cook() {
        super(cookingTime);
        start();
    }

    public void cooked(int curr, int dish) throws InterruptedException {
        System.out.println("Cook: I cooked dish " + dish + " for customer " + curr);
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
