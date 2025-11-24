package geometryapp;

public class Rectangle extends Shape{
	private float length;
	private float breadth;
	
	public Rectangle(float length, float breadth, String color) {
		super(color);
		this.length = length;
		this.breadth = breadth;
		this.color = color;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getBreadth() {
		return breadth;
	}

	public void setBreadth(float breadth) {
		this.breadth = breadth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public float calculateArea() {
		return length*breadth;
	}
	
	@Override
	public float calculatePerimeter() {
		return 0;
	}
	
	@Override //built-in annotation to check if overriding is appropriate. It is recommended to do so.
	public void draw() {
		super.draw();
		System.out.println("With length "+ this.length + " and breadth " + this.breadth);
	}

	@Override
	public void print() {
		System.out.println("This is a rectangle.");
	}
}

