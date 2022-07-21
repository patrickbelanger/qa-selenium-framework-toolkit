package qa.free.tools.selenium.toolkit.utilities;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.enums.Locator;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class FindElementHelper {

	private FindElementHelper() { }
	
	public static By getElementFromAnnotation(FindElement targetElement, Integer index, String... args) {
		if (targetElement.elements().length > 0) {
			return getElement(targetElement.locators().length > 0 ? 
					targetElement.locators()[index] : targetElement.locator(), targetElement.elements()[index], args);
		}
		return getElement(targetElement.locator(), targetElement.element(), args);
	}
	
	private static By getElement(Locator locator, String element, String... args) {
		if (locator.equals(Locator.CLASS_NAME)) {
			return By.className(String.format(element, (Object[]) args));
		} else if (locator.equals(Locator.CSS_SELECTOR)) {
			return By.cssSelector(String.format(element, (Object[]) args));
		} else if (locator.equals(Locator.ID)) {
			return By.id(String.format(element, (Object[]) args));
		} else if (locator.equals(Locator.LINK_TEXT)) {
			return By.linkText(String.format(element, (Object[]) args));
		} else if (locator.equals(Locator.NAME)) {
			return By.name(String.format(element, (Object[]) args));
		} else if (locator.equals(Locator.PARTIAL_LINK_TEXT)) {
			return By.partialLinkText(String.format(element, (Object[]) args));
		} else if (locator.equals(Locator.TAG_NAME)) {
			return By.tagName(String.format(element, (Object[]) args));
		}
		return By.xpath(String.format(element, (Object[]) args));
	}
}
