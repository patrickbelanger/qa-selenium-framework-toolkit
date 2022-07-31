package qa.free.tools.selenium.toolkit.unit.utilities;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.enums.Locator;
import qa.free.tools.selenium.toolkit.utilities.FindElementHelper;

class FindElementHelperTest {

	@FindElement(locator = Locator.CLASS_NAME, element="spacer")
	@Test
	public void getElementFromAnnotation_shouldBeAbleToGetAnElementWithClassNameLocator() 
			throws NoSuchMethodException, SecurityException {
		By by = FindElementHelper.getElementFromAnnotation(
				this.getClass().getMethod("getElementFromAnnotation_shouldBeAbleToGetAnElementWithClassNameLocator")
				.getAnnotation(FindElement.class), 1);
		assertNotNull(by);
		assertTrue(by.toString().contains(Locator.CLASS_NAME.toString()));
	}

	
}
