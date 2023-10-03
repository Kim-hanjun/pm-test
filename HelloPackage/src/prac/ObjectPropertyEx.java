package prac;

class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// override toString() that returns string of point object
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
	
	// implement equals
	// compare two points
	public boolean equals(Object obj) {
		Point p = (Point)obj;
		if (x == p.x && y == p.y) return true;
		else return false;
	}
}

public class ObjectPropertyEx {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getName()); //클래스 이름
		System.out.println(obj.hashCode()); // 해시코드 값
		System.out.println(obj.toString()); // 객체를 문자열로 출력
		System.out.println(obj); // 객체 출력
	}
	
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		print(p);
		
		// call toString() method
		System.out.println(p.toString());
		System.out.println(p); // automatically p to p.toString()
		System.out.println(p + "입니다.");
		
		// test equal method
		Point a = new Point(2, 3);
		Point b = new Point(2, 3);
		Point c = new Point(3, 4);
		
		if (a == b) {
			System.out.println("a == b");
		}
		if (a.equals(b)) {
			System.out.println("a is equal to b");
		}
		if (a.equals(c)) {
			System.out.println("a is equal to c");
		}
	}
}
