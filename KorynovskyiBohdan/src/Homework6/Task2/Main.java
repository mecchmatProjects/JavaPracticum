/*
    10.interface Фільм - class - Вітчизняний Фільм - class - Комедія.
 */

package Homework6.Task2;

class Domestic implements Movie{

    @Override
    public String view() {
        return "Viewing domestic movie";
    }

    @Override
    public String stop() {
        return "Domestic film stopped";
    }

    @Override
    public String run() {
        return "Running domestic film";
    }

    @Override
    public String getTitle() {
        return "Domestic film";
    }

    @Override
    public String getTitle(String str) {
        return String.format("Comedy film: %s", str);
    }
}

class Comedy extends Domestic{
    @Override
    public String view() {
        return "Viewing comedy movie";
    }

    @Override
    public String stop() {
        return "Comedy film stopped";
    }

    @Override
    public String run() {
        return "Running comedy film";
    }

    @Override
    public String getTitle() {
        return "Comedy film";
    }

    @Override
    public String getTitle(String str) {
        return String.format("Comedy film: %s", str);
    }
}

public class Main {
    public static void main(String[] args) {
        Domestic movie1 = new Domestic();
        Comedy movie2 = new Comedy();

        System.out.println(movie1.getTitle());
        System.out.println(movie2.getTitle());

        System.out.println(movie1.getTitle("Movie1"));
        System.out.println(movie2.getTitle("Movie2"));
    }
}
