package qa.free.tools.selenium.toolkit.utilities;

import org.testng.Reporter;

import qa.free.tools.selenium.toolkit.enums.TestNgParameters;
import qa.free.tools.selenium.toolkit.exceptions.MissingTestNgParameterException;

public class TestNgXml {
	
	private TestNgXml() { }
	
	public static String getValue(TestNgParameters parameter) {
		String value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter(parameter.getName());
		if ((value == null) && (parameter.isRequired())) {
			throw new MissingTestNgParameterException(
					String.format("The parameter '%s' is required in the TestNg file", parameter.getName()));
		}
		return value;
	}
	
	public static boolean getValueAsBoolean(TestNgParameters parameter) {
		return Boolean.parseBoolean(getValue(parameter));
	}
	
}
