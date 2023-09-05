package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter @Setter
@Entity
@Table(name="tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    public Endereco(){}
    public Endereco(Long id, String rua, String numero, String bairro, String cidade,String estado){
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", numero=" + numero + '\'' +
                ", bairro=" + bairro + '\'' +
                ", cidade=" + cidade + '\'' +
                ", estado=" + estado +
                '}';
    }
}
