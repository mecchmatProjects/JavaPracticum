package taxi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import taxi.car.Car;

public class Park {

  private final List<Car> cars;

  public Park() {
    this.cars = new ArrayList<>();
  }

  public void addCar(Car car) {
    cars.add(car);
  }

  public double getTotalCost() {
    double ret = 0.0;
    for (Car car : cars) {
      ret += car.getPrice();
    }
    return ret;
  }

  public List<Car> getCarsOrderByFuelConsumption() {
    List<Car> ret = new ArrayList<>(cars);
    ret.sort(Comparator.comparing(Car::getFuelConsumptionPer100km));
    return ret;
  }

  public List<Car> getCarsWhereSpeedBetween(double a, double b) {
    List<Car> ret = new ArrayList<>();
    for (Car car : cars) {
      if (car.getMaximumSpeed() >= a && car.getMaximumSpeed() <= b) {
        ret.add(car);
      }
    }
    return ret;
  }
}
