package geometryapp;

public class GeometryApplication {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle(3.5f, "red");
		System.out.println("Area of circle is " + circle1.calculateArea());
		circle1.draw();
		
		/*Rectangle rect1 = new Rectangle(3.3f, 3.2f, "blue");
		System.out.println("Area of circle is " + rect1.calculateArea());
		rect1.draw();*/
		
		//Shape circle2 = new Shape(3.5f, "red");// this will give error bcoz shape is abstract
		Shape circle2 = new Circle(3.5f, "red");
		System.out.println("Area of circle is " + circle2.calculateArea());
		circle1.draw();
		
		//TypeCasting
		//upcasting
		Shape shape;
		Circle circle4 = new Circle(3.29f, "blue");
		shape = circle4;
		
		//upcasting example 2
		Shape s = getShape();
		
		//downcasting
		Circle circle5 = (Circle)shape;
		circle5.getPi();
	}

	
	//a generalized method 
	public static Shape getShape() {
		return null;
	}
	
}
