package Classwork8;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1file {
    public static String RemoveSpaces(String str) {
        String clear = str.replaceAll("^(\\s)*", "");
        clear = clear.replaceAll("(\\s)*$", "");
        clear = clear.replaceAll("(\\s){2,}", " ");
        return clear;
    }

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/Classwork8/input.txt");
        Scanner scanner = new Scanner(fr);
        FileWriter fw = new FileWriter("src/Classwork8/output.txt");
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            fr.close();
            
            String cl_str = RemoveSpaces(str);
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(cl_str);
            ArrayList<String> words = new ArrayList<>();
            while (matcher.find()) {
                words.add(cl_str.substring(matcher.start(), matcher.end()));
            }
            int max_l = 0;
            String max_str = "";
            for (String i : words) {
                if (i.length() > max_l) {
                    max_l = i.length();
                    max_str = i;
                }
            }

            fw.write("The longest word is " + max_str + ", with " + max_l + " letters\n");
            fw.write("Words amount: " + words.size() + "\n");
            String noone_str = cl_str.replaceAll("\\s\\w\\s", " ");
            fw.write("Line for task3: " + noone_str + "\n\n");


            int line_length =  80; // str.length();
            fw.write("L=" +line_length + "\n");
            int words_lens = 0;
            int cnt = 0;
            for(String w: words){
                words_lens += w.length();
                cnt +=1;
            }
            fw.write("W=" +words_lens + "\n");

            int sp_interval = (line_length - words_lens)/(cnt-1);
            int mod = (line_length - words_lens)%(cnt-1);
            fw.write("k=" + sp_interval + "\n");

            String out = "";

            for(int i=0; i<cnt-1;++i){
                out += words.get(i);
                //if (w==words[cnt-1]) break;
                for(int j=0;j<sp_interval;++j){
                    out += " ";
                }
                if(mod>0){
                    out += " ";
                    mod--;
                }
            }

            fw.write(out + "\n\n");
        }

        fw.close();


    }
}
