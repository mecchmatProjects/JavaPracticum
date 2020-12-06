package Homework5.Task2;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Utils {
    private static final double percentage = 0.3;
    
    public static User readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        String[] args = line.split(" ");

        double mainWork = Double.parseDouble(args[0]);
        double secondWork = Double.parseDouble(args[1]);
        double copyrightAwards = Double.parseDouble(args[2]);
        double saleOfProperty = Double.parseDouble(args[2]);
        double gift = Double.parseDouble(args[4]);
        double transfersFromAbroad = Double.parseDouble(args[5]);
        double exemption = Double.parseDouble(args[6]);

        Tax taxMainWork = new Tax(TypeOfTax.MainWork, mainWork, percentage);
        Tax taxSecondWork = new Tax(TypeOfTax.SecondWork, secondWork, percentage);
        Tax taxCopyrightAwards = new Tax(TypeOfTax.CopyrightAwards, copyrightAwards, percentage);
        Tax taxSaleOfProperty = new Tax(TypeOfTax.SaleOfProperty, saleOfProperty, percentage);
        Tax taxGift = new Tax(TypeOfTax.Gift, gift, percentage);
        Tax taxTransfersFromAbroad = new Tax(TypeOfTax.TransfersFromAbroad, transfersFromAbroad, percentage);
        Tax taxExemption = new Tax(TypeOfTax.Exemption, exemption, percentage);

        Tax[] t = new Tax[]{taxMainWork, taxSecondWork, taxCopyrightAwards, taxSaleOfProperty, taxGift, taxTransfersFromAbroad, taxExemption};
        ArrayList<Tax> taxes = new ArrayList<>(Arrays.asList(t));

        User user = new User(taxes);

        fileReader.close();
        reader.close();

        return user;
    }
}
