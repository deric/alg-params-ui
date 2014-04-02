package cz.cvut.fit.alg.params.ui;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import cz.cvut.fit.alg.params.ConfigException;

/**
 *
 * @author ytoh
 */
public class MaxLengthValidator implements ConstraintValidator<MaxLength, String> {

    private int maxLength = Integer.MAX_VALUE;

    public void initialize(MaxLength annotation) {
        if (annotation.value() <= 0) {
            throw new ConfigException("Max length cannot be less then 1 (was " + annotation.value() + ")");
        }

        maxLength = annotation.value();
    }

    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        if (input == null) {
            return true;
        }

        return input.length() <= maxLength;
    }
}
