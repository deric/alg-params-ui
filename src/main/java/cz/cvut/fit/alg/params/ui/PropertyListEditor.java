package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyEditor;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.Validate;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.context.PublishingContext;

/**
 *
 * @author ytoh
 */
public class PropertyListEditor implements PropertyEditor<List<?>, cz.cvut.fit.alg.params.api.List> {

    public Component getEditorComponent(Property<List<?>> property, cz.cvut.fit.alg.params.api.List annotation, PublishingContext context) {
        Validate.notNull(property.getValue(), "list property null.");
        Validate.isTrue(property.getValue() instanceof List, "property value does not hold a list.");

        final JPanel panel = new JPanel(new GridLayout(0, 1));

        CollectionUtils.forAllDo(property.getValue(), new Closure() {

            public void execute(Object i) {
                panel.add(new PropertyTable(i));
            }
        });

        return panel;
    }
}
