package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyRenderer;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.api.SelectionSet;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by IntelliJ IDEA.
 * User: lagon
 * Date: Oct 14, 2009
 * Time: 11:35:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionSetRenderer extends JPanel implements PropertyRenderer<Object, SelectionSet>, PropertyChangeListener {

    @Override
    public Component getRendererComponent(Property<Object> property, SelectionSet annotation) {
        ValueModel model = new PropertyAdapter(property, "value", true);
        model.addValueChangeListener(this);

        /*   String s[] = Bean4.getInstance().getModel().getAllElements();
         for (int i = 0; i < s.length; i++) {
         System.out.printf("item %d - %s\n", i, s[i].toString());
         }*/
        add(new JLabel(annotation.rendererCellText()));

        if (property.getValue() == null) {
//            System.out.printf("Je to nulllll\n");
            return this;
        }

        return this;
    }

    public void propertyChange(PropertyChangeEvent evt) {
//        System.out.printf("Changed %s\n", evt.getNewValue().toString());
    }
}
