package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Data
@Entity
@NoArgsConstructor
@Table(name="tb_eletrodomestico")
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty
    @Column(name="nome")
    private String nome;

    @JsonProperty
    @Column(name="modelo")
    private String modelo;

    @JsonProperty
    @Column(name="potencia")
    private String potencia;

    @JsonProperty
    @Column(name="selo")
    private String selo;

    public Eletrodomestico(String nome, String modelo, String potencia, String selo){
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.selo = selo;
    }
}
