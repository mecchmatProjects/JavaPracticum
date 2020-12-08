package MyPack;

public class Sort extends Deb{
    public Sort(){
            int j = 0;
            while (j < n - 1) {
                if (risk_eq[j + 1] > risk_eq[j]) {
                    int b = risk_eq[j];
                    risk_eq[j] = risk_eq[j + 1];
                    risk_eq[j + 1] = b;

                    b = price_eq[j];
                    price_eq[j] = price_eq[j + 1];
                    price_eq[j + 1] = b;

                    b = zab_eq[j];
                    zab_eq[j] = zab_eq[j + 1];
                    zab_eq[j + 1] = b;

                    String c = res_eq[j];
                    res_eq[j] = res_eq[j + 1];
                    res_eq[j + 1] = c;

                    j = 0;
                } else j++;
            }


    }

}
