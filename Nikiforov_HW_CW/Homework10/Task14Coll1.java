package Homework10;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task14Coll1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/Homework10/input.txt");
        Scanner scanner = new Scanner(fr);
        ArrayList<String> str = new ArrayList<>();
        while (scanner.hasNext()) {
            str.add(scanner.nextLine());
        }
        fr.close();
        Collections.sort(str);
        for(String x: str){
            System.out.println(x);
        }
    }
}
