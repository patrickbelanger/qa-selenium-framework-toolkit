package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;

public abstract class SearchPanel<T extends SearchPanel<T>> extends PageObject<T> {
	
	public abstract void setSearchCriterias(Customer customer);
	
	public SearchPanel<T> clickTabHotels() {
		perform()
			.click()
			.against(By.xpath("//button[@data-bs-target='#hotels']"))
			.execute();
		return this;
	}
	
	public SearchPanel<T> clickTabFlights() {
		perform()
			.click()
			.against(By.xpath("//button[@data-bs-target='#flights']"))
			.execute();
		return this;
	}
	
	public SearchPanel<T> clickTabTours() {
		perform()
			.click()
			.against(By.xpath("//button[@data-bs-target='#tours']"))
			.execute();
		return this;
	}
	
	public SearchPanel<T> clickTabVisa() {
		perform()
			.click()
			.against(By.xpath("//button[@data-bs-target='#visa']"))
			.execute();
		return this;
	}
	
}
