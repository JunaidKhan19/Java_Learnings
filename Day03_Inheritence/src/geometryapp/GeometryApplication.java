package geometryapp;

public class GeometryApplication {

	public static void main(String[] args) {
		Circle circle1 = new Circle(3.5f, "red");
		System.out.println("Area of circle is " + circle1.calculateArea());;
		circle1.draw();
		
		/*Rectangle rect1 = new Rectangle(3.3f, 3.2f, "blue");
		System.out.println("Area of circle is " + rect1.calculateArea());
		rect1.draw();*/
	}

}
