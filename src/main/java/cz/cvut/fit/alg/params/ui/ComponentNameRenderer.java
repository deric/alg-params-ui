package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyRenderer;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.annotation.Annotation;
import javax.swing.JLabel;
import javax.swing.JPanel;
import cz.cvut.fit.alg.params.Property;

/**
 * A {@link PropertyRenderer} instance displaying the component's human readable
 * name.
 *
 * @author ytoh
 */
public class ComponentNameRenderer implements PropertyRenderer<Object, Annotation> {

    public Component getRendererComponent(final Property<Object> property, Annotation annotation) {
        final ValueModel model = new PropertyAdapter(property, "value", true);
        final JPanel panel = new JPanel(new BorderLayout());
        final JLabel label = new JLabel();

        model.addValueChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                Object value = property.getValue();
                String text = null;

                if(value != null) {
                    if (value.getClass().isAnnotationPresent(cz.cvut.fit.alg.params.annotations.Component.class)) {
                        text = value.getClass().getAnnotation(cz.cvut.fit.alg.params.annotations.Component.class).name();
                    } else {
                        text = String.valueOf(value);
                    }
                }

                label.setText(text);
            }
        });

        panel.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if ("foreground".equals(evt.getPropertyName())) {
                    label.setForeground((Color) evt.getNewValue());
                } else if ("background".equals(evt.getPropertyName())) {
                    label.setBackground((Color) evt.getNewValue());
                }
            }
        });

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
