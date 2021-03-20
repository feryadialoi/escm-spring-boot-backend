package dev.feryadi.escm.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtil {
    @Autowired
    private Validator validator;

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> validationResult = validator.validate(object);

        if (validationResult.size() != 0) {
            throw new ConstraintViolationException(validationResult);
        }
    }
}
