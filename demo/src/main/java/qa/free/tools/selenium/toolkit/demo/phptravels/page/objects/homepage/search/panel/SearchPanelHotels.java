package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

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
	
	@FindElement(
			locators = {
					Locator.XPATH,
					Locator.ID,
					Locator.ID
			},
			elements = {
					"//input[@class='select2-search__field']",
					"select2-hotels_city-container",
					"select2-hotels_city-results"
			}
	)
	public SearchPanelHotels setCityName(String cityName) {
		set()
			.text(cityName)
			.against(getBy(0))
			.before()
				.triggerElementUpdateAgainst(getBy(1), "input")
				.and()
			.after()
				.pressEnter()
				.clickMatchingTextElement(getBy(2))
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
