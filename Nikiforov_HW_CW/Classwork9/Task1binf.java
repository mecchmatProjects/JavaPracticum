package Classwork9;

import java.io.*;
import java.util.ArrayList;

public class Task1binf {
    static ArrayList<ArrayList<Float>> readFile(String filePath) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));

        ArrayList<ArrayList<Float>> arr = new ArrayList<>();

        try {
            while (true) {
                String[] infoArr = dis.readLine().split(" ");
                ArrayList<Float> row = new ArrayList<>();
                for (String sbi: infoArr){
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i+=2){
                        a += Character.toString(sbiBytes[i]);
                    }

                    if (a.isEmpty()) continue;
                    row.add(Float.parseFloat(a));
                }
                if (!row.isEmpty())
                    arr.add(row);

            }

        } catch (EOFException | NullPointerException ignored) { dis.close(); }

        return arr;

    }

    static float task1(ArrayList<ArrayList<Float>> arr){
        float sum = 0;
        for(ArrayList<Float> row: arr) {
            for (Float x : row) {
                sum += x;
            }
        }
        return sum;

    }

    static int task2(ArrayList<ArrayList<Float>> arr){
        int counter=0;
        for(ArrayList<Float> row: arr) {
            for (Float x : row) {
                if (x < 0) {
                    counter += 1;
                }
            }
        }
       return counter;
    }

    static float task3(ArrayList<ArrayList<Float>> arr){
        int n = arr.size();
        int m = arr.get(n-1).size();
        float last = arr.get(n-1).get(m-1);
        return last;
    }

    static float task4(ArrayList<ArrayList<Float>> arr){
        float max = arr.get(0).get(0);
        for(ArrayList<Float> row: arr) {
            for (Float x : row) {
                if(x>max){
                    max = x;
                }
            }
        }
        return max;
    }

    static float task5(ArrayList<ArrayList<Float>> arr){
        float min = 1000000000.f;
        int n = arr.size();
        int m;
        for(int i = 0; i < n; i++){
            if (i % 2 == 1){
                m = arr.get(i).size();
                for(int j = 0; j < m; j++){
                    if(j % 2 == 1 && arr.get(i).get(j) < min){
                        min = arr.get(i).get(j);
                    }
                }
            }
        }

        return min;
    }

    static float task6(ArrayList<ArrayList<Float>> arr){
        float min = arr.get(0).get(0);
        for(ArrayList<Float> row: arr) {
            for (Float x : row) {
                if(x<min){
                    min = x;
                }
            }
        }
        float max = task4(arr);
        return min+max;
    }

    static float task7(ArrayList<ArrayList<Float>> arr){
        float first = arr.get(0).get(0);
        float last = task3(arr);
        return first-last;
    }

    static ArrayList<Float> task8(ArrayList<ArrayList<Float>> arr){
        int size = 0;
        for(ArrayList<Float> row: arr) {
            size+=row.size();
        }
        float sum = task1(arr);
        float average = sum/((float)(sum));
        ArrayList<Float> result = new ArrayList<>();
        for(ArrayList<Float> row: arr) {
            for (Float x : row) {
                if(x<average){
                    result.add(x);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        String bfile = "src/Classwork9/b_inp.dat";
        ArrayList<ArrayList<Float>> arr = new ArrayList<>();
        arr = readFile(bfile);
        System.out.println("Values from file: ");
        for(ArrayList<Float> row: arr) {
            for (Float x : row) {
                System.out.print(x + " ");

            }
            System.out.println();
        }

        System.out.println("\n\n");

        System.out.println("Task 1: ");
        System.out.println("Sum of values: "+task1(arr));

        System.out.println("\n\n");

        System.out.println("Task 2: ");
        System.out.println("Total amount negative values: "+task2(arr));

        System.out.println("\n\n");

        System.out.println("Task 3: ");
        System.out.println("Last value: "+ task3(arr));

        System.out.println("\n\n");

        System.out.println("Task 4: ");
        System.out.println("Biggest value: "+task4(arr));

        System.out.println("\n\n");

        System.out.println("Task 5: ");
        System.out.println("Lowest value with even indexes: "+ task5(arr));

        System.out.println("\n\n");

        System.out.println("Task 6: ");
        System.out.println("Sum of lowest and biggest values: "+ task6(arr));

        System.out.println("\n\n");

        System.out.println("Task 7: ");
        System.out.println("Difference of first and last values: "+ task7(arr));

        System.out.println("\n\n");

        System.out.println("Task 8: ");
        ArrayList<Float> result = new ArrayList<>();
        result = task8(arr);
        System.out.println("Values lowest then avarage: ");
        for(float x:result){
            System.out.print(x+" ");
        }
    }
}
