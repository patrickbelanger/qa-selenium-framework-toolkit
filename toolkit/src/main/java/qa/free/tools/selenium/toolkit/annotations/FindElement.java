package qa.free.tools.selenium.toolkit.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import qa.free.tools.selenium.toolkit.enums.Locator;

/**
 * @author pbelanger <1848500+patrickbelanger@users.noreply.github.com>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface FindElement {
	
	Locator locator() default Locator.XPATH;
	String element();
	String[] elements() default {};
	
}
