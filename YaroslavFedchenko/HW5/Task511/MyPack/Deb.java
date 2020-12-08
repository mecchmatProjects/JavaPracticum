package MyPack;

public class Deb extends Res{
    public int n;
    public String []res_eq;
    public int []price_eq;
    public int []risk_eq;
    public int []zab_eq;

    public Deb(){
            this.n = 9;
            this.res_eq = new String[n];
            this.price_eq = new int[n];
            this.risk_eq = new int[n];
            this.zab_eq = new int[n];
            for (int i = 0; i < n; i++) {
                res_eq[i] = res[i];
                price_eq[i] = price[i];
                risk_eq[i] = risk[i];
                zab_eq[i] = zab[i];
            }
    }


}
