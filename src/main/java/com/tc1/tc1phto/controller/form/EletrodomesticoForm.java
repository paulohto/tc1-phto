package com.tc1.tc1phto.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tc1.tc1phto.dominio.Eletrodomestico;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.Validation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EletrodomesticoForm {

    private Long id;
    @Autowired
    public Validator validator;

    @NotBlank(message = "Nome não pode estar em branco e não pode ser nulo.")
    @JsonProperty
    private String nome;

    @NotBlank(message = "Modelo não pode estar em branco e não pode ser nulo.")
    private String modelo;

    @NotBlank(message = "Potencia não pode estar em branco e não pode ser nulo.")
    private String potencia;

    @NotBlank(message = "Selo não pode estar em branco e não pode ser nulo.")
    private String selo;

    public EletrodomesticoForm(){}

    public EletrodomesticoForm(Long id, String nome, String modelo, String potencia, String selo){
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.selo = selo;
    }

    public EletrodomesticoForm(Eletrodomestico entidade){
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.modelo = entidade.getModelo();
        this.potencia = entidade.getPotencia();
        this.selo = entidade.getSelo();
    }

}
