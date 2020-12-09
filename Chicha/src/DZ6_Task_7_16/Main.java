package DZ6_Task_7_16;

public class Main {
    public static void main(String[] args){
        Lamp lamp = new Lamp();
        TableLamp tableLamp = new TableLamp();

        lamp.switchOff();
        lamp.isSwitchOff();
        lamp.isSwitchOn();
        lamp.switchOn();

        System.out.println();
        tableLamp.switchOff();
        tableLamp.isSwitchOff();
        tableLamp.isSwitchOn();
        tableLamp.switchOn();
    }
}

