package Classwork10;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/Classwork10/input.txt");
        Scanner scanner = new Scanner(fr);
        Stack<String> stack = new Stack<>();
        while (scanner.hasNext()) {
            stack.push(scanner.nextLine());
        }
        fr.close();
        FileWriter fw = new FileWriter("src/Classwork10/output.txt");
        for (int i = stack.size() - 1; i >= 0; i--) {
            fw.write(stack.pop()+"\n");
        }
        fw.close();
    }
}


