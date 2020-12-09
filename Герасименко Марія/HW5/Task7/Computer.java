import java.util.Scanner;

public class Computer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean turnOn = true;


        hardDrive h = new hardDrive("SATA", 24, 666, 228, 322);
        CPU c = new CPU(5,2,7,2, 3, "Socket 8");
        floppyDrive f = new floppyDrive(" DIMM ", " ", 2048, 32);
        RAM r = new RAM(" SATA ", " ", 128, 512, 654);
        System.out.println("Character of this Computer:");
        System.out.println("Hard Drive info: ");
        System.out.println(h.getInfo());
        System.out.println("CPU info: ");
        System.out.println(c.getInfo());
        System.out.println("Floopy Drive info: ");
        System.out.println(f.getInfo());
        System.out.println("RAM info: ");
        System.out.println(r.getInfo());

        while (turnOn){
            System.out.println("Turn off computer ?");
            String s = in.next();
            if (s == "yes"){
                break;
            }
            break;
        }

    }

    static class hardDrive {
        private String Interface; // Интерфейс
        private int volume; // Объем
        private int spindleSpeed; // скорость вращения шпинделя
        private int baudRate; // Скорость передачи данных
        private int bufferSize;
        public hardDrive(String Interface, int volume, int spindleSpeed, int baudRate, int bufferSize){
            this.Interface = Interface;
            this.volume = volume;
            this.spindleSpeed = spindleSpeed;
            this.baudRate = baudRate;
            this.bufferSize = bufferSize;
        }
        private String getInfo(){
            return Interface + " " + volume + " " + spindleSpeed + " " + baudRate + " " + bufferSize;
        }
    }

    static class floppyDrive{
        private String typeOfDrive;
        private String Interface;
        private int maximumReadingSpeed;
        private int BufferSize;
        public floppyDrive(String typeOfDrive, String Interface, int maximumReadingSpeed, int BufferSize){
            this.typeOfDrive = typeOfDrive;
            this.Interface = Interface;
            this.maximumReadingSpeed = maximumReadingSpeed;
            this.BufferSize = BufferSize;
        }
        private String getInfo(){
            return typeOfDrive + " " + Interface + " " + maximumReadingSpeed + " " + BufferSize;
        }
    }

    static class RAM{
        private String typeMemory;
        private String formFactor;
        private int modSize;
        private int clockFrequency;
        private int timing;
        public RAM(String typeMemory, String formFactor, int modSize, int clockFrequency, int timing){
            this.typeMemory = typeMemory;
            this.formFactor = formFactor;
            this.modSize = modSize;
            this.clockFrequency = clockFrequency;
            this.timing = timing;
        }
        private String getInfo(){
            return typeMemory + " " + formFactor + " " + modSize + " " + clockFrequency + " " + timing;
        }
    }
    static class CPU {
        private int clockfrequency;
        private int factor;
        private int bitDepth; // Разрядность
        private int cacheMemory; // Кэш-память
        private int core; // кол-во ядер
        private String typeSocket;
        public CPU(int clockfrequency, int factor, int bitDepth,  int cacheMemory, int core, String typeSocket){
            this.clockfrequency = clockfrequency;
            this.factor = factor;
            this.bitDepth = bitDepth;
            this.cacheMemory = cacheMemory;
            this.core = core;
            this.typeSocket = typeSocket;
        }
        private String getInfo(){
            return clockfrequency + " " + factor + " " + bitDepth + " " + cacheMemory + " " + core+ " " + typeSocket;
        }
    }

}




