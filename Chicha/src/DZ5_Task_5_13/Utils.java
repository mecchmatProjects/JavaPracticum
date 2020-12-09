package DZ5_Task_5_13;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;

public class Utils {
    public static ArrayList<Product> readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);

        ArrayList<Product> products = new ArrayList<>();

        String name;
        String sortOfCoffee;
        String mill;
        double price;
        double weight;
        double volumeOfPackage;

        String line = reader.readLine();
        while (line != null) {
            String[] args = line.split(" ");

            name = args[0];
            sortOfCoffee = args[1];
            mill = args[2];
            price = Double.parseDouble(args[3]);
            weight = Double.parseDouble(args[4]);
            volumeOfPackage = Double.parseDouble(args[5]);

            Product product = new Product(name, sortOfCoffee, mill, price, weight, volumeOfPackage);
            products.add(product);

            line = reader.readLine();
        }
        reader.close();
        return products;
    }

    public static void sortByPriceByKilo(ArrayList<Product> array){
        int size = array.size();
        int i, j, highestValueIndex;
        for (i = 0; i < size; i++){
            highestValueIndex = i;
            for (j = i + 1; j < size; j++){
                if (array.get(j).price/array.get(j).weight >
                        array.get(highestValueIndex).price/array.get(highestValueIndex).weight){
                    highestValueIndex = j;
                }
            }

            Collections.swap(array, i, highestValueIndex);
        }
    }
}