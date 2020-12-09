/*
Чича Олександр

5)Задано натуральне число n  та файл F,  компоненти якого є ці-
лими  числами.  Побудувати  файл  G,  записавши  до  нього  найбільше
значення перших n компонент файла F, потім – наступних n компонент
тощо. Розглянути два випадки:
а) кількість компонент файла ділиться на n;
б) кількість компонент файла не ділиться на n. Остання компонента
файла  g має  дорівнювати  найбільшій  із  компонент файла F,  які  утво-
рюють останню (неповну) групу.
 */

package DZ9_Task_5;

import java.io.*;
import java.util.ArrayList;

public class Task_5 {
    static ArrayList<Integer> readData() throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("./src/DZ9_Task_5/F.txt"));
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

        int n = 10;
        int maxVal;

        DataOutputStream out = new DataOutputStream(new FileOutputStream("./src/Homework9/G.txt"));

        if (data.size() % n == 0){
            for (int i = 0; i < data.size()-n; i +=n ) {
                maxVal = Integer.MIN_VALUE;
                for (int j = 0; j < i + n; j++ ){
                    if (data.get(j) > maxVal){
                        maxVal = data.get(j);
                    }
                }
                out.writeInt(maxVal);
            }
        }
        else {
            int p = data.size()-n-(data.size()%n);
            for (int i = 0; i < p; i +=n ) {
                maxVal = Integer.MIN_VALUE;
                for (int j = 0; j < i + n; j++ ){
                    if (data.get(j) > maxVal){
                        maxVal = data.get(j);
                    }
                }
                out.writeInt(maxVal);
            }
            maxVal = Integer.MIN_VALUE;
            for (int i = p + 1; i < data.size(); i++ ) {
                if (data.get(i) > maxVal) {
                    maxVal = data.get(i);
                }
            }
            out.writeInt(maxVal);
            }

        out.close();
    }

}
