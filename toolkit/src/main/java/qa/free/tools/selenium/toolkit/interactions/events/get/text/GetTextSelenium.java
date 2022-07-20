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

package qa.free.tools.selenium.toolkit.interactions.events.get.text;

import org.openqa.selenium.By;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;

public class GetTextSelenium extends GetText {
	
	@Override
	public String getText(By by) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by));
		return getWebElement().getText();
	}

	@Override
	public String getAttribute(By by, String attributeName) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by));
		return getWebElement().getAttribute(attributeName);
	}

	@Override
	public String getValue(By by) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by));
		return getWebElement().getAttribute("value");
	}
	
}
