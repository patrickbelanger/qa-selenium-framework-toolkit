package qa.free.tools.selenium.toolkit.demo.phptravels.data.model;

import java.time.LocalDate;

import qa.free.tools.selenium.toolkit.demo.phptravels.enums.Trip;

public class Customer {

	private String fromDestination;
	private String toDestination;
	private String cityName;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private LocalDate departureDate;
	private LocalDate returnDate;
	private Trip tripType;
	private int numberRooms;
	private int numberAdults;
	private int numberChildren;
	
	public String getFromDestination() {
		return fromDestination;
	}
	
	public void setFromDestination(String fromDestination) {
		this.fromDestination = fromDestination;
	}
	
	public String getToDestination() {
		return toDestination;
	}
	
	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
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

	public Trip getTripType() {
		return tripType;
	}

	public void setTripType(Trip tripType) {
		this.tripType = tripType;
	}
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
}
