package Task7n2;

public class PartTimeStudent extends Student {
    protected String name;
    protected String surname;
    protected String facultet;
    protected int kurs;
    protected int age;
    PartTimeStudent(String name, String surname, String facultet, int kurs, int age){
        this.name=name;
        this.surname=surname;
        this.facultet = facultet;
        this.kurs=kurs;
        this.age=age;
    }

    @Override
    public void make_homework(){
        System.out.println("\n" + "Part-time student is making homework");
    }

    @Override
    public void studying(){
        System.out.println("Part-time student studies hard");
    }

    @Override
    public void eat(){
        System.out.println("Part-time student is eating");
    }

    @Override
    public void sleep(){
        System.out.println("Part-time student is sleeping");
    }

    @Override
    public void passes_exams(){
        System.out.println("Part-time student takes the exams");
    }

}
