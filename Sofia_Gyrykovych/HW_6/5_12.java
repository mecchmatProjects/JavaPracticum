import java.util.Scanner;

import cellular.Company;
import cellular.tariff.InternetTariff;
import cellular.tariff.PhoneCallsTariff;
import cellular.tariff.PremiumTariff;
import cellular.tariff.Tariff;

class Main {

  public static void main(String[] args) {
    Company company = new Company();

    company.addTariff(new InternetTariff("Mega 2021 ", 32081));
    company.addTariff(new PremiumTariff("Ultra 2021 ", 30211));
    company.addTariff(new PhoneCallsTariff("Super 2021 ", 33833));
    company.addTariff(new PhoneCallsTariff("Super 2019 ", 48513));
    company.addTariff(new InternetTariff("Mega 2020 ", 19953));
    company.addTariff(new PremiumTariff("Ultra 2019 ", 35274));
    company.addTariff(new InternetTariff("Mega 2019 ", 29775));
    company.addTariff(new PhoneCallsTariff("Super 2020 ", 24534));
    company.addTariff(new PremiumTariff("Ultra 2020 ", 42917));

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println();
      System.out.println("options:");
      System.out.println(" 0) exit");
      System.out.println(" 1) count total clients");
      System.out.println(" 2) print tariffs by fee");
      System.out.println(" 3) find tariffs by parameters");

      System.out.print("i want to: ");
      int option = scanner.nextInt();

      if (option == 0) {
        System.out.println("bye");
        break;
      }

      switch (option) {
        case 1:
          System.out.println();
          System.out.println("total clients: " + company.getTotalClientCount());
          break;
        case 2:
          System.out.println();
          System.out.println("tariffs:");
          for (Tariff tariff : company.getTariffsOrderByFee()) {
            System.out.println(tariff);
          }
          break;
        case 3:
          System.out.println();
          System.out.print("enter min minutes: ");
          int minMinutes = scanner.nextInt();
          System.out.print("enter min megabytes: ");
          int minMegabytes = scanner.nextInt();
          System.out.println("tariffs:");
          for (Tariff tariff : company.getTariffsWhithMinimumMinutesAndMegabytes(minMinutes, minMegabytes)) {
            System.out.println(tariff);
          }
          break;
        default:
          System.out.println("invalid option");
      }
    }
  }
}
