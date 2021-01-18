/*
    10.Train: Пункт призначення, Номер поїзда, Час відправлення, Число місць (загальних, купе, плацкарт, люкс).
    Створити масив об`єктів. Вивести:
    a) список поїздів, які прямують дозаданного пункту призначення;
    b) список поїздів, які прямують дозаданного пункту призначення і відправки після заданої години;
    c) список поїздів, які відправляються до заданного пункту призначення і мають спільні місця.
 */

package Homework4;

import java.util.Scanner;

class Train {
    String destination;
    int number;
    int time;
    int seatAll;
    int seatCompartment;
    int seatReserved;
    int seatLuxury;

    public Train(String destination, int number, int time, int seatAll, int seatCompartment, int seatReserved, int seatLuxury) {
        this.destination = destination;
        this.number = number;
        this.time = time;
        this.seatAll = seatAll;
        this.seatCompartment = seatCompartment;
        this.seatReserved = seatReserved;
        this.seatLuxury = seatLuxury;
    }

    public Train(String destination, int number, int time, int seatAll) {
        this.destination = destination;
        this.number = number;
        this.time = time;
        this.seatAll = seatAll;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public int getTime() {
        return time;
    }

    public int getSeatAll() {
        return seatAll;
    }

    public String toString() {
        return "destination: " + destination + " number:" + number + " time:" + time + " seatAll:" + seatAll + " seatCompartment:" + seatCompartment +
                " seatReserved:" + seatReserved + " seatLuxury:" + seatLuxury;
    }

    public static Train[] arrayOfTrains(int n) {
        Train[] res = new Train[n];
        for (int i = 0; i < n - 2; i++) {
            res[i] = new Train("destination-" + i, i, 11 + i, 20 + i * 10);
        }

        res[n - 2] = new Train("destination-1", n - 2, 12, 30);
        res[n - 1] = new Train("destination-1", n - 1, 8, 239);

        return res;
    }


}

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dest = in.nextLine();
        int time = in.nextInt();
        int seatAll = in.nextInt();

        Train[] trains = Train.arrayOfTrains(8);

        trains[5].setDestination("destination-1");

        // a
        System.out.println("список поїздів, які прямують дозаданного пункту призначення;");
        for (int i = 0; i < 8; i++) {
            if (trains[i].getDestination().equals(dest)) {
                System.out.println(trains[i].toString());
            }
        }

        // b
        System.out.println("\nсписок поїздів, які прямують дозаданного пункту призначення і відправки після заданої години;");
        for (int i = 0; i < 8; i++) {
            if (trains[i].getDestination().equals(dest) & trains[i].getTime() >= time) {
                System.out.println(trains[i].toString());
            }
        }

        // c
        System.out.println("\nсписок поїздів, які відправляються до заданного пункту призначення і мають спільні місця.");
        for (int i = 0; i < 8; i++) {
            if (trains[i].getDestination().equals(dest) & trains[i].getSeatAll() == seatAll) {
                System.out.println(trains[i].toString());
            }
        }
    }
}
