package qa.free.tools.selenium.toolkit.demo.phptravels;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.testng.annotations.Test;

import qa.free.tools.selenium.toolkit.core.base.testng.BaseTest;
import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;
import qa.free.tools.selenium.toolkit.demo.phptravels.enums.SearchType;
import qa.free.tools.selenium.toolkit.demo.phptravels.enums.Trip;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.PhpTravels;

public class HomePageTest_AbleToSearchAFlight extends BaseTest {

	private Customer customer = new Customer();
	
	private void setUp() { // TODO: Externalize test data into JSON
		customer.setFromDestination("YUL");
		customer.setToDestination("YTZ");
		customer.setDepartureDate(LocalDate.now());
		customer.setReturnDate(LocalDate.now().plus(2, ChronoUnit.DAYS));
		customer.setTripType(Trip.ROUND_TRIP);
	}
	
	@Test
	public void homePage_ableToSearchAFlight() {
			setUp();
			PhpTravels
				.homePage()
				.goTo()
				.searchPanel(SearchType.FLIGHT)
				.setSearchCriterias(customer);
	}
	
}
