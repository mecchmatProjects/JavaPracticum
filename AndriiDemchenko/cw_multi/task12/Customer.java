package multithreadingTasks.task12;

public class Customer extends Person {
    static int eatingTime = 4000;
    int id;
    int dish;

    Customer(int id, int dish) {
        super(eatingTime);
        this.id = id;
        this.dish = dish;
        start();
    }

    void eating(){
        System.out.println(String.format("Customer_%d: I eated dish %d", id, dish));
    }

    @Override
    public void run() {
        try {
            sleep(time);
            eating();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
