package week7;

class Menu {
	int price;
	Menu(int price) {
		this.price = price;
	}
}

class Steak extends Menu {
	String name = "hj";
	Steak(){
		super(30000);
	}
	public String toString() {
		return "스테이크123";
	}
	public String hello() {
		return "맛있게드세요";
	}
}

class Customer {
	void choice(Menu menu) {
		System.out.println(menu.toString() + " 가격은 " + menu.price + "입니다");
	}
}

public class UpCastingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu steak = new Steak();
		Customer c = new Customer();
		c.choice(steak);
	}

}
