package qa.free.tools.selenium.toolkit.interactions;

import org.openqa.selenium.By;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;

public abstract class Interaction<T> extends SeleniumCore {

	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PROTECTED)
	private Before before;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private By by;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Using using = Using.SELENIUM;

	public Interaction<T> against(By by) {
		setBy(by);
		return this;
	}
	
	public Interaction<T> using(Using using) {
		setUsing(using);
		return this;
	}
	
	public Before before() {
		return getBefore();
	}
	
	public class Before extends Interaction<T> {
		
		private Interaction<T> currentInstance;
		
		public Before(Interaction<T> currentInstance) {
			this.currentInstance = currentInstance;
		}
		
		public Interaction<T> triggerElementUpdate(By locator, String expectedHtmlTag) {
			setWebElement(getSynchronization().synchronizeWebElement(
					SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, locator));
			clickIfUnexpectedElement(expectedHtmlTag);
			return currentInstance;
		}
		
	}
	
	public void execute() {
		if (getBy() == null) { 
			throw new ElementNotSpecifiedException("Element not specified");
		}
	}
	
}
