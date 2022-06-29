package qa.free.tools.selenium.toolkit.interactions;

import org.openqa.selenium.By;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;

public abstract class Interaction<T> extends SeleniumCore {
	
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private By by;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Using using = Using.SELENIUM;
	
	public Interaction<T> using(Using using) {
		setUsing(using);
		return this;
	}
	
	public Interaction<T> against(By by) {
		setBy(by);
		return this;
	}
	
	public void execute() {
		if (getBy() == null) { 
			throw new ElementNotSpecifiedException("Element not specified");
		}
	}
	
}
