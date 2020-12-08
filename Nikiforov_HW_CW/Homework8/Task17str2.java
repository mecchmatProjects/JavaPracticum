package Homework8;

import java.util.ArrayList;
import java.util.Collections;

public class Task17str2 {
    public static void main(String[] args) {
        String[] inp = ("George id75 380-99-71-89890 Lana id24 380-99-88-76765 Andrew id13 380997656564").split(" ");
        ArrayList <String> words = new ArrayList<>();
        for (int i =0;i<inp.length;i++){
            if (inp[i].matches("[a-zA-Z]+")){
                words.add(inp[i]);
            }
        }
        Collections.sort(words);
        System.out.println("Sorted words: ");
        for(String x: words){
            System.out.println(x);
        }

    }
}
