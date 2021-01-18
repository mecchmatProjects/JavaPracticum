/*
    5.15.Податки. Визначити кількість і суму податкових виплат фізичної особи заздалегідь з урахуванням доходів
    сосновной і додаткового місць роботи, авторських винагород, продажу майна, отримання вподарок грошових сум і майна,
    переказів з-за кордону, пільг на дітей і матеріальної допомоги. Провести сортування податків за сумою.
 */

package Homework5.Task2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void sortByAmount(ArrayList<Tax> taxes) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < taxes.size(); i++) {
                if (taxes.get(i).getTax() < taxes.get(i - 1).getTax()) {
                    Collections.swap(taxes, i, i - 1);
                    needIteration = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        User user = Utils.readFile("./src/Homework5/Task2/task2.txt");

        System.out.println("User");

        System.out.printf("\nAmount of taxes: %d", user.amountOfTaxes());
        System.out.printf("\nSum of taxes: %f\n", user.sumOfTaxes());

        sortByAmount(user.taxes);

        System.out.println(user.toString());


    }
}
