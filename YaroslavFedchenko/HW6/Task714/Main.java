package HW6.Task714;
// task 7.14(interface) Fedchenko Yaroslav interface Пристрій Печатки  - class - Принтер  - class - Лазерний Принтер
interface PrintDevice {

    String getModel();

}

class Printer implements PrintDevice {
    @Override
    public String getModel() {
        return "HP123";
    }

}

class LaserPrinter extends Printer {
    @Override
    public String getModel() {
        return "Sony123";
    }
}

class Main {

    public static void main(String[] args) {
        LaserPrinter laserPrinter = new LaserPrinter();

        PrintDevice PrintDevice = laserPrinter;
        System.out.println("PrintDevice.getModel(): " + PrintDevice.getModel());

        System.out.println();

        Printer printer = laserPrinter;
        System.out.println("Printer.getModel(): " + printer.getModel());
    }
}
