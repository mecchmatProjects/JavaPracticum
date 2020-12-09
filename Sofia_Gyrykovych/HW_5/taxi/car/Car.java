package taxi.car;

public abstract class Car {

  private final String brand;
  private final String model;
  private final double price;

  public Car(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public double getPrice() {
    return price;
  }

  public abstract double getFuelConsumptionPer100km();

  public abstract double getMaximumSpeed();

  public double calculateFuelForDistance(double distance) {
    return distance / 100.0 * getFuelConsumptionPer100km();
  }

  @Override
  public String toString() {
    return "" +
      "Car{" +
      "brand='" + brand + "'" +
      ", model='" + model + "'" +
      ", price=" + price +
      ", fuelConsumption=" + getFuelConsumptionPer100km() +
      ", maximumSpeed=" + getMaximumSpeed() +
      "}";
  }
}
