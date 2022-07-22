package qa.free.tools.selenium.toolkit.interactions.elements.custom.datepicker.type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;

import qa.free.tools.selenium.synchronization.SynchronizationMethods;
import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;

public abstract class DatePickerElement extends SeleniumCore {

	public abstract void setDate(By by, LocalDate localDate);
	
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
	
}
