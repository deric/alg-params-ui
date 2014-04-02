package cz.cvut.fit.alg.params.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import cz.cvut.fit.alg.params.annotations.Editor;
import cz.cvut.fit.alg.params.ui.DropDownEditor;

/**
 * Edit as a drop down.
 *
 * @author ytoh
 */
@Editor(component = DropDownEditor.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DropDown {

    /**
     * Options to choose from.
     *
     * @return array of string values to choose from
     */
    String[] value() default {};
}
