package flowers;

public class Bouquet {
	
	int size; 
	Item[] flowers;
	
	String name;
	
	void addFlower(Item x){
		flowers[size++] = x;
	}
	
	 boolean removeFlower(Item x) {
		 int k=0;
		for(Item it : flowers){
			if(it.equals(x)){
				for(int i=k;i<flowers.length;i++){
					flowers[k]=flowers[k+1];
				} 
			}
			k++;
		} 
		return false;
	}

	float getPrice(){
		float sum =0f;
		for(Item it : flowers){
			sum += it.getPrice();
		}
		return sum;
	} 
	
	float getFresh(){
		
		int sum = 0;
		int num = 0;
		for(Item it : flowers){
			
			if(it instanceof Bush){
				continue;
			}
			
			sum += it.getTime();
			num++; 
		}
		
		if(num>0)
			return (float)sum/num;
        return Float.POSITIVE_INFINITY;		
	}
	
	Flower getByLength(float a, float b){
		for(Item it : flowers){
			if(it instanceof Flower){
				Flower z = (Flower) it;
				if(z.getLength()>=a && z.getLength()<=b){
					return z;
				}
			}
		}
		return new Flower();
	}
	

	
	
	 public static void main(String[] args) {
		
		 Flower rose1= new Flower();
		 
		 Flower rose2= new Flower();
		 
		 Flower lilia = new Flower();
		 
		 Bush b = new Bush(); 
		 
		 Bouquet buk = new Bouquet();
		 
		 buk.addFlower(rose1);
		 buk.addFlower(rose2);
		 buk.addFlower(lilia);
		 buk.addFlower(b);
		 
		 Float p = buk.getPrice();
		 
		 Flower x = buk.getByLength(10, 20);
		 System.out.println(x);
		 
		 

	}

}
