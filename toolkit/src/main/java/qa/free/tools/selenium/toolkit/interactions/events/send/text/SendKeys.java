package qa.free.tools.selenium.toolkit.interactions.events.send.text;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;

public abstract class SendKeys extends SeleniumCore {

	public abstract void sendKeys(By by, CharSequence keysToSend);
	public abstract void sendKeys(By by, CharSequence keysToSend, boolean addKey, Keys key);
	
	public boolean isEditable(By by) {
		return true;
	}
	
}
