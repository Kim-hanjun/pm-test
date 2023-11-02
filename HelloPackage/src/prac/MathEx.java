package prac;

class circle123{
	int r;
	circle123(int r){
		this.r = r;
	}
}

public class MathEx {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		
		double a = Math.PI;
		System.out.println(Math.ceil(a));
		System.out.println(Math.floor(a));
		
		System.out.println(Math.sqrt(9));
		System.out.println(Math.exp(2));
		System.out.println(Math.round(3.14));
		
		
		// 1~45 사이의 정수 랜덤값 5개 생성
		System.out.print("이번주 행운의 번호는 ");
		for (int i = 0; i < 5; i++) {
			System.out.print((int)(Math.random() * 45 + 1) + " ");
		}
			
		System.out.println();
		
		circle123 ob1 = new circle123(1);
		circle123 ob2 = new circle123(2);
		circle123 s;
		s = ob2;
		ob1 = ob2;
		System.out.print(ob2.r);
		
//		String d = new String("Hello");
//		String b = new String("Java");
//		String c = new String("Java");
		String b = "hello";
		String c = "hello";
		
		System.out.print(b==c);
		
		
		
	}

}
