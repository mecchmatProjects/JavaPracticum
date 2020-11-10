package Task7n1;

public class Directory extends Book {
    protected String name;
    protected String author_name;
    protected String author_surname;
    protected float price;
    Directory(String name, String author_name, String author_surname, float price){
        this.name=name;
        this.author_name=author_name;
        this.author_surname=author_surname;
        this.price=price;
    }

    @Override
    public void printb(){
        System.out.println("Directory '"+this.name+"' is printing");
    }
    @Override
    public void advertise(){
        System.out.println("Directory '"+this.name+"' is advertised");
    }

    @Override
    public void popular(){
        System.out.println("Directory '"+this.name+"' is popular");
    }

    @Override
    public String toString(){
        return "Directory "+this.name+" is published by "+this.author_name+" "+this.author_surname;
    }
}
