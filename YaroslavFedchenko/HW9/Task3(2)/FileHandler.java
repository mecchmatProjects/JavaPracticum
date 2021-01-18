package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private File inputFile;
    private File outputFile;
    private int[] pairedNumbers;

    public FileHandler(String inputPath) {
        this.inputFile = new File(inputPath);
        this.outputFile = new File("res/Task3/G");
    }

    private void writeInFile() {
        try (FileWriter writer = new FileWriter(outputFile, false)) {
            StringBuilder builderToWrite = new StringBuilder();
            for (Integer number : pairedNumbers) {
                builderToWrite.append(number);
                builderToWrite.append(" ");
            }
            writer.append(new String(builderToWrite));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void pairedNumbers() throws FileNotFoundException {

        Scanner reader = new Scanner(inputFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            pairedNumbers = Arrays.stream(Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray())
                    .filter(x -> x % 2 == 0).toArray();
        }
        writeInFile();
    }

    public void multiplyNumbers() throws FileNotFoundException {
        Scanner reader = new Scanner(inputFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            pairedNumbers = Arrays.stream(Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray())
                    .filter(x -> x % 3 == 0 && x % 5 == 0).toArray();
        }
        writeInFile();
    }

    public void squareNumbers() throws FileNotFoundException {
        Scanner reader = new Scanner(inputFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            pairedNumbers = Arrays.stream(Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray())
                    .filter(x -> Math.sqrt((double) x) % 1 == 0).toArray();
        }
        writeInFile();
    }

    public void reverseNumbers() throws FileNotFoundException {
        Scanner reader = new Scanner(inputFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            pairedNumbers = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < pairedNumbers.length / 2; i++) {
                int temp = pairedNumbers[i];
                pairedNumbers[i] = pairedNumbers[pairedNumbers.length - 1 - i];
                pairedNumbers[pairedNumbers.length - 1 - i] = temp;
            }
        }
        writeInFile();
    }

    public void numbersWithoutRepetitions() throws FileNotFoundException {
        Scanner reader = new Scanner(inputFile);
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            pairedNumbers = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < pairedNumbers.length ; i++) {
                if (searchNumber(pairedNumbers[i]) ==1 ) {
                    stringBuilder.append(pairedNumbers[i]);
                    stringBuilder.append(" ");
                }
            }
        }
        try (FileWriter writer = new FileWriter(outputFile, false)) {

            writer.append(new String(stringBuilder));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int searchNumber(int number) {
        int counter= 0;
        for (int pairedNumber : pairedNumbers) {
            if (pairedNumber == number)
                counter++;
        }
        return counter;
    }

}
