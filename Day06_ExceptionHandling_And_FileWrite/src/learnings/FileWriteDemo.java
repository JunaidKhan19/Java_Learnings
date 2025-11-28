package learnings;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteDemo {
	public static void main(String[] args) {
		FileOutputStream foutputstr = null;
		try {
			foutputstr = new FileOutputStream("copyread.txt");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				foutputstr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
