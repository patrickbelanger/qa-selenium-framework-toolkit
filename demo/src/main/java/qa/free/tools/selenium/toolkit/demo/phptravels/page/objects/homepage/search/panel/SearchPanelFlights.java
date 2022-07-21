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
	
	@FindElement(
			locators = {
					Locator.NAME,
					Locator.CLASS_NAME
			}, 
			elements = {
					"from",
					"autocomplete-result"
			}
	)
	public SearchPanelFlights setFlightFrom(String cityName) {
		return setDestination(cityName, getBy(0), getBy(1));
	}

	@FindElement(
			locators = {
					Locator.NAME,
					Locator.CLASS_NAME
			}, 
			elements = {
					"to",
					"autocomplete-result"
			}
	)
	public SearchPanelFlights setToDestination(String cityName) {
		return setDestination(cityName, getBy(0), getBy(1));
	}
	
	private SearchPanelFlights setDestination(String textToMatch, By against, By clickMatchingElement) {
		set()
  		.text(textToMatch)
  		.against(against)
  		.after()
  			.pressEnter()
  			.clickMatchingTextElement(clickMatchingElement)
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
