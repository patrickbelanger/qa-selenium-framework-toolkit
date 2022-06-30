package qa.free.tools.selenium.toolkit.utilities;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;

public class PredicateHelper extends SeleniumCore {

	public void clickMatchingTextElement(By listElements, String text) {
		setWebElements(getSynchronization()
				.synchronizeWebElements(SynchronizationMethods.PRESENCE_OF_ALL_ELEMENTS_LOCATED, listElements));
		Optional<WebElement> matchingElement = getWebElements()
				.stream()
				.filter(e -> e.getText().equals(text) || e.getText().contains(text))
				.findAny();
		if (matchingElement.isPresent()) {
			matchingElement.get().click();
		}
	}
	
	
}
