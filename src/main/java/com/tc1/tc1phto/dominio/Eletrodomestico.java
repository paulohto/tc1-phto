package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Data
@Entity
@NoArgsConstructor
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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
