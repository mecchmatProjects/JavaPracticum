package multithreadingTasks.task12;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of customers: ");
        int n = sc.nextInt();

        ArrayList<Integer> customers = new ArrayList<>();
        for (int i = 1; i <= n; i++) customers.add(i);

        RestarauntThread restarauntThread = new RestarauntThread(customers);

    }
}
