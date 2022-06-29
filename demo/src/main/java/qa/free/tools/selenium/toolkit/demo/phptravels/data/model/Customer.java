package qa.free.tools.selenium.toolkit.demo.phptravels.data.model;

import java.time.LocalDate;

public class Customer {

	private String fromCountry;
	private String toCountry;
	private String cityName;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int numberRooms;
	private int numberAdults;
	private int numberChildren;
	
	public String getFromCountry() {
		return fromCountry;
	}
	
	public void setFromCountry(String fromCountry) {
		this.fromCountry = fromCountry;
	}
	
	public String getToCountry() {
		return toCountry;
	}
	
	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}
	
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	
	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	
	public int getNumberRooms() {
		return numberRooms;
	}
	
	public void setNumberRooms(int numberRooms) {
		this.numberRooms = numberRooms;
	}
	
	public int getNumberAdults() {
		return numberAdults;
	}
	
	public void setNumberAdults(int numberAdults) {
		this.numberAdults = numberAdults;
	}
	
	public int getNumberChildren() {
		return numberChildren;
	}

	public void setNumberChildren(int numberChildren) {
		this.numberChildren = numberChildren;
	}
	
}
