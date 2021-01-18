package cellular.tariff;

public class PremiumTariff extends Tariff {

  public PremiumTariff(String name, int clients) {
    super(name + " Premium", clients);
  }

  @Override
  public double getSubscriptionFee() {
    return 250.0;
  }

  @Override
  public int getAvailableMegabytes() {
    return 30000;
  }

  @Override
  public int getAvailableMinutes() {
    return 500;
  }
}
