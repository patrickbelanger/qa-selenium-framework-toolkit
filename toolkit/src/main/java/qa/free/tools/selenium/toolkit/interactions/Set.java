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

package qa.free.tools.selenium.toolkit.interactions;

import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.exceptions.TextOrValueNotSpecifiedException;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeys;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysSelenium;
import qa.free.tools.selenium.toolkit.utilities.PredicateHelper;

public class Set extends Interaction<Set> {

	private String text;
	private SendKeys sendKeys;
	
	public Set() {
		setBefore(new Before(this));
		setAfter(new After(this));
	}
	
	public Set text(String text) {
		this.text = text;
		this.sendKeys = getUsing().equals(Using.JAVASCRIPT) ?
				new SendKeysJavascript() : new SendKeysSelenium();
		return this;
	}
	
	@Override
	public void execute() {
		super.execute();
		sendText();
		clickMatchingTextElementList();
	}
	
	private void clickMatchingTextElementList() {
		if (getAfter().isClickMatchingTextElement()) {
			new PredicateHelper().clickMatchingTextElement(getAfter().getListElements(), text);
		}
	}
	
	private void sendText() {
		if (text == null) {
			throw new TextOrValueNotSpecifiedException("No text or value specified");
		}
		if (sendKeys != null) {
			sendKeys.sendKeys(getBy(), text, getAfter().isAddKey(), getAfter().getKey());
		}
	}
	
}
