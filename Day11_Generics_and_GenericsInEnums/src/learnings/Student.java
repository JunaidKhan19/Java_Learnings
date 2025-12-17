package learnings;

interface Printable {
	void print();
}
 
class MyNumber extends Number implements Printable {
	private final int value;
	
	public MyNumber(int value) {
		this.value = value;
	};
	
	@Override
	public void print() {
		System.out.println("My number is " + value);
	}

	@Override
	public int intValue() {
		return 0;
	}

	@Override
	public long longValue() {
		return 0;
	}

	@Override
	public float floatValue() {
		return 0;
	}

	@Override
	public double doubleValue() {
		return 0;
	}
	
}

//this is bounded generics
//1.always use extend keyword for both method and interface
//2.if bounding with both class and interface then always the first must be a class then after '&' be interfaces 
class Dice <N extends Number & Printable> {
	private N item;
	
	public Dice(N item) {
		this.item = item;
	}
	
	public void display() {
		item.print();
	}
	
	public N getItem() {
		return item;
	}
}

public class Student{
	public static void main(String[] args) {
		MyNumber myNum = new MyNumber(123);
		Dice<MyNumber> dice = new Dice<>(myNum); //dice can only take classes inside <?> that extends number and printable
		dice.display();
	}
}
