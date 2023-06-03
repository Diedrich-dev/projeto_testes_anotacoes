package util.validacao;

import model.Endereco;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnderecoValidador implements ConstraintValidator<ValidEndereco, Endereco> {
    public boolean isValid(Endereco endereco, ConstraintValidatorContext context) {
        if (endereco == null) {
            return true; // Endereço nulo será tratado por outras anotações
        }

        // Aqui você pode implementar sua lógica de validação personalizada para a classe Endereco
        // Por exemplo, verificar se todos os campos obrigatórios estão preenchidos corretamente

        boolean isValid = true/* Implemente sua lógica de validação aqui */;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Endereço inválido")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
