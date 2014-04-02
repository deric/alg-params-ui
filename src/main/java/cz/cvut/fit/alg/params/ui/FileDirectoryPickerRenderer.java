package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyRenderer;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.api.FileDirectoryPicker;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class FileDirectoryPickerRenderer extends JPanel implements PropertyRenderer<String, FileDirectoryPicker>, PropertyChangeListener {

    private static final long serialVersionUID = -3753326031549499757L;

    JLabel text;
    Property<String> prop;

    public FileDirectoryPickerRenderer() {
        super();

        text = new JLabel();
        setLayout(new FormLayout("fill:50px:grow", "fill:20px"));
        CellConstraints cc = new CellConstraints();
        add(text, cc.xy(1, 1));

    }

    @Override
    public Component getRendererComponent(Property<String> property, FileDirectoryPicker annotation) {

        prop = property;

        ValueModel model = new PropertyAdapter(property, "value", true);
        model.addValueChangeListener(this);

        text.setText(annotation.value());

        return this;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        text.setText(prop.getValue());
    }
}
