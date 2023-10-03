
import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		// cash unit
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		// 스캐너 객체 생성
		Scanner scanner = new Scanner(System.in);
		System.out.print("input price(won) : ");
		
		// 사용자로부터 입력값 받아서 num 변수에 넣기
		int num = scanner.nextInt();
		// 잔액 계산을 위한 변수
		int extra_change;
		
		// unit array의 길이 만큼 반복문을 실행
		for(int i=0; i < unit.length; i++) {
			// unit array의 0번 인덱스로부터 몫이 있으면 loop실행. 없다면 다음 loop 실행
			if(num / unit[i] > 0) {
				System.out.println(unit[i] + " : " + num / unit[i]);
				// 잔액 계산을 위해 unit array값과 몫을 곱한값을 num에서 sub 
				extra_change = unit[i] * (num / unit[i]);
				num = num - extra_change;
			}
		scanner.close();
		}
	}

}
