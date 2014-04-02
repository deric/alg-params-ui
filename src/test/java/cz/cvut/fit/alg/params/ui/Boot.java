package cz.cvut.fit.alg.params.ui;

import cz.cvut.fit.alg.params.ConfigException;
import cz.cvut.fit.alg.params.module.BasicModule;
import cz.cvut.fit.alg.params.module.Module;
import cz.cvut.fit.alg.params.module.Modules;

/**
 *
 * @author ytoh
 */
public class Boot {

    public static void main(String[] args) throws ConfigException {

        Module core = BasicModule.withName("core", Modules.getRootModule())
                .withComponent(new Object())
                .build();

        Module moduleA = BasicModule.withName("moduleA", core)
                .withComponent(new Object())
                .build();

        Module moduleB = BasicModule.withName("moduleB", core)
                .withComponent(new Object())
                .build();

        Module extension = BasicModule.withName("extension", Modules.getRootModule())
                .withComponent(new Object())
                .build();

        Module module1 = BasicModule.withName("module1", extension)
                .withComponent(new Bean2())
                .build();

        System.out.println(Modules.getModuleFullName(Modules.getRootModule()));
        System.out.println(Modules.getModuleFullName(core));
        System.out.println(Modules.getModuleFullName(moduleA));
        System.out.println(Modules.getModuleFullName(moduleB));
        System.out.println(Modules.getModuleFullName(extension));
        System.out.println(Modules.getModuleFullName(module1));

        Modules.save();

//        JFrame f = new JFrame("Table test");
//        f.getContentPane().setLayout(new BorderLayout());
//        final Bean b = new Bean();
//        System.out.println("b.getArray() = " + Arrays.toString(b.getArray()));
//        System.out.println("b.getSwitchers() = " + b.getSwitchers());
//        System.out.println("b.getSwitcher() = " + b.getSwitcher());
//        System.out.println("b.getMap() = " + b.getMap());
//        PropertyTable table = new PropertyTable(Modules.getModule("extension/module1").getComponent("bean2"));
//        PropertyTable table = new PropertyTable(b);
//        table.setRowHeight(25);
//
//        f.add(new JScrollPane(table), BorderLayout.CENTER);
//        f.setSize(400, 300);
//        f.pack();
//        f.setVisible(true);
//
//        f.addWindowListener(new WindowAdapter() {
//
//            @Override
//            public void windowClosing(WindowEvent e) {
////                System.out.println("b.getArray() = " + Arrays.toString(b.getArray()));
//                System.out.println("b.getSwitchers() = " + b.getSwitchers());
//                System.out.println("b.getSwitcher() = " + b.getSwitcher());
//                System.out.println("b.getMap() = " + b.getMap());
//                System.exit(0);
//            }
//        });
//        File config = new File(Modules.getModuleFullName(module1) + "bean2" + ".properties");
//        System.out.println(config.getAbsolutePath());
//        ConfigurationManager manager = new AnnotationConfigurationManager(new CommonsConfigurationProvider(new File(Modules.getModuleFullName(module1))));
//        manager.configure(module1);
    }
}
