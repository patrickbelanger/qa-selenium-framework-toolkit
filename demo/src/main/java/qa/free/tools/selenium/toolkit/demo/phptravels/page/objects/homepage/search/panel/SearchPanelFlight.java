package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;
import qa.free.tools.selenium.toolkit.demo.phptravels.enums.Trip;

public class SearchPanelFlight extends SearchPanel {
	
	@Override
	public SearchPanelFlight goTo() {
		return null;
	}

	@Override
	public SearchPanelFlight isPageLoaded() {
		isPageLoaded(By.id("select2-hotels_city-container")); // Returns custom exception if page not loaded
		return this;
	}
	
	public SearchPanelFlight setCityName(String cityName) {
		set()
			.text(cityName)
			.against(By.xpath("//input[@class='select2-search__field']"))
			.before()
				.triggerElementUpdateAgainst(By.id("select2-hotels_city-container"), "input")
			.after()
				.pressEnter()
			.after()
				.clickMatchingTextElement(By.id("select2-hotels_city-results"))
			.execute();
		return this;
	}

	public SearchPanelFlight setTrip(Trip trip) {
		set()
			.radio(trip)
			.against(By.name("trip"))
			.execute();
		return this;
	}
	
	public SearchPanelFlight clickSearch() {
		perform()
			.click()
			.against(By.id("submit"))
			.execute();
		return this;
	}
	
	@Override
	public void setSearchCriterias(Customer customer) {
		isPageLoaded()
			.setCityName(customer.getCityName())
			.clickSearch();
	}

}
