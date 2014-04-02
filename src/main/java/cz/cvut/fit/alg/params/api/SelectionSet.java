package cz.cvut.fit.alg.params.api;

import cz.cvut.fit.alg.params.annotations.Editor;
import cz.cvut.fit.alg.params.annotations.Renderer;
import cz.cvut.fit.alg.params.ui.SelectionSetEditor;
import cz.cvut.fit.alg.params.ui.SelectionSetRenderer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Editor(component = SelectionSetEditor.class)
@Renderer(component = SelectionSetRenderer.class)

public @interface SelectionSet {

    String key();

    Class<?> type();

    String windowTitle() default "Selection window";

    String rendererCellText() default "Click to select items...";
}
