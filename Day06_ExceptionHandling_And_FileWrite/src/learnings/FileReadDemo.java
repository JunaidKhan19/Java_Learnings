package learnings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadDemo {
	public static void main(String[] args) {
		
		FileInputStream finputstr = null;
		try {
			finputstr = new FileInputStream("./Readme.txt");
			System.out.println("File found");
			int data = finputstr.read(); //declaration and start reading
			while(data != -1) { // end of file gives -1. so read until -1 is reached
				System.out.print((char)data); // print every read char
				data = finputstr.read(); //read the next char
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				finputstr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
