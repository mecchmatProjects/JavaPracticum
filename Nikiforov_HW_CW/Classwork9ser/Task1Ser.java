package Classwork9ser;

import java.io.*;
import java.util.ArrayList;

public class Task1Ser {
    static ArrayList<luggage> readlug(String lbfile) throws IOException {
        DataInputStream ds = new DataInputStream(new FileInputStream(lbfile));
        ArrayList<luggage> lug = new ArrayList<>();
        try{
            while (true) {
                ArrayList<Integer> tmp = new ArrayList<>();
                String[] reader = ds.readLine().split(" ");
                for (String sbi: reader){
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i+=2){
                        a += Character.toString(sbiBytes[i]);
                    }
                    if (a.isEmpty()) continue;
                    tmp.add(Integer.parseInt(a));
                }
                if (!tmp.isEmpty()){
                    luggage obj = new luggage(tmp.get(0), tmp.get(1),tmp.get(2));
                    lug.add(obj);
                }

            }
        }  catch (EOFException | NullPointerException ignored) { ds.close(); }
        return lug;
    }


    static ArrayList<Passenger> readpass(String pbfile) throws IOException {
        DataInputStream ds = new DataInputStream(new FileInputStream(pbfile));
        ArrayList<Passenger> pass = new ArrayList<>();
        try {
            boolean checker = true;
            while (true) {
                String[] reader = ds.readLine().split(" ");
                String tmpstr="";
                int inttmp=0;
                for (String sbi: reader) {
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i += 2) {
                        a += Character.toString(sbiBytes[i]);
                    }
                    if (a.isEmpty()){continue;}
                    if(checker){
                        checker=false;
                        tmpstr=a;
                    }
                    else{
                        checker=true;
                        inttmp = (Integer.parseInt(a));
                    }
                }
                if(inttmp!=0&&!tmpstr.equals("")) {
                    Passenger pass_tmp = new Passenger(tmpstr, inttmp);
                    pass.add(pass_tmp);
                }
            }
        }catch (NullPointerException ignored) { ds.close(); }
        return pass;
    }

    static void task1(ArrayList<Passenger> pass,ArrayList<luggage> lug, String task_1){
        System.out.println("Task1: ");
        int sum_weight = 0;
        int sum_amount = 0;
        for(luggage x: lug){
            sum_amount+=x.getAmount();
            sum_weight+=x.getWeight();
        }
        float avarage_sum = (float)(sum_weight/sum_amount);
        ArrayList<Integer> passed_id = new ArrayList<>();
        for(luggage x: lug){
            float tmp_sum = (float)(x.getWeight()/x.getAmount());
            if(Math.abs(tmp_sum-avarage_sum)<=1){
                passed_id.add(x.getId());
            }
        }
        ArrayList<Passenger> result = new ArrayList<>();
        for(Passenger x: pass){
            for(Integer y: passed_id){
                if(x.getId()==y){
                    System.out.println(x+" passed under rules!");
                    result.add(x);
                }
            }
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(task_1))) {
            for(Passenger x:result) {
                oos.writeObject(x);
            }
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }

    }


    static void task2(ArrayList<Passenger> pass,ArrayList<luggage> lug, String task_2){
        System.out.println("Task 2: ");
        int sum_amount = 0;
        int size=0;
        for(luggage x: lug){
            sum_amount+=x.getAmount();
            size+=1;
        }

        float avarage_amount = (float)(sum_amount/size);
        ArrayList<Integer> about_avarage = new ArrayList<>();
        ArrayList<Integer> about_two = new ArrayList<>();

        for(luggage x:lug){
            if(x.getAmount()>2){
                about_two.add(x.getId());
            }
            if(x.getAmount()>avarage_amount){
                about_avarage.add(x.getId());
            }
        }
        ArrayList<Passenger> result1 = new ArrayList<>();
        ArrayList<Passenger> result2 = new ArrayList<>();
        for(Passenger x: pass){
            for(Integer y: about_avarage){
                if(x.getId()==y){
                    System.out.println(x+" have more clothes then avarage!");
                    result1.add(x);
                }
            }
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(task_2))) {
            for(Passenger x:result1) {
                oos.writeObject(x);
            }
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }



        for(Passenger x: pass){
            for(Integer y: about_two){
                if(x.getId()==y){
                    System.out.println(x+" have more clothes then two!");
                    result2.add(x);
                }
            }
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(task_2))) {
            for(Passenger x:result2) {
                oos.writeObject(x);
            }
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }


    }


    public static void main(String[] args) throws IOException {
       String lbfile = "src/Classwork9ser/blug.dat";
       String pbfile = "src/Classwork9ser/bpass.dat";
       ArrayList<luggage> lug = new ArrayList<>();
       lug = readlug(lbfile);
       ArrayList<Passenger> pass = new ArrayList<>();
       pass = readpass(pbfile);
       String task_1= "src/Classwork9ser/task1.dat";
       task1(pass,lug,task_1);
       System.out.println("\n\n");
       String task_2= "src/Classwork9ser/task2.dat";
       task2(pass,lug,task_2);
    }
}
