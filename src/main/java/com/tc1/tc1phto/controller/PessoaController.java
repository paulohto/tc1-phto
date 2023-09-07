package com.tc1.tc1phto.controller;

import com.tc1.tc1phto.controller.form.PessoaForm;
import com.tc1.tc1phto.controller.form.PessoaUsuarioForm;
import com.tc1.tc1phto.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;

@RestController
//@RequestMapping(name="/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoas")
    public ResponseEntity<Page<PessoaUsuarioForm>> findAll(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ){
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var pessoas = pessoaService.findAll(pageRequest);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<PessoaUsuarioForm> findById(@PathVariable Long id){
        var pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping("/pessoas")
    public ResponseEntity<PessoaUsuarioForm> save(@Valid @RequestBody PessoaUsuarioForm pessoa){
        var pessoaSaved = pessoaService.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((pessoaSaved.getId())).toUri();
        return ResponseEntity.created(uri).body(pessoaSaved);
    }

    @PutMapping("pessoas/{id}")
    public ResponseEntity<PessoaUsuarioForm> update( @RequestBody PessoaUsuarioForm pessoa, @PathVariable Long id){
        var pessoaUpdated = pessoaService.update(id,pessoa);
        return ResponseEntity.ok(pessoaUpdated);
    }

    @DeleteMapping("pessoas/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
