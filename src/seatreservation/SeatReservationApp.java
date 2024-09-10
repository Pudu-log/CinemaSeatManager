package seatreservation;

import java.util.Scanner;

public class SeatReservationApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SeatReservationService seatService = new SeatReservationService();
		// 10 개의 좌석에 대한 객체 생성... 
		Seat[] seats = new Seat[10];
		int userinput = 0;
		while (true) {
			seatService.menu(seatService.availableSeats, userinput);
			userinput = sc.nextInt();
			switch (userinput) {
			case 1:
				seatService.printSeats(seats);
				break;
			case 2:
				seatService.reservation(seats);
				break;
			case 3:
				seatService.cancle(seats);
				break;
			case 4:
				return;
			}
		}   
	}


}
