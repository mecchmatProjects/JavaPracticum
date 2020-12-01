package Task5n12;

abstract class Item {
    protected String name;
    protected float price;

    protected void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }


    Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}