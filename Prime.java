import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Prime {
	public static LinkedList<Number> multiple(LinkedList<Number> list) {

		int i = 0;
		while(i < list.size()) {
			if(((Number) list.get(i)).getPrime() != -1) { 
				i++;
				continue;
			}else {
				for(int j = i+1; j < list.size(); j++) {
					Number num = (Number)list.get(j);
					if(num.getValue() % ((Number)list.get(i)).getValue() == 0) {
						num.setPrime(0);
					}
				}
				i++;
			}
		}		
		//Update the list of Numbers so that any unknown values are set to prime value
		 for(int z = 0; z < list.size(); z++) {
			 Number num = (Number)list.get(z);
			 if(num.getPrime() == -1) {
				 num.setPrime(1);;
			 }
		 }
		 return list; //returns list with prime and composite DS Number
	}
	//Generates the list of Numbers from 2 to the user defined limit
	public static LinkedList<Number> linkedListGenerator(int limit) {
		LinkedList<Number>  list = new LinkedList<Number>();
		for(int i = 2; i < limit + 1; i++) {
			Number num = new Number(i);
			list.add(num);
		}
		return list;
	}
	// Returns an array of all prime numbers between 1 and the user given limit
	public static int [] findPrime(int limit){
		LinkedList<Number> list = multiple(linkedListGenerator(limit));
		List<Number> primeNumber = new ArrayList<Number>();
		int numOfPrimes;
		
		for(int i = 0; i < list.size(); i++) {
			Number num = (Number)list.get(i);
			if(num.getPrime() == 1) {
				primeNumber.add(num);
			}
		}
		numOfPrimes = primeNumber.size();
		int [] prime = new int[numOfPrimes];
		for(int i = 0; i < numOfPrimes; i++) {
			prime [i]= ((Number)primeNumber.get(i)).getValue();
		}
		return prime;
	}
}
