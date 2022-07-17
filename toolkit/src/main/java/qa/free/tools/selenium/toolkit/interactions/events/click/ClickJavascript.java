package qa.free.tools.selenium.toolkit.interactions.events.click;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import lombok.Getter;
import qa.free.tools.selenium.synchronization.SynchronizationMethods;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class ClickJavascript extends Click {
	
	@Getter
	private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getWebDriver();
	
	public void click(By by) {
		getJavascriptExecutor().executeScript(
				"arguments[0].click()", 
				getSynchronization().synchronizeWebElement(SynchronizationMethods.VISIBILITY_OF_ELEMENT_LOCATED, by));
	}

	@Override
	public void click(WebElement webElement) {
		getJavascriptExecutor().executeScript("arguments[0].click()", webElement);
	}
	
}
