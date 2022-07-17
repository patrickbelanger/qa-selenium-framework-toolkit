package qa.free.tools.selenium.toolkit.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import qa.free.tools.selenium.toolkit.enums.Locator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface FindElement {
	
	Locator locator() default Locator.XPATH;
	String element();
	String[] elements() default {};
	
}
