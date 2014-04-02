package cz.cvut.fit.alg.params.ui;



import org.hibernate.validator.constraints.NotEmpty;
import cz.cvut.fit.alg.params.annotations.Component;
import cz.cvut.fit.alg.params.annotations.Property;

import javax.validation.constraints.NotNull;

/**
 *
 * @author ytoh
 */
@Component(name="Third level bean")
public class Bean3 {
    @Property(name="Name", description = "Blabla")
    @NotNull
    @NotEmpty
    private String name;

    @Property
    @DynamicRange(fromKey="min", toKey="max", defaultFrom=-1.0, defaultTo=1.0)
    private double x;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
