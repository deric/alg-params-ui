package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.api.PropertyEditor;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.fit.alg.params.Property;
import cz.cvut.fit.alg.params.api.FileDirectoryPicker;
import cz.cvut.fit.alg.params.context.PublishingContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileDirectoryPickerEditor extends JPanel implements PropertyEditor<String, FileDirectoryPicker>, ActionListener {

    private static final long serialVersionUID = 5686143374297149473L;

    private JButton browseButt;
    private JTextField pathField;
    private Property<String> prop;
    private FileDirectoryPicker annot;
    private JFileChooser fc;
    private boolean fileMustExist;

    public FileDirectoryPickerEditor() {
        super();
        setLayout(new FormLayout("fill:10dlu:grow,fill:30px", "pref"));

        browseButt = new JButton("...");
        pathField = new JTextField();

//        pathField.addActionListener(this);
        pathField.setEditable(false);

        fc = new JFileChooser();
    }

    @Override
    public Component getEditorComponent(final Property<String> property, final FileDirectoryPicker annotation, PublishingContext context) {
        prop = property;
        annot = annotation;

        ValueModel model = new PropertyAdapter(property, "value", true);

        fc.setDialogTitle(annotation.title());
        fc.setMultiSelectionEnabled(annotation.multipleFilesAllowed());

        if ((!annotation.allowDirectories()) && (!annotation.allowFiles())) {
            JLabel lbl = new JLabel("Selection of directories nor files is allowed. Can not continue");
            removeAll();
            add(lbl);
            revalidate();
            return this;
        }

        if (annotation.allowDirectories() && annotation.allowFiles()) {
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        } else {
            if (annotation.allowDirectories()) {
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            }
            if (annotation.allowFiles()) {
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            }
        }

        browseButt.addActionListener(this);

        fileMustExist = annotation.pathMustExist();

        removeAll();
        CellConstraints cc = new CellConstraints();
        add(pathField, cc.xy(1, 1));
        add(browseButt, cc.xy(2, 1));
        revalidate();

        pathField.setText(annotation.value());

        return this;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String paths = "";
        int res = fc.showDialog(null, annot.title());
        if (res == JFileChooser.APPROVE_OPTION) {

            if (fc.isMultiSelectionEnabled()) {
                String delimiter = System.getProperty("path.separator");
                File[] files = fc.getSelectedFiles();
                for (File file : files) {
                    if (fileMustExist) {
                        if (!file.exists()) {
                            JOptionPane.showMessageDialog(null, "File " + file.getAbsolutePath()
                                    + " does not exists.", "File does not exist", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        paths = paths + file.getAbsolutePath() + delimiter;
                    }
                }
                paths = paths.substring(0, paths.length() - 2);
            } else {
                paths = fc.getSelectedFile().getAbsolutePath();
            }

            pathField.setText(paths);
            prop.setValue(paths);
        }
    }
}
