package flowers;

public abstract class Item {

	
	private String name;
	private float price;
	int time;
	
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
	
	Item(){
		name="";
	}
	
    @Override
	public String toString(){
		return name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
