/*
Чича Олександр

3). Нехай множина цілих чисел задана у файлі. Визначити:
а) процедуру введення множини;
б) процедуру виведення множини;
в) процедуру доповнення множини;
г) процедуру видалення елемента з множини;
ґ) функцію, що дає відповідь, чи входить елемент до множини;
д) функцію, що дає відповідь, чи порожня множина;
е) функцію, що знаходить максимальний елемент множини;
є) функцію, що знаходить мінімальний елемент множини;
ж) процедуру об'єднання множин;
з) процедуру різниці множин;
и) процедуру перетину множин;
і) функцію обчислення ваги множини;
ї) функцію обчислення діаметра множини;
й) функцію, що  за множиною  A  знаходить  підмножину  всіх  таких  її
елементів, для яких справедлива умова Q(х), x∈A;
к) функцію, що з'ясовує, чи є множина A підмножиною множини В;
л) функцію, що з'ясовує, чи дорівнює множина A множині В.
 */

package DZ9_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class Task_9_3 {

    static ArrayList<Integer> read() throws IOException {
        FileReader fileReader = new FileReader("./src/DZ9_3/Task_9_3/F.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();

        ArrayList<Integer> lst = new ArrayList<>();
        while (line != null) {
            for (String str : line.split(" ")) {
                lst.add(Integer.parseInt(str));
            }
            line = reader.readLine();
        }
        fileReader.close();
        reader.close();

        return lst;
    }

    static Map concatenate(Map first, Map second) {
        Map out = new Map();
        Object[] lst1 = first.intSet.toArray();
        Object[] lst2 = second.intSet.toArray();
        for (int i = 0; i < first.intSet.size(); i++) {
            if (!out.isContains((int) lst1[i])) {
                out.add((int) lst1[i]);
            } else if (!out.isContains((int) lst2[i])) {
                out.add((int) lst2[i]);
            }
        }
        return out;
    }

    static Map difference(Map first, Map second) {
        Map out = new Map();
        Object[] lst1 = first.intSet.toArray();
        Object[] lst2 = second.intSet.toArray();

        for (int i = 0; i < first.intSet.size(); i++) {
            if (!second.isContains((int) lst1[i]) & !out.isContains((int) lst1[i])) {
                out.add((int) lst1[i]);
            }
        }

        for (int i = 0; i < second.intSet.size(); i++) {
            if (!first.isContains((int) lst2[i]) & !out.isContains((int) lst2[i])) {
                out.add((int) lst2[i]);
            }
        }

        return out;
    }

    static Map pereten(Map first, Map second) {
        Map out = new Map();
        Object[] lst1 = first.intSet.toArray();
        Object[] lst2 = second.intSet.toArray();

        for (int i = 0; i < first.intSet.size(); i++) {
            if (second.isContains((int) lst1[i]) & !out.isContains((int) lst1[i])) {
                out.add((int) lst1[i]);
            }
        }

        for (int i = 0; i < second.intSet.size(); i++) {
            if (first.isContains((int) lst2[i]) & !out.isContains((int) lst2[i])) {
                out.add((int) lst2[i]);
            }
        }

        return out;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Integer> lst = read();
        Map map = new Map(lst);
        map.print();
    }

}

class Map {
    HashSet<Integer> intSet;

    Map(ArrayList<Integer> inp) {
        intSet = new HashSet<>();
        intSet.addAll(inp);
    }

    Map() {
        intSet = new HashSet<>();
    }

    void print() {
        for (Integer el : this.intSet) {
            System.out.printf("%d ", el);
        }
    }

    void add(int el) {
        intSet.add(el);
    }

    void remove(int el) {
        intSet.remove(el);
    }

    boolean isContains(int el) {
        return intSet.contains(el);
    }

    boolean isEmpty() {
        return intSet.isEmpty();
    }

    int max() {
        int max = 0;
        for (Integer el : intSet) {
            if (el > max) {
                max = el;
            }
        }

        return max;
    }

    int min() {
        int min = 0;
        for (Integer el : intSet) {
            if (el < min) {
                min = el;
            }
        }

        return min;
    }

    boolean isEqual(Object el){
        return  intSet.equals(el);
    }

    boolean isSubSet(Map map) {
        return intSet.containsAll(map.intSet);
    }

}

