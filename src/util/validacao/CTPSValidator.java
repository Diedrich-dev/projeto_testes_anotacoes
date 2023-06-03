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
public class CTPSValidator implements ConstraintValidator<CTPS, String>{

    private static final String CTPS_REGEX = "\\d{7}";
    private static final Pattern CTPS_PATTERN = Pattern.compile(CTPS_REGEX);

    @Override
    public boolean isValid(String ctps, ConstraintValidatorContext context) {
        if (ctps == null) {
            return true;
        }

        // Verificar se a CTPS corresponde ao padrão regex
        boolean isValid = CTPS_PATTERN.matcher(ctps).matches();

        return isValid;
    }
    
    
}
