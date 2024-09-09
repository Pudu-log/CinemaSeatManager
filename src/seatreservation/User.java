package seatreservation;

public class User {
	String name;
	String phone;
	
	//생성자
	//reservation(Seat[] seats)  좌석정보 객체 생성 
	public User(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

}