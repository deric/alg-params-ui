package cz.cvut.fit.alg.params.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import cz.cvut.fit.alg.params.context.DefaultContext;
import cz.cvut.fit.alg.params.context.DefaultPublishingContext;
import cz.cvut.fit.alg.params.util.AnnotationPropertyExtractor;

/**
 *
 * @author ytoh
 */
public class Boot4 {
    public static void main(String[] args) {
        DefaultPublishingContext defaultContext = new DefaultPublishingContext(new DefaultContext());

        defaultContext.register(Double.class, 10.0, "max");
        defaultContext.register(Double.class, -10.0, "min");

        JFrame f = new JFrame("Table test");
        f.getContentPane().setLayout(new BorderLayout());
        final Bean3 b = new Bean3();

        PropertyTable table = new PropertyTable(b, new AnnotationPropertyExtractor(defaultContext));
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
