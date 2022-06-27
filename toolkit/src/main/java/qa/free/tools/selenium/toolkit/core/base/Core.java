package qa.free.tools.selenium.toolkit.core.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import qa.free.tools.selenium.synchronization.Synchronize;
import qa.free.tools.selenium.toolkit.enums.TestNgParameters;
import qa.free.tools.selenium.toolkit.interactions.browser.Navigate;
import qa.free.tools.selenium.toolkit.utilities.TestNgXml;
import qa.free.tools.selenium.webdriver.base.Driver;
import qa.free.tools.selenium.webdriver.factory.WebDriverFactory;

public abstract class Core {

		private Synchronize synchronize; // Thread concurrency already handled
		private ThreadLocal<String> testName = new ThreadLocal<>();
		private ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
		private ThreadLocal<WebElement> webElement = new ThreadLocal<>();
		private ThreadLocal<List<WebElement>> webElements = new ThreadLocal<>();
		
		public Synchronize getSynchronization() {
			return synchronize;
		}

		public void setSynchronize(Synchronize synchronize) {
			this.synchronize = synchronize;
		}

		public String getTestName() {
			return testName.get();
		}

		public void setTestName(String testName) {
			this.testName.set(testName);
		}

		public WebDriver getWebDriver() {
			return webDriver.get();
		}

		public void setWebDriver(WebDriver webDriver) {
			this.webDriver.set(webDriver); 
		}

		public WebElement getWebElement() {
			return webElement.get();
		}

		public void setWebElement(WebElement webElement) {
			this.webElement.set(webElement);
		}

		public List<WebElement> getWebElements() {
			return webElements.get();
		}

		public void setWebElements(List<WebElement> webElements) {
			this.webElements.set(webElements);
		}

		public void setFrameworkContext(ITestContext testContext) {
			setTestName(testContext.getName());
			setWebDriver(WebDriverFactory.getDriver(
					Driver.valueOf(TestNgXml.getValue(TestNgParameters.WEBDRIVER)),false)
			);
			setSynchronize(new Synchronize(getWebDriver()));
		}
	
		public void clearFrameworkContext() {
			if (getWebDriver() != null) {
				getWebDriver().quit();
			}
			this.testName.remove();
			this.webDriver.remove();
			this.webElement.remove();
			this.webElements.remove();
		}
		
		public Navigate navigate() {
			return new Navigate();
		}
		
}
 