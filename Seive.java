import java.util.*;



public class Seive {

	public static void main(String[] args) {
	
		System.out.println("*******Welcome to the Seive of Erathoronthenes*******");
		System.out.println("Please enter your limit: ");
		
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		LinkedList list1 = linkedListGenerator(limit);
		LinkedList list2 = multiple(list1);
		display(list2);
	
	}
	public static void display(LinkedList list) {
		
		List prime = new ArrayList();
		List composite = new ArrayList();
		
		for(int i = 0; i < list.size(); i++) {
			Number num = (Number)list.get(i);
			if(num.getPrime() == 1) {
				prime.add(num);
			}else {
				composite.add(num);
			}
		}
		System.out.println("Prime Numbers are: ");
		for(int i = 0; i < prime.size(); i++) {
			Number primeNum = (Number)prime.get(i);
			System.out.print(primeNum.getValue());
			System.out.print(" ");
			if(i == prime.size()/2) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Composite Numbers are: ");
		for(int i = 0; i < composite.size(); i++) {
			Number compositeNum = (Number)composite.get(i);
			System.out.print(compositeNum.getValue());
			System.out.print(" ");
			if(i == composite.size()/2) {
				System.out.println();
			}
		}
	}
	
	public static LinkedList multiple(LinkedList list) {

		int i = 0;
		
		while(i < list.size()) {
			int test = 0;
			if(((Number) list.get(i)).getPrime() != -1) {
				i++;
				continue;
			}else {
				for(int j = i+1; j < list.size(); j++) {
					Number num = (Number)list.get(j);
					if(num.getValue() % ((Number)list.get(i)).getValue() == 0) {
						num.setPrime(0);
						test++;
					}
				}
				i++;
			}
			
		}		
	
		 for(int z = 0; z < list.size(); z++) {
			 Number num = (Number)list.get(z);
			 if(num.getPrime() == -1) {
				 num.setPrime(1);;
			 }
		 }
		 return list;
	}
	
	public static LinkedList linkedListGenerator(int limit) {
		LinkedList  list = new LinkedList();
		for(int i = 2; i < limit + 1; i++) {
			Number num = new Number(i);
			list.add(num);
		}
		return list;
	}
}
