package com.tc1.tc1phto.controller;

import com.tc1.tc1phto.controller.form.EnderecoForm;
//import com.tc1.tc1phto.controller.form.PessoaForm;
import com.tc1.tc1phto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
//@RequestMapping(name = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/enderecos")
    public ResponseEntity<Page<EnderecoForm>> findAll(
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ){
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var enderecos = enderecoService.findAll(pageRequest);
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("enderecos/{id}")
    public ResponseEntity<EnderecoForm> findById(@PathVariable Long id){
        var endereco = enderecoService.findById(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping("/enderecos")
    public ResponseEntity<EnderecoForm> save(@Valid @RequestBody EnderecoForm endereco){
        var enderecoSaved = enderecoService.save(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((enderecoSaved.getId())).toUri();
        return ResponseEntity.created(uri).body(enderecoSaved);
    }

    @PutMapping("/enderecos/{id}")
    public ResponseEntity<EnderecoForm> update(@RequestBody EnderecoForm endereco, @PathVariable Long id){
        var enderecoUpdated = enderecoService.update(id,endereco);
        return ResponseEntity.ok(enderecoUpdated);
    }

    @DeleteMapping("/enderecos/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
