package Task5n7;


import java.util.ArrayList;
import java.util.Collections;

public class Ammunition {

    int size;
        ArrayList<Equipment> equipments;

        Ammunition(){
            this.size = 0;
            equipments = new ArrayList<>();
        }

        void addEquipment(Equipment x) {
            equipments.add(x);
            this.size+=1;
        }

        void removeEquipment(Equipment x) {
            int i = equipments.indexOf(x);
            equipments.remove(i);
        this.size-=1;
    }

    float getPriceSum() {
        float sum = 0;
        for(Equipment x: equipments){
            sum+= x.getPrice();
        }
        return sum;
    }

    void getWeightRange() {
        int i, j, highestValueIndex;
        for (i = 0; i < size; i++){
            highestValueIndex = i;

            for (j = i + 1; j < size; j++){
                if (equipments.get(j).weight > equipments.get(highestValueIndex).weight){
                    highestValueIndex = j;
                }
            }

            Collections.swap(equipments, i, highestValueIndex);
        }
        System.out.println("Sorted by weigth,from heavy to light: ");
        for(Equipment x:equipments){
            System.out.println(x);
        }
    }
    Equipment getByPrice(float a, float b) {
        for(Equipment x: equipments){
            Equipment z = (Equipment) x;
            if (z.getPrice() >= a && z.getPrice() <= b) {
                return z;
            }
        }
        return new Equipment("",0,0,false);
    }

    public static void main(String[] args) {
        Equipment helmet = new Equipment("Helmet",2500,2,true);
        Equipment gloves = new Equipment("Gloves",500,0.5f,false);
        Equipment pants = new Equipment("Pants",1500,1.5f,true);
        Equipment jacket = new Equipment("Jacket",3500,1.2f,true);

        Ammunition amu = new Ammunition();
        amu.addEquipment(helmet);
        amu.addEquipment(gloves);
        amu.addEquipment(pants);
        amu.addEquipment(jacket);

        float price = amu.getPriceSum();
        System.out.println("Total price of ammunition: " + price);
        System.out.println();
        Equipment x = amu.getByPrice(1000, 2000);
        System.out.println(x);
        System.out.println();
        amu.getWeightRange();
    }

}
