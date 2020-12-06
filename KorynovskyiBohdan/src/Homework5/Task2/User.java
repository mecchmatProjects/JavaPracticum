package Homework5.Task2;

import java.util.ArrayList;
import java.util.Collections;

class User {
    ArrayList<Tax> taxes = new ArrayList<>();

    User(){}

    User(ArrayList<Tax> taxes) {
        this.taxes = taxes;
    }

    public int amountOfTaxes() {
        int amount = 0;
        for (Tax tax : taxes) {
            if (tax.getTax() != 0) {
                amount += 1;
            }
        }

        return amount;
    }

    public double sumOfTaxes() {
        double sum = 0;
        for (Tax tax : taxes) {
            sum += tax.getTax();
        }

        return sum;
    }

    @Override
    public String toString() {
        return String.format("MainWork: %f" +
                        "    SecondWork: %f" +
                        "    CopyrightAwards: %f" +
                        "    SaleOfProperty: %f" +
                        "    Gift: %f" +
                        "    TransfersFromAbroad: %f" +
                        "    Exemption: %f", taxes.get(0).getTax(), taxes.get(1).getTax(), taxes.get(2).getTax(),
                taxes.get(3).getTax(), taxes.get(4).getTax(), taxes.get(5).getTax(), taxes.get(6).getTax());
    }
}