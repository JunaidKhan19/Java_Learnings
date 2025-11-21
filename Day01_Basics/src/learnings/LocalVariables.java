package learnings;

public class LocalVariables {

	public static void main(String[] args) {
		int age; //age is local to main method
		//System.out.println(age); //ERROR local variables must be initialized before use/accessing.
		
		for(int i=0; i<=5; i++) {};
        //System.out.println(i); //ERROR bcz i is local to for-loop
		
		int j;
		for(j=0; j<=5; j++) {};
        //System.out.println(j); //Print6  bcz j is local to main method and gets initialized in for loop
								//when it becomes 6 it comes out of the loop.
	}

}
