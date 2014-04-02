package cz.cvut.fit.alg.params.api;

import cz.cvut.fit.alg.params.annotations.Editor;
import cz.cvut.fit.alg.params.annotations.Renderer;
import cz.cvut.fit.alg.params.ui.ComponentNameRenderer;
import cz.cvut.fit.alg.params.ui.PropertyListEditor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author ytoh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Editor(component = PropertyListEditor.class)
@Renderer(component = ComponentNameRenderer.class)
public @interface List {
}
