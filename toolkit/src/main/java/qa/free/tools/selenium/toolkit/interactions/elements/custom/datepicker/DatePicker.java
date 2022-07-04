package qa.free.tools.selenium.toolkit.interactions.elements.custom.datepicker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.core.base.SeleniumCore;

public abstract class DatePicker extends SeleniumCore {
	
	public abstract void setDate(By by, LocalDate localDate);
	public abstract String getDate(By by);
	public abstract String getDate(By by, DateTimeFormatter dateTimeFormatter);
	
}
