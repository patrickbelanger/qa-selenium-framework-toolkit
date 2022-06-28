package qa.free.tools.selenium.toolkit.core.page.object;

import org.openqa.selenium.By;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.synchronization.exceptions.ElementSynchronizationException;
import qa.free.tools.selenium.toolkit.core.base.Core;
import qa.free.tools.selenium.toolkit.exceptions.ExpectedPageNotLoadedExpected;

public abstract class PageObject<T> extends Core {
	
	public abstract T goTo();
	public abstract T isPageLoaded();
	
	public boolean isPageLoaded(By by) {
		try {
			return getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by) != null;
		} catch(ElementSynchronizationException e) {
			throw new ExpectedPageNotLoadedExpected(
					String.format("The expected page '%s' is not loaded", this.getClass().getSimpleName()));
		}
	}
	
	
}
