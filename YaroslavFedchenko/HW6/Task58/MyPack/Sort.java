package MyPack;

public class Sort extends Equip{
    public Sort(){
        try {
            int j = 0;
            while (j < n - 1) {
                if (tip_eq[j + 1] > tip_eq[j]) {
                    int b = tip_eq[j];
                    tip_eq[j] = tip_eq[j + 1];
                    tip_eq[j + 1] = b;

                    b = bag_eq[j];
                    bag_eq[j] = bag_eq[j + 1];
                    bag_eq[j + 1] = b;

                    b = pas_eq[j];
                    pas_eq[j] = pas_eq[j + 1];
                    pas_eq[j + 1] = b;

                    String c = wagon_eq[j];
                    wagon_eq[j] = wagon_eq[j + 1];
                    wagon_eq[j + 1] = c;

                    j = 0;
                } else j++;
            }
        } catch(Exception e){}


    }

}
