package qa.free.tools.selenium.toolkit.unit.utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import qa.free.tools.selenium.toolkit.enums.TestNgParameters;
import qa.free.tools.selenium.toolkit.utilities.TestNgXml;

/**
 * Remarks: Must be executed from the unit-test.xml
 * @author pbelanger
 *
 */
class TestNgXmlTest {
	
	@Test
	void getValue_webDriver_shouldBeAbleToGetTestNgParameterValueAsString() {
		assertEquals(TestNgXml.getValue(TestNgParameters.WEBDRIVER), "CHROME");
	}

	@Test
	void getValue_gridThirdParty_shouldReturnNull() {
		assertNotNull(TestNgXml.getValue(TestNgParameters.GRID_THIRD_PARTY));
	}
	
	@Test
	void getValue_remote_shouldBeAbleToGetTestNgParameterValueAsBoolean() {
		assertNotEquals(TestNgXml.getValue(TestNgParameters.REMOTE), false);
		assertEquals(TestNgXml.getValueAsBoolean(TestNgParameters.REMOTE), false);
	}
	
}
