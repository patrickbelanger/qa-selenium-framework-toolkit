package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.search.panel;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.demo.phptravels.data.model.Customer;

public abstract class SearchPanel extends PageObject<SearchPanel> {
	
	public abstract void setSearchCriterias(Customer customer);
	
}
