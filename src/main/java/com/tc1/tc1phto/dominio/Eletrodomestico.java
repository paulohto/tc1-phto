package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tc1.tc1phto.controller.form.EletrodomesticoForm;
import lombok.Getter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter @Setter
@Entity
@Table(name="tb_eletrodomestico")
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String modelo;

    private String potencia;

    private String selo;

    public Eletrodomestico(){}

    public Eletrodomestico(Long id, String nome, String modelo, String potencia, String selo){
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.selo = selo;
    }

    public Eletrodomestico(EletrodomesticoForm form) {
        this.id = form.getId();
        this.nome = form.getNome();
        this.modelo = form.getModelo();
        this.potencia = form.getPotencia();
        this.selo = form.getSelo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eletrodomestico produto = (Eletrodomestico) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Eletrodomestico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modelo=" + modelo + '\'' +
                ", potencia=" + potencia + '\'' +
                ", selo=" + selo +
                '}';
    }
}