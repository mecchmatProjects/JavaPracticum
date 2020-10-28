package flowers;

public class Flower extends Item {

	boolean odour;
	float length;
	int color;

	
	void setOdour(boolean x){
		this.odour = x;
	}
	
	boolean getOdour(){
		return odour;
	}
	
	void setLength(float x){
		this.length = x;
	}
	
	float getLength(){
		return length;
	}
	
	Flower(){
		super();
		odour =false;
		length =0;
	}
	
	
	
	protected void setColor(int c){
		this.color =c;
	}
	
	public int getColor(){
		return color;
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
