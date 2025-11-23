package geometryapp;

public abstract class Shape {
	protected String color;
	
	public Shape(String color) {
		this.color = color;
	}
	
	public abstract float calculateArea();
	
	public abstract float calculatePerimeter();
	
	public void draw() {
		System.out.println("Shape drawn using color "+ this.color);
	}
}