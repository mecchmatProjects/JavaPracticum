package taxi.car;

public class Ford extends Car {

  public Ford(String model, double price) {
    super("Ford", model, price);
  }

  @Override
  public double getFuelConsumptionPer100km() {
    return 4.0;
  }

  @Override
  public double getMaximumSpeed() {
    return 130.0; 
  }
}
