package learnings;

public class ArraysInJava {

	public static void main(String[] args) {
		//way-1 of creating array
		int[] numbers = new int[3];
		numbers[0] = 5;
		numbers[1] = 29;
		numbers[2] = 55;
		
		System.out.println(numbers[2]);
		
		//way-2 of creating array
		float[] marks = new float[3];
		marks[0] = 39.99f;
		marks[1] = 50.84f;
		marks[2] = 89.99f;
		
		System.out.println(marks[2]);
		
		//way-3 of creating array
		String[] subjects = {"Java","Spring","dotNet"};
		
		System.out.println(subjects[2]);
		
		//printing all elements
//		for(int i = 0; i < subjects.length; i++) {
//			System.out.println(subjects[i]);
//		}
		
		//enhanced for loop
		//added in jdk5
		for(String s: subjects) {
			System.out.println(s);
		}

		//if we dont pass value in args array an exception is generated
		System.out.println(args[0]);
		
	}

}
