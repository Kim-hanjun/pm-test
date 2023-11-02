import java.util.Scanner;

public class GradingSwitch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char grade;
		System.out.print("점수를 입력하세요(0~100) : ");
		int score = scanner.nextInt();
		switch (score/10) {
		case 10:
		case 9:
			grade = 'A';
			System.out.println("학점은 " + grade + "입니다.");
//			break;
		case 8:
			grade = 'B';
			System.out.println("학점은 " + grade + "입니다.");
//			break;
		case 7:
			grade = 'C';
			System.out.println("학점은 " + grade + "입니다.");
//			break;
		case 6:
			grade = 'D';
			System.out.println("학점은 " + grade + "입니다.");
//			break;
		default:
			grade = 'F';
			System.out.println("학점은 " + grade + "입니다.");
		}
//		System.out.println("학점은 " + grade + "입니다.");
		scanner.close();
	}

}
