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
	
	public Optional<WebElement> getMatchingElement(By by, String value) {
		return getMatchingElement(by, value, SynchronizationMethods.PRESENCE_OF_ALL_ELEMENTS_LOCATED);
	}
	
	public Optional<WebElement> getMatchingElement(By by, String value, SynchronizationMethods synchronizationMethods) {
		setWebElements(getSynchronization().synchronizeWebElements(synchronizationMethods, by));
		return getWebElements().stream().filter(
				webElement -> webElement.getAttribute("id").equals(value) ||
					webElement.getAttribute("value").equals(value)).findAny();
	}
	
}
