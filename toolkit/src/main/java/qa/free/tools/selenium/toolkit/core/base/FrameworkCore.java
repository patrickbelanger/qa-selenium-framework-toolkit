package qa.free.tools.selenium.toolkit.core.base;

import org.testng.ITestContext;

import qa.free.tools.selenium.synchronization.Synchronize;
import qa.free.tools.selenium.toolkit.enums.TestNgParameters;
import qa.free.tools.selenium.toolkit.interactions.Perform;
import qa.free.tools.selenium.toolkit.interactions.Set;
import qa.free.tools.selenium.toolkit.interactions.browser.Navigate;
import qa.free.tools.selenium.toolkit.utilities.TestNgXml;
import qa.free.tools.selenium.webdriver.base.Driver;
import qa.free.tools.selenium.webdriver.factory.WebDriverFactory;

public abstract class FrameworkCore extends SeleniumCore {

		private static ThreadLocal<String> testName = new ThreadLocal<>();
	
		public String getTestName() {
			return testName.get();
		}

		public void setTestName(String testName) {
			FrameworkCore.testName.set(testName);
		}
	
		public void setFrameworkContext(ITestContext testContext) {
			setTestName(testContext.getName());
			setWebDriver(
					WebDriverFactory.getDriver(
					Driver.valueOf(
						TestNgXml.getValue(TestNgParameters.WEBDRIVER, Driver.CHROME)
					),
					false)
			);
			setSynchronize(new Synchronize(getWebDriver()));
		}
	
		public void clearFrameworkContext() {
			if (getWebDriver() != null) {
				getWebDriver().quit();
			}
			FrameworkCore.testName.remove();
			SeleniumCore.removeSelenium();
		}
		
		/**
		 * Set a value against an element
		 * @return {@link Set}
		 */
		@SuppressWarnings("rawtypes")
		public Set set() {
			return new Set();
		}
		
		/**
		 * Perform an action against an element
		 * @return {@link Perform}
		 */
		public Perform perform() {
			return new Perform();
		}
		
		/**
		 * Access the browser's history, navigate to a given URL, or switching frame or tab
		 * @return {@link Navigate}
		 */
		public Navigate navigate() {
			return new Navigate();
		}
		
}
 