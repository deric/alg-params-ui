package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyEditor;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.api.Table;
import cz.cvut.fit.alg.params.context.PublishingContext;

/**
 * A {@link PropertyEditor} implementation modifying the underlying
 * {@link Property} with a {@link PropertyTable}.
 *
 * @author ytoh
 */
public class PropertyTableEditor implements PropertyEditor<Object, Table> {

    @Override
    public Component getEditorComponent(Property<Object> property, Table annotation, PublishingContext context) {
        JPanel panel = new JPanel(new BorderLayout());
        PropertyTable table = new PropertyTable(property.getValue());
        panel.add(table, BorderLayout.CENTER);
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        return panel;
    }
}
