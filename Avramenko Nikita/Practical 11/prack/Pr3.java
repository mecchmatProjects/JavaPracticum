package prack;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Pr3 {
    public static void main(String[] args){
        HashMap<Integer, String> Hash = new HashMap<>();
        try{
            DataInputStream file = new DataInputStream(new FileInputStream("file_task2"));
            int i=0;
            while (file.available() > 0) {
                Hash.put(i++, file.readLine().trim());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Hash);
    }
}
