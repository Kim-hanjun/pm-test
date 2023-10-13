package prac;

class Person {
	private int weight;
	int age;
	protected int height;
	public String name;

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getweight() {
		return weight;
	}
	
	public String toString() {
		return "name : " + this.name + " age : " + this.age + " height : " + this.height + " weight : " + this.weight;
	}
}

class NewStudent extends Person {
	public void set() {
		setWeight(70);
		age = 24;
		height = 177;
		name = "HJ";
	}
}

public class InheritanceEx {

	public static void main(String[] args) {
		NewStudent s = new NewStudent();
		s.set();
		System.out.println(s.toString());
	}

}
