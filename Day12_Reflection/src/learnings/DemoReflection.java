package learnings;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DemoReflection {

	public static void main(String[] args) {
		/*
		// Way 1: making object of target class and then using it with Class
		Project p = new Project();
		Class c = p.getClass();
		
		String nameOfp = c.getName();
		System.out.println(nameOfp);
		
		Method[] m = c.getMethods(); //Method is a class in java.lang.reflect
		for(Method method : m) {
			//System.out.println(method.getName());
			System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + " " + method.getName());
		}
		
		//Field[] f = c.getFields();// this wont get private fields
		Field[] f = c.getDeclaredFields();// this will also get private fields		
		for(Field fields : f) {
			System.out.println(fields.getName() + "\t \t" + Modifier.toString(fields.getModifiers()));
		}
		*/
		
		
		/*
		// Way 2: Passing the Name of target class
		try {
			Class c2 = Class.forName("LearningsReflection.Project");
			System.out.println(c2.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/

		
		// Way 3: on different types of objects. Eg: String, int, Thread, etc.
		Thread t1 = new Thread();
		Class c3 = t1.getClass();
		
		String nameOft1 = c3.getName();
		System.out.println(nameOft1);
		
		Method[] mt1 = c3.getMethods(); //Method is a class in java.lang.reflect
		for(Method method : mt1) {
			System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + " " + method.getName());
		}

		Field[] ft1 = c3.getDeclaredFields();// this will also get private fields		
		for(Field fields : ft1) {
			System.out.println(fields.getName() + "\t \t" + Modifier.toString(fields.getModifiers()));
		}
	}

}
