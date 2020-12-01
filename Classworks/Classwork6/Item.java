package Classwork6;

abstract class Item {
    protected String name;
    protected float price;
    protected String color;
    protected int time;

    protected void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    protected void setName(String name){
        this.name =name;
    }

    public String getName(){
        return name;
    }

    protected void setPrice(float price){
        this.price =price;
    }

    public float getPrice(){
        return price;
    }

    protected void setTime(int t){
        this.time =t;
    }

    public int getTime(){
        return time;
    }

    Item(String name,float price,String color, int time){
        this.name=name;
        this.price = price;
        this.color = color;
        this.time = time;
    }

    @Override
    public String toString(){
        return name;
    }
}


