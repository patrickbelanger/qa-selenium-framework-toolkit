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

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;

public abstract class Interaction<T> extends SeleniumCore {
	
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private After after;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Before before;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private By by;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Using using = Using.SELENIUM;

	public Interaction<T> against(By by) {
		setBy(by);
		return this;
	}
	
	public Interaction<T> using(Using using) {
		setUsing(using);
		return this;
	}
	
	public Before before() {
		return getBefore();
	}
	
	public After after() {
		return getAfter();
	}
	
	public void execute() {
		if (getBy() == null) { 
			throw new ElementNotSpecifiedException("Element not specified");
		}
	}

	public class After extends Interaction<T> {
		
		@Getter(AccessLevel.PUBLIC)
		private boolean addKey;

		@Getter(AccessLevel.PUBLIC)
		private boolean clickMatchingTextElement;
		
		@Getter(AccessLevel.PUBLIC)
		private Keys key;
		
		@Getter(AccessLevel.PUBLIC)
		private By listElements;
		
		private Interaction<T> currentInstance;
		
		public After(Interaction<T> currentInstance) {
			this.currentInstance = currentInstance;
		}
		
		public After pressTab() {
			this.addKey = true;
			this.key = Keys.TAB;
			return this;
		}
		
		public After pressEnter() {
			this.addKey = true;
			this.key = Keys.ENTER;
			return this;
		}

		public After clickMatchingTextElement(By listElements) {
			this.clickMatchingTextElement = true;
			this.listElements = listElements;
			return this;
		}
		
		public Interaction<T> and() {
			return currentInstance;
		}
		
	}
	
	public class Before extends Interaction<T> {
		
		@Getter(AccessLevel.PUBLIC)
		private boolean clearInput;

		
		private Interaction<T> currentInstance;
		
		public Before(Interaction<T> currentInstance) {
			this.currentInstance = currentInstance;
		}
		
		public Before clearInput() {
			this.clearInput = true;
			return this;
		}
		
		public Before triggerElementUpdateAgainst(By locator, String expectedHtmlTag) {
			setWebElement(getSynchronization().synchronizeWebElement(
					SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, locator));
			clickIfUnexpectedElement(expectedHtmlTag);
			return this;
		}

		public Interaction<T> and() {
			return currentInstance;
		}
		
	}
	
}
