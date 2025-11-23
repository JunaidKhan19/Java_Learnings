package geometryapp;

public class Circle extends Shape {
	private float radius;

	public Circle(float radius, String color) {
		super(color);
		this.radius = radius;
		this.color = color;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public float getPi() {
		return 3.14f;
	}
	
	@Override
	public float calculateArea() {
		return 3.14f*radius*radius;
	}
	
	@Override
	public float calculatePerimeter() {
		return 0;
	}
	
	@Override //built-in annotation to check if overriding is appropriate. It is recommended to do so.
	public void draw() {
		super.draw();
		System.out.println("with radius "+ this.radius);
	}
}
