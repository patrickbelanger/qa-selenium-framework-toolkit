package qa.free.tools.selenium.toolkit.utilities;

import java.lang.reflect.Method;

import qa.free.tools.selenium.toolkit.core.page.object.PageObject;
import qa.free.tools.selenium.toolkit.exceptions.ElementNotSpecifiedException;

public class ThreadHelper {

	private ThreadHelper() { }
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static Method findMethodWithAnnotation(PageObject<?> clazz, Class annotation, int level) {
		for (Method method : clazz.getClass().getMethods()) {
			if (method.isAnnotationPresent(annotation) &&
					method.getName().equals(getCallerMethodName(level))) {
				return method;
			}
		}
		throw new ElementNotSpecifiedException("");
	}

	private static String getCallerMethodName(int level) {
		return StackWalker.getInstance().walk(s -> s.skip(level).findFirst().get()).getMethodName();
	}

}
