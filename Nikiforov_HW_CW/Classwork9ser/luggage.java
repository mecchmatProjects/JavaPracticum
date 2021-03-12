package Classwork9ser;

class luggage {
    private int id;
    private int amount;
    private int weight;

    luggage(int id, int amount, int weight){
        this.id = id;
        this.amount=amount;
        this.weight=weight;
    }
    void setId(int id){
        this.id=id;
    }

    void setAmount(int amount){
        this.amount=amount;
    }

    void setWeight(int weight){
        this.weight=weight;
    }

    int getId(){return this.id;}
    int getAmount(){return this.amount;}
    int getWeight(){return this.weight;}

    @Override
    public String toString() {
        return "ID: "+this.id+", Amount: "+this.amount+", Weight: "+this.weight;
    }
}
