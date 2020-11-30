/*
    Домашня робота №3. Масиви
    Завдання 5.4

    Напишить програму, що вводить з командного рядку числа x,y,z (координату точки А)
    та читає з консолі числа (xi,yi,zi), і виводить ту з нових точок, що найближча до (x,y,z).
*/

package Homework3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);

        double bestX = Double.NaN;
        double bestY = Double.NaN;
        double bestZ = Double.NaN;
        double bestDist = Double.POSITIVE_INFINITY;

        while (in.hasNextDouble()) {
            double xi = in.nextDouble();
            double yi = in.nextDouble();
            double zi = in.nextDouble();
            double dist = Math.pow(x - xi, 2) + Math.pow(y - yi, 2) + Math.pow(z - zi, 2);
            if (dist < bestDist) {
                bestX = xi;
                bestY = yi;
                bestZ = zi;
                bestDist = dist;
            }
        }
        System.out.printf("Closest point = (%f, %f, %f)\n", bestX, bestY, bestZ);
    }
}
