import java.util.Scanner;

public class clap {

	public static void main(String[] args) {
		// 스캐너 객체 생성
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter interger value 1~99 : ");
		
		//사용자로부터 입력값 받아서 num 변수에 넣기
		int num = scanner.nextInt();
		// 3 6 9 숫자 개수를 세기 위한 변수
		int i = 0;
		
		//십의자리 수가 3,6,9중 하나인지 확인 (10으로 나눠 몫 확인)
		if(num / 10 == 3 || num / 10 == 6 || num / 10 == 9)
			i++;
		//일의자리 수가 3,6,9중 하나인지 확인 (10으로 나눠 나머지 확인)
		if(num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
			i++;
		
		//3 or 6 or 9 가 숫자에 없을 때
		if(i == 0)
			System.out.println("No 3, 6, or 9");
		if(i == 1)
			System.out.println("박수짝");
		if(i == 2)
			System.out.println("박수짝짝");
		// 스캐너 닫기
		scanner.close();
	}

}
