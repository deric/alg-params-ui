package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.DynamicDropDown;
import cz.cvut.fit.alg.params.api.PropertyEditor;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import org.apache.commons.lang.StringUtils;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.context.Publisher;
import cz.cvut.fit.alg.params.context.PublishingContext;
import cz.cvut.fit.alg.params.context.Subscriber;
import cz.cvut.fit.alg.params.api.DynamicDropDown.Label;

/**
 * A {@link PropertyEditor} instance retrieving values dynamically for a
 * {@link Context} instance.
 *
 * @author ytoh
 */
public class DynamicDropDownEditor implements PropertyEditor<Object, DynamicDropDown> {

    @Override
    public Component getEditorComponent(Property<Object> property, final DynamicDropDown annotation,
            final PublishingContext context) {
        final Class<?> type = annotation.type();
        String key = annotation.key();

        final ValueModel model = new PropertyAdapter(property, "value");
        final JComboBox box = new JComboBox();

        Subscriber subscriber = new Subscriber() {

            @Override
            public void notifyOf(Publisher publisher, List value, String key) {
                box.setModel(new ComboBoxAdapter(value.toArray(), model));
                box.setRenderer(new MyCellRenderer(annotation.label()));
            }
        };

        context.subscribeTo(type, key, subscriber);

        subscriber.notifyOf(context, context.getList(type, key), key);
        return box;
    }

    private class MyCellRenderer extends DefaultListCellRenderer {

        private final Label labelType;

        public MyCellRenderer(Label labelType) {
            this.labelType = labelType;
        }

        private static final long serialVersionUID = -5460014450312978883L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            String label = null;

            switch (labelType) {
                case NAME:
                    if (value != null) {
                        if (value.getClass().isAnnotationPresent(cz.cvut.fit.alg.params.annotations.Component.class)) {
                            label = value.getClass().getAnnotation(cz.cvut.fit.alg.params.annotations.Component.class).name();
                        }

                        if (StringUtils.isEmpty(label)) {
                            label = value.getClass().getSimpleName();
                        }
                    }
                    break;
                case VALUE:
                    label = String.valueOf(value);
                    break;
            }

            return super.getListCellRendererComponent(list, label, index, isSelected, cellHasFocus);
        }
    }
}
