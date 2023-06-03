/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 *
 * @author pedro
 */
public class TelefoneValidator implements ConstraintValidator<Telefone, String>{

    private static final String TELEFONE_REGEX = "\\d{3}-\\d{4}-\\d{4}";
    private static final Pattern TELEFONE_PATTERN = Pattern.compile(TELEFONE_REGEX);

    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext context) {
        if (telefone == null) {
            return true;
        }

        // Verificar se o telefone corresponde ao padrão regex
        boolean isValid = TELEFONE_PATTERN.matcher(telefone).matches();

        return isValid;
    }
    
}
