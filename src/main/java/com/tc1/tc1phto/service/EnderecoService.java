package com.tc1.tc1phto.service;

import com.tc1.tc1phto.controller.form.EnderecoForm;
import com.tc1.tc1phto.controller.form.PessoaForm;
import com.tc1.tc1phto.dominio.Endereco;
import com.tc1.tc1phto.dominio.Pessoa;
import com.tc1.tc1phto.exception.service.ControllerNotFoundException;
import com.tc1.tc1phto.exception.service.DatabaseException;
import com.tc1.tc1phto.repositorio.IRepositorioEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Validator;
import java.net.URI;

@Service
public class EnderecoService {

    @Autowired
    private IRepositorioEndereco repoEndereco;
    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    public Page<EnderecoForm> findAll(PageRequest page){
        Page<Endereco> enderecos = repoEndereco.findAll(page);
        return enderecos.map(e -> new EnderecoForm(e));
    }

    @Transactional(readOnly = true)
    public EnderecoForm findById(Long id){
        var endereco = repoEndereco.findById(id).orElseThrow(() -> new ControllerNotFoundException("Endereco não encontrado"));
        return new EnderecoForm(endereco);
    }

    @Transactional
    public EnderecoForm save(EnderecoForm endereco){
        Endereco entidade = new Endereco();
        mapperFormParaDominio(endereco, entidade);
        var enderecoSalvo = repoEndereco.save(entidade);
        return new EnderecoForm(enderecoSalvo);
    }

    @Transactional
    public EnderecoForm update(Long id, EnderecoForm endereco){
        try{
            Endereco entidade = repoEndereco.getOne(id);
            mapperFormParaDominio(endereco, entidade);
            return new EnderecoForm(entidade);
        }catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Endereco não encontrado, id:" + id);
        }
    }

    @Transactional
    public void delete(Long id){
        try{
            repoEndereco.deleteById(id);
        }catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Endereço não encontrada, id:" + id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de integridade da base");
        }
    }

    public void mapperFormParaDominio(EnderecoForm form, Endereco entidade){
        entidade.setId(form.getId());
        entidade.setRua(form.getRua());
        entidade.setNumero(form.getNumero());
        entidade.setBairro(form.getBairro());
        entidade.setCidade(form.getCidade());
        entidade.setEstado(form.getEstado());
    }
}
