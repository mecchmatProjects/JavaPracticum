package taxi.car;

public class BMW extends Car {

  public BMW(String model, double price) {
    super("BMW", model, price);
  }

  @Override
  public double getFuelConsumptionPer100km() {
    return 7.0;
  }

  @Override
  public double getMaximumSpeed() {
    return 100.0; 
  }
}
