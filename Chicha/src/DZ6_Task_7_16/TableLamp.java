package DZ6_Task_7_16;

public class TableLamp extends Lamp {
    @Override
    public void switchOn() {
        if (!ON) {
            ON = true;
            OFF = false;
            System.out.println("You switch on your table lamp");
        } else {
            System.out.println("Your tableLamp is already switch on");
        }
    }

    @Override
    public void switchOff() {
        if (!OFF) {
            OFF = true;
            ON = false;
            System.out.println("You switch off your table lamp");
        } else {
            System.out.println("Your tableLamp is already switch off");
        }
    }

    @Override
    public void isSwitchOff() {
        if (OFF) {
            System.out.println("Your table lamp is OFF");
        } else {
            System.out.println("Your table lamp is not OFF");
        }
    }

    @Override
    public void isSwitchOn() {
        if (ON) {
            System.out.println("Your table lamp is ON");
        } else {
            System.out.println("Your table lamp is not ON");
        }
    }

}
