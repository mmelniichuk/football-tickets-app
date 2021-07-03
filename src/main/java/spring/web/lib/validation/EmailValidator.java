package spring.web.lib.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    public static final String EMAIL_VALIDATION_REGEX = "^(.+)@(.+)$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(EMAIL_VALIDATION_REGEX);
    }
}
