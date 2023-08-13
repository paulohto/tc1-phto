package com.tc1.tc1phto.controller.dto;

import com.tc1.tc1phto.dominio.Eletrodomestico;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class EletrodomesticoDTO {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Nome não pode estar em branco e não pode ser nulo.")
    private String nome;

    @NotBlank(message = "Modelo não pode estar em branco e não pode ser nulo.")
    private String modelo;

    @NotBlank(message = "Potencia não pode estar em branco e não pode ser nulo.")
    private String potencia;

    @NotBlank(message = "Selo não pode estar em branco e não pode ser nulo.")
    private String selo;

    public EletrodomesticoDTO(Eletrodomestico entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.modelo = entity.getModelo();
        this.potencia = entity.getPotencia();
        this.selo = entity.getSelo();
    }
}
