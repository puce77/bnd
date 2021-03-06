package aQute.bnd.annotation.headers;

import java.lang.annotation.*;

/**
 * The Bundle-Category header holds a comma-separated list of category names.
 * These categories are free form but there is a list on the <a
 * href='http://www.osgi.org/Specifications/Reference#categories'>OSGi
 * Website</a>
 * <p>
 * All categories are merged together with any duplicates removed
 * See {@link About}
 */
@Retention(RetentionPolicy.CLASS)
@Target({
		ElementType.ANNOTATION_TYPE, ElementType.TYPE
})
public @interface BundleCategory {

	/**
	 * The list of categories on the <a
	 * href='http://www.osgi.org/Specifications/Reference#categories'>OSGi
	 * Website</a>
	 */
	Category[] value();

	/**
	 * Custom categories.
	 */
	String[] custom() default {};
}
