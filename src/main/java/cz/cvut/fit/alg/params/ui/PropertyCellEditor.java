package cz.cvut.fit.alg.params.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import cz.cvut.fit.alg.params.Property;

/**
 *
 * @author ytoh
 */
public class PropertyCellEditor extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = 5547935951644376545L;

    private final Property property;
    private final JPanel panel;

    public PropertyCellEditor(Property property) {
        this.property = property;
        panel = new JPanel(new BorderLayout());
    }

    @Override
    public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row, int column) {
        property.setValue(value);

        Component editorComponent = property.getEditorComponent();

        editorComponent.validate();
        panel.removeAll();
        panel.add(editorComponent, BorderLayout.CENTER);
        if (panel.getComponentListeners().length == 0) {
            panel.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    table.setRowHeight(row, e.getComponent().getPreferredSize().height);
                }
            });
        }
        panel.setBackground(table.getBackground());
        for (int i = 0, size = panel.getComponentCount(); i < size; i++) {
            panel.getComponent(i).setBackground(table.getBackground());
        }

        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return this.property.getValue();
    }
}
