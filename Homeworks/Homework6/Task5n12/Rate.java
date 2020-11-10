package Task5n12;

class Rate extends Item {
    protected int amount_users;
    Rate(String name, float price, int amount_users){
        super(name,price);
        this.amount_users = amount_users;
    }

    public int getAmount_users(){
        return this.amount_users;
    }

    protected void setAmount_users(int am1){
        this.amount_users=am1;
    }


}
