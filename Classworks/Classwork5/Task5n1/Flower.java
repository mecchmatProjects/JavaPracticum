package Task5n1;

class Flower extends Item {
    protected int length;

    Flower(String name,float price,String color, int time, int length) {
        super(name,price,color,time);
        this.length = length;
    }

    protected void setColor(int l) {
        this.length = l;
    }

    public int getLength() {
        return length;
    }

}
