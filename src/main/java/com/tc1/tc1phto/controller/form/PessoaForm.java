package com.tc1.tc1phto.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tc1.tc1phto.dominio.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PessoaForm {

    private Long id;
    @JsonProperty
    @NotBlank(message = "Nome não pode estar em branco e não pode ser nulo.")
    private String nome;
    @JsonProperty
    @NotBlank(message = "Data de Nascimento não pode estar em branco e não pode ser nulo.")
    private String data_nascimento;

    @JsonProperty
    @NotBlank(message = "Sexo não pode estar em branco e não pode ser nulo.")
    private String sexo;
    @JsonProperty
    @NotBlank(message = "Parentesco não pode estar em branco e não pode ser nulo.")
    private String parentesco;

    public PessoaForm(){}

    public PessoaForm(Long id, String nome, String data_nascimento, String sexo, String parentesco){
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
    }

    public PessoaForm(Pessoa entidade){
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.data_nascimento = entidade.getData_nascimento();
        this.sexo = entidade.getSexo();
        this.parentesco = entidade.getParentesco();
    }

}
