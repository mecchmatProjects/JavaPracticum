package DZ5_Task_13;

public class Product {
    protected String name;
    protected String sortOfCoffe;
    protected String mill;
    protected double price;
    protected double weight;
    protected double volumeOfPackage;

    Product(){};

    Product(String name, String sortOfCoffe, String mill,double price, double weight, double volumeOfPackage) {
        this.name = name;
        this.sortOfCoffe = sortOfCoffe;
        this.mill = mill;
        this.price = price;
        this.weight = weight;
        this.volumeOfPackage = volumeOfPackage;
    }

    @Override
    public String toString() {
        return ("Product : " + "{" +
                "name : " + name + ", " +
                "sortOfCoffe : " + sortOfCoffe + ", " +
                "mill : " + mill + ", " +
                "price : " + price + ", " +
                "weight : " + weight + ", " +
                "volumeOfPackage : " + volumeOfPackage + "}");

    }

    public String getName(){
        return name;
    }

    public String getSortOfCoffe(){
        return sortOfCoffe;
    }

    public String getMill(){
        return mill;
    }

    public double getPrice(){
        return price;
    }

    public double getVolumeOfPackage(){
        return volumeOfPackage;
    }

    public double getWeight(){
        return weight;
    }
}

