package qa.free.tools.selenium.toolkit.demo.phptravels;

import org.testng.annotations.Test;

import qa.free.tools.selenium.toolkit.core.base.testng.BaseTest;
import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;
import qa.free.tools.selenium.toolkit.demo.phptravels.enums.SearchType;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.PhpTravels;

public class HomePageTest_AbleToSearchAFlight extends BaseTest {

	private Customer customer = new Customer();
	
	private void setUp() {
		customer.setCityName("Montreal");
	}
	
	@Test
	public void homePage_ableToSearchAFlight() {
			setUp();
			PhpTravels
				.homePage()
				.goTo()
				.isPageLoaded()
				.searchPanel(SearchType.HOTELS)
				.setSearchCriterias(customer);
	}
	
}
