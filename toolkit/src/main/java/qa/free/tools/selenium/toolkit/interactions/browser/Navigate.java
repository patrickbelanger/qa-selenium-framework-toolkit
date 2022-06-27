package qa.free.tools.selenium.toolkit.interactions.browser;

import qa.free.tools.selenium.toolkit.core.base.Core;

public class Navigate extends Core {

	public void back() {
		try {
			getWebDriver().navigate().back();
		} catch(Exception e) {
			//
		}
	}
	
	public void forward() {
		try {
			getWebDriver().navigate().forward();
		} catch(Exception e) {
			//
		}
	}
	
	public void goTo(String url) {
		try {
			getWebDriver().navigate().to(url);
		} catch(Exception e) {
			//
		}
	}
	
	public void refresh(String url) {
		try {
			getWebDriver().navigate().to(url);
		} catch(Exception e) {
			//
		}
	}
	
}
