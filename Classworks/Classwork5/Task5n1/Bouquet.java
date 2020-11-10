package Task5n1;

import java.util.ArrayList;
import java.util.Collections;


public class Bouquet {

    int size;
    ArrayList<Flower> flowers;

    Bouquet(){
        this.size = 0;
        flowers = new ArrayList<>();
    }

    void addFlower(Flower x) {
        flowers.add(x);
        this.size+=1;
    }

    void removeFlower(Flower x) {
        int i = flowers.indexOf(x);
        flowers.remove(i);
        this.size-=1;
    }

    float getPrice() {
        float sum = 0;
        for(Flower x: flowers){
            sum+= x.getPrice();
        }
        return sum;
    }

    void getFresh() {
        int i, j, highestValueIndex;
        for (i = 0; i < size; i++){
            highestValueIndex = i;

            for (j = i + 1; j < size; j++){
                if (flowers.get(j).time > flowers.get(highestValueIndex).time){
                    highestValueIndex = j;
                }
            }

            Collections.swap(flowers, i, highestValueIndex);
        }
        System.out.println("Sorted by freshness, to sell faster: ");
        for(Flower x:flowers){
            System.out.println(x);
        }
    }

    Flower getByLength(float a, float b) {
        for(Flower x: flowers){
            Flower z = (Flower) x;
            if (z.getLength() >= a && z.getLength() <= b) {
                return z;
            }
        }
        return new Flower("",0,"",0,0);
    }


    public static void main(String[] args) {
        Flower rose1 = new Flower("Rose",15,"Black",18,15);
        Flower aster = new Flower("Aster",17,"Red",15,12);
        Flower lilia = new Flower("lilia",40,"Blue",12,7);
        Flower buttercup = new Flower("Buttercup",25,"Blue",25,5);
        Flower chamomile = new Flower("Chamomile",7,"Yellow",38,10);

        Bouquet bouquet = new Bouquet();

        bouquet.addFlower(rose1);
        bouquet.addFlower(aster);
        bouquet.addFlower(lilia);
        bouquet.addFlower(chamomile);
        bouquet.addFlower(buttercup);

        float price = bouquet.getPrice();
        System.out.println("Total price of bouquet: " + price);
        System.out.println();
        Flower x = bouquet.getByLength(10, 20);
        System.out.println(x);
        System.out.println();
        bouquet.getFresh();
    }

}
