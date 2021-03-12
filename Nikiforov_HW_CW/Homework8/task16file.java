package Homework8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class task16file {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/Homework8/input.txt");
        Scanner scanner = new Scanner(fr);
        FileWriter fw = new FileWriter("src/Homework8/output.txt");
        ArrayList<Cube> info = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split(" ");
            Cube newCube = new Cube(str);
            info.add(newCube);
        }
        fr.close();
        int sum_b=0, sum_g=0,sum_r=0,sum_y=0;
        int b=0, g=0,r=0,y=0;
        for(Cube x:info){
            if(x.getColor().equals("b")){
                sum_b+= x.getA()*x.getA()* x.getA();
                b++;
            }
            else if(x.getColor().equals("y")){
                sum_y+= x.getA()*x.getA()* x.getA();
                y++;
            }
            else if(x.getColor().equals("r")){
                sum_r+= x.getA()*x.getA()* x.getA();
                r++;
            }
            else if(x.getColor().equals("g")){
                sum_g+= x.getA()*x.getA()* x.getA();

            }
        }


        fw.write("Blues cubes amount is: " + b + ", with " + sum_b + " total volume\n");
        fw.write("Reds cubes amount is: " + r + ", with " + sum_r + " total volume\n");
        fw.write("Yellows cubes amount is: " + y + ", with " + sum_y + " total volume\n");
        fw.write("Greens cubes amount is: " + g + ", with " + sum_g + " total volume\n\n\n");

        int w3=0,m5=0;
        for(Cube x:info){
            if(x.getMat().equals("w")&&x.getA()==3){
                w3++;
            }

            else if(x.getMat().equals("m")&&x.getA()>=5){
                m5++;
            }
        }

        fw.write("Woods cubes with edge=3 amount is: " + w3 +"\n");
        fw.write("Metalic cubes with edge higher than 5 amount is: " + m5 +"\n");
        fw.close();
    }
}
