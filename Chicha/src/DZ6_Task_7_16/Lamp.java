package DZ6_Task_7_16;

public class Lamp implements LightSource {
    protected boolean ON = false;
    protected boolean OFF = true;

    @Override
    public void switchOn() {
        if (!ON) {
            ON = true;
            OFF = false;
            System.out.println("You switch on your lamp");
        } else {
            System.out.println("Your Lamp is already switch on");
        }
    }

    @Override
    public void switchOff() {
        if (!OFF) {
            OFF = true;
            ON = false;
            System.out.println("You switch off your lamp");
        } else {
            System.out.println("Your Lamp is already switch off");
        }
    }

    @Override
    public void isSwitchOff() {
        if (OFF) {
            System.out.println("Your lamp is OFF");
        } else {
            System.out.println("Your lamp is not OFF");
        }
    }

    @Override
    public void isSwitchOn() {
        if (ON) {
            System.out.println("Your lamp is ON");
        } else {
            System.out.println("Your lamp is not ON");
        }
    }
}
