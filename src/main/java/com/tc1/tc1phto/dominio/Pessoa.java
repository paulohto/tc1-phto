package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Pessoa {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty
    private String nome;
    @JsonProperty
    private String datanascimento;
    @JsonProperty
    private String sexo;
    @JsonProperty
    private String parentesco;

    public Pessoa (String nome, String datanascimento, String sexo, String parentesco){
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
    }
}
