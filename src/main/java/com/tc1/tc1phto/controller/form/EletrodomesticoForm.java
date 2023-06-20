package com.tc1.tc1phto.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tc1.tc1phto.dominio.Eletrodomestico;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import javax.validation.constraints.NotBlank;
import javax.validation.Validation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EletrodomesticoForm {
    @JsonProperty
    @NotBlank(message = "Nome não pode estar em branco e não pode ser nulo.")
    private String nome;
    @JsonProperty
    @NotBlank(message = "Modelo não pode estar em branco e não pode ser nulo.")
    private String modelo;
    @JsonProperty
    @NotBlank(message = "Potencia não pode estar em branco e não pode ser nulo.")
    private String potencia;
    @JsonProperty
    @NotBlank(message = "Selo não pode estar em branco e não pode ser nulo.")
    private String selo;

    public Eletrodomestico toEletro(){
        return new Eletrodomestico(nome, modelo, potencia, selo);
    }

}
