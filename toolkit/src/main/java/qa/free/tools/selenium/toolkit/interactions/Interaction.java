package qa.free.tools.selenium.toolkit.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;

public abstract class Interaction<T> extends SeleniumCore {

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private After after;
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
	
	public After after() {
		return getAfter();
	}
	
	public void execute() {
		if (getBy() == null) { 
			throw new ElementNotSpecifiedException("Element not specified");
		}
	}

	public class After extends Interaction<T> {
		
		@Getter(AccessLevel.PUBLIC)
		private boolean addKey;

		@Getter(AccessLevel.PUBLIC)
		private boolean clickMatchingTextElement;
		
		@Getter(AccessLevel.PUBLIC)
		private Keys key;
		
		@Getter(AccessLevel.PUBLIC)
		private By listElements;
		
		private Interaction<T> currentInstance;
		
		public After(Interaction<T> currentInstance) {
			this.currentInstance = currentInstance;
		}
		
		public Interaction<T> pressTab() {
			this.addKey = true;
			this.key = Keys.TAB;
			return currentInstance;
		}
		
		public Interaction<T> pressEnter() {
			this.addKey = true;
			this.key = Keys.ENTER;
			return currentInstance;
		}

		public Interaction<T> clickMatchingTextElement(By listElements) {
			this.clickMatchingTextElement = true;
			this.listElements = listElements;
			return currentInstance;
		}
		
	}
	
	public class Before extends Interaction<T> {
		
		private Interaction<T> currentInstance;
		
		public Before(Interaction<T> currentInstance) {
			this.currentInstance = currentInstance;
		}
		
		public Interaction<T> triggerElementUpdateAgainst(By locator, String expectedHtmlTag) {
			setWebElement(getSynchronization().synchronizeWebElement(
					SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, locator));
			clickIfUnexpectedElement(expectedHtmlTag);
			return currentInstance;
		}
		
	}
	
}
