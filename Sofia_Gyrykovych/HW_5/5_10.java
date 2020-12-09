import java.util.Scanner;

import taxi.Park;
import taxi.car.BMW;
import taxi.car.Car;
import taxi.car.Ford;
import taxi.car.Nissan;

class Main {

    public static void main(String[] args) {
        Park park = new Park();

        park.addCar(new Nissan("Versa", 15000.0));
        park.addCar(new BMW("340", 50000.0));
        park.addCar(new Ford("Figo", 5000.0));
        park.addCar(new Ford("Endeavour", 30000.0));
        park.addCar(new BMW("330", 42000.0));
        park.addCar(new Ford("Freestyle", 6000.0));
        park.addCar(new Nissan("Altime", 25000.0));
        park.addCar(new Nissan("Sentra", 20000.0));
        park.addCar(new BMW("230", 36000.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("options:");
            System.out.println(" 0) exit");
            System.out.println(" 1) count total cost of cars");
            System.out.println(" 2) print cars by fuel consumption");
            System.out.println(" 3) find cars by maximum speed");

            System.out.print("i want to: ");
            int option = scanner.nextInt();

            if (option == 0) {
                System.out.println("bye");
                break;
            }

            switch (option) {
                case 1:
                    System.out.println();
                    System.out.println("total cost: " + park.getTotalCost());
                    break;
                case 2:
                    System.out.println();
                    System.out.println("cars:");
                    for (Car car : park.getCarsOrderByFuelConsumption()) {
                        System.out.println(car);
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.print("enter a: ");
                    double a = scanner.nextDouble();
                    System.out.print("enter b: ");
                    double b = scanner.nextDouble();
                    System.out.println("cars:");
                    for (Car car : park.getCarsWhereSpeedBetween(a, b)) {
                        System.out.println(car);
                    }
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
    }
}