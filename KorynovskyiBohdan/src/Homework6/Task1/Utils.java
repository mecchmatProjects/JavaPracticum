package Homework6.Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<Sweet> readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);

        ArrayList<Sweet> sweets = new ArrayList<>();

        String line = reader.readLine();
        while (line != null){
            String[] args = line.split(" ");
            String name = args[0];
            int weight = Integer.parseInt(args[1]);
            double sugar = Double.parseDouble(args[2]);

            Sweet sweet = new Sweet(name, weight, sugar);
            sweets.add(sweet);

            line = reader.readLine();
        }

        fileReader.close();
        reader.close();

        return sweets;
    }
}
