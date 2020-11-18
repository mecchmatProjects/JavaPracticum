package prack;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.*;

public class Pr1 {
    public static double[] toDoubleArray(byte[] byteArray){
        int times = Double.SIZE / Byte.SIZE;
        double[] doubles = new double[byteArray.length / times];
        for(int i=0;i<doubles.length;i++){
            doubles[i] = ByteBuffer.wrap(byteArray, i*times, times).getDouble();
        }
        return doubles;
    }

    public static void writeToBinary(String filename, double[] doubles) throws IOException {
        try(OutputStream outputStream = new FileOutputStream(filename);)
        {
            ByteBuffer bb = ByteBuffer.allocate(doubles.length*8);
            for(double d : doubles) {
                bb.putDouble(d);
            }
            byte[] bytearray = bb.array();
            outputStream.write(bytearray);
        } catch (IOException ex) {
        ex.printStackTrace();
        }
    }

    public static byte[] readFromBinary(String filename) throws IOException {
        byte[] allBytes = Files.readAllBytes(Paths.get(filename));
        return allBytes;
    }

    static double A(double[] doubles){
        double sum = 0;
        for (double d: doubles) {
            sum += d;
        }
        return sum;
    }

    static double B(double[] doubles){
        double sum = 0;
        for (double d: doubles) {
            if (d<0)
                sum += 1;
        }
        return sum;
    }

    static double C(double[] doubles){
        return doubles[doubles.length-1];
    }

    static double D(double[] doubles){
        double max = Double.MIN_VALUE;
        for (double d: doubles) {
            if (d>max)
                max = d;
        }
        return max;
    }

    static double E(double[] doubles){
        double min = Double.MAX_VALUE;
        int i=0;
        for (double d: doubles) {
            if (d<min && (i%2)==0)
                min = d;
        }
        return min;
    }

    static double F(double[] doubles){
        double min = Double.MAX_VALUE;
        for (double d: doubles) {
            if (d<min)
                min = d;
        }
        return D(doubles) + min;
    }

    static double G(double[] doubles){
        return doubles[0] - doubles[doubles.length-1];
    }

    static double H(double[] doubles){
        double mean = A(doubles)/ doubles.length;
        double num = 0;
        for (double d: doubles) {
            if (d<mean)
                num ++;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "file1";
        String outputFile = "file2";

        double[] num = {1.1f,2.5f,-2.7f,9.9f,0.01f};
        writeToBinary(inputFile, num);
        double[] doubles = toDoubleArray(readFromBinary(inputFile));
        for (double d :
                doubles) {
            System.out.println(d);
        }
        System.out.println();
        writeToBinary(outputFile, new double[]{A(doubles), B(doubles), C(doubles), D(doubles),
                E(doubles), F(doubles), G(doubles), H(doubles)});
        for (double d :
                toDoubleArray(readFromBinary(outputFile))) {
            System.out.println(d);
        }

    }
}
