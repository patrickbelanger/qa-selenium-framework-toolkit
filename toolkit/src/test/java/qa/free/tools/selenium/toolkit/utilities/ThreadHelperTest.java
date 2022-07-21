package qa.free.tools.selenium.toolkit.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import qa.free.tools.selenium.toolkit.annotations.FindElement;
import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;
import qa.free.tools.selenium.toolkit.utilities.mock.DummyPageObjectClassWithNoFindElements;

class ThreadHelperTest {

	@Test
	void findMethodWithAnnotation_shouldRaiseAnExceptionIfAnnotationOnMethodIsMissing() {
		PageObject<DummyPageObjectClassWithNoFindElements> pageObject = new DummyPageObjectClassWithNoFindElements();
		ElementNotSpecifiedException thrown = Assertions.assertThrows(ElementNotSpecifiedException.class, () -> {
			ThreadHelper.findMethodWithAnnotation(pageObject, FindElement.class);
		});
		Assertions.assertNotEquals("Element(s) not specified using @FindElement annotation. Make sure page object is public", 
				thrown.getMessage());
	}
	
}
