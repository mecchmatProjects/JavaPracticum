package MyPack;

public class Print extends Sort{
    public String print(){
            String s = "";
            for (int i = 0; i < n; i++) {
                s += "\n " + wagon_eq[i] + " Пассажири: " + String.valueOf(pas_eq[i]) + " Багаж: " + String.valueOf(bag_eq[i]) + " Категория: " + String.valueOf(tip_eq[i]);
                s += " ";
            }

            return s;
    }

    public String printIn(int t, int d){
        String s = "";
        for (int i = 0; i < n; i++) {
            if (pas_eq[i]>=t && pas_eq[i]<=d) {
                s += "\n " + wagon_eq[i] + " Пассажири: " + String.valueOf(pas_eq[i]) + " Багаж: " + String.valueOf(bag_eq[i]) + " Категория: " + String.valueOf(tip_eq[i]);
                s += " ";
            }
        }

        return s;
    }

    public String full_bag(){
            int full_bag = 0;
            try {
                for (int i = 0; i < n; i++) {
                    full_bag += bag_eq[i];
                }
            }catch(Exception e){}
            String s = "Всего багажа в поезде: " + String.valueOf(full_bag);
            return s;
    }

    public String full_pas(){
        int full_pas = 0;
        try {
            for (int i = 0; i < n; i++) {
                full_pas += pas_eq[i];
            }
        }catch(Exception e){}
        String s = "Всего пассажиров в поезде: " + String.valueOf(full_pas);
        return s;
    }
}
