package util.validacao;

import model.Cargo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CargoValidador implements ConstraintValidator<ValidCargo, Cargo> {
    public boolean isValid(Cargo cargo, ConstraintValidatorContext context) {
        if (cargo == null) {
            return true; // Cargo nulo será tratado por outras anotações
        }

        // Aqui você pode implementar sua lógica de validação personalizada para a classe Cargo
        // Por exemplo, verificar se todos os campos obrigatórios estão preenchidos corretamente

        boolean isValid = true/* Implemente sua lógica de validação aqui */;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Cargo inválido")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
