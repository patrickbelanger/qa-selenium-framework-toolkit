package qa.free.tools.selenium.toolkit.utilities;

import java.lang.reflect.Method;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
public class ThreadHelper {

	private ThreadHelper() { }
	
	@SuppressWarnings("rawtypes")
	public static Method findMethodWithAnnotation(PageObject<?> clazz, Class annotation) {
		Method method = getMatchingMethod(clazz.getClass().getMethods(), annotation);
		if (method != null) {
			return method;
		}
		throw new ElementNotSpecifiedException("Element(s) not specified using @FindElement annotation. Make sure page object is public");
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static Method getMatchingMethod(Method[] methods, Class annotation) {
		for (int i = 0; i <= 5; i++) { // We perform a maximum of  5 attempts to find the method 
																	 // with the specified annotation
  		for (Method method : methods) {
  			if (method.isAnnotationPresent(annotation) && // For some reason, this not work using streams (to investigate)
  					method.getName().equals(getCallerMethodName(i))) {
  				return method;
  			}
  		}
		}
		return null;
	}
	
	private static String getCallerMethodName(int level) {
		return StackWalker.getInstance().walk(s -> s.skip(level).findFirst().get()).getMethodName();
	}

}
