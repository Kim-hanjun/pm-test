package prac;

public class Circle {
	private final double PI = 3.14;
	
	// public으로 선언 (필드)
	public int radius;
	public String name;
	
	// 아무것도 하지 않는 construct
	public Circle() {
		
	}
	
	// 메서드 선언
	public double getPI() {
		return this.PI;
	}
	
	// 메서드 선언
	public double getArea() {
		return PI * radius * radius;
	}
	
	// main 에서는 아무것도 안함
	public static void main(String[] args) {
		System.out.println("Class and Object Practice");
	}

}
