package cellular.tariff;

public abstract class Tariff {

  private final String name;
  private final int clients;

  public Tariff(String name, int clients) {
    this.name = name;
    this.clients = clients;
  }

  public String getName() {
    return name;
  }

  public int getClients() {
    return clients;
  }

  public abstract double getSubscriptionFee();

  public abstract int getAvailableMegabytes();

  public abstract int getAvailableMinutes();

  @Override
  public String toString() {
    return "" +
      "Tariff{" +
      "name='" + name + "'" +
      ", clients=" + clients +
      ", fee=" + getSubscriptionFee() +
      ", megabytes=" + getAvailableMegabytes() +
      ", minutes=" + getAvailableMinutes() +
      "}";
  }
}
