package task_4_10;

public abstract class Animal {
    protected int age;
    protected String color;

    abstract void Run();

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }
}
