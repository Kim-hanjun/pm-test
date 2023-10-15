package prac;
import java.util.Scanner;

class PhoneBookSave {
	String name;
	String number;
	
	// 기본 생성자
	public PhoneBookSave() {}
	
	// name과 number을 받아서 클래스변수에 저장하는 생성자
	public PhoneBookSave(String name, String number) {
		this.name = name;
		this.number = number;
	}
}

public class PhoneBook {
	public static void main(String[] args) {
		Scanner person_cnt_tmp = new Scanner(System.in);
		Scanner NameAndNumber = new Scanner(System.in);
		Scanner FindName_tmp = new Scanner(System.in);
		
		System.out.print("Number of Person>>");
		// scanner로 몇명의 이름과 번호를 저장할지 받는다.
		int person_cnt = person_cnt_tmp.nextInt();
		
		//입력받은 숫자로 object array 생성
		PhoneBookSave [] pb;
		pb = new PhoneBookSave[person_cnt];
		
		for(int i = 0; i < person_cnt; i++) {
			System.out.print("Name and Phonenumber (ex. 홍길동 010-1234-5678) >> ");
			
			// creating object and assign to each element array
			pb[i] = new PhoneBookSave(NameAndNumber.next(), NameAndNumber.next());
		}
		System.out.println("Store Done");
		
		for (;;) {
			System.out.print("Name to search >> ");
			// 찾을 이름 scanner로 받기
			String FindName = FindName_tmp.next();
			
			// String 자체로 불리언 비교하려는데 안돼서 해본 노력
//			System.out.println(FindName.getClass().getName());
//			System.out.println(pb[0].name.getClass().getName());
//			System.out.println(FindName == pb[0].name);
			
			// 아래처럼 하니 String 비교가 안됨. 따라서 equals를 사용한다
//			if (FindName == "Stop")
			if (FindName.equals("Stop"))
				break;
			// pb array 안에 찾으려는 이름과 같은 이름이 있는지 없는지 확인하는 변수. 없으면 0유지, 있으면 0이 아닌 값 
			int not_found = 0;
			for(int j = 0; j < pb.length; j++) {
//				if (pb[j].name == FindName) {
				if (FindName.equals(pb[j].name)) {
					System.out.println(pb[j].name + " 's number is " + pb[j].number);
					not_found += 1;
				}
			}
			if (not_found == 0)
				System.out.println(FindName + " not found");
			
		}
		// scanner가 for문 안에 들어가있어서 .close(); 를 써도 warning이 사라지지 않는다.
		// 강의자료 예제에도 for문 안에 스캐너가 들어가있는 예제가 있는데 그 경우에 마지막에 close를 하지 않았기 때문에
		// 여기서도 close를 하지 않겠다. 실행에는 문제가 없다.
//		person_cnt_tmp.close();
//		NameAndNumber.close();
//		FindName_tmp.close();
		
	}
}
