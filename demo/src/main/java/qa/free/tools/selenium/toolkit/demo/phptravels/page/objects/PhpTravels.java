package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects;


import qa.free.tools.selenium.toolkit.demo.phptravels.enums.SearchType;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.HomePage;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.search.results.SearchResults;
import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.search.results.SearchResultsFlights;

public class PhpTravels {

	private PhpTravels() { }
	
	public static HomePage homePage() {
		return new HomePage();
	}
		
	@SuppressWarnings("rawtypes")
	public static SearchResults searchResults(SearchType searchType) {
		if (searchType.equals(SearchType.FLIGHT)) {
			return new SearchResultsFlights();
		}
		return new SearchResultsFlights(); // Temporary
	}

}
