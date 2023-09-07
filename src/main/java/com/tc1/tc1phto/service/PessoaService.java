package com.tc1.tc1phto.service;

import com.tc1.tc1phto.controller.form.EletrodomesticoForm;
import com.tc1.tc1phto.controller.form.PessoaForm;
import com.tc1.tc1phto.controller.form.PessoaUsuarioForm;
import com.tc1.tc1phto.dominio.Eletrodomestico;
import com.tc1.tc1phto.dominio.Pessoa;
import com.tc1.tc1phto.exception.service.ControllerNotFoundException;
import com.tc1.tc1phto.exception.service.DatabaseException;
import com.tc1.tc1phto.repositorio.IRepositorioPessoas;
import com.tc1.tc1phto.repositorio.IRepositorioUsuario;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private IRepositorioPessoas repoPessoa;
    @Autowired
    private IRepositorioUsuario repoUsuario;

    @Transactional(readOnly = true)
    public Page<PessoaUsuarioForm> findAll(PageRequest page){
        Page<Pessoa> pessoas = repoPessoa.findAll(page);
        return pessoas.map(PessoaUsuarioForm::fromEntity);
    }

    @Transactional(readOnly = true)
    public PessoaUsuarioForm findById(Long id){
        var pessoa = repoPessoa.findById(id).orElseThrow(() -> new ControllerNotFoundException("Pessoa não encontrado"));
        return PessoaUsuarioForm.fromEntity(pessoa);
    }

    @Transactional
    public PessoaUsuarioForm save(PessoaUsuarioForm pessoa){
        try {

            var usuario = repoUsuario.getReferenceById(pessoa.getId());
            var entidade = PessoaUsuarioForm.toEntity(pessoa, usuario);
            //Pessoa entidade = new Pessoa();
            //mapperFormParaDominio(pessoa, entidade);
            var pessoaSalvo = repoPessoa.save(entidade);
            return PessoaUsuarioForm.fromEntity(pessoaSalvo);

        } catch (DataIntegrityViolationException e) {
            throw  new DatabaseException("Usuário não encontrado");
        }

    }

    @Transactional
    public PessoaUsuarioForm update(Long id, PessoaUsuarioForm pessoa){
        try{
            var usuario = repoUsuario.getReferenceById(pessoa.getId());
            Pessoa entidade = repoPessoa.getReferenceById(id);
            PessoaUsuarioForm.mapperFormToEntity(pessoa, entidade, usuario);
            //mapperFormParaDominio(pessoa, entidade);
            entidade = repoPessoa.save(entidade);
            return PessoaUsuarioForm.fromEntity(entidade);

        }catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Pessoa não encontrada, id:" + id);
        }
    }
    @Transactional
    public void delete(Long id){
        try{
            repoPessoa.deleteById(id);
        }catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("Pessoa não encontrada, id:" + id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de integridade da base");
        }
    }

    //SERÁ QUE ISSO ESTÁ SENDO USADO?
    public void mapperFormParaDominio(PessoaForm form, Pessoa entidade){
        entidade.setId(form.getId());
        entidade.setNome(form.getNome());
        entidade.setData_nascimento(form.getData_nascimento());
        entidade.setSexo(form.getSexo());
        entidade.setParentesco(form.getParentesco());
    }

}
