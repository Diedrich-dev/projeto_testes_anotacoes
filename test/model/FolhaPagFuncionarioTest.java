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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author rafael
 */
public class FolhaPagFuncionarioTest {

    private static ValidatorFactory factory;
    private static Validator validator;


    public FolhaPagFuncionarioTest() {
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
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setAnoReferencia(null); // Define o valor como null para testar a anotação @NotNull
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("não pode ser nulo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("anoReferencia", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarMesReferencia() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setMesReferencia(null); // Define o valor como null para testar a anotação @NotNull
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("não pode ser nulo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("mesReferencia", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarDataPagamento() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setDataPagamento(LocalDate.now()); // Define uma data inválida para testar a anotação @Pattern
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("data pagamento esta fora do padrão", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("dataPagamento", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarHorasTrabalhadas() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setHorasTrabalhadas(LocalTime.now()); // Define uma hora inválida para testar a anotação @Pattern
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("horas trabalhadas esta fora do padrao", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("horasTrabalhadas", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarFaltasSemJustificativa() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setFaltasSemJustificativa(-1); // Define um valor negativo para testar a anotação @Min
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("não pode adicionar numero negativos", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("faltasSemJustificativa", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarSalarioBase() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setSalarioBase(-1000.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("salarioBase", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarValorHorasExtras() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setValorHorasExtras(-123.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("valorHorasExtras", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarTotalProventos() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setTotalProventos(-1125.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("totalProventos", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarValorValeTransporte() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setValorValeTransporte(-110.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("valorValeTransporte", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarValorValeAlimentacao() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setValorValeAlimentacao(-1000.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("valorValeAlimentacao", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarDescontoINSS() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setDescontoINSS(-210.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("descontoINSS", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarDescontoIR() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setDescontoIR(-10120.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("descontoIR", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarDescontoValeTransporte() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setDescontoValeTransporte(-120.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("descontoValeTransporte", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarDescontoValeAlimentacao() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setDescontoValeAlimentacao(-10.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("descontoValeAlimentacao", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarValorFGTS() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setValorFGTS(-1120.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("valorFGTS", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarTotalDescontos() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setTotalDescontos(-356.0); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("totalDescontos", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }

    @Test
    public void testarSalarioLiquido() {
        FolhaPagFuncionario folhaPagFuncionario = new FolhaPagFuncionario();
        folhaPagFuncionario.setSalarioLiquido(-32.9); // Define um valor negativo para testar a anotação @PositiveOrZero
        Set<ConstraintViolation<FolhaPagFuncionario>> violations = validator.validate(folhaPagFuncionario);
        assertEquals(1, violations.size()); // Verifica se há apenas uma violação de validação
        ConstraintViolation<FolhaPagFuncionario> violation = violations.iterator().next();
        assertEquals("o valor não pode ser negativo", violation.getMessage()); // Verifica a mensagem de erro esperada
        assertEquals("salarioLiquido", violation.getPropertyPath().toString()); // Verifica o campo que violou a validação
    }
}
