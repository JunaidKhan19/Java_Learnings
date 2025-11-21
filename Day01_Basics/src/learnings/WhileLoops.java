package learnings;

public class WhileLoops {

	public static void main(String[] args) {
		//check if prime 
		int num = 97;
		int i = 2;
		boolean isPrime = true;
		while(i<num){
			if(num % i == 0){
			        isPrime = true;
				break;
			}
			i++;
		}

		if(isPrime) 
			System.out.println("Prime");
		else 
			System.out.println("Not prime");
		
	}

}
