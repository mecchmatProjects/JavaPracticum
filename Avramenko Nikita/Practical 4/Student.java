import java.util.Scanner;

public class Student {
    private int id;
    private String first;
    private String last;
    private String adress;
    private long phone;
    private String faculty;
    private int curs;
    private String group;

    public Student(){
        this.id = 0;
        this.first = "first";
        this.last = "last";
        this.adress = "adress";
        this.phone = 1111111111;
        this.faculty = "faculty";
        this.curs = 1;
        this.group = "group";
    }

    public Student(int id, String first, String last, String adress,
                   long phone, String faculty, int curs, String group) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.adress = adress;
        this.phone = phone;
        this.faculty = faculty;
        this.curs = curs;
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCurs(int curs) {
        this.curs = curs;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getAdress() {
        return adress;
    }

    public long getPhone() {
        return phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCurs() {
        return curs;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first='" + first +
                ", last='" + last +
                ", adress='" + adress +
                ", phone=" + phone +
                ", faculty='" + faculty +
                ", curs='" + curs +
                ", group='" + group +
                '}';
    }

    public void inputConsole(Scanner in){
        System.out.print("----------Input Student----------\nid: ");
        this.id = in.nextInt();
        System.out.print("first: ");
        this.first = in.next();
        System.out.print("last: ");
        this.last = in.next();
        System.out.print("adress: ");
        this.adress = in.nextLine();
        System.out.print("phone: ");
        this.phone = in.nextLong();
        System.out.print("faculty: ");
        this.faculty = in.next();
        System.out.print("curse: ");
        this.curs = in.nextInt();
        System.out.print("group: ");
        this.group = in.next();
    }

    public void checkFaculty(String faculty){
        if (faculty.equals(getFaculty()))
            System.out.println(toString());
    }

    public void checkFacultyAndCurse(String faculty, int curs){
        if (faculty.equals(getFaculty()) && curs == getCurs())
            System.out.println(toString());
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть кількість студентів: ");
        int n = in.nextInt();
        int num;
        String op, str;
        Student[] students = new Student[n];
        for (int i=0;i< students.length;i++){
            students[i] = new Student();
            students[i].inputConsole(in);
        }
        System.out.print("\nДоступні операції:\n" +
                "1 - вивести список студентів певного факультету\n" +
                "2 - вивести список студентів певного факультету та курсу\n" +
                "exit - вихід\n\n");
        label:
        while (true){
            System.out.print("Введіть номер операції: ");
            op = in.next();
            switch (op) {
                case "1":
                    System.out.print("Введіть факультет: ");
                    str = in.next();
                    for (Student student :
                            students) {
                        student.checkFaculty(str);
                    }
                    break;
                case "2":
                    System.out.print("Введіть факультет: ");
                    str = in.next();
                    System.out.print("Введіть курс: ");
                    num = in.nextInt();
                    for (Student student :
                            students) {
                        student.checkFacultyAndCurse(str, num);
                    }
                    break;
                case "exit":
                    break label;
            }
        }
    }

}
