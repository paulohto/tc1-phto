package com.tc1.tc1phto.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Data
@Entity
@NoArgsConstructor
@Table(name="tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty
    @Column(name="rua")
    private String rua;

    @JsonProperty
    @Column(name="numero")
    private String numero;

    @JsonProperty
    @Column(name="bairro")
    private String bairro;

    @JsonProperty
    @Column(name="cidade")
    private String cidade;

    @JsonProperty
    @Column(name="estado")
    private String estado;
    public Endereco(String rua, String numero, String bairro, String cidade,String estado){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
