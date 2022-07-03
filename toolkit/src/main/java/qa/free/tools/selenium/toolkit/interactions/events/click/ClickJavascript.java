package qa.free.tools.selenium.toolkit.interactions.events.click;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import lombok.Getter;
import qa.free.tools.selenium.synchronization.SynchronizationMethods;

public class ClickJavascript extends Click {
	
	@Getter
	private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
	
	public void click(By by) {
		getJavascriptExecutor().executeScript(
				"arguments[0].click()", 
				getSynchronization().synchronizeWebElement(SynchronizationMethods.PRESENCE_OF_ELEMENT_LOCATED, by));
	}

	@Override
	public void click(WebElement webElement) {
		getJavascriptExecutor().executeScript("arguments[0].click()", webElement);
	}
	
}
