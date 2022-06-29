package qa.free.tools.selenium.toolkit.demo.phptravels.page.objects;

import qa.free.tools.selenium.toolkit.demo.phptravels.page.objects.homepage.HomePage;

public class PhpTravels {

	private PhpTravels() { }
	
	public static HomePage homePage() {
		return new HomePage();
	}
	
}
