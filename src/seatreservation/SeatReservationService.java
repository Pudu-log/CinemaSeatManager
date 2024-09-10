package seatreservation;

import java.util.Scanner;

public class SeatReservationService {
	int availableSeats = 0;
	Scanner sc = new Scanner(System.in);
	void menu(int cnt, int userinput) {
		
		if (cnt < 10) {		
			System.out.println("1. 좌석 현황 확인");
			System.out.println("2. 좌석 예매하기 - 예매가능 좌석 : " + (10 - cnt));
			System.out.println("3. 좌석 예매 취소하기");
			System.out.println("4. 종료하기");
		} else if (cnt == 10) {
			// 모든 좌석이 차면 예약은 불가하지만 취소는할 수 있게
			System.out.println("1. 좌석 현황 확인");
			System.out.println("[사용불가] 좌석 예매하기 - 예매가능 좌석 : " + (10 - cnt));
			System.out.println("3. 좌석 예매 취소하기");
			System.out.println("4. 종료하기");

		}

	}

	void printSeats(Seat[] seats) {
		// 순회하여 좌석 출력
		// 예매하시겠습니까... 예약할 좌석 표시 -> 번호로 선택
		// 배열을+1해서 i값을그대로 쓸 수도 있음....
		System.out.println("----- 좌석 현황 -----");
		for (int i = 0; i < seats.length; i++) {
			// 예약된 좌석이라면 예약되었다고 나오게하기 - null인지 먼저 체크해야함.
			if (seats[i] == null || seats[i].isReservation == false) {
				System.out.println("[*예매가능]" + " 좌석-" + (i + 1));
			} else if (seats[i].isReservation == true) {
				System.out.print("[예매불가]" + " 좌석-" + (i + 1));
				// 예약자 정보 출력
				System.out.println("[예약자: " + seats[i].getUserName() + "  전화번호: " + seats[i].getUserPhone() + "]");
			}
		}
		System.out.println("------------------");
	}

	void reservation(Seat[] seats) {
		System.out.println("\n 예매할 좌석을 선택해주세요");
		int input;
		input = sc.nextInt() - 1; // 인덱스에 접근하기 위해 -1
		if (seats[input] == null) {
			// 좌석정보 객체 생성
			System.out.println("예약자 이름 : ");
			String name = sc.next();
			System.out.println("예약자 전화번호 : ");
			String phone = sc.next();
			User user = new User(name, phone); // 예약자 정보 생성
			seats[input] = new Seat(input, user, true);
			availableSeats++;
			// 예매완료
			System.out.println("[좌석 " + (input + 1) + "] 예매완료");
			System.out.println("예약 여부 : " + seats[input].isReservation);
			System.out.println("----------------------------");

		} else if (seats[input].isReservation == true) {

		}
	}

	void cancle(Seat[] seats) {
		System.out.println("예매를 취소할 좌석을 입력해주세요 ");
		int userinput = sc.nextInt() - 1;
		// 이미 예약이 가능하다면 //null인 경우 먼저 체크
		if(seats[userinput] == null) {
			System.out.println("예매되지 않은 좌석 입니다. 예매해주세요!");
		}else if (seats[userinput].isReservation == false) {
			System.out.println("이미 예약 가능합니다.");
		} else {
			seats[userinput].isReservation = false;
			availableSeats--;
			System.out.println("[좌석 " + (userinput + 1) + "] 취소완료");
		}
	}

	void ifFullcancleAndClose(Seat[] seats) {
		System.out.println("모두 예약 되었습니다.");
		System.out.println("1. 좌석 예매 취소하기");
		System.out.println("2. 종료");
		int userinput = sc.nextInt();
		if (userinput == 1) {
			cancle(seats);
		} else if (userinput == 2) {
			return;
		}
	}

}
