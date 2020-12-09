/*
    9. Списки (стеки, черги) I (1..n) і U (1..n) містять результати n вимірів струму і напруги на невідомому опорі R.
     Знайти наближене число R методом найменших квадратів.
 */

package Homework10;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Double> I = new ArrayList<>();
        I.add(0.1);
        I.add(0.2);
        I.add(0.3);
        I.add(0.4);
        ArrayList<Double> U = new ArrayList<>();
        U.add(1.0);
        U.add(2.0);
        U.add(3.0);
        U.add(4.0);
        ArrayList<Double> R = new ArrayList<>();

        for (int i = 0; i < I.size(); i ++){
            R.add(U.get(i) / I.get(i));
        }

        double sum = 0;
        for (Double r: R){
            sum += r;
        }

        System.out.println(sum / 4);
    }
}
