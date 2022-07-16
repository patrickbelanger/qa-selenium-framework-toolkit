package qa.free.tools.selenium.toolkit.interactions.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AccessLevel;
import lombok.Getter;
import qa.free.tools.selenium.toolkit.core.base.FrameworkCore;

public class Navigate extends FrameworkCore {

	@Getter(AccessLevel.PRIVATE)
	static final Logger logger = LoggerFactory.getLogger(Navigate.class);
	
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
			logger.info("Navigate/GoTo method - Open url {}", url);
		} catch(Exception e) {
			//
		}
	}
	
	public void refresh() {
		try {
			getWebDriver().navigate().refresh();
		} catch(Exception e) {
			//
		}
	}
	
}
