package util.validacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CPFValidator.class)
public @interface CPF {
    String message() default "Numero de CPF invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}