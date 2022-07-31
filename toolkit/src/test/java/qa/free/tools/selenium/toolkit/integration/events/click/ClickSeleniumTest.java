package qa.free.tools.selenium.toolkit.integration.events.click;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.testng.BaseTest;
import qa.free.tools.selenium.toolkit.interactions.events.click.Click;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickSelenium;

public class ClickSeleniumTest extends BaseTest {

	private Click underTest;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		underTest = new ClickSelenium();
	}
		
	@Test
	public void click_by_ableToClickOnElement() {
		navigate().goTo("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
		getSynchronization().synchronizeWebDriverInstance(SynchronizationMethods.FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT, 
				By.id("iframeResult"));
		underTest.click(By.tagName("button"));
		assertEquals(getSynchronization().synchronizeAlert().getText(), "Hello world!");
		getSynchronization().synchronizeAlert().accept();
	}
	
	@Test
	public void click_webElement_ableToClickOnElement() {
		navigate().goTo("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
		getSynchronization().synchronizeWebDriverInstance(SynchronizationMethods.FRAME_TO_BE_AVAILABLE_AND_SWITCH_TO_IT, 
				By.id("iframeResult"));
		underTest.click(getSynchronization().synchronizeWebElement(SynchronizationMethods.ELEMENT_TO_BE_CLICKABLE, 
				By.tagName("button")));
		assertEquals(getSynchronization().synchronizeAlert().getText(), "Hello world!");
		getSynchronization().synchronizeAlert().accept();
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		underTest = null;
	}
	
}
