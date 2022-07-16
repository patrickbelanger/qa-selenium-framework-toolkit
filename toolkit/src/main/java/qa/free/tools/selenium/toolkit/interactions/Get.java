package qa.free.tools.selenium.toolkit.interactions;

import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetText;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetTextJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetTextSelenium;

public class Get extends Interaction<Get> {

	/*
	private GetText getText;
	
	public Get text() {
		this.getText = getUsing().equals(Using.JAVASCRIPT) ?
				new GetTextJavascript() : new GetTextSelenium();
		return this;
	}
	
	public String get() {
		return this.getText.getText(getBy());
	}
	*/
	
}
