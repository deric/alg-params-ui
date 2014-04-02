package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyEditor;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.context.PublishingContext;


/**
 * Created by IntelliJ IDEA.
 * User: lagon
 * Date: Sep 29, 2009
 * Time: 4:35:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DynamicListPickerEditor extends JDialog implements PropertyEditor<String, DynamicListPicker> {

    public Component getEditorComponent(Property<String> property, DynamicListPicker annotation, PublishingContext context) {
        JButton butt = new JButton();
        butt.setText("Close list window");
        return butt;
    }

}
