class Main {

  public static void main(String[] args) {
    Model model = new Model();

    Mobile mobile = model;
    System.out.println("mobile.getNumber(): " + mobile.getNumber());
    System.out.println("mobile.getScreenSize(): " + mobile.getScreenSize());

    System.out.println();

    SiemensMobile siemensMobile = model;
    System.out.println("siemensMobile.getModelName(): " + siemensMobile.getModelName());
    System.out.println("siemensMobile.getPriceInUSD(): " + siemensMobile.getPriceInUSD());
    System.out.println("siemensMobile.getPriceInUAH(): " + siemensMobile.getPriceInUAH());
  }
}

interface Mobile {

  String getNumber();

  double getScreenSize();
}

abstract class SiemensMobile implements Mobile {

  public abstract String getModelName();

  public abstract double getPriceInUSD();

  public double getPriceInUAH() {
    return getPriceInUSD() * 28;
  }
}

class Model extends SiemensMobile {

  @Override
  public String getNumber() {
    return "+12345";
  }

  @Override
  public double getScreenSize() {
    return 6.1;
  }

  @Override
  public String getModelName() {
    return "S-500";
  }

  @Override
  public double getPriceInUSD() {
    return 499.99;
  }
}
