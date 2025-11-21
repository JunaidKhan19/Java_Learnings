package assignmentsday01;

import java.util.Scanner;

public class ScannerMenuProject {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do{
			System.out.println("--------------------");
   			System.out.println("1.Register");
   			System.out.println("2.Find");
   			System.out.println("3.Find All");
   			System.out.println("4.Delete");
   			System.out.println("5.Update");
   			System.out.println("0.Exit");
   			System.out.println("--------------------");
	                System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println("Register");
					break;
				case 2:	
					System.out.println("Find");
					break;	
				case 3:
					System.out.println("Find All");
					break;	
				case 4:
					System.out.println("Delete");
					break;	
				case 5:
					System.out.println("Update");
					break;	
				case 0:
					System.out.println("Exit");
					break;	
				default:
					System.out.println("One");
					break;
			}
		}while(choice != 0);
        	sc.close(); // always close scanner
	}

}
