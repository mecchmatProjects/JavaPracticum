package Task5n12;
import java.util.ArrayList;
import java.util.Collections;

public class MobileOperator {


    int size;
    ArrayList<Rate> rates;

    MobileOperator() {
        this.size = 0;
        rates = new ArrayList<>();
    }

    void addRate(Rate x) {
        rates.add(x);
        this.size += 1;
    }

    void removeRate(Rate x) {
        int i = rates.indexOf(x);
        rates.remove(i);
        this.size -= 1;
    }

    int getAmountUsersSum() {
        int sum = 0;
        for (Rate x : rates) {
            sum += x.getAmount_users();
        }
        return sum;
    }

    void getPriceRange() {
        int i, j, highestValueIndex;
        for (i = 0; i < size; i++) {
            highestValueIndex = i;

            for (j = i + 1; j < size; j++) {
                if (rates.get(j).price > rates.get(highestValueIndex).price) {
                    highestValueIndex = j;
                }
            }

            Collections.swap(rates, i, highestValueIndex);
        }
        System.out.println("Sorted by price, from expensive to cheap: ");
        for (Rate x : rates) {
            System.out.println(x);
        }
    }

    Rate getByPrice(float a, float b) {
        for (Rate x : rates) {
            Rate z = (Rate) x;
            if (z.getPrice() >= a && z.getPrice() <= b) {
                return z;
            }
        }
        return new Rate("", 0, 0);
    }

    public static void main(String[] args) {
        Rate g2 = new Rate("2G unlimited", 50, 1560);
        Rate g3 = new Rate("3G 10GB", 120, 3020);
        Rate g3b = new Rate("3G unlimited", 180, 8550);
        Rate g4 = new Rate("4G unlimited", 280, 12560);

        MobileOperator operator = new MobileOperator();
        operator.addRate(g2);
        operator.addRate(g3);
        operator.addRate(g3b);
        operator.addRate(g4);

        int sum_users = operator.getAmountUsersSum();
        System.out.println("Total amount of users: "+sum_users);
        System.out.println();
        System.out.println(operator.getByPrice(100,150));
        System.out.println();
        operator.getPriceRange();
    }
}
