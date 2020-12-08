package MyPack;

public class Res{
    public int m = 0;
    public String[] res;
    public int[] price;
    public int[] risk;
    public int [] zab;

    public Res() {
            this.m = 9;
            this.res = new String[]{"Обязанность №1:", "Обязанность №2:", "Обязанность №3:", "Обязанность №4:", "Обязанность №5:", "Обязанность №6:", "Обязанность №7:", "Обязанность №8:", "Обязанность №9:"};
            this.zab = new int []{7200, 13000, 10000, 6700, 4000, 5500, 90000, 1200, 730};
            this.price = new int[]{8200, 13500, 11025, 9200, 7000, 8500, 92125, 2000, 920};
            this.risk = new int[]{1000, 500, 1025, 2500, 3000, 2125, 230, 800, 190};
    }
}
