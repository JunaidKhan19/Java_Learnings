package learnings;

import java.io.IOException;

public class ThrowKeyword_and_Throws {
	public static void main(String[] args) {
		try{
			readFile();
		} catch(IOException ex) {}
	}
	
	static void readFile() throws IOException{  //propagates the exception to main
		IOException e = new IOException();
		throw e;
	}
}
