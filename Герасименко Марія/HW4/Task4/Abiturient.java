import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Abiturient {
    private String name, surname, middle_name;
    private int id;
    private long number;
    private int marks;

    public Abiturient(String name,  String middle_name, String surname, int id, long number, int marks){
        this.name = name;
        this.id = id;
        this.number = number;
        this.marks = marks;
        this.surname = surname;
        this.middle_name = middle_name;
    }
    public int getMark(){
        return marks;
    }

    public String getName(){
        return name + middle_name + surname +  marks;
    }

    static void getMaxMarks(Abiturient[] name){
        List<Abiturient> temp = new ArrayList<Abiturient>();
        for (int i = 0; i < name.length; i++){
            if (name[i].getMark() >= 60){
                temp.add(name[i]);
                System.out.println(name[i].getName());
            }
        }
    }



    static void getBadMarks(Abiturient[] name){
        List<Abiturient> temp = new ArrayList<Abiturient>();
        for (int i = 0; i < name.length; i++){
            if (name[i].getMark() <= 60){
                temp.add(name[i]);
                System.out.println(name[i].getName());
            }
        }


        //System.out.println("Student: " + name + " have marks: " + marks + ".");
    }

    void getPassingScore(){
        ;
    }

    public static void main(String[] args) {
        Abiturient [] a = new Abiturient[4];
        a[0] = new Abiturient("Amid ", "Olofovich ", "Ingvar ", 18, 880055666, 45);
        a[1] = new Abiturient("Alex ", "Olofovich ", "Ingvar ", 666, 290055366, 25);
        a[2] = new Abiturient("Evan ", "Ananasovich ", "Gustav ", 69, 120035656, 90);
        a[3] = new Abiturient("Bogdan ", "Zukerbegoff ", "Untitled ", 48, 450057646, 34);

        System.out.println("Students with bad marks.");
        Abiturient.getBadMarks(a);
        System.out.println("");
        System.out.println("Students with affordable marks.");
        Abiturient.getMaxMarks(a);
    }
}
