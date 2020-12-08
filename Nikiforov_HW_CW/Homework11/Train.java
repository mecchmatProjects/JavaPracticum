package Homework11;

public class Train extends Thread{
    int time;
    int id;
    int tunId;
    static int num = 1;

    Train(int time, int tunId){
        this.time=time;
        this.id = num++;
        this.tunId = tunId;
    }

    @Override
    public void run() {
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Train " + id + " passed " + tunId + " tunnel");
    }
}
