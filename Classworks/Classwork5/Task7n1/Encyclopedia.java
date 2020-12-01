package Task7n1;

public class Encyclopedia extends Book {
    protected String name;
    protected String genre;
    protected float price;
    Encyclopedia(String name, String genre, float price){
        this.name=name;
        this.genre = genre;
        this.price=price;
    }

    @Override
    public void printb(){
        System.out.println("Encyclopedia '"+this.name+"' is printing");
    }
    @Override
    public void advertise(){
        System.out.println("Encyclopedia '"+this.name+"' is advertised");
    }

    @Override
    public void popular(){
        System.out.println("Encyclopedia '"+this.name+"' is popular");
    }

    @Override
    public String toString(){
        return "Directory "+this.name+" has " + this.genre+" genre";
    }
}

