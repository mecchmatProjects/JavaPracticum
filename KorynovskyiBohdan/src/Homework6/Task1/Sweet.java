package Homework6.Task1;

public class Sweet {
    String name;
    int weight;
    double sugar;

    Sweet(String name, int weight, double sugar){
        this.name = name;
        this.weight = weight;
        this.sugar = sugar;
    }

    @Override
    public String toString(){
        return String.format("%s: %d grams, sugar percent %f", name, weight, sugar);
    }
}
