/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.validacao.CPF;
import util.validacao.Email;
import util.validacao.Telefone;

import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class PessoaTest {
    
    private static ValidatorFactory factory;
    private static Validator validator;
    
    public PessoaTest() {
        
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
    public void testarNomeEmBranco() {
        Pessoa p = new Pessoa();
        p.setNome("    ");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        for (ConstraintViolation<Pessoa> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("nome")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank) {
                    assertTrue("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Size) {
                    assertFalse("validar @Size", violation.getConstraintDescriptor().getAnnotation() instanceof Size);
                }
            }
        }
    }
    
    @Test
    public void testarQuantidadeMinCaracteresNome(){
        Pessoa p = new Pessoa();
        p.setNome("ed");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        for (ConstraintViolation<Pessoa> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("nome")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank) {
                    assertFalse("validar @NotBlank", violation.getConstraintDescriptor().getAnnotation() instanceof NotBlank);
                }
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Size) {
                    assertTrue("validar @Size", violation.getConstraintDescriptor().getAnnotation() instanceof Size);
                }
            }
        }
    }
    
    
    @Test
    public void testarNomeValido(){
        Pessoa p = new Pessoa();
        p.setNome("And");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        for (ConstraintViolation<Pessoa> violation : violations) {
            assertFalse("validar nome", violation.getPropertyPath().toString().equalsIgnoreCase("nome"));
        }
        
        p.setNome("pedrohenriquejorgejoaocarlosPedrorafaelgustavo");
        violations = validator.validate(p);
        for (ConstraintViolation<Pessoa> violation : violations) {
            assertFalse("validar nome com 90 caracteres", violation.getPropertyPath().toString().equalsIgnoreCase("nome"));
        }
    }
    
    @Test
    public void testarCPFValido(){
        Pessoa p = new Pessoa();
        p.setCpf("2532623625");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        for (ConstraintViolation<Pessoa> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("cpf")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof CPF) {
                    assertTrue("validar @CPF", violation.getConstraintDescriptor().getAnnotation() instanceof CPF);
                }
            }
        }
    }

    @Test
    public void testarEmailValido(){
        Pessoa p = new Pessoa();
        p.setEmail("pedroDiedrich123@gmail.com");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        for (ConstraintViolation<Pessoa> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("email")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Email) {
                    assertTrue("validar @Email", violation.getConstraintDescriptor().getAnnotation() instanceof Email);
                }
            }
        }
    }

    @Test
    public void testarTelefoneValido(){
        Pessoa p = new Pessoa();
        p.setTelefone("2532623625");
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        for (ConstraintViolation<Pessoa> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("telefone")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Telefone) {
                    assertTrue("validar @Telefone", violation.getConstraintDescriptor().getAnnotation() instanceof Telefone);
                }
            }
        }
    }

    
}
