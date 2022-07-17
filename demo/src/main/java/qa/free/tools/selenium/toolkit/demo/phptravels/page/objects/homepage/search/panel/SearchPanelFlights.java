package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import java.time.LocalDate;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;
import qa.free.tools.selenium.toolkit.demo.phptravels.enums.Trip;
import qa.free.tools.selenium.toolkit.enums.Locator;

public class SearchPanelFlights extends SearchPanel<SearchPanelFlights> {
	
	@Override
	public SearchPanelFlights goTo() {
		return null;
	}

	@FindElement(locator = Locator.ID, element = "select2-hotels_city-container")
	@Override
	public SearchPanelFlights isPageLoaded() {
		isPageLoaded(getBy()); // Returns custom exception if page not loaded
		return this;
	}
	
	public SearchPanelFlights setFlightFrom(String cityName) {
		set()
			.text(cityName)
			.against(By.name("from"))
			.after()
				.pressEnter()
				.clickMatchingTextElement(By.className("autocomplete-result"))
				.and()
			.execute();
		return this;
	}

	public SearchPanelFlights setToDestination(String cityName) {
		set()
			.text(cityName)
			.against(By.name("to"))
			.after()
				.pressEnter()
				.clickMatchingTextElement(By.className("autocomplete-result"))
				.and()
			.execute();
		return this;
	}
	
	@FindElement(locator = Locator.NAME, element = "trip")
	public SearchPanelFlights setTrip(Trip trip) {
		set()
			.radio(trip.toString())
		.against(getBy())
		.execute();
		return this;
	}
	
	@FindElement(locator = Locator.ID, element = "flights-search")
	public SearchPanelFlights clickSearch() {
		perform()
			.click()
			.against(getBy())
			.execute();
		return this;
	}

	@FindElement(locator = Locator.ID, element = "departure")
	public SearchPanelFlights setDepartureDate(LocalDate departureDate) {
		set()
			.date()
				.setSpecificDate(departureDate)
				.usingSendKeys()
				.usingDateFormatter("dd-MM-yyyy")
				.apply()
			.against(getBy())
			.before()
				.clearInput()
				.and()
			.execute();
		return this;
	}
	
	@FindElement(locator = Locator.ID, element = "return")
	public SearchPanelFlights setReturnDate(LocalDate returnDate) {
		set()
		.date()
			.setSpecificDate(returnDate)
			.usingSendKeys()
			.usingDateFormatter("dd-MM-yyyy")
			.apply()
		.against(getBy())
		.before()
			.clearInput()
			.and()
		.execute();
		return this;
	}
	
	@Override
	public void setSearchCriterias(Customer customer) {
		((SearchPanelFlights) isPageLoaded()
			.clickTabFlights())
			.setTrip(customer.getTripType())
			.setFlightFrom(customer.getFromDestination())
			.setToDestination(customer.getToDestination())
			.setDepartureDate(customer.getDepartureDate())
			.setReturnDate(customer.getReturnDate())
			.clickSearch();
	}

}
