package com.salesianostriana.dam.validacion.simple.validadores;

import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

    private int min;
    private int max;


    @Override
    public void initialize(StrongPassword constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length()>max|| value.length()<min) {
            return false;
        }
        if(value.equals(value.toLowerCase())){
            return false;
        }
        if(value.equals(value.toUpperCase())){
            return false;
        }
        if(!value.matches(".*\\d.*")){
            return false;
        }
        if(!value.matches(".*[a-z].*")){
            return false;
        }
            if(!(value.contains(".") || value.contains(",") || value.contains("$")
                    || value.contains("-") || value.contains("_") || value.contains("@"))){
                return false;
        }
        return true;
    }
}
