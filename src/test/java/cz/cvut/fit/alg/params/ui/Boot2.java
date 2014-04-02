package cz.cvut.fit.alg.params.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import cz.cvut.fit.alg.params.context.DefaultContext;
import cz.cvut.fit.alg.params.context.DefaultPublishingContext;
import cz.cvut.fit.alg.params.ui.PropertyTable;
import cz.cvut.fit.alg.params.util.AnnotationPropertyExtractor;

/**
 *
 * @author ytoh
 */
public class Boot2 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        List<String> trainers = Arrays.asList("linear", "polynomial");
        List<Integer> integers = Arrays.asList(1, 2, 3);
        DefaultPublishingContext context = new DefaultPublishingContext(new DefaultContext());
        context.register(String.class, strings, "key");
        context.register(Integer.class, integers, "");
        context.register(String.class, trainers, "key1");
        DynamicBean dynaBean = new DynamicBean();

        JFrame f = new JFrame("Table test");
        f.getContentPane().setLayout(new BorderLayout());

        PropertyTable table = new PropertyTable(dynaBean, new AnnotationPropertyExtractor(context));
        table.setRowHeight(25);

        f.add(new JScrollPane(table), BorderLayout.CENTER);
        f.setSize(400, 300);
        f.pack();
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
