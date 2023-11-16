package project;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Variables{
	// V,S,A,B 4 종류와 각각 30석의 자리, 해당 좌석 정보가 들어가는 배열 생성
	String[][][] seat = new String[4][30][5];
	int Menu_num;
	String seat_type;
	int seat_num1;
	int seat_num2;
	int seat_cnt;
	String name;
	String digit;
	String[] seat_Array = {"V", "S", "A", "B"};
	List<String> seat_list = new ArrayList<>(Arrays.asList(seat_Array));
	List<Integer> seat_num_list = new ArrayList<>();
	InputMismatchException e = new InputMismatchException();
	public Variables() {
		Menu_num = 0;
		seat_type = "";
		seat_num1 = 0;
		seat_num2 = 0;
		seat_cnt = 0;
		name = "";
		digit = "";
		seat_num_list.clear();
		for (int i = 1; i <= 30; i++) {
			seat_num_list.add(i);
		}
	}
	
	public void Search_Seat(){
		for(int i = 0; i <= 3 ; i++) {
			for(int k = 0; k <= 29; k++) {
				System.out.println(seat[i][k]);
			}
		}
	}
}
class Menu extends Variables{
	boolean meneger;
	public Menu() {
		super();
	}
	public Menu(boolean meneger) {
		this.meneger = true;
	}
	public void MenuPage() {
		System.out.println("원하는 메뉴를 선택하세요. (원하는 메뉴의 숫자를 입력해주세요.)");
		if(meneger == true) System.out.println("1.예약, 2.조회, 3.예약취소, 4.예약프로그램 종료, 99.예약좌석 초기화");
		else System.out.println("1.예약, 2.조회, 3.예약취소, 4.예약프로그램 종료");
		Scanner scanner = new Scanner(System.in);
        try {
        	Menu_num = scanner.nextInt();
            if(Menu_num == 1) {
            	System.out.println("예약메뉴");
            	Reservation();
            }
            else if(Menu_num == 2) {
            	System.out.println("조회메뉴");
            	Search_Seat();
            }
            else if(Menu_num == 3) {
            	System.out.println("예약취소메뉴");
            	Cancel_Seat();
            }
            else if(Menu_num == 4) {
            	System.out.println("예약 프로그램을 종료합니다.");
            }
            // 관리자모드 초기화 기능
            else if(Menu_num == 99) {
            	System.out.println("모든 예약 좌석을 초기화 합니다.");
            	for (int i = 0; i < seat.length; i++) {
                    for (int j = 0; j < seat[i].length; j++) {
                        for (int k = 0; k < seat[i][j].length; k++) {
                            seat[i][j][k] = null;
                        }
                    }
            	}
            	MenuPage();
            }
            // 1~4번 외의 메뉴를 선택했을때 exception handling
            else {
            	throw e;
            }
        } catch (InputMismatchException e) {
        	System.out.println("해당 메뉴는 없는 메뉴입니다. 다시 선택해주세요.");
            MenuPage();
        }
        scanner.close();
	}
	
