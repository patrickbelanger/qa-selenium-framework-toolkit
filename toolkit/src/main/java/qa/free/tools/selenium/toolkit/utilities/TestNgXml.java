package qa.free.tools.selenium.toolkit.utilities;

import org.testng.Reporter;

import qa.free.tools.selenium.toolkit.enums.TestNgParameters;
import qa.free.tools.selenium.toolkit.exceptions.MissingTestNgParameterException;

public class TestNgXml {
	
	private TestNgXml() { }
	
	public static String getValue(TestNgParameters parameter) throws MissingTestNgParameterException {
		String value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter(parameter.getName());
		if ((value == null) && (parameter.isRequired())) {
			throw new MissingTestNgParameterException(
					String.format("The parameter '%s' is required in the TestNg file", parameter.getName()));
		}
		return value;
	}
	
	public static String getValue(TestNgParameters parameter, Object defaultValue) {
		try {
			return getValue(parameter) != null ? getValue(parameter) : defaultValue.toString();
		} catch(MissingTestNgParameterException e) {
			return defaultValue.toString();
		}
	}
	
	public static boolean getValueAsBoolean(TestNgParameters parameter) throws MissingTestNgParameterException {
			return Boolean.parseBoolean(getValue(parameter));
	}
	
}
