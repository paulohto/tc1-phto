package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String data_nascimento;

    private String sexo;

    private String parentesco;

    public Pessoa() {}

    public Pessoa (Long id, String nome, String data_nascimento, String sexo, String parentesco){
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data_nascimento=" + data_nascimento + '\'' +
                ", sexo=" + sexo + '\'' +
                ", parentesco=" + parentesco +
                '}';
    }
}
