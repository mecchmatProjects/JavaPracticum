/*
    3) Дано файл F,  компоненти  якого  є  цілими  числами. Побудувати
    файл G, який містив би всі компоненти файла F:
    а) що є парними числами;   б) що діляться на 3 і на 5;
    в) що є точними квадратами;        г) записані у зворотному порядку;
    ґ) за винятком повторних входжень одного й того самого числа.
 */

package Homework9;

import java.io.*;
import java.util.ArrayList;

public class Task1 {
    static boolean a(int el) {
        return el % 2 == 0;
    }

    static boolean b(int el) {
        return el % 3 == 0 & el % 5 == 0;
    }

    static boolean v(int el) {
        if (el < 0)
            return false;

        int tst = (int) (Math.sqrt(el) + 0.5);
        return tst * tst == el;
    }

    static ArrayList<Integer> readData() throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("./src/Homework9/F.txt"));
        ArrayList<Integer> lst = new ArrayList<>();
        try {
            while (true) {
                String[] infoArr = in.readLine().split(" ");
                for (String sbi : infoArr) {
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i++) {
                        a += Character.toString(sbiBytes[i]);
                    }

                    lst.add(Integer.parseInt(a));
                }

            }
        } catch (EOFException | NullPointerException ignored) {
            in.close();
        }

        return lst;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = readData();

        DataOutputStream out = new DataOutputStream(new FileOutputStream("./src/Homework9/G.txt"));

        for (int i = data.size() - 1; i >= 0; i--) {
            out.writeInt(data.get(i));
        }

        out.close();
    }

}
