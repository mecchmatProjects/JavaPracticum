package homework_6.task_5_14;

import java.util.ArrayList;
import java.util.Arrays;

public class GameRoom {
    String category;
    int money;
    ArrayList<Toy> toys;
    int maxToysAmount;

    GameRoom(String category, int money, int maxToysAmount){
        this.category = category;
        this.money = money;
        this.toys = new ArrayList<>();
        this.maxToysAmount = maxToysAmount;
    }

    void buyToys(ArrayList<Toy> allToys){
        int i = 0;

        ArrayList<Toy> toysCopy = new ArrayList<>(allToys);

        for (Toy toy : toysCopy){
            if (toy.size.equals(category) && money >= toy.price){
                toys.add(toy);
                allToys.remove(toy);
                money -= toy.price;
                i++;
            }

            if (i >= maxToysAmount) break;
        }
    }

    @Override
    public String toString() {
        String output = "";
        output += "========= GAMEROOM =========" +
                "\nCategory: " + category +
                "\nToys amount: " + toys.size() +
                "\n_____ Toys: _____" + "\n";
        for (Toy toy : toys){
            output += toy + "\n";
        }

        return output;
    }

    void sortToys(){};

}
