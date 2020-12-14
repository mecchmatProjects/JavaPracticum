import java.util.ArrayList;

public class Group {
    protected String name;
    protected ArrayList<String> teachers = new ArrayList<String>();
    protected ArrayList<String> lessonsNames = new ArrayList<String>();
    protected ArrayList<String> students = new ArrayList<String>();
    protected ArrayList<ArrayList<Double>> cells = new ArrayList<ArrayList<Double>>();

    Group(){};

    Group(String name, ArrayList<String> teachers, ArrayList<String> students,
          ArrayList<String> lessonsNames, ArrayList<ArrayList<Double>> cells){
        this.name = name;
        this.teachers = teachers;
        this.lessonsNames = lessonsNames;
        this.students = students;
        this.cells = cells;
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getTeachers(){
        return teachers;
    }

    public ArrayList<String> getStudents(){
        return students;
    }

    public ArrayList<String> getLessonsNames(){
        return lessonsNames;
    }

    public ArrayList<ArrayList<Double>> getCells(){
        return cells;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addTeacher(String teacher){
        teachers.add(teacher);
    }

    public void addLessonName(String lessonName){
        lessonsNames.add(lessonName);
    }

    public void addStudent(String student){
        students.add(student);
    }

    public void addCells(ArrayList<Double> cell){
        cells.add(cell);
    }

    private int getIndexOfStudent(String name){
        for (int i = 0;i < students.size();i++){
            if (students.get(i).equals(name)){
                return i;
            }
        }
        return -1;
    }

    private int getIndexOfTeacher(String name){
        for (int i = 0;i < teachers.size();i++){
            if (teachers.get(i).equals(name)){
                return i;
            }
        }
        return -1;
    }


    public void printStudents(){
        for (String student: students){
            System.out.println(student);
        }
    }

    public double getMediumIndividualCell(String name){
        int studentIndex = getIndexOfStudent(name);

        if (studentIndex == -1){
            return -1;
        }
        ArrayList<Double> cellsOfCurrStud = cells.get(studentIndex);
        double medium = 0;

        for (int i = 0; i<cellsOfCurrStud.size();i++){
            double currCell = cellsOfCurrStud.get(i);
            medium += currCell;
        }

        return medium/cellsOfCurrStud.size();
    }

    public double getMediumCellsByTeacher(String name){
        int teacherIndex = getIndexOfTeacher(name);

        if (teacherIndex == -1){
            return -1;
        }

        double medium = 0;
        for (ArrayList<Double> cell: cells){
            medium += cell.get(teacherIndex);
        }
        return medium/cells.size();
    }

    public double getMediumCellOfGroup(){
        double medium = 0;
        int count = 0;
        for (ArrayList<Double> cell: cells){
            for (double i : cell){
                medium += i;
                count += 1;
            }
        }
        return medium/count;
    }


    @Override
    public String toString() {
        String ans = name;

        for (String teacher : teachers){
            ans += "\t  " + teacher;
        }
        ans += "\n";

        for (int i = 0;i<students.size();i++){
            String raw = "";
            raw += students.get(i);
            for (double score : cells.get(i)){
                raw += "\t  " + score;
            }
            ans += raw += "\n";
        }
        return ans;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Group)) {
            return false;
        }
        Group group = (Group) obj;
        return group.name.equals(name) && group.teachers == teachers &&
                group.lessonsNames == lessonsNames && group.students == students &&
                group.cells == cells;
    }

}
