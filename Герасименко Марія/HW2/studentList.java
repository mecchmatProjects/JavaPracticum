import java.io.*;
import java.util.Scanner;

public class studentList {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter student's name: ");
        String text = in.next();
        System.out.println("Enter time: ");
        String time = in.next();
        System.out.println("Enter number of student: ");
        int numOfStudent = in.nextInt();

        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>This is a Heading</h1>\n" +
                "<p>" + "Student: " + text +  "</p>\n" +
                "\n" +
                "<p>" + "Time: " + time +  "</p>\n" +
                "\n" +
                "<p>" + "Number of Student: " + numOfStudent +  "</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        File f = new File("test.html");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(html);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}