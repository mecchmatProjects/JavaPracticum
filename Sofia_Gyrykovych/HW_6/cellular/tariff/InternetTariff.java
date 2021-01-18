package cellular.tariff;

public class InternetTariff extends Tariff {

  public InternetTariff(String name, int clients) {
    super(name + " Internet", clients);
  }

  @Override
  public double getSubscriptionFee() {
    return 75.0;
  }

  @Override
  public int getAvailableMegabytes() {
    return 10000;
  }

  @Override
  public int getAvailableMinutes() {
    return 90;
  }
}
