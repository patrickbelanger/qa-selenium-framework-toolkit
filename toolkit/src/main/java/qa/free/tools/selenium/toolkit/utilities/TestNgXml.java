// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

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
