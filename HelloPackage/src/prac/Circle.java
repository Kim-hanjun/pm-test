package prac;

// 이 클래스 내에서는 private접근이 가능하다. 다른 클래스를 만들어서 접근을 하려 하면 불가하다.
public class Circle {
	private final double PI = 3.14;
	
	// public으로 선언 (필드)
	int radius;
	private String name;
	

	public Circle() {
		this(1, "random pizza");
	}
	
	public Circle(Circle c) {
		this.radius = c.radius;
		this.name = new String(c.name);
	}
	
	public Circle(int r, String n) {
		this.initialize(r, n);
	}
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	
	private void initialize(int r, String n) {
		this.radius = r;
		this.name = n;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	// 메서드 선언
	public double getPI() {
		return this.PI;
	}
	
	// 메서드 선언
	public double getArea() {
		return PI * radius * radius;
	}
	
	public String toString() {
		return "name : " + getName() + " radius : " + getRadius();
	}
	// main 에서는 아무것도 안함
	public static void main(String[] args) {
		System.out.println("Class and Object Practice");
		
		Circle pizza = new Circle();
//		
//		pizza.radius = 10;
//		pizza.name = "Cheese Pizza";
//		
//		System.out.println(pizza.toString());
//		
		Circle pizza2 = new Circle();
		
//		pizza2.initialize(8, "Chicago Pizza");
		
		System.out.println(pizza2.toString());
		
		Circle pizza3 = new Circle(15, "Hwaiian Pizza");
		System.out.println(pizza3.toString());
		
		Circle pizzaCopy = new Circle(pizza);
		System.out.println(pizzaCopy.toString());
		
		Circle[] c;
		c = new Circle[5];
		
		for(int i = 0; i < c.length; i++) {
			c[i] = new Circle(i);
		}
		for(int i = 0; i < c.length; i++) {
			System.out.print((int)(c[i].getArea()) + " ");
		}
	}

}
