/*
    11. Додати два многочлена заданого ступеня, якщо коефіцієнти многочленів зберігаються в об'єкті HashMap.
 */

package Homework10;

import java.util.HashMap;

public class Task2 {
    public static void main(String[] args) {
        // a0 + a1*x + a2*x^2
        HashMap<Integer, Double> first = new HashMap<>();
        HashMap<Integer, Double> second = new HashMap<>();
        first.put(0, 2.5);
        first.put(1, 5.2);
        first.put(2, 3.0);
        second.put(0, 1.5);
        second.put(1, 2.5);
        second.put(2, 1.5);
        HashMap<Integer, Double> result = new HashMap<>();
        for (Integer indx: first.keySet()){
            result.put(indx, first.get(indx) + second.get(indx));
        }

        for (Integer indx: result.keySet()){
            System.out.println(result.get(indx));
        }
    }
}
