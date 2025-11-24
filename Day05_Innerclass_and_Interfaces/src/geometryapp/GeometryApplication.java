package geometryapp;

public class GeometryApplication {

	public static void main(String[] args) {
		Circle circle1 = new Circle(3.5f, "red");
		System.out.println("Area of circle is " + circle1.calculateArea());
		circle1.draw();
		circle1.print();
		
		System.out.println();
		
		Rectangle rect1 = new Rectangle(3.3f, 3.2f, "blue");
		System.out.println("Area of rectangle is " + rect1.calculateArea());
		rect1.draw();
		rect1.print();
	}

}
