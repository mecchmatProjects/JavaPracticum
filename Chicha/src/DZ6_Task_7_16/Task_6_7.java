/*
Чича Олександр

16.interface Джерело Світу - class - Лампа - class - Настільна Лампа.
 */

package DZ6_Task_7_16;

public class Task_6_7 {
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

