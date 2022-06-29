package qa.free.tools.selenium.toolkit.interactions.events.click;

import org.openqa.selenium.By;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;

public abstract class Click extends SeleniumCore {

	public abstract void click(By by);
	
	public boolean isClickable(By by) {
		return getSynchronization().synchronizeWebElement(SynchronizationMethods.ELEMENT_TO_BE_CLICKABLE, by) != null;
	}
	
}