	public void Reservation() {
		while(true) {
			try {
				System.out.println("V, S, A, B 중 원하시는 좌석 종류를 선택해주세요.");
				Scanner scanner = new Scanner(System.in);
				seat_type = scanner.next();
				if (seat_list.contains(seat_type)){
					System.out.println(seat_type + "좌석 타입 선택");
					break;
				}
				else {
	            	throw e;
				}
			} catch (InputMismatchException e) {
	        	System.out.println("해당 좌석은 없는 좌석입니다. 다시 선택해주세요.");
			}
		}
		while(true) {   	
			try {
				System.out.println("몇 개의 좌석을 예약하시겠습니까? 1 or 2");
				Scanner scanner = new Scanner(System.in);
				seat_cnt = scanner.nextInt();
				if(seat_cnt==1 || seat_cnt==2) {
					System.out.println(seat_cnt + "개의 좌석을 선택해주세요");
					break;
				}
				else throw e;
				
			} catch (InputMismatchException e) {
	        	System.out.println("한 좌석이나 두 좌석만 예약 가능합니다. 다시 선택해주세요.");
	        	continue;
			}
		}
		if(seat_cnt==1) {
			while(true) {	
				try {
					System.out.println("1 ~ 30번 중 원하시는 좌석 번호를 선택해주세요.");
					Scanner scanner = new Scanner(System.in);
					seat_num1 = scanner.nextInt();
					if (seat_num_list.contains(seat_num1)){}
					else {
		            	throw e;
					}
					if (seat[seat_list.indexOf(seat_type)][seat_num1-1][0] != null) {
						System.out.println(seat_num1 + "번 좌석은 이미 예약된 좌석입니다. 다른 좌석번호를 선택해주세요.");
						continue;
					}
					break;
				} catch (InputMismatchException e) {
		        	System.out.println("1 ~ 30번 좌석만 예약 가능합니다. 다시 선택해주세요.");
		        	continue;
				}
			}
			System.out.println("이름과 전화번호를 입력해주세요 ex)홍길동 010-0000-0000");
			Scanner scanner = new Scanner(System.in);
			name = scanner.next();
			digit = scanner.next();
			int name_cnt = 0;
			for(int i = 0; i <= 3; i++) {
				for(int k = 0; k <= 29; k++) {
//					System.out.println(seat[i][k][2]);
					if(seat[i][k][2] == null) {}
					else if(seat[i][k][2].equals(name)) name_cnt += 1;
				}
			}
			System.out.println(name_cnt);
			if(name_cnt == 2) {
				System.out.println("해당 예약자는 이미 2좌석을 예약하였으므로 예약이 불가합니다.");
				MenuPage();
			}
			String reserv_num = get_Reserv_Num(digit, seat_type, seat_num1);
			reserv_seat(seat_type, seat_num1, name, digit, reserv_num);
//			System.out.println(Arrays.toString(seat[seat_list.indexOf(seat_type)][seat_num1]));
			System.out.println("예약이 완료되었습니다. 예약번호 : " + reserv_num);
			
			
		}
		if(seat_cnt==2) {
			while(true) {
				try {
					System.out.println("1 ~ 30번 중 원하시는 좌석 번호 2개를 선택해주세요.");
					Scanner scanner = new Scanner(System.in);
					seat_num1 = scanner.nextInt();
					seat_num2 = scanner.nextInt();
					if (seat_num_list.contains(seat_num1)){
						System.out.println(seat_num1 + "좌석 번호 선택");
					}
					else {
		            	throw e;
					}
					if (seat[seat_list.indexOf(seat_type)][seat_num1-1][0] != null) {
						System.out.println(seat_num1 + "번 좌석은 이미 예약된 좌석입니다. 다른 좌석번호를 선택해주세요.");
						continue;
					}
					if (seat_num_list.contains(seat_num2)){
						System.out.println(seat_num2 + "좌석 번호 선택");
					}
					else {
		            	throw e;
					}
					if (seat[seat_list.indexOf(seat_type)][seat_num2-1][0] != null) {
						System.out.println(seat_num2 + "번 좌석은 이미 예약된 좌석입니다. 다른 좌석번호를 선택해주세요.");
						continue;
					}
					break;
				} catch (InputMismatchException e) {
		        	System.out.println("1 ~ 30번 좌석만 예약 가능합니다. 다시 선택해주세요.");
		        	continue;
				}
			}
			System.out.println("이름과 전화번호를 입력해주세요 ex)홍길동 010-0000-0000");
			Scanner scanner = new Scanner(System.in);
			name = scanner.next();
			digit = scanner.next();
			int name_cnt = 0;
			for(int i = 0; i <= 3; i++) {
				for(int k = 0; k <= 29; k++) {
					if(seat[i][k][2] == null) {}
					else if(seat[i][k][2].equals(name)) name_cnt += 1;
				}
			}
			if(name_cnt == 1) {
				System.out.println("해당 예약자는 이미 한 좌석을 예약하였으므로 두 좌석 예약이 불가합니다.");
				MenuPage();
			}
			if(name_cnt == 2) {
				System.out.println("해당 예약자는 이미 두 좌석을 예약하였으므로 예약이 불가합니다.");
				MenuPage();
			}
			String reserv_num = get_Reserv_Num(digit, seat_type, seat_num1, seat_num2);
			
			reserv_seat(seat_type, seat_num1, name, digit, reserv_num);
			reserv_seat(seat_type, seat_num2, name, digit, reserv_num);
			
//			System.out.println(Arrays.toString(seat[seat_list.indexOf(seat_type)][seat_num1]));
			System.out.println("예약이 완료되었습니다. 예약번호 : " + reserv_num);
			
		}
		MenuPage();
	}
	//좌석별 예약 현황을 볼 수 있도록 기능 추가, 오버라이딩 이걸로 쓰기. for문 두개 도는걸로 조회. 다른 기능을 추가하고 싶을때 다른 클래스에서 충분히 사용 가능
	public void Search_Seat(){
		for(int i = 0; i <= 3 ; i++) {
			for(int k = 0; k <= 29; k++) {
				String seat_type_search = seat_list.get(i);
				if(seat[i][k][0]==null) {
					System.out.println(seat_type_search + "_" + (k+1) + " : 예약가능" );
				}
				else {
					String reserv_name = seat[i][k][2];
					String reserv_number = seat[i][k][4];
					System.out.println(seat_type_search + "_" + (k+1) + " : " + reserv_number + " " + reserv_name);
					
				}
			}
		}
		MenuPage();
	}
	
