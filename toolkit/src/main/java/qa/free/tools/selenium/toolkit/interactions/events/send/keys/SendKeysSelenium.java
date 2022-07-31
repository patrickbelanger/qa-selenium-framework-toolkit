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

package qa.free.tools.selenium.toolkit.interactions.events.send.keys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class SendKeysSelenium extends SendKeys {
	
	@Override
	public void sendKeys(By by, CharSequence keysToSend) {
		sendKeys(by, keysToSend, false, Keys.NULL);
	}
	
	@Override
	public void sendKeys(By by, CharSequence keysToSend, boolean addKey, Keys key) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.VISIBILITY_OF_ELEMENT_LOCATED, by));
		sendKeys(by, keysToSend, addKey, key, false);
	}

	@Override
	public void sendKeys(By by, CharSequence keysToSend, boolean addKey, Keys key, boolean clearInput) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.VISIBILITY_OF_ELEMENT_LOCATED, by));
		if (clearInput) {
			getWebElement().clear();
		}
		sendKeys(getWebElement(), keysToSend);
	}
	
	@Override
	public void sendKeys(WebElement webElement, CharSequence keysToSend) {
		sendKeys(webElement, keysToSend, false, Keys.NULL);
	}

	@Override
	public void sendKeys(WebElement webElement, CharSequence keysToSend, boolean addKey, Keys key) {
		getWebElement().sendKeys(keysToSend, addKey ? key : "");
	}
	
}
