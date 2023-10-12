package prac;

class Calc {
	public static int abs(int a) {return a>0?a:-a;}
	public static int max(int a, int b) {return (a>b)?a:b;}
	public static int min(int a, int b) {return (a>b)?b:a;}
}

public class CalEx {

	public static void main(String[] args) {
		// static 덕분에 인스턴스 호출 없이도 메소드 호출 가능
		System.out.println(Calc.abs(-5));
		System.out.println(Calc.max(10, 8));
		System.out.println(Calc.min(-3, -8));
	}

}
