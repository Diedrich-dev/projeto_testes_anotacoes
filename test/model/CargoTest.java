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

import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.Size;

import java.time.LocalTime;
import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author rafael
 */
public class CargoTest {

    private static ValidatorFactory factory;

    private static Validator validator;
    
    public CargoTest() {
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
    public void validarDescricaoMaximaMin() {
        Cargo cargo = new Cargo();
        cargo.setDescricao("TE");
        Set<ConstraintViolation<Cargo>> violations = validator.validate(cargo);
        for (ConstraintViolation<Cargo> violation : violations) {
            if (violation.getPropertyPath().toString().equalsIgnoreCase("descricao")) {
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Size) {
                    assertTrue("validar @Size", violation.getConstraintDescriptor().getAnnotation() instanceof Size);
                }
            }
        }
    }


    @Test
    public void validarCargaMensalNula(){
        Cargo cargo = new Cargo();
        cargo.setCargaHorariaMensal(LocalTime.now());
        Set<ConstraintViolation<Cargo>> violations = validator.validate(cargo);
        for(ConstraintViolation<Cargo> violation : violations){
            if(violation.getPropertyPath().toString().equalsIgnoreCase("cargaHorarioMensal")){
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof NotNull) {
                    assertTrue("validar @NotNull", violation.getConstraintDescriptor().getAnnotation() instanceof NotNull);
                }
            }
        }
    }

    @Test
    public void validarCargaMensalSintaxe(){
        Cargo cargo = new Cargo();
        cargo.setCargaHorariaMensal(LocalTime.now());
        Set<ConstraintViolation<Cargo>> violations = validator.validate(cargo);
        for(ConstraintViolation<Cargo> violation : violations){
            if(violation.getPropertyPath().toString().equalsIgnoreCase("cargaHorarioMensal")){
                System.out.println(violation.getMessage());
                if (violation.getConstraintDescriptor().getAnnotation() instanceof Pattern) {
                    assertTrue("validar @Pattern", violation.getConstraintDescriptor().getAnnotation() instanceof Pattern);
                }
            }
        }
    }

}
