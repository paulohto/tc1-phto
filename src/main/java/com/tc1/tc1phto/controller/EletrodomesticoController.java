package com.tc1.tc1phto.controller;

import com.tc1.tc1phto.controller.form.EletrodomesticoForm;
import com.tc1.tc1phto.dominio.Eletrodomestico;
import com.tc1.tc1phto.repositorio.IRepositorioEletrodomesticos;
import com.tc1.tc1phto.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;

@RestController
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    private EletrodomesticoService eletrodomesticoService;
    @Autowired
    private Validator validator;

    @GetMapping
    public ResponseEntity<Page<EletrodomesticoForm>> findAll(
        @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
        @RequestParam(value = "tamanho", defaultValue = "10") Integer tamanho
    ){
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        var eletrodomesticos = eletrodomesticoService.findAll(pageRequest);
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EletrodomesticoForm> findById(@PathVariable Long id){
        var eletrodomestico = eletrodomesticoService.findById(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<EletrodomesticoForm> save(@Valid @RequestBody EletrodomesticoForm eletrodomestico){
        var eletroSaved = eletrodomesticoService.save(eletrodomestico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((eletroSaved.getId())).toUri();
        return ResponseEntity.created(uri).body(eletroSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EletrodomesticoForm> update(
            @RequestBody EletrodomesticoForm eletrodomestico, @PathVariable Long id
    ){
        var eletroUpdated = eletrodomesticoService.update(id,eletrodomestico);
        return ResponseEntity.ok(eletroUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        eletrodomesticoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

