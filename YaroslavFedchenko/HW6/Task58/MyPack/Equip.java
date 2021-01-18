package MyPack;

public class Equip extends Wagon{
    public int n;
    public String []wagon_eq;
    public int []bag_eq;
    public int []tip_eq;
    public int []pas_eq;

    public Equip(){
        try {
            this.n = 9;
            this.wagon_eq = new String[n];
            this.bag_eq = new int[n];
            this.tip_eq = new int[n];
            this.pas_eq = new int[n];
            for (int i = 0; i < n; i++) {
                int j = i;
                wagon_eq[i] = wagon[j];
                bag_eq[i] = bag[j];
                tip_eq[i] = tip[j];
                pas_eq[i] = pas[j];
            }
        } catch(Exception e){}
    }


}
