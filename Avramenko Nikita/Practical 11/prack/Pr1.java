package prack;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Pr1 {
    public static void main(String[] args){
        LinkedList<String> stack = new LinkedList<>();
        try {
            FileReader file = new FileReader("C:\\UnivEdu\\kurs_3\\Java\\Practical 11\\src\\prack\\filename.txt");
            Scanner myReader = new Scanner(file);
            System.out.println(myReader.hasNext());
            while (myReader.hasNext()) {
                stack.push(myReader.nextLine());
            }
            FileWriter writer = new FileWriter("C:\\UnivEdu\\kurs_3\\Java\\Practical 11\\src\\prack\\filename.txt");
            while (!stack.isEmpty()) {
                writer.write(stack.pop()+'\n');
            }
            file.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
