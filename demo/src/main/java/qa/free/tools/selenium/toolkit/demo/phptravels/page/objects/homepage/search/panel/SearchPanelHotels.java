package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;
import qa.free.tools.selenium.toolkit.enums.Locator;

public class SearchPanelHotels extends SearchPanel<SearchPanelHotels> {
	
	@Override
	public SearchPanelHotels goTo() {
		return null;
	}

	@FindElement(locator = Locator.ID, element = "select2-hotels_city-container")
	@Override
	public SearchPanelHotels isPageLoaded() {
		isPageLoaded(getBy()); // Returns custom exception if page not loaded
		return this;
	}
	
	public SearchPanelHotels setCityName(String cityName) {
		set()
			.text(cityName)
			.against(By.xpath("//input[@class='select2-search__field']"))
			.before()
				.triggerElementUpdateAgainst(By.id("select2-hotels_city-container"), "input")
				.and()
			.after()
				.pressEnter()
				.clickMatchingTextElement(By.id("select2-hotels_city-results"))
				.and()
			.execute();
		return this;
	}

	@FindElement(locator = Locator.ID, element = "submit")
	public SearchPanelHotels clickSearch() {
		perform()
			.click()
			.against(getBy())
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
