package qa.free.tools.selenium.toolkit.core.base.testng;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import qa.free.tools.selenium.toolkit.core.base.FrameworkCore;

public abstract class BaseTest extends FrameworkCore {

	@BeforeSuite(alwaysRun = true)
	public void startFramework() {
	
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setUpFramework(ITestContext testContext) {
		setFrameworkContext(testContext);
	}
	
	@AfterMethod(alwaysRun = true) 
	public void tearDownFramework() {
		clearFrameworkContext();
	}
	
	@AfterSuite(alwaysRun = true) 
	public void shutdownFramework() {

	}
	
}
