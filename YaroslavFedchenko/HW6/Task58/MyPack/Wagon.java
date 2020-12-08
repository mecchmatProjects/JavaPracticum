package MyPack;

public class Wagon{
    public int m = 0;
    public String[] wagon;
    public int[] bag;
    public int[] tip;
    public int [] pas;

    public Wagon() {
        try {
            this.m = 9;
            this.wagon = new String[]{"Вагон 1", "Вагон 2", "Вагон 3", "Вагон 4", "Вагон 5", "Вагон 6", "Вагон 7", "Вагон 8", "Вагон 9"};
            this.pas = new int []{72, 28, 17, 53, 46, 55, 90, 43, 35};
            this.bag = new int[]{95, 175, 120, 345, 350, 120, 74, 230, 540};
            this.tip = new int[]{1, 2, 3, 1, 3, 1, 2, 3, 2};
        } catch(Exception e){}
    }
}
