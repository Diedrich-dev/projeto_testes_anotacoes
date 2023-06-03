/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;

import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author rafael
 */
public class EnderecoTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    public EnderecoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testarCidadeValida(){
        Endereco endereco = new Endereco();
        endereco.setCidade("bauru");
        Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);
        for (ConstraintViolation<Endereco> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("cidade")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank) {
                    assertFalse("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Pattern) {
                    assertTrue("validar @Pattern", violation.getConstraintDescriptor().getAnnotation() instanceof Pattern);
                }
            }
        }
    }
    @Test
    public void testarBairroValido(){
        Endereco endereco = new Endereco();
        endereco.setBairro("santo antonio");
        Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);
        for (ConstraintViolation<Endereco> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("bairro")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank) {
                    assertFalse("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Pattern) {
                    assertTrue("validar @Pattern", violation.getConstraintDescriptor().getAnnotation() instanceof Pattern);
                }
            }
        }
    }
    @Test
    public void testarRuaValida(){
        Endereco endereco = new Endereco();
        endereco.setRua("magalhaes");
        Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);
        for (ConstraintViolation<Endereco> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("rua")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank) {
                    assertFalse("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Pattern) {
                    assertTrue("validar @Pattern", violation.getConstraintDescriptor().getAnnotation() instanceof Pattern);
                }
            }
        }
    }

    @Test
    public void testarNumeroValido(){
        Endereco endereco = new Endereco();
        endereco.setNumero(123);
        Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);
        for (ConstraintViolation<Endereco> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("cidade")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof NotNull) {
                    assertFalse("validar @NotNull", violation.getConstraintDescriptor().getAnnotation() instanceof NotNull);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Min) {
                    assertTrue("validar @Min", violation.getConstraintDescriptor().getAnnotation() instanceof Min);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Positive) {
                    assertTrue("validar @Positive", violation.getConstraintDescriptor().getAnnotation() instanceof Positive);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Digits) {
                    assertTrue("validar @Digits", violation.getConstraintDescriptor().getAnnotation() instanceof Digits);
                }
            }
        }
    }

    
}
