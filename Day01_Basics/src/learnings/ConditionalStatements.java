package learnings;

public class ConditionalStatements {

	public static void main(String[] args) {
		int age;
		age = 20;
		char nationality = 'I';
		if(age > 18 && nationality == 'I'){
			System.out.println("Eligible for voting"); 
		} else {
			System.out.println("Not eligible for voting"); 
		}
	}

}
