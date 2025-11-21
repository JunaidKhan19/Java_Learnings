package learnings;

public class SwitchCase {

	public static void main(String[] args) {
		int number;
		number = 1;
		/*
		if(number == 1){
			System.out.println("One"); 
		} else 	if(number == 2){
			System.out.println("Two"); 
		} else 	if(number == 3){
			System.out.println("Three"); 
		} else 	{
			System.out.println("Invalid Value"); 
		}
		*/
		
		switch(number){
			case 1:
				System.out.println("One");
				break;
			case 2:	
				System.out.println("Two");
				break;	
			case 3:
				System.out.println("Three");
				break;	
			default:
				System.out.println("One");
				break;
		}
	}

}
