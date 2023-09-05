package com.tc1.tc1phto.controller;

import com.tc1.tc1phto.controller.form.UsuarioForm;
import com.tc1.tc1phto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
//@RequestMapping(name = "/usuarios")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<Page<UsuarioForm>> findAll(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
            ){
        PageRequest pageRequest = PageRequest.of(pagina,tamanho);
        var usuarios = usuarioService.findAll(pageRequest);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("usuarios/{id}")
    public ResponseEntity<UsuarioForm> findById(@PathVariable Long id){
        var usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioForm> save(@Valid @RequestBody UsuarioForm form){
        var usuarioSaved = usuarioService.save(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((usuarioSaved.getId())).toUri();
        return ResponseEntity.created(uri).body(usuarioSaved);
    }

    @PutMapping("usuarios/{id}")
    public ResponseEntity<UsuarioForm> update(@Valid @RequestBody UsuarioForm form, @PathVariable Long id){
        var usuario = usuarioService.update(id,form);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
