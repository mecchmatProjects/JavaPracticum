package Task5n7;
abstract class Item {
    protected String name;
    protected float price;
    protected float weight;

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

    public float getWeight(){
        return this.weight;
    }

    protected void setWeight(float weight){
        this.weight=weight;
    }

    Item(String name, float price, float weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name;
    }
}



