package Homework6.Task1;

import java.util.ArrayList;

public class Present {
    ArrayList<Sweet> sweets;
    int weight;
    int maxWeight;

    Present(int maxWeight) {
        this.sweets = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.weight = 0;
    }

    public void addSweet(Sweet sweet) {
        if (this.weight >= this.maxWeight){
            return;
        }else if (this.weight + sweet.weight > this.maxWeight){
            return;
        }

        sweets.add(sweet);
    }



}
