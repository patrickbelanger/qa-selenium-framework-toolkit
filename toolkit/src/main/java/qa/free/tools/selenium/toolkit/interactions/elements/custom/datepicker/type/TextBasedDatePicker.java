package qa.free.tools.selenium.toolkit.interactions.elements.custom.datepicker.type;

import java.time.LocalDate;

import org.openqa.selenium.By;

import qa.free.tools.selenium.toolkit.interactions.events.send.keys.SendKeysSelenium;

public class TextBasedDatePicker extends DatePickerElement {

	@Override
	public void setDate(By by, LocalDate localDate) {
		new SendKeysSelenium().sendKeys(by, "");
	}

}
