package qa.free.tools.selenium.toolkit.interactions.browser;

import qa.free.tools.selenium.toolkit.core.base.FrameworkCore;

public class Navigate extends FrameworkCore {

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
