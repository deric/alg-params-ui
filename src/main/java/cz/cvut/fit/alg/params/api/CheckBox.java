package cz.cvut.fit.alg.params.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import cz.cvut.fit.alg.params.annotations.Editor;
import cz.cvut.fit.alg.params.annotations.Renderer;
import cz.cvut.fit.alg.params.ui.CheckBoxEditor;


/**
 * Render and edit as a checkbox.
 *
 * @author ytoh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Editor(component=CheckBoxEditor.class)
@Renderer(component=CheckBoxEditor.class)
public @interface CheckBox { }
