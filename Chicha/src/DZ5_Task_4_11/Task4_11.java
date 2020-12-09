/*
Чича Олександр

11.Створити об&#39;єкт класу Квочка, використовуючи класи Птах, Зозуля. Методи:
літати, співати, нести яйця, висиджувати пташенят.
 */

package DZ5_Task_4_11;

import java.util.Objects;

public class Task4_11 {
    public static void main(String[] args){
        Quip quip = new Quip( 1, "white", 2.5);

        System.out.println(quip);
        System.out.println("Age: " + quip.getAge());
        System.out.println("Color: " + quip.getColor());
        System.out.println("Weight: " + quip.getWeight());
        quip.Fly();
        quip.carryEggs();
        quip.hangTheBirds();
        quip.Sing();

        Zozulya zozulya = new Zozulya(2, "black", 4);
        System.out.println("\n" + zozulya);
        System.out.println("Age: " + zozulya.getAge());
        System.out.println("Color: " + zozulya.getColor());
        System.out.println("Weight: " + zozulya.getWeight());
        zozulya.Fly();
        zozulya.carryEggs();
        zozulya.hangTheBirds();
        zozulya.Sing();
    }
}

abstract class Bird{

    protected int age;
    protected String color;

    protected Bird(int age, String color) {
        this.age = age;
        this.color = color;
    }

    protected Bird() {}

    abstract void Fly();
    abstract void carryEggs();
    abstract void hangTheBirds();

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bird)) {
            return false;
        }
        Bird bird = (Bird) obj;
        return bird.age == age && bird.color.equals(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, color);
    }

    @Override
    public String toString() {
        return "" + "Bird{" + "age=" + age + ", color=" + color + "}";
    }
}

class Zozulya extends Bird {
    protected double weight;

    Zozulya(int age, String color, double weight) {
        super(age, color);
        this.weight = weight;
    }

    double getWeight() {
        return weight;
    }

    @Override
    void Fly() {
        System.out.println("Zozulya is flying.");
    }

    @Override
    void carryEggs() {
        System.out.println("Zozulya is carrying eggs.");
    }

    @Override
    void hangTheBirds() {
        System.out.println("Zozulya is hanging the birds.");
    }

    void Sing() {
        System.out.println("Zozulya is singing.");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Zozulya)) {
            return false;
        }
        Zozulya zozulya = (Zozulya) obj;
        return zozulya.age == age && zozulya.color.equals(color) && zozulya.weight == weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, color, weight);
    }

    @Override
    public String toString() {
        return "" + "Zozulya{" + "age=" + age + ", color=" + color + ", weight=" + weight + "}";
    }
}

class Quip extends Zozulya{
    Quip(int age, String color, double weight) {
        super(age, color, weight);
    }

    @Override
    void Fly() {
        System.out.println("Quip can't fly.");
    }

    @Override
    void carryEggs() {
        System.out.println("Quip is carrying eggs.");
    }

    @Override
    void hangTheBirds() {
        System.out.println("Quip is hanging the birds.");
    }

    void Sing() {
        System.out.println("Quip can't sing.");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quip)) {
            return false;
        }
        Quip quip = (Quip) obj;
        return quip.age == age && quip.color.equals(color) && quip.weight == weight;
    }

    @Override
    public String toString() {
        return "" + "Quip{" + "age=" + age + ", color=" + color + ", weight=" + weight + "}";
    }
}