	public void Cancel_Seat() {
	    System.out.println("이름, 전화번호, 예약번호중 하나를 통하여 예약취소가 가능합니다. 원하시는 종류의 취소를 선택해주세요.(1 or 2 or 3)");
		System.out.println("1.이름 , 2.전화번호 , 3.예약번호");
		System.out.println("번호와 함께 조회하려는 해당 항목의 이름이나 전화번호나 예약번호를 적어주세요.");
		System.out.println("ex1) 1 김한준    ex2) 2 010-0000-0000    ex3) 3 0000230");
		Scanner scanner = new Scanner(System.in);
		int cancel_type = scanner.nextInt();
		String cancel_var = scanner.next();
		
		try {
            if(cancel_type == 1) {
            	int name_exist = 0;
            	for(int i = 0; i <= 3; i++) {
            		for(int k = 0; k <= 29; k++) {
            			if(seat[i][k][2] == null) {}
            			else if(seat[i][k][2].equals(cancel_var)) {
            				for(int j = 0; j <= 4; j++) {
            					seat[i][k][j] = null;            					
            				}
            				name_exist += 1;
            			}
            		}
            	}
            	if(name_exist == 0) {
            		System.out.println(cancel_var + " 는 예약 명단에 없습니다. 에약자명을 확인해주세요");
            		Cancel_Seat();
            	}
            }
            else if(cancel_type == 2) {
            	int digit_exist = 0;
            	for(int i = 0; i <= 3; i++) {
            		for(int k = 0; k <= 29; k++) {
            			if(seat[i][k][3] == null) {}
            			else if(seat[i][k][3].equals(cancel_var)) {
            				for(int j = 0; j <= 4; j++) {
            					seat[i][k][j] = null;            					
            				}
            				digit_exist += 1;
            			}
            		}
            	}
            	if(digit_exist == 0) {
            		System.out.println(cancel_var + " 는 예약 명단에 없습니다. 전화번호를 확인해주세요");
            		Cancel_Seat();
            	}
            }
            else if(cancel_type == 3) {
            	int reserv_num_exist = 0;
            	for(int i = 0; i <= 3; i++) {
            		for(int k = 0; k <= 29; k++) {
            			if(seat[i][k][4] == null) {}
            			else if(seat[i][k][4].equals(cancel_var)) {
            				for(int j = 0; j <= 4; j++) {
            					seat[i][k][j] = null;            					
            				}
            				reserv_num_exist += 1;
            			}
            		}
            	}
            	if(reserv_num_exist == 0) {
            		System.out.println(cancel_var + " 는 예약 명단에 없습니다. 예약번호를 확인해주세요");
            		Cancel_Seat();
            	}
            }            
            else {
            	throw e;
            }
        } catch (InputMismatchException e) {
        	System.out.println("해당 메뉴는 없는 메뉴입니다. 다시 선택해주세요.");
        	Cancel_Seat();
        }
		MenuPage();
	}
	
	public String get_Reserv_Num(String phone_num, String seat_type, int seat_num) {
		int length = phone_num.length();
		String lastfourdigit = phone_num.substring(length - 4);
		return lastfourdigit + (seat_list.indexOf(seat_type)+1) + seat_num;
	}
	//메소드 오버로딩- 예약 번호를 만들때 두자리를 예약하는 경우를 따로 생각해야해서 사용
	public String get_Reserv_Num(String phone_num, String seat_type, int seat_num1, int seat_num2) {
		int length = phone_num.length();
		String lastfourdigit = phone_num.substring(length - 4);
		return lastfourdigit + (seat_list.indexOf(seat_type)+1) + seat_num1 + seat_num2;
	}
	
	public void reserv_seat(String seat_type, int seat_num, String name, String digit, String reserv_num) {
		seat_num = seat_num-1;
		seat[seat_list.indexOf(seat_type)][seat_num][0] = seat_type;
		seat[seat_list.indexOf(seat_type)][seat_num][1] = String.valueOf(seat_num1);
		seat[seat_list.indexOf(seat_type)][seat_num][2] = name;
		seat[seat_list.indexOf(seat_type)][seat_num][3] = digit;
		seat[seat_list.indexOf(seat_type)][seat_num][4] = reserv_num;
	}
	
}



public class Concert_Reservation {

	public static void main(String[] args) {
		System.out.println("모드를 선택하세요");
		System.out.println("1.일반 고객, 2.관리자");
		Scanner scanner = new Scanner(System.in);
		int menege_num = scanner.nextInt();
		if(menege_num == 1) {
			Menu menu = new Menu();
			menu.MenuPage();
		}
		if(menege_num == 2) {
			Menu menu = new Menu(true);
			menu.MenuPage();
		}
		scanner.close();
		
	}

}
