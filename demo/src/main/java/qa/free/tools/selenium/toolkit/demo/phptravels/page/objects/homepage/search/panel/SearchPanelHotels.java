package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;

public class SearchPanelHotels extends SearchPanel {
	
	@Override
	public SearchPanelHotels goTo() {
		return null;
	}

	@Override
	public SearchPanelHotels isPageLoaded() {
		isPageLoaded(By.id("select2-hotels_city-container")); // Returns custom exception if page not loaded
		return this;
	}
	
	public SearchPanelHotels setCityName(String cityName) {
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

	public SearchPanelHotels clickSearch() {
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
