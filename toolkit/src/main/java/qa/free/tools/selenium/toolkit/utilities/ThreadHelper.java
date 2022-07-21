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
	public static Method findMethodWithAnnotation(PageObject<?> clazz, Class annotation, int level) {
		Method method = getMatchingMethod(clazz.getClass().getMethods(), annotation, level);
		if (method == null) {
			method = getMatchingMethod(clazz.getClass().getMethods(), annotation, level - 1);
		}
		if (method != null) {
			return method;
		}
		throw new ElementNotSpecifiedException("Element not specified or page object method must be public");
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static Method getMatchingMethod(Method[] methods, Class annotation, int level) {
		for (Method method : methods) {
			if (method.isAnnotationPresent(annotation) &&
					method.getName().equals(getCallerMethodName(level))) {
				return method;
			}
		}
		return null;
	}
	
	private static String getCallerMethodName(int level) {
		return StackWalker.getInstance().walk(s -> s.skip(level).findFirst().get()).getMethodName();
	}

}
