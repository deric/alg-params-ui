package cz.cvut.fit.alg.params.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import cz.cvut.fit.alg.params.annotations.Editor;
import cz.cvut.fit.alg.params.annotations.Renderer;
import cz.cvut.fit.alg.params.ui.ComponentNameRenderer;
import cz.cvut.fit.alg.params.ui.DynamicDropDownEditor;

/**
 * Edit as a drop down witch dynamic values.
 *
 * <p>Values for the options are retrieved at runtime from a {@link org.ytoh.configurations.context.Context} instance.</p>
 *
 * @author ytoh
 */
@Editor(component = DynamicDropDownEditor.class)
@Renderer(component= ComponentNameRenderer.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DynamicDropDown {
    public enum Label {
        NAME, VALUE
    }

    /**
     * Type of the values dynamically retrieved.
     *
     * @return type of options
     */
    Class<?> type();

    /**
     * Key to retrieve.
     *
     * @return string key
     */
    String key() default "";

    /**
     * Should the label be the components name set to {@link Label#NAME}.
     * Should the label be the components value set to {@link Label#VALUE}.
     *
     * @return label type
     */
    Label label() default Label.VALUE;
}
