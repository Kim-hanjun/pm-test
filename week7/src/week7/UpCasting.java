package week7;

class Person0 {
	String name;
	String id;
	public Person0(String name) {
		this.name = name;
	}
}

class Student0 extends Person0 {
	String grade;
	String department;
	
	public Student0(String name) {
		super(name);
	}
}

public class UpCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person0 p;
		Student0 s = new Student0("이재문");
//		p = s;
//		p.grade = "A";
	}

}
