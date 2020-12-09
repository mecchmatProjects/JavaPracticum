package cellular.tariff;

public class PhoneCallsTariff extends Tariff {

  public PhoneCallsTariff(String name, int clients) {
    super(name + " Phone Calls", clients);
  }

  @Override
  public double getSubscriptionFee() {
    return 45.0;
  }

  @Override
  public int getAvailableMegabytes() {
    return 2000;
  }

  @Override
  public int getAvailableMinutes() {
    return 300;
  }
}
