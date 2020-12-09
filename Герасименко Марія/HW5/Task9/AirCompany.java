import java.util.ArrayList;
import java.util.List;

public class AirCompany {

    public static void main(String[] args) {
        Airplane[] a = new Airplane[3];
        a[0] = new Airplane("AN-26", 320, 480, 15, 2048);
        a[1] = new Airplane("Airbus A320", 320, 320, 45, 3026);
        a[2] = new Airplane("AN-26", 320, 640, 35, 4012);

        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i].getFuelConsumption();
        }
        int avg = sum / a.length;

        System.out.println("Average of Fuel Consumption: ");
        System.out.println(avg);
        for (int i = 0; i < a.length; i++){
            sum += a[i].getLoadCapacity();
        }
        avg = sum / a.length;
        System.out.println("Average of load Capacity: ");
        System.out.println(avg);



    }
}
class Airplane{

    private static String title;
    private int capacity;
    private int loadCapacity;
    private int rangeOfPlane;
    private int fuelConsumption;

    public Airplane(String title, int capacity, int loadCapacity, int rangeOfPlane, int fuelConsumption){
        this.title = title;
        this.capacity = capacity;
        this.loadCapacity = loadCapacity;
        this.rangeOfPlane = rangeOfPlane;
        this.fuelConsumption = fuelConsumption;
    }
    public String showInfo(){
        return "Airplane " + title + " Capacity " + capacity + " Load Capacity " + loadCapacity + " Range of Plane " + rangeOfPlane + " Fuel Consumption " + fuelConsumption;
    }

    public String findAvarageOfFuel(){
        return "Avarage of fuel" + fuelConsumption;
    }
    public int getFuelConsumption(){
        return  fuelConsumption;
    }
    public int getLoadCapacity(){
        return loadCapacity;
    }






}
