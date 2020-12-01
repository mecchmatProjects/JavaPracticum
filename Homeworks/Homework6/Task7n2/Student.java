package Task7n2;

abstract class Student implements Abiturient {
    @Override
    public void make_homework(){
        System.out.println("Student is making homework");
    }

    @Override
    public void studying(){
        System.out.println("Student studies hard");
    }

    @Override
    public void eat(){
        System.out.println("Student is eating");
    }

    @Override
    public void sleep(){
        System.out.println("Student is sleeping");
    }

    @Override
    public void passes_exams(){
        System.out.println("Student takes the exams");
    }
}
