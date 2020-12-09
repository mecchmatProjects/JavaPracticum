import java.io.*;

public class readNwriteFile {

    public static void main(String[] args) throws IOException {
        int[] intArray = {2,4,6,8,10};
        int[] intArray2 = {1,3,5,7,9,15};

        String text = "G.txt";
        String text2 = "H.text";
        writeToTxt(intArray, text);
        writeToTxt(intArray2, text2);
        ReadFile(text);
    }
    public static void writeToTxt (int [] array, String filePathName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePathName)));
        for (int i = 0; i < array.length; i++) {
                writer.write(String.valueOf(array[i]));
                writer.write(" ");
            writer.write("\r\n");
        }
        writer.flush();
    }
    public static void ReadFile(String path) {

        try(FileInputStream fin=new FileInputStream(path))
        {
            System.out.printf("File size: %d bytes \n", fin.available());

            int i=-1;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
