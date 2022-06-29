package qa.free.tools.selenium.toolkit.interactions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.interactions.events.click.Click;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickMethods;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickSelenium;

public class Perform extends Interaction<Perform> {
	
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private ClickMethods clickMethods;
	
	@Getter(AccessLevel.PRIVATE)
	private Click click;
	
	public Perform click() {
		setClickMethods(ClickMethods.CLICK);
		click = getUsing().equals(Using.JAVASCRIPT) 
				? new ClickJavascript() : new ClickSelenium();
		return this;
	}
	
	@Override
	public void execute() {
		super.execute();
		if (getClickMethods().equals(ClickMethods.CLICK)) {
			click.click(getBy());
		}
	}
}
