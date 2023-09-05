package com.tc1.tc1phto.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.tc1.tc1phto.dominio.Endereco;
import com.tc1.tc1phto.dominio.Endereco;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EnderecoForm {
    private Long id;
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

    public EnderecoForm(){}
    public EnderecoForm(Long id, String rua, String numero, String bairro, String cidade, String estado){
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    public EnderecoForm(Endereco entidade){
       this.id = entidade.getId();
       this.rua = entidade.getRua();
       this.numero = entidade.getNumero();
       this.bairro = entidade.getBairro();
       this.cidade = entidade.getCidade();
       this.estado = entidade.getEstado();
    }

}
