package Homework9ser;

import java.io.*;
import java.util.ArrayList;


public class Task4Ser {
    static Polynom readfile(String inp_file) throws IOException {
        DataInputStream ds = new DataInputStream(new FileInputStream(inp_file));

        ArrayList<Float> coeffs = new ArrayList<>();
        ArrayList<Integer> powers = new ArrayList<>();

        try{
            while (true) {
                boolean checker=true;
                String[] reader = ds.readLine().split(" ");
                for (String s: reader){
                    byte[] sBytes = s.trim().getBytes();
                    String a = "";

                    for (int i = 0; i < sBytes.length; i+=2){
                        a += Character.toString(sBytes[i]);
                    }

                    if (a.isEmpty()) continue;

                    if (checker) coeffs.add(Float.parseFloat(a));
                    else powers.add(Integer.parseInt(a));

                    checker = !checker;
                }
            }
        }  catch (EOFException | NullPointerException ignored) { ds.close(); }

        Polynom new_poly = new Polynom(coeffs, powers);
        return new_poly;
    }



    public static void main(String[] args) throws IOException {
        String inp_file = "src/Homework9ser/bin_input.dat";
        String result = "src/Homework9ser/bin_result.dat";
        Polynom poly = readfile(inp_file);

        System.out.println("Initial polynom: " + poly+"\n");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
           oos.writeObject(poly);
           System.out.println("Serialized!");
       } catch(Exception ex){
            System.out.println("Something go wrong!");
        }

        Polynom der_poly = poly.derivative();
        System.out.println("Derivative polynom: " + der_poly+"\n");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
            oos.writeObject(der_poly);
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }

        Polynom int_poly = poly.Integral();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
            oos.writeObject(int_poly);
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }
        System.out.println("Integral of polynom: " + int_poly+"\n");


        String inp_file2 = "src/Homework9ser/bin_input2.dat";
        Polynom poly2 = readfile(inp_file2);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
            oos.writeObject(poly2);
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }
        System.out.println("Second initial polynom: " + poly2+"\n");

        poly2.simplifyPoly();
        System.out.println(poly2);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
            oos.writeObject(poly2);
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }

        System.out.println("Value of polynom when x=2: "+ poly.PolynomValue(2)+"\n");

        System.out.println("Max pow of polynom: "+poly.MaxPow()+"\n");

        Polynom sum=poly.add(poly2);
        System.out.println("Polynomials addition: " + sum);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
            oos.writeObject(sum);
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }

        Polynom subtract=poly.subtract(poly2);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
            oos.writeObject(subtract);
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }
        System.out.println("Polynomial subtraction: " + subtract);

        Polynom multiply = poly.multiplication(poly2);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(result))) {
            oos.writeObject(subtract);
            System.out.println("Serialized!");
        } catch(Exception ex){
            System.out.println("Something go wrong!");
        }
        System.out.println("Polynomial multiplication: " + multiply);

    }
}
