package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyEditor;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import java.awt.Component;
import java.text.DecimalFormat;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.context.PublishingContext;

/**
 * A {@link PropertyEditor} instance editing number properties with a formatted
 * JTextField.
 *
 * @author ytoh
 */
public class DoubleTextFieldEditor implements PropertyEditor<Object, TextField> {

    @Override
    public Component getEditorComponent(final Property<Object> property, TextField annotation, PublishingContext context) {
        final ValueModel model = new PropertyAdapter(property, "value", true);
        return BasicComponentFactory.createFormattedTextField(model, new DecimalFormat("#.###"));
    }
}
