package qa.free.tools.selenium.toolkit.interactions.events.send.text;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;

public class SendKeysSelenium extends SendKeys {
	
	@Override
	public void sendKeys(By by, CharSequence keysToSend) {
		sendKeys(by, keysToSend, false, Keys.NULL);
	}
	
	public void sendKeys(By by, CharSequence keysToSend, boolean addKey, Keys key) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by));
		getWebElement().sendKeys(keysToSend, addKey ? key : "");
	}
	
}
