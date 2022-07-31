package qa.free.tools.selenium.toolkit.integration.send.keys;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.testng.BaseTest;
import qa.free.tools.selenium.toolkit.interactions.events.send.keys.SendKeys;
import qa.free.tools.selenium.toolkit.interactions.events.send.keys.SendKeysSelenium;

public class SendKeysSeleniumTest extends BaseTest {

	private SendKeys underTest;
	private static final String FIRST_NAME = "John";
	private static final String LAST_NAME = "Smith";
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		underTest = new SendKeysSelenium();
	}
		
	@Test
	public void click_by_ableSendKeys() {
		navigate().goTo("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_text");
		getSynchronization().synchronizeWebDriverInstance(SynchronizationMethods.FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT, 
				By.id("iframeResult"));
		underTest.sendKeys(By.id("fname"), FIRST_NAME);
		underTest.sendKeys(By.id("lname"), LAST_NAME);
		assertEquals(getWebDriver().findElement(By.id("fname")).getAttribute("value"), FIRST_NAME);
		assertEquals(getWebDriver().findElement(By.id("lname")).getAttribute("value"), LAST_NAME);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		underTest = null;
	}
	
}
