package th.co.geniustree.quarkus;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;

import java.util.*;

@Named("validation")
@RequestScoped
public class Validation extends io.quarkiverse.renarde.util.Validation {

    private List<io.quarkiverse.renarde.util.Validation.Error> errors = new ArrayList<>();

    @Override
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void required(String field, Object value) {
        if (value == null || (value instanceof String && ((String) value).isEmpty()))
            addError(field, "Required");
    }

    @Override
    public void addError(String field, String message) {
        errors.add(new io.quarkiverse.renarde.util.Validation.Error(field, message));
    }

    @Override
    // Called from ifError.html
    public boolean hasError(String field) {
        for (io.quarkiverse.renarde.util.Validation.Error error : errors) {
            if (error.field.equals(field))
                return true;
        }
        return false;
    }

    @Override
    // Called from error.html
    public String getError(String field) {
        for (io.quarkiverse.renarde.util.Validation.Error error : errors) {
            if (error.field.equals(field))
                return error.message;
        }
        return null;
    }

    @Override
    public void addErrors(Set<ConstraintViolation<Object>> violations) {
        for (ConstraintViolation<Object> violation : violations) {
            Iterator<Path.Node> iterator = violation.getPropertyPath().iterator();
            String lastNode = null;
            int size = 0;
            while (iterator.hasNext()) {
                lastNode = iterator.next().getName();
                size++;
            }
            addError(lastNode, violation.getMessage());
            if (size > 1) {
                var prop = violation.getPropertyPath().toString();
                addError(prop.substring(prop.indexOf('.') + 1), violation.getMessage());
            }
        }
    }
}