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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.exceptions.TextOrValueNotSpecifiedException;
import qa.free.tools.selenium.toolkit.interactions.elements.group.ElementsGroup;
import qa.free.tools.selenium.toolkit.interactions.elements.group.RadioButtons;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeys;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysSelenium;
import qa.free.tools.selenium.toolkit.utilities.PredicateHelper;

public class Set<T extends Set<T>> extends Interaction<T> {

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Date date;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private After after;
	private String text;
	private ElementsGroup radio;
	private SendKeys sendKeys;
	
	public Set() {
		setBefore(new Before(this));
		setAfter(new After(this));
	}
	
	public Date date() {
		setDate(new Date(this));
		return getDate();
	}
	
	public Set<T> radio(String idOrvalue) {
		this.text = idOrvalue;
		this.radio = new RadioButtons();
		return this;
	}
	
	public Set<T> text(String text) {
		this.text = text;
		this.sendKeys = getUsing().equals(Using.JAVASCRIPT) ?
				new SendKeysJavascript() : new SendKeysSelenium();
		return this;
	}
	
	@Override
	public void execute() {
		super.execute();
		setDate();
		setRadio();
		sendText();
		clickMatchingTextElementList();
	}
	
	private void clickMatchingTextElementList() {
		if (getAfter().isClickMatchingTextElement()) {
			new PredicateHelper().clickMatchingTextElement(getAfter().getListElements(), text);
		}
	}
	
	private void sendText() {
		if (sendKeys != null) {
			if (text == null) {
				throw new TextOrValueNotSpecifiedException("No text/value specified");
			}
			sendKeys.sendKeys(getBy(), text, getAfter().isAddKey(), getAfter().getKey());
		}
	}
	
	private void setDate() {
		if (date != null) {
  		if (getDate().getDateToSet() == null) {
  			throw new TextOrValueNotSpecifiedException("No date specified");
  		}
		}
	}
	
	private void setRadio() {
		if (radio != null) {
			if (text == null) {
				throw new TextOrValueNotSpecifiedException("No text/value specified");
			}
			radio.set(getBy(), text);
		}
	}
	
	public class Date extends Interaction<T> {
		
		@Getter(AccessLevel.PUBLIC)
		private LocalDate dateToSet;
		private By datePickerContainer;
		private Set<T> currentInstance;
		
		public Date(Set<T> currentInstance) {
			this.currentInstance = currentInstance;
		}
		
		public Date currentDate() {
			dateToSet = LocalDate.now();
			return this;
		}
		
		public Date minus(int amountToSubstract, ChronoUnit chronoUnit) {
			dateToSet = LocalDate.now().minus(amountToSubstract, chronoUnit);
			return this;
		}
		
		public Date plus(int amountToAdd, ChronoUnit chronoUnit) {
			dateToSet = LocalDate.now().plus(amountToAdd, chronoUnit);
			return this;
		}

		public Date specificDate(LocalDate localDate) {
			dateToSet = localDate;
			return this;
		}
		
		public By getCalendarContainer() {
			return datePickerContainer;
		}

		public Date setDatePickerContainer(By datePickerContainer) {
			this.datePickerContainer = datePickerContainer;
			return this;
		}
	
		public Set<T> apply() {
			return currentInstance;
		}
		
	}
	
}
