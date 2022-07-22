package qa.free.tools.selenium.toolkit.interactions.elements.type;

import org.openqa.selenium.By;

import lombok.Getter;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeys;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysSelenium;

public class Input extends SeleniumCore {

	@Getter
	private Using using;
	private SendKeys sendKeys;
	
	public Input() {
		this(Using.JAVASCRIPT);
	}
	
	public Input(Using using) {
		this.using = using;
		this.sendKeys = using.equals(Using.JAVASCRIPT) ? new SendKeysJavascript() : new SendKeysSelenium();
	}
	
	public void sendKeys(By by, CharSequence text) {
			this.sendKeys.sendKeys(by, text);
	}
	
}
