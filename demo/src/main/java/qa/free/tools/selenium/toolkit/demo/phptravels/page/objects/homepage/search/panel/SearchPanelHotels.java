package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;

public class SearchPanelHotels extends SearchPanel {
	
	@Override
	public SearchPanel goTo() {
		return null;
	}

	@Override
	public SearchPanel isPageLoaded() {
		return null;
	}
	
	public void setCityName(String cityName) {
		set().text(cityName).against(By.id("select2-hotels_city-container")).execute();
	}

	public void clickSearch() {
		perform().click().against(By.id("submit")).execute();
	}
	
	@Override
	public void setSearchCriterias(Customer customer) {
		setCityName(customer.getCityName());
		clickSearch();
	}

	

}
