package util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CPFValidator implements ConstraintValidator<CPF, String> {

    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{11}");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || !CPF_PATTERN.matcher(value).matches()) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (todosOsDigitosIguais(value)) {
            return false;
        }

        // Verificar se os dígitos verificadores estão corretos
        if (!verificarVerificadores(value)) {
            return false;
        }

        // Verificar se o CPF é válido de acordo com as regras matemáticas
        if (!CPFValido(value)) {
            return false;
        }

        return true;
    }

    private int calcularDigito(int[] digitos, int index) {
        int sum = 0;
        int peso = index + 1;

        for (int i = 0; i < index; i++) {
            sum += digitos[i] * peso;
            peso--;
        }

        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    private boolean todosOsDigitosIguais(String cpf) {
        char primeiroDigito = cpf.charAt(0);

        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != primeiroDigito) {
                return false;
            }
        }

        return true;
    }

    private boolean verificarVerificadores(String cpf) {
        int[] digits = cpf.chars().map(Character::getNumericValue).toArray();
        int primeiroDigitoVerificador = digits[9];
        int segundoDigitoVerificador = digits[10];

        int calcularPrimeiroDigitoVerificador = calcularDigito(digits, 9);
        int calcularSegundoDigitoVerificador = calcularDigito(digits, 10);

        return primeiroDigitoVerificador == calcularPrimeiroDigitoVerificador && segundoDigitoVerificador == calcularSegundoDigitoVerificador;
    }

    private boolean CPFValido(String cpf) {
        int[] digitos = cpf.chars().map(Character::getNumericValue).toArray();

        // Verifica o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digitos[i] * (10 - i);
        }
        int primeiroDigitoVerificador = 11 - (sum % 11);
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }
        if (digitos[9] != primeiroDigitoVerificador) {
            return false;
        }

        // Verifica o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digitos[i] * (11 - i);
        }
        int segundoDigitoVerificador = 11 - (sum % 11);
        if (segundoDigitoVerificador >= 10) {
            segundoDigitoVerificador = 0;
        }
        if (digitos[10] != segundoDigitoVerificador) {
            return false;
        }

        return true;
    }
}
