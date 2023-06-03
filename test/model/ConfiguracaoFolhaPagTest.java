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

import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author rafael
 */
public class ConfiguracaoFolhaPagTest {

    private static ValidatorFactory factory;
    private static Validator validator;


    public ConfiguracaoFolhaPagTest() {
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
    public void testarAnoReferencia() {
        ConfiguracaoFolhaPag configuracaoFolhaPag = new ConfiguracaoFolhaPag();
        configuracaoFolhaPag.setAnoVigencia(null); // Define o valor como null para testar a anotação @NotNull
        Set<ConstraintViolation<ConfiguracaoFolhaPag>> violations = validator.validate(configuracaoFolhaPag);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<ConfiguracaoFolhaPag> violation = violations.iterator().next();
        assertEquals("não pode ser nulo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("anoVigencia", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarValorDiaValeAlimentacao() {
        ConfiguracaoFolhaPag ConfiguracaoFolhaPag = new ConfiguracaoFolhaPag();
        ConfiguracaoFolhaPag.setValorDiaValeAlimentacao(-32.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<ConfiguracaoFolhaPag>> violations = validator.validate(ConfiguracaoFolhaPag);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<ConfiguracaoFolhaPag> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("valorDiaValeAlimentacao", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarValorDiaValeTransporte() {
        ConfiguracaoFolhaPag ConfiguracaoFolhaPag = new ConfiguracaoFolhaPag();
        ConfiguracaoFolhaPag.setValorDiaValeTransporte(-13.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<ConfiguracaoFolhaPag>> violations = validator.validate(ConfiguracaoFolhaPag);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<ConfiguracaoFolhaPag> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("valorDiaValeTransporte", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarPercentualDescontoValeTransporte() {
        ConfiguracaoFolhaPag ConfiguracaoFolhaPag = new ConfiguracaoFolhaPag();
        ConfiguracaoFolhaPag.setPercentualDescontoValeTransporte(-3.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<ConfiguracaoFolhaPag>> violations = validator.validate(ConfiguracaoFolhaPag);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<ConfiguracaoFolhaPag> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("percentualDescontoValeTransporte", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarPercentualDescontoValeAlimentacao() {
        ConfiguracaoFolhaPag ConfiguracaoFolhaPag = new ConfiguracaoFolhaPag();
        ConfiguracaoFolhaPag.setPercentualDescontoValeAlimentacao(-235.8); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<ConfiguracaoFolhaPag>> violations = validator.validate(ConfiguracaoFolhaPag);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<ConfiguracaoFolhaPag> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("percentualDescontoValeAlimentacao", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }
    

}
