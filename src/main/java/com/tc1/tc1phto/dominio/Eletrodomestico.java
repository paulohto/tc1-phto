package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class Eletrodomestico {
    @JsonProperty
    private String nome;
    @JsonProperty
    private String modelo;
    @JsonProperty
    private String potencia;
    @JsonProperty
    private String selo;

    public Eletrodomestico(String nome, String modelo, String potencia, String selo){
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.selo = selo;
    }
}
