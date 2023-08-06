package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="tb_pessoa")
public class Pessoa {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty
    @Column(name="nome")
    private String nome;


    @JsonProperty
    @Column(name="data_nascimento")
    private String datanascimento;


    @JsonProperty
    @Column(name="sexo")
    private String sexo;

    @JsonProperty
    @Column(name="parentesco")
    private String parentesco;

    public Pessoa (String nome, String datanascimento, String sexo, String parentesco){
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
    }
}
