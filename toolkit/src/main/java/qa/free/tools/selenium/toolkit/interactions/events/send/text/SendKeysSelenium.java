package qa.free.tools.selenium.toolkit.interactions.events.send.text;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;

public class SendKeysSelenium extends SendKeys {

	@Override
	public void sendKeys(By by, CharSequence keysToSend) {
		sendKeys(by, keysToSend, false);
	}
	
	public void sendKeys(By by, CharSequence keysToSend, boolean addTab) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by));
		if (triggerElementUpdate("input")) {
			setWebElements(
					getWebElement()
						.findElements(By.xpath("./child::*"))
						.stream()
						.filter(webElement -> webElement.getTagName().equals("input"))
						.collect(Collectors.toList())
			);
			setWebElement(getWebElements().get(0));
		}
		getWebElement().sendKeys(keysToSend, addTab ? Keys.TAB : "");
	}
	
}
