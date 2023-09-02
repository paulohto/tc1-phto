package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getSelo() {
        return selo;
    }

    public void setSelo(String selo) {
        this.selo = selo;
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