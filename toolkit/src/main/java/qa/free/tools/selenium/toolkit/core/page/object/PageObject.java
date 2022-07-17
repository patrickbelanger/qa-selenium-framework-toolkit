package qa.free.tools.selenium.toolkit.core.page.object;

import org.openqa.selenium.By;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.synchronization.exceptions.ElementSynchronizationException;
import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.core.base.FrameworkCore;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;
import qa.free.tools.selenium.toolkit.exceptions.ExpectedPageNotLoadedException;
import qa.free.tools.selenium.toolkit.utilities.FindElementHelper;
import qa.free.tools.selenium.toolkit.utilities.ThreadHelper;

public abstract class PageObject<T> extends FrameworkCore {
	
	private static final int PAGE_OBJECT_THREAD_LEVEL = 4;
	public abstract T goTo();
	public abstract T isPageLoaded();
	
	public boolean isPageLoaded(By by) {
		try {
			return getSynchronization()
					.synchronizeWebElement(SynchronizationMethods.VISIBILITY_OF_ELEMENT_LOCATED, by) != null;
		} catch(ElementSynchronizationException e) {
			throw new ExpectedPageNotLoadedException(
					String.format("The expected page '%s' is not loaded", this.getClass().getSimpleName()));
		}
	}
	
	public By getBy(String... args) {
		return getBy(null, args);
	}
	
	public By getBy(Integer index, String... args) {
		FindElement targetElement = ThreadHelper.findMethodWithAnnotation(this, FindElement.class, PAGE_OBJECT_THREAD_LEVEL)
				.getAnnotation(FindElement.class);
		if (targetElement != null) {
			return FindElementHelper.getElementFromAnnotation(targetElement, index, args);
		}
  	throw new ElementNotSpecifiedException(
  			"Unable to get element from getBy() - Make sure the caller method is declared public");
	}
	
}
