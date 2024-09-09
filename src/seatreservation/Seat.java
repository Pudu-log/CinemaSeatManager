package seatreservation;

public class Seat {
	//좌석번호
	int no ;
	User user;
	boolean isReservation;
	
	public Seat(int no, User user, boolean isReservation) {
		this.no = no;
		this.user = user;
		this.isReservation = isReservation;
	}
	
	void setIsRv(boolean isReservation) {
		this.isReservation = isReservation;
		// 갱신 
	}
	String getIsRv() {
		if(isReservation = false) {
			return "예약가능";
		}else {
			return "예약불가";
		}
	}
	
	//유저 객체 생성 
	void setUser(String name, String phone) {
		this.user = new User(name, phone);
	}
	String getUserName(){
		return user.name;
	}
	String getUserPhone(){
		return user.phone;
	}
	
}
