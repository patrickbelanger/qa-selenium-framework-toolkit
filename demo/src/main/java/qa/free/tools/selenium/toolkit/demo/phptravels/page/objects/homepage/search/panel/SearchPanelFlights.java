package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;
import qa.free.tools.selenium.toolkit.demo.phptravels.enums.Trip;

public class SearchPanelFlights extends SearchPanel<SearchPanelFlights> {
	
	@Override
	public SearchPanelFlights goTo() {
		return null;
	}

	@Override
	public SearchPanelFlights isPageLoaded() {
		isPageLoaded(By.id("select2-hotels_city-container")); // Returns custom exception if page not loaded
		return this;
	}
	
	public SearchPanelFlights setFlightFrom(String cityName) {
		set()
			.text(cityName)
			.against(By.name("from"))
			.after()
				.pressEnter()
			.after()
				.clickMatchingTextElement(By.className("autocomplete-result"))
			.execute();
		return this;
	}

	public SearchPanelFlights setToDestination(String cityName) {
		set()
			.text(cityName)
			.against(By.name("to"))
			.after()
				.pressEnter()
			.after()
				.clickMatchingTextElement(By.className("autocomplete-result"))
			.execute();
		return this;
	}
	
	public SearchPanelFlights setTrip(Trip trip) {
		set()
			.radio(trip)
			.against(By.name("trip"))
			.execute();
		return this;
	}
	
	public SearchPanelFlights clickSearch() {
		perform()
			.click()
			.against(By.id("flights-search"))
			.execute();
		return this;
	}

	public SearchPanelFlights setDepartureDate(LocalDate departureDate) {
		set()
			.date()
				.plus(2, ChronoUnit.DAYS)
			.date()
				.setCalendarContainer(By.xpath("//div[contains(@class,'datepicker dropdown-menu') and contains(@style,'block')]"))
			.against(By.id("departure"))
			.execute();
		return this;
	}
	
	public SearchPanelFlights setReturnDate(LocalDate returnDate) {

		return this;
	}
	
	@Override
	public void setSearchCriterias(Customer customer) {
		((SearchPanelFlights) isPageLoaded()
			.clickTabFlights())
			.setTrip(customer.getTripType())
			.setFlightFrom(customer.getFromDestination())
			.setToDestination(customer.getToDestination())
			.clickSearch();
	}

}
