package qa.free.tools.selenium.toolkit.interactions.elements.custom.datepicker;

import java.time.LocalDate;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.free.tools.selenium.toolkit.interactions.elements.custom.datepicker.type.DatePickerElement;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class DatePicker<T extends DatePickerElement> extends DatePickerElement {

	private T type;
	
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
	
	@Override
	public String getDate(By by) {
		return type.getDate(by);
	}
	
	@Override
	public String getDate(By by, String dateTimePattern) {
		return type.getDate(by, dateTimePattern);
	}
	
	@Override
	public String getDate(By by, String dateTimePattern, Locale locale) {
		return type.getDate(by, dateTimePattern, locale);
	}

	@Override
	public void setDate(By by, LocalDate localDate) {
		 type.setDate(by, localDate);
	}
	
}
