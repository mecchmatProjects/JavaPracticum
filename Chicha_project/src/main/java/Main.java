import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Read from Exel file
        File file = new File("./src/main/resources/Students.xls");
        ArrayList<Group> groups = tableRead(file);

        ArrayList<String> toShow = new ArrayList<String>();

        toShow.add(getStringIndividualCell(groups.get(0), "Чича Олександр Сергійович"));
        toShow.add(getStringIndividualCell(groups.get(1), "Чича Олександр Сергійович"));

        toShow.add(getStringCellOfGroup(groups.get(1)));
        toShow.add(getStringCellOfGroup(groups.get(0)));

        toShow.add(getStringMediumCellsByTeacher(groups.get(0), "Бородін В.А."));
        toShow.add(getStringMediumCellsByTeacher(groups.get(1), "Ганюшкін О.Г."));
        System.out.print(groups.get(0).getTeachers());

        writeToFile("./src/main/resources/Answer.txt", toShow);
    }

    public static String getStringIndividualCell(Group group, String nameToCheck){
        double n = group.getMediumIndividualCell(nameToCheck);
        if (n != -1){
            return "Середня оцінка " + nameToCheck + ":" + n + "\n";
        }
        else {
            return "Студента " + nameToCheck + " немає в групі " + group.getName() + "\n";
        }
    }

    public static String getStringCellOfGroup(Group group){
        return "Середня оцінка группи " + group.name + " " + group.getMediumCellOfGroup() + "\n";
    }

    public static String getStringMediumCellsByTeacher(Group group, String nameToCheck){
        double n = group.getMediumCellsByTeacher(nameToCheck);
        if (n != -1){
            return "Середній бал групи " + group.getName() +
                    " у вчителя " + nameToCheck + " : " + group.getMediumCellsByTeacher(nameToCheck) + "\n";
        }
        else {
            return "В групі " + group.getName() + " не викладає вчитель з ім'ям " + nameToCheck + "\n";
        }
    }

    // Write data to file
    public static void writeToFile(String fileName, ArrayList<String> data){
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for (String line:data){
                writer.write(line);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    // Read from Exel file
    public static ArrayList<Group> tableRead(File file){
        return Utils.parse(file.getAbsolutePath());
    }


    //Read group from console
    public static Group consoleRead(){

        Scanner in = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = in.nextLine();

        ArrayList<String> students = new ArrayList<>();
        System.out.println("Input count of students: ");
        int n = in.nextInt();
        System.out.println("Input names of students: ");
        for (int i = 0; i < n; i++){
            students.add(in.nextLine());
        }


        ArrayList<String> teachers = new ArrayList<>();
        System.out.println("Input count of teachers: ");
        n = in.nextInt();
        System.out.println("Input names of teachers: ");
        for (int i = 0; i < n; i++){
            teachers.add(in.nextLine());
        }

        ArrayList<String> lessons = new ArrayList<>();
        System.out.println("Input names of students: ");
        for (int i = 0; i < n; i++){
            lessons.add(in.nextLine());
        }

        ArrayList<ArrayList<Double>> cells = new ArrayList<ArrayList<Double>>();
        for (String student : students){
            ArrayList<Double> scoresOfStudent = new ArrayList<Double>();
            for (String lesson: lessons){
                System.out.println("Input score of student " + student + " from lesson " + lesson + " :");
                scoresOfStudent.add(in.nextDouble());
            }
            cells.add(scoresOfStudent);
        }

        return new Group(name, teachers, students, lessons, cells);
    }
}
