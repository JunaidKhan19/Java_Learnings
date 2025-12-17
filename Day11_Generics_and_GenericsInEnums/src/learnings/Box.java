package learnings;

/* without generics
public class Box {
	private Object value;
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
}
*/


// with generics
//Make this class generic type i.e the class will be able to define the data type to work with while making the object 
public class Box<T> {
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}

class Box2{
	public <T> Box2 (T value){
		//this is a generic constructor if the class is not generic type
	}
	
	//this is an example of generic method if class is not generic
	public <T> void printArray(T[] array) {
		for(T element : array) {
			System.out.println(element + " ");
		}
	}
}


