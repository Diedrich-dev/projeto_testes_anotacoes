/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import jakarta.validation.constraints.PositiveOrZero;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.validacao.CTPS;
import util.validacao.ValidCargo;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author rafael
 */
public class FuncionarioTest {

    private static ValidatorFactory factory;
    private static Validator validator;


    public FuncionarioTest() {
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
    public void testarCtpsValido(){
        Funcionario funcionario = new Funcionario();
        funcionario.setCtps("12f13f3");
        Set<ConstraintViolation<Funcionario>> violations = validator.validate(funcionario);
        for (ConstraintViolation<Funcionario> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("ctps")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof CTPS) {
                    assertFalse("validar @CTPS", violation.getConstraintDescriptor().getAnnotation() instanceof CTPS);
                }
            }
        }
    }

    @Test
    public void testarDataAdimissaoValida(){
        Funcionario funcionario = new Funcionario();
        funcionario.setDataAdmissao(LocalDate.now());
        Set<ConstraintViolation<Funcionario>> violations = validator.validate(funcionario);
        for (ConstraintViolation<Funcionario> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("dataAdmissao")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Pattern) {
                    assertFalse("validar @Pattern", violation.getConstraintDescriptor().getAnnotation() instanceof Pattern);
                }
            }
        }
    }

    @Test
    public void testarDataDemissaoValido(){
        Funcionario funcionario = new Funcionario();
        funcionario.setDataDemissao(LocalDate.now());
        Set<ConstraintViolation<Funcionario>> violations = validator.validate(funcionario);
        for (ConstraintViolation<Funcionario> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("dataDemissao")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Pattern) {
                    assertFalse("validar @Pattern", violation.getConstraintDescriptor().getAnnotation() instanceof Pattern);
                }
            }
        }
    }

    @Test
    public void testarCargoValido(){
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(new Cargo());
        Set<ConstraintViolation<Funcionario>> violations = validator.validate(funcionario);
        for (ConstraintViolation<Funcionario> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("cargo")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof ValidCargo) {
                    assertFalse("validar @ValidCargo", violation.getConstraintDescriptor().getAnnotation() instanceof ValidCargo);
                }
            }
        }
    }

    @Test
    public void testarSalarioValido(){
        Funcionario funcionario = new Funcionario();
        funcionario.setSalario(1353.00);
        Set<ConstraintViolation<Funcionario>> violations = validator.validate(funcionario);
        for (ConstraintViolation<Funcionario> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("salario")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof PositiveOrZero) {
                    assertFalse("validar @PositiveOrZero", violation.getConstraintDescriptor().getAnnotation() instanceof PositiveOrZero);
                }
            }
        }
    }

}
