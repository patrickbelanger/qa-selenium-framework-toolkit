package qa.free.tools.selenium.toolkit.unit.utilities;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;
import qa.free.tools.selenium.toolkit.mock.page.object.InvalidPageObject;
import qa.free.tools.selenium.toolkit.utilities.ThreadHelper;

class ThreadHelperTest {

	@Test(expectedExceptions = { ElementNotSpecifiedException.class })
	void findMethodWithAnnotation_shouldTriggerAnExceptionIfFindElementIsNotSpecified() {
		assertTrue(ThreadHelper.findMethodWithAnnotation(new InvalidPageObject(), FindElement.class) instanceof Method);
	}
	
}
