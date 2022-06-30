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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.interactions.events.click.Click;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickMethods;
import qa.free.tools.selenium.toolkit.interactions.events.click.ClickSelenium;

public class Perform extends Interaction<Perform> {
	
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private ClickMethods clickMethods;
	
	@Getter(AccessLevel.PRIVATE)
	private Click click;
	
	public Perform click() {
		setClickMethods(ClickMethods.CLICK);
		click = getUsing().equals(Using.JAVASCRIPT) 
				? new ClickJavascript() : new ClickSelenium();
		return this;
	}
	
	@Override
	public void execute() {
		super.execute();
		if (getClickMethods().equals(ClickMethods.CLICK)) {
			click.click(getBy());
		}
	}
}
