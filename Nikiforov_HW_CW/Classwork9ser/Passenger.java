package Classwork9ser;


import java.io.Serializable;

public class Passenger implements Serializable {
    private int id;
    private String name;

    Passenger(String name, int id){
        this.id = id;
        this.name = name;
    }

    void setId(int id){
        this.id=id;
    }

    void setName(String name){
        this.name=name;
    }

    int getId(){return this.id;}
    String getName(){return this.name;}

    @Override
    public String toString() {
        return "ID: "+this.id+", Name: "+this.name;
    }

}
