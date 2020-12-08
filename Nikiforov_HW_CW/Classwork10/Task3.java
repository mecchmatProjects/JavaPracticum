package Classwork10;


import java.io.*;
import java.util.HashMap;

public class Task3 {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> dict = new HashMap<>();
        int key = 0;
        DataInputStream dis = new DataInputStream(new FileInputStream("src/Classwork10/bfile.dat"));
        try {
            while (true) {
                String[] infoArr = dis.readLine().split(" ");
                int value = 0;
                for (String sbi : infoArr) {
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i += 2) {
                        a += Character.toString(sbiBytes[i]);
                    }

                    if (a.isEmpty()) continue;
                    value = Integer.parseInt(a);
                    dict.put(key,value);
                    key+=1;
                }
            }

        } catch (EOFException | NullPointerException ignored) {
            dis.close();
        }

        System.out.println(dict.get(5));
        System.out.println(dict.get(3));
        System.out.println(dict.get(2));
    }
}
