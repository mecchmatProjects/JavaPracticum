package MyPack;

public class Print extends Sort{
    public String print(){
            String s = "";
            for (int i = 0; i < n; i++) {
                s += "\n " + res_eq[i] + " " + String.valueOf(zab_eq[i]) + " Багаж: " + String.valueOf(price_eq[i]) + " Риск: " + String.valueOf(risk_eq[i]);
                s += " ";
            }

            return s;
    }

    public String printIn(int t, int d){
        String s = "";
        for (int i = 0; i < n; i++) {
            if (zab_eq[i]>=t && zab_eq[i]<=d) {
                s += "\n " + res_eq[i] + " " + String.valueOf(zab_eq[i]) + " Багаж: " + String.valueOf(price_eq[i]) + " Риск: " + String.valueOf(risk_eq[i]);
                s += " ";
            }
        }

        return s;
    }

    public String full_price(){
            int full_price = 0;
                for (int i = 0; i < n; i++) {
                    full_price += price_eq[i];
                }
            String s = "Сумма цен: " + String.valueOf(full_price);
            return s;
    }
}
