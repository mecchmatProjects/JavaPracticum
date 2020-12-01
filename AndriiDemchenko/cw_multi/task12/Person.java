package multithreadingTasks.task12;

public abstract class Person extends Thread{
    protected int time;

    Person(int time){
        this.time = time;
    }
}
