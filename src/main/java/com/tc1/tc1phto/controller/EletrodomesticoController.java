package com.tc1.tc1phto.controller;

import com.tc1.tc1phto.controller.dto.EletrodomesticoDTO;
import com.tc1.tc1phto.service.EletrodomesicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eletrodomesticos")
public class EletrodomesticoController {
    @Autowired
    private Validator validator;
    @Autowired
    private EletrodomesicoService eletrodomesicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EletrodomesticoDTO> findById(@PathVariable Long id){

        EletrodomesticoDTO dto = eletrodomesicoService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<EletrodomesticoDTO> insert(@Valid @RequestBody EletrodomesticoDTO eletrodomesticoDto){

        eletrodomesticoDto = eletrodomesicoService.insert(eletrodomesticoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(eletrodomesticoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(eletrodomesticoDto);
    }
    private <T>ResponseEntity<Map<Path, String>> validar(T form) {
        Set<ConstraintViolation<T>> violacoes = validator.validate(form);
        Map<Path, String> violacoesToMap = violacoes.stream()
                .collect(Collectors.toMap(
                        violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));
        if(!violacoesToMap.isEmpty()){
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        return null;
    }
}
