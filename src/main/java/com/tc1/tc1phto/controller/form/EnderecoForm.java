package com.tc1.tc1phto.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tc1.tc1phto.dominio.Endereco;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EnderecoForm {
    @JsonProperty
    @NotBlank(message = "Rua não pode estar em branco e não pode ser nulo.")
    private String rua;
    @JsonProperty
    @NotBlank(message = "Número não pode estar em branco e não pode ser nulo.")
    private String numero;
    @JsonProperty
    @NotBlank(message = "Bairro não pode estar em branco e não pode ser nulo.")
    private String bairro;
    @JsonProperty
    @NotBlank(message = "Cidade não pode estar em branco e não pode ser nulo.")
    private String cidade;
    @JsonProperty
    @NotBlank(message = "Estado não pode estar em branco e não pode ser nulo.")
    private String estado;

    public Endereco toEndereco(){
        return new Endereco(rua,numero, bairro, cidade,estado);
    }
}
