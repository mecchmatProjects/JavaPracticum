package taxi.car;

public class Nissan extends Car {

  public Nissan(String model, double price) {
    super("Nissan", model, price);
  }

  @Override
  public double getFuelConsumptionPer100km() {
    return 5.0;
  }

  @Override
  public double getMaximumSpeed() {
    return 120.0; 
  }
}
