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

package qa.free.tools.selenium.toolkit.interactions.elements.type;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import lombok.Getter;
import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;
import qa.free.tools.selenium.toolkit.enums.Using;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetText;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetTextJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.get.text.GetTextSelenium;
import qa.free.tools.selenium.toolkit.interactions.events.send.keys.SendKeys;
import qa.free.tools.selenium.toolkit.interactions.events.send.keys.SendKeysJavascript;
import qa.free.tools.selenium.toolkit.interactions.events.send.keys.SendKeysSelenium;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class Text extends SeleniumCore {

	@Getter
	private Using using;
	@Getter
	private GetText textClass;
	@Getter
	private SendKeys sendKeysClass;
	
	public Text() {
		this(Using.JAVASCRIPT);
	}
	
	public Text(Using using) {
		this.using = using;
		this.textClass = using.equals(Using.JAVASCRIPT) ? new GetTextJavascript() : new GetTextSelenium();
		this.sendKeysClass = using.equals(Using.JAVASCRIPT) ? new SendKeysJavascript() : new SendKeysSelenium();
	}
	
	/**
	 * Return if the element is editable (i.e, the input/textbox is clickable, visible and enabled)
	 * @param by {@link By} Element locator
	 * @return True: the input/textbox is editable
	 * 				 False: the input/textbox is not editable
	 */
	public boolean isEditable(By by) {
		return getSynchronization().synchronizeWebElement(SynchronizationMethods.ELEMENT_TO_BE_CLICKABLE, by) != null;
	}
	
	/**
	 * Return if the element is an input<br/>
	 * Remark: this method perform an element synchronization
	 * @param by {@link By} Element locator
	 * @return True: Element is an input (ex: <input type="text" value="Some value" />)
	 * 				 False: Element is anything but an input
	 */
	public boolean isInput(By by) {
		return getSynchronization().synchronizeWebElement(SynchronizationMethods.VISIBILITY_OF_ELEMENT_LOCATED, by)
				.getTagName().equals("input");
	}

	/**
	 * Return if the element is an input<br/>
	 * Remark: this method does not perform an element synchronization
	 * @param webElement {@link WebElement} A web element
	 * @return True: Element is an input (ex: <input type="text" value="Some value" />)
	 * 				 False: Element is anything but an input
	 */
	public boolean isInput(WebElement webElement) {
		return webElement.getTagName().equals("input");
	}

	/**
	 * Return if the element is a textarea<br/>
	 * Remark: this method perform an element synchronization
	 * @param by {@link By} Element locator
	 * @return True: Element is a textarea (ex: <textarea id="message">Some value</textarea>)
	 * 				 False: Element is anything but a textarea
	 */
	public boolean isTextArea(By by) {
		return getSynchronization().synchronizeWebElement(SynchronizationMethods.VISIBILITY_OF_ELEMENT_LOCATED, by)
				.getTagName().equals("textarea");
	}

	/**
	 * Return if the element is a textarea<br/>
	 * Remark: this method does not perform an element synchronization
	 * @param webElement {@link WebElement} A web element
	 * @return True: Element is a textarea (ex: <textarea id="message">Some value</textarea>)
	 * 				 False: Element is anything but a textarea
	 */
	public boolean isTextArea(WebElement webElement) {
		return webElement.getTagName().equals("textarea");
	}
	
	/**
	 * Get attribute from an element<br/>
	 * Remark: this method perform an element synchronization
	 * @param by {@link By} Element locator
	 * @param attributeName The name of the attribute
	 * @return
	 */
	public String getAttribute(By by, String attributeName) {
		return getTextClass().getAttribute(by, attributeName);
	}
	
	/**
	 * Get inner text from an element<br/>
	 * Remark: this method perform an element synchronization
	 * @param by {@link By} Element locator
	 * @return The inner text from an element
	 */
	public String getText(By by) {
		return getTextClass().getText(by);
	}
	
	/**
	 * Get value from an element (i.e, from the attribute "value")<br/>
	 * Remark: this method perform an element synchronization
	 * @param by {@link By} Element locator
	 * @return The value mentioned in the "value" attribute
	 */
	public String getValue(By by) {
		return getTextClass().getValue(by);
	}
	
	/**
	 * Injecting (or sending keys) into a input or textarea.
	 * Remarks: 
	 * <ul>
	 * <li>this method perform an element synchronization</li>
	 * <li><b>JavaScript implementation:</b> the method inject the value without typing. 
	 * (This implementation is selected by default, unless stated)</li>
	 * <li><b>Selenium implementation:</b> the method to simulate typing into an element, which may set its value.</li>
	 * </ul>
	 * 							
	 * @param by {@link By} Element locator
	 * @param text Text to inject or type in the specified element
	 */
	public void sendKeys(By by, CharSequence text) {
		getSendKeysClass().sendKeys(by, text);
	}

	/**
	 * Injecting (or sending keys) into a input or textarea.
	 * Remarks: 
	 * <ul>
	 * <li>this method perform an element synchronization</li>
	 * <li><b>JavaScript implementation:</b> the method inject the value without typing. 
	 * (This implementation is selected by default, unless stated)</li>
	 * <li><b>Selenium implementation:</b> the method to simulate typing into an element, which may set its value.</li>
	 * </ul>
	 * 
	 * @param by {@link By} Element locator
	 * @param text Text to inject or type in the specified element
 	 * @param boolean Clear the current value from the input/textarea before injecting/typing 
 	 * 								the specified value
	 */
	public void sendKeys(By by, CharSequence text, boolean clearInput) {
		getSendKeysClass().sendKeys(by, text, false, Keys.NULL, clearInput);
	}

	/**
	 * Injecting (or sending keys) into a input or textarea.
	 * Remarks: 
	 * <ul>
	 * <li>this method perform an element synchronization</li>
	 * <li><b>JavaScript implementation:</b> the method inject the value without typing. 
	 * (This implementation is selected by default, unless stated)</li>
	 * <li><b>Selenium implementation:</b> the method to simulate typing into an element, which may set its value.</li>
	 * </ul>
	 * 
	 * @param by {@link By} Element locator
	 * @param text Text to inject or type in the specified element
 	 * @param boolean Clear the current value from the input/textarea before injecting/typing 
 	 * 								the specified value
	 * @param addKey Add a key after inject/typing (e.g, the value is injected/typed, then we are 
	 * required to press Tab key)
	 * @param keyToAdd {@link Key} Key to inject/type/perform
	 * @param clearInput Clear the current value from the input/textarea before injecting/typing the specified value
	 */
	public void sendKeys(By by, CharSequence text, boolean addKey, Keys keyToAdd, boolean clearInput) {
		getSendKeysClass().sendKeys(by, text, addKey, keyToAdd, clearInput);
	}
	
}
