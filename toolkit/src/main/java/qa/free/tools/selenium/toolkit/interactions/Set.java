package qa.free.tools.selenium.toolkit.interactions;

import qa.free.tools.selenium.toolkit.exceptions.TextOrValueNotSpecifiedException;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeys;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysSelenium;
import qa.free.tools.selenium.toolkit.utilities.PredicateHelper;

public class Set extends Interaction<Set> {

	private String text;
	private SendKeys sendKeys;
	
	public Set() {
		setBefore(new Before(this));
		setAfter(new After(this));
	}
	
	public Set text(String text) {
		this.text = text;
		this.sendKeys = new SendKeysSelenium();
		return this;
	}
	
	@Override
	public void execute() {
		super.execute();
		sendText();
		clickMatchingTextElementList();
	}
	
	private void clickMatchingTextElementList() {
		if (getAfter().isClickMatchingTextElement()) {
			new PredicateHelper().clickMatchingTextElement(getAfter().getListElements(), text);
		}
	}
	
	private void sendText() {
		if (text == null) {
			throw new TextOrValueNotSpecifiedException("No text or value specified");
		}
		if (sendKeys != null) {
			sendKeys.sendKeys(getBy(), text, getAfter().isAddKey(), getAfter().getKey());
		}
	}
	
}
