package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.search.results;

import org.openqa.selenium.By;

public class SearchResultsFlights extends SearchResults<SearchResultsFlights> {
	
	public int getNumberTotalOfFlights() {
		try {
  		return Integer.parseInt(get()
  				.text()
  				.from(By.xpath("//ul[@class='list-items d-flex justify-content-end']/li/a")).split(":")[1].trim());
		} catch(Exception e) {
			return 0;
		}
	}
	
}
