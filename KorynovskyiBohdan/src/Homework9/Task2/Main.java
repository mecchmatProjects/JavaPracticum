package Homework9.Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


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

public class Main {

    static ArrayList<Integer> read() throws IOException {
        FileReader fileReader = new FileReader("./src/Homework9/Task2/F.txt");
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
            if (!out.isContains((Integer) lst1[i])) {
                out.add((Integer) lst1[i]);
            } else if (!out.isContains((Integer) lst2[i])) {
                out.add((Integer) lst2[i]);
            }
        }
        return out;
    }

    static Map difference(Map first, Map second) {
        Map out = new Map();
        Object[] lst1 = first.intSet.toArray();
        Object[] lst2 = second.intSet.toArray();

        for (int i = 0; i < first.intSet.size(); i++) {
            if (!second.isContains((Integer) lst1[i]) & !out.isContains((Integer) lst1[i])) {
                out.add((Integer) lst1[i]);
            }
        }

        for (int i = 0; i < second.intSet.size(); i++) {
            if (!first.isContains((Integer) lst2[i]) & !out.isContains((Integer) lst2[i])) {
                out.add((Integer) lst2[i]);
            }
        }

        return out;
    }

    static Map pereten(Map first, Map second) {
        Map out = new Map();
        Object[] lst1 = first.intSet.toArray();
        Object[] lst2 = second.intSet.toArray();

        for (int i = 0; i < first.intSet.size(); i++) {
            if (second.isContains((Integer) lst1[i]) & !out.isContains((Integer) lst1[i])) {
                out.add((Integer) lst1[i]);
            }
        }

        for (int i = 0; i < second.intSet.size(); i++) {
            if (first.isContains((Integer) lst2[i]) & !out.isContains((Integer) lst2[i])) {
                out.add((Integer) lst2[i]);
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
