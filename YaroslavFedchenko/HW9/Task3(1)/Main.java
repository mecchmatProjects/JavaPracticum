package Task31;

import java.io.*;
// task 3 Визначити процедуру виведення:
//а) усіх рядків текстового файла;
//б) рядків, які містять більше 60 символів.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File("res/Task3(1)/text.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        String name;
        String line;
        System.out.println("Print File "+f.getName()+"? y/n");
        name = br.readLine();
        if(name.equals("y")) {
            while ((line = fin.readLine()) != null){
                if (line.length() >= 60) {
                    System.out.println(line);
                }
            }
        }
    }
}