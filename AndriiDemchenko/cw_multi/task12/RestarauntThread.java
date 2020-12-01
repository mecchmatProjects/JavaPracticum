package multithreadingTasks.task12;

import java.util.*;

public class RestarauntThread extends Thread {
    ArrayList<Integer> customers;
    HashMap<Integer, Integer> dishesMap;

    RestarauntThread(ArrayList<Integer> customers){
        this.customers = customers;
        dishesMap = new HashMap<>();
        for (Integer c: customers) dishesMap.put(c, 1);

        start();
    }

    static int getNewId(ArrayList<Integer> arr) {
        int prev = arr.get(0);
        int c;

        if ((new Random()).nextBoolean()){
            for (int i = 1; i < arr.size(); i++){
                c = arr.get(i);
                if (c < prev){
                    arr.remove(i);
                    return c;
                }
                prev = c;
            }
        }

        c = arr.get(0);
        arr.remove(0);
        return c;

    }

    @Override
    public void run() {
        System.out.println("\nRestaurant opened!");

        int curr;
        while (!(customers.isEmpty())){
            curr = getNewId(customers);
            int dish = dishesMap.get(curr);

            if (dish < 3) {
                customers.add(curr);
                dishesMap.put(curr, dish+1);
            }

            try {
                Cook cook = new Cook();
                cook.join();
                cook.cooked(curr, dish);
                Waiter waiter = new Waiter();
                waiter.join();
                waiter.carried(curr, dish);
                Customer customer = new Customer(curr, dish);

            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
    }

}
