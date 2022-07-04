package qa.free.tools.selenium.toolkit.interactions.elements.custom.datepicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;

public abstract class DatePicker extends SeleniumCore {
	
	public abstract void setDate(By by, LocalDate localDate);
	public abstract void setDate(By by, Predicate<? extends WebElement> predicate, LocalDate localDate);
	
	public String getDate(By by) {
		setWebElement(getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by));
		return getWebElement().getAttribute("value");
	}
	
	public String getDate(By by, String dateTimePattern) {
		return getDate(by, dateTimePattern, Locale.US);
	}
	
	public String getDate(By by, String dateTimePattern, Locale locale) {
		return LocalDateTime.parse(getDate(by), DateTimeFormatter.ofPattern(dateTimePattern, locale)).toString();
	}
	
	public boolean isTypeCustom(WebElement webElement) {
		return !isTypeDate(webElement) && 
				!isTypeText(webElement);
	}
	
	public boolean isTypeDate(WebElement webElement) {
		return webElement.getAttribute("type").equals("date");
	}
	
	public boolean isTypeText(WebElement webElement) {
		return webElement.getAttribute("type").equals("text");
		
	}
	
}
