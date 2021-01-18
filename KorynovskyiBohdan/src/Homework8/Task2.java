/*
   9) У  текстовому файлі F  записано  послідовність  цілих  чисел,  які
      розділяються  пропусками.  Визначити  процедуру  запису  до  текстовог
      файла g усіх додатних чисел із F.

 */

package Homework8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("./src/Homework8/F.txt");
        FileWriter writer = new FileWriter("./src/Homework8/g.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        ArrayList<Integer> positive = new ArrayList<>();

        String line = reader.readLine();
        while (line != null){
            for (String str: line.split(" ")) {
                int number = Integer.parseInt(str);
                if (number >= 0) {
                    positive.add(number);
                }
            }
            line = reader.readLine();
        }

        String out = "";
        for (Integer el: positive){
            out += String.format("%d ", el);
        }

        writer.write(out);
        writer.close();

        fileReader.close();
        reader.close();
    }
}
