package qa.free.tools.selenium.toolkit.core.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qa.free.tools.selenium.synchronization.Synchronize;
import qa.free.tools.selenium.toolkit.core.reporter.Reporter;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public abstract class SeleniumCore {

	private static ThreadLocal<Reporter> reporter = new ThreadLocal<>();
	private static Synchronize synchronize; // Already thread-safe by design
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	private static ThreadLocal<WebElement> webElement = new ThreadLocal<>();
	private static ThreadLocal<List<WebElement>> webElements = new ThreadLocal<>();
	
	public Synchronize getSynchronization() {
		return synchronize;
	}

	public static void setSynchronize(Synchronize synchronize) {
		SeleniumCore.synchronize = synchronize;
	}
	
	public Reporter getReporter() {
		return reporter.get();
	}
	
	public void setReporter(Reporter reporter) {
		SeleniumCore.reporter.set(reporter); 
	}
	
	public WebDriver getWebDriver() {
		return webDriver.get();
	}
	
	public void setWebDriver(WebDriver webDriver) {
		SeleniumCore.webDriver.set(webDriver); 
	}

	public WebElement getWebElement() {
		return webElement.get();
	}
	public void setWebElement(WebElement webElement) {
		SeleniumCore.webElement.set(webElement);
	}

	public List<WebElement> getWebElements() {
		return webElements.get();
	}

	public void setWebElements(List<WebElement> webElements) {
		SeleniumCore.webElements.set(webElements);
	}

	protected static void removeSelenium() {
		SeleniumCore.reporter.remove();
		SeleniumCore.webDriver.remove();
		SeleniumCore.webElement.remove();
		SeleniumCore.webElements.remove();
	}
	
	public boolean isCustomElement(String expectedHtmlTag) {
		return !getWebElement().getTagName().equals(expectedHtmlTag);
	}
	
	public boolean clickIfUnexpectedElement(String expectedHtmlTag) {
		if (isCustomElement(expectedHtmlTag)) {
			getWebElement().click();
			return true;
		}
		return false;
	}
}
