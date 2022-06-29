package qa.free.tools.selenium.toolkit.interactions.events.click;

import org.openqa.selenium.By;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;

public class ClickSelenium extends Click {

	public void click(By by) {
		getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by).click();
	}
	
}
