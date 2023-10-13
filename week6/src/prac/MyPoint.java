package prac;

public class MyPoint {
	int x;
	int y;
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("Point(" + this.x + "," + this.y + ")");
	}
}
