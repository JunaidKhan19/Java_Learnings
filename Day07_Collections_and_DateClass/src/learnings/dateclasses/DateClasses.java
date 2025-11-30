package learnings.dateclasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClasses {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		//converting date format to string 
		String strDate = df.format(d);
		System.out.println(strDate);
		
		//string to date
		try {
			Date d1 = df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
