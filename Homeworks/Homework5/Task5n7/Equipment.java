package Task5n7;

class Equipment extends Item{
    protected boolean quality;
    Equipment(String name, float price, float weight,boolean quality){
        super(name,price,weight);
        this.quality = quality;
    }

    void setQuality(boolean quality){
        this.quality = quality;
    }

    public boolean getQuality(){
        return this.quality;
    }



}
