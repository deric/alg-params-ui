package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyEditor;
import java.awt.Component;
import java.lang.annotation.Annotation;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.context.PublishingContext;

/**
 * Default {@link PropertyEditor} implementation.
 *
 * @author ytoh
 */
public class DefaultEditor implements PropertyEditor {

    public Component getEditorComponent(Property property, Annotation annotation, PublishingContext context) {
        return new DefaultRenderer().getRendererComponent(property, annotation);
    }
}
