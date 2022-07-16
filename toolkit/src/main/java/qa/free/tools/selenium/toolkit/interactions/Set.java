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
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.exceptions.MissingClosingMethodInBuilderException;
import qa.free.tools.selenium.toolkit.exceptions.TextOrValueNotSpecifiedException;
import qa.free.tools.selenium.toolkit.interactions.elements.group.ElementsGroup;
import qa.free.tools.selenium.toolkit.interactions.elements.group.RadioButtons;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeys;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.send.text.SendKeysSelenium;
import qa.free.tools.selenium.toolkit.utilities.PredicateHelper;

public class Set<T extends Set<T>> extends Interaction<Set<T>> {

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private Date date;
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private After after;
	private String text;
	private ElementsGroup radio;
	private SendKeys sendKeys;	
	
	@Override
	public Before before() {
		if (getBefore() == null) {
			setBefore(new Before(this));
		}
		return getBefore();
	}
	
	@Override
	public After after() {
		if (getAfter() == null) {
			setAfter(new After(this));
		}
		return getAfter();
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
		if (getAfter() != null && !getAfter().isAndCalled()) {
			throw new MissingClosingMethodInBuilderException("after() builder must be closed using the and() method");
		}
		if (getBefore() != null && !getBefore().isAndCalled()) {
			throw new MissingClosingMethodInBuilderException("before() builder must be closed using the and() method");
		}
		super.execute();
		setDate();
		setRadio();
		sendText();
		clickMatchingTextElementList();
	}
	
	private void clickMatchingTextElementList() {
		if (getAfter() != null && getAfter().isClickMatchingTextElement()) {
			new PredicateHelper().clickMatchingTextElement(getAfter().getListElements(), text);
		}
	}
	
	private void sendText() {
		if (sendKeys != null) {
			if (text == null) {
				throw new TextOrValueNotSpecifiedException("No text/value specified");
			}
			sendKeys.sendKeys(getBy(), text, isAddKey(), getKey(), isClearInput());
		}
	}
	
	private void setDate() {
		if (date != null) {
  		if (getDate().getDateToSet() == null) {
  			throw new TextOrValueNotSpecifiedException("No date specified");
  		}
  		if (!getDate().isAppliedCalled()) {
  			throw new MissingClosingMethodInBuilderException("date() builder must be closed using the apply() method");
  		}
  		if (getDate().isSendKeys()) {
  			text(getDate().getDateToSet());
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

	private boolean isAddKey() {
		return getAfter() != null && getAfter().isAddKey();
	}
	
	private boolean isClearInput() {
		return getBefore() != null && getBefore().isClearInput();
	}
	
	public Keys getKey() {
		return getAfter() != null ? getAfter().getKey() : Keys.NULL;
	}
	
	public class Date extends Interaction<T> {
		
		@Getter(AccessLevel.PUBLIC)
		public boolean sendKeys;
		private LocalDate dateToSet;
		private String dateFormatPattern;
		private By datePickerContainer;
		private Set<T> currentInstance;
		@Getter(AccessLevel.PUBLIC)
		private boolean appliedCalled;
		
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

		public Date setSpecificDate(LocalDate localDate) {
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
	
		public Date usingDateFormatter(String dateFormatPattern) {
			this.dateFormatPattern = dateFormatPattern;
			return this;
		}
		
		public Date usingSendKeys() {
			this.sendKeys = true;
			return this;
		}
		
		public String getDateToSet() {
			return dateToSet.format(DateTimeFormatter.ofPattern(this.dateFormatPattern));
		}
		
		public Set<T> apply() {
			this.appliedCalled = true;
			return currentInstance;
		}
		
	}
	
}
