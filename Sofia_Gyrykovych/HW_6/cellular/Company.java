package cellular;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cellular.tariff.Tariff;

public class Company {

  private final List<Tariff> tariffs;

  public Company() {
    this.tariffs = new ArrayList<>();
  }

  public void addTariff(Tariff tariff) {
    tariffs.add(tariff);
  }

  public int getTotalClientCount() {
    int ret = 0;
    for (Tariff tariff : tariffs) {
      ret += tariff.getClients();
    }
    return ret;
  }

  public List<Tariff> getTariffsOrderByFee() {
    List<Tariff> ret = new ArrayList<>(tariffs);
    ret.sort(Comparator.comparing(Tariff::getSubscriptionFee));
    return ret;
  }

  public List<Tariff> getTariffsWhithMinimumMinutesAndMegabytes(int minMinutes, int minMegabytes) {
    List<Tariff> ret = new ArrayList<>();
    for (Tariff tariff : tariffs) {
      if (tariff.getAvailableMinutes() >= minMinutes && tariff.getAvailableMegabytes() >= minMegabytes) {
        ret.add(tariff);
      }
    }
    return ret;
  }
}
