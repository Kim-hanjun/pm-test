package prac;

class ColorPoint extends MyPoint{
	String color;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void showColorPoint(){
		System.out.print(color);
		showPoint();
	}
}
