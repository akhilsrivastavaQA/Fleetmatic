import java.util.ArrayList;
import java.util.Iterator;

public class RabbitCount {
	
	static ArrayList<RabbitPair> rabbits = new ArrayList<RabbitPair>();
	
	public static int RabbitCount(int month){
		
		//add magically appeared pair of rabbits
		if(month >= 0)
			rabbits.add(new RabbitPair());
		
		for(int m = 1; m <= month; m++){
			Iterator<RabbitPair> itr = rabbits.iterator();
			int newPairs = 0;
			while(itr.hasNext()){
				RabbitPair rp = itr.next();
				rp.increaseAgeByAMonth();
				if(rp.isMature()){
					//Rabbit pair is mature to give birth to babies
					newPairs++;
				}
			}
			
			for(int i = 0; i < newPairs; i++){
				rabbits.add(new RabbitPair());
			}
		}
		
		return rabbits.size();
	}
	
	public static void main(String[] args){
		System.out.println(RabbitCount(7));
	}
}

class RabbitPair{
	int age = 0;
	
	public void increaseAgeByAMonth(){
		age++;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public boolean isMature(){
		return (age >= 3) ? true : false; 
	}
}