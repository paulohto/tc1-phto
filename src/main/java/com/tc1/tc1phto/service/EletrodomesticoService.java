package com.tc1.tc1phto.service;

import com.tc1.tc1phto.controller.form.EletrodomesticoForm;
import com.tc1.tc1phto.dominio.Eletrodomestico;
import com.tc1.tc1phto.exception.service.ControllerNotFoundException;
import com.tc1.tc1phto.exception.service.DatabaseException;
import com.tc1.tc1phto.repositorio.IRepositorioEletrodomesticos;

//import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Service
public class EletrodomesticoService {

    @Autowired
    private IRepositorioEletrodomesticos repoEletro;

    @Transactional(readOnly = true)
    public Page<EletrodomesticoForm> findAll(PageRequest page){
        Page<Eletrodomestico> eletrodomesticos = repoEletro.findAll(page);
        return eletrodomesticos.map(e -> new EletrodomesticoForm(e));
    }

    @Transactional(readOnly = true)
    public EletrodomesticoForm findById(Long id){
        var eletrodomestico = repoEletro.findById(id).orElseThrow(() -> new ControllerNotFoundException("Eletrodoméstico não encontrado"));
        return new EletrodomesticoForm(eletrodomestico);
    }


    @Transactional
    public EletrodomesticoForm save(EletrodomesticoForm eletrodomestico){
        Eletrodomestico entidade = new Eletrodomestico();
        mapperFormParaDominio(eletrodomestico, entidade);
        var eletroSalvo = repoEletro.save(entidade);
        return new EletrodomesticoForm(eletroSalvo);
    }

    @Transactional
    public EletrodomesticoForm update(Long id, EletrodomesticoForm eletrodomestico) {
        try {
            Eletrodomestico entidade = repoEletro.getReferenceById(id);
            mapperFormParaDominio(eletrodomestico, entidade);
            return new EletrodomesticoForm(entidade);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Eletrodoméstico não encontrado, id:" + id);
        }
    }

    public void delete(Long id){
        try{
            repoEletro.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Entidade não encontrada com o ID: " + id);
        } catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade da base");
        }
    }

    private void mapperFormParaDominio(EletrodomesticoForm form, Eletrodomestico dominio) {
        dominio.setId(form.getId());
        dominio.setNome(form.getNome());
        dominio.setModelo(form.getModelo());
        dominio.setSelo(form.getSelo());
        dominio.setPotencia(form.getPotencia());

//        for (EletrodomesticoForm eletrodomesticoForm: form.) {
//            Categoria categoria = categoriaRepo.getOne(categoriaDTO.getId());
//            entity.getCategorias().add(categoria);
//        }
    }


}
