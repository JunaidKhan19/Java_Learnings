package learnings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWritePract {
	public static void main(String[] args) {
		FileInputStream fsin = null;
		FileOutputStream fsop = null;
		try {
			fsin = new FileInputStream("Readme.txt");
			System.out.println("File found");
			fsop = new FileOutputStream("copyread.txt");
			int data = fsin.read();
			while(data != -1) {
				fsop.write(data);
				data = fsin.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fsin.close();
				fsop.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
