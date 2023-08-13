package com.tc1.tc1phto.service;

import com.tc1.tc1phto.controller.dto.EletrodomesticoDTO;
import com.tc1.tc1phto.dominio.Eletrodomestico;
import com.tc1.tc1phto.repositorio.RepositorioEletrodomesticos;
import com.tc1.tc1phto.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EletrodomesicoService {
    @Autowired
    private RepositorioEletrodomesticos eletrodomesticosRepositorio;

    @Transactional
    public EletrodomesticoDTO insert(EletrodomesticoDTO dto){
        Eletrodomestico entity = new Eletrodomestico();
        copyDtoToEntity(dto, entity);
        entity = eletrodomesticosRepositorio.save(entity);
        return new EletrodomesticoDTO(entity);
    }

    @Transactional(readOnly = true)
    public EletrodomesticoDTO findById(Long id){
        Optional<Eletrodomestico> obj = eletrodomesticosRepositorio.findById(id);
        Eletrodomestico entity = obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado, id: " + id));
        return new EletrodomesticoDTO(entity);
    }

    private void copyDtoToEntity(EletrodomesticoDTO eletrodomesticoDto, Eletrodomestico eletrodomesticoEntity) {
        eletrodomesticoEntity.setNome(eletrodomesticoDto.getNome());
        eletrodomesticoEntity.setModelo(eletrodomesticoDto.getModelo());
        eletrodomesticoEntity.setPotencia(eletrodomesticoDto.getPotencia());
        eletrodomesticoEntity.setSelo(eletrodomesticoDto.getSelo());
    }
}
