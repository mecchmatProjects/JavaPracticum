/*
Чича Олександр

12. Помножити два многочлена заданого ступеня, якщо коефіцієнти многочленів зберігаються в різних списках.
 */

package DZ10_Task_12;

public class Task_12 {
    public static double[] multiply(double[] first, double[] second){
        double[] result = new double[first.length+second.length-1];
        for (int i = 0; i < first.length;i++){
            for (int j = 0; j < second.length;j++){
                result[i+j] += first[i]*second[j];
            }
        }
        return result;
    }

    public static String toStr(double[] list){
        String ans = "";
        int n = list.length;
        for (int i = 0;i<n;i++){
            if (i > 0) {
                if (list[i] > 0){
                    ans += " + " + list[i] + "*x^" + i ;
                }
                else if (list[i] < 0) {
                    ans += list[i] + "*x^" + i ;
                }
            }
            if ((i == 0)&&(list[i] != 0)){
                ans += list[i] + "*x^" + i;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        double[] first = {1, 2, -2, 3};
        System.out.println(first[0]);
        System.out.println(toStr(first));

        double[] second = {3, -1, 0, 4};
        System.out.println(toStr(second));

        double[] multy = multiply(first, second);
        System.out.println(toStr(multy));
    }
}
