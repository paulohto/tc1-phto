package com.tc1.tc1phto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorBean {
    @Bean
    Validator validator (){
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
