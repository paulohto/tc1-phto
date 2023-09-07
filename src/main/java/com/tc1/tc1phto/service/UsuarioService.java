package com.tc1.tc1phto.service;

import com.tc1.tc1phto.controller.form.PessoaForm;
import com.tc1.tc1phto.controller.form.UsuarioForm;
import com.tc1.tc1phto.controller.form.UsuarioPessoaForm;
import com.tc1.tc1phto.dominio.Pessoa;
import com.tc1.tc1phto.dominio.Usuario;
import com.tc1.tc1phto.exception.service.ControllerNotFoundException;
import com.tc1.tc1phto.exception.service.DatabaseException;
import com.tc1.tc1phto.repositorio.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private IRepositorioUsuario repoUsuario;

    @Transactional(readOnly = true)
    public Page<UsuarioPessoaForm> findAll(PageRequest page){
        Page<Usuario> usuarios = repoUsuario.findAll(page);
        return usuarios.map(UsuarioPessoaForm::fromEntity);
    }

    @Transactional(readOnly = true)
        public UsuarioPessoaForm findById(Long id){
        var usuario = repoUsuario.findById(id).orElseThrow(() -> new ControllerNotFoundException("Usuário não encontrado"));
        return UsuarioPessoaForm.fromEntity(usuario);
    }

    @Transactional
    public UsuarioForm save(UsuarioForm usuario) {
        //Usuario entidade = UsuarioForm.to new Usuario();
        var entidade = UsuarioForm.paraDominio(usuario);
        mapperFormParaDominio(usuario, entidade);
        var usuarioSalvo = repoUsuario.save(entidade);
        //return new UsuarioForm(usuarioSalvo);
        return UsuarioForm.deDominio(usuarioSalvo);
    }

    @Transactional
    public UsuarioForm update(Long id, UsuarioForm form) {
        try {
            Usuario entidade = repoUsuario.getReferenceById(id);
            UsuarioForm.mapperFormParaDominio(form, entidade);
            entidade = repoUsuario.save(entidade);
            return UsuarioForm.deDominio(entidade);

        }  catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Usuario não encontrado, id: " + id);
        }
    }

    @Transactional
    public void delete(Long id)  {
        try {
            repoUsuario.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade dos dados");
        }
    }

    public void mapperFormParaDominio(UsuarioForm form, Usuario entidade){
        entidade.setId(form.getId());
        entidade.setUsername(form.getUsername());
        entidade.setPassword(form.getPassword());
    }
}
