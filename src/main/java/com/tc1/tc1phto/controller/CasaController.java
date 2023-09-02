package com.tc1.tc1phto.controller;

import com.tc1.tc1phto.controller.form.EletrodomesticoForm;
//import com.tc1.tc1phto.controller.form.EnderecoForm;
//import com.tc1.tc1phto.controller.form.PessoaForm;
import com.tc1.tc1phto.dominio.Eletrodomestico;
//import com.tc1.tc1phto.dominio.Endereco;
//import com.tc1.tc1phto.dominio.Pessoa;
import com.tc1.tc1phto.repositorio.IRepositorioEletrodomesticos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CasaController {

////    @Autowired
////    private IRepositorioEletrodomesticos repositorioEletrodomesticos;
//    @Autowired
//    private Validator validator;
//
////    @PostMapping
////    @RequestMapping("/eletrodomesticos")
////    public ResponseEntity criarEletrodomestico(@RequestBody EletrodomesticoForm eletroForm){
////        ResponseEntity violacoesToMap = validar(eletroForm);
////        if (violacoesToMap != null) return violacoesToMap;
////
////        Eletrodomestico eletro = eletroForm.toEletro();
////        repositorioEletrodomesticos.salvar(eletro);
////        return ResponseEntity.status(HttpStatus.CREATED).body(eletro);
////        //return ResponseEntity.ok("Eletrodoméstico cadastrado com sucesso!");
////    }
////
////    @GetMapping
////    public String consultaEletro(
////            @RequestParam (name = "nome") String nome,
////            @RequestParam (name = "modelo") String modelo,
////            @RequestParam (name = "potencia") String potencia,
////            @RequestParam (name = "selo") String selo
////    ){
////        Eletrodomestico eletrodomestico =
////                repositorioEletrodomesticos.buscar(nome,modelo,potencia,selo)
////                        .orElse( new Eletrodomestico() );
////
////        return String.format("OK", nome,modelo,potencia,selo);
////    }
//
//    @PostMapping
//    @RequestMapping("/pessoas")
//    public ResponseEntity criarPessoa(@RequestBody PessoaForm pessoaForm){
//        ResponseEntity violacoesToMap = validar(pessoaForm);
//        if (violacoesToMap != null) return violacoesToMap;
//
//        Pessoa pessoa = pessoaForm.toPessoa();
//        //return  ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
//        return ResponseEntity.ok("Pessoa cadastrada com sucesso!");
//    }
//
//    @PostMapping
//    @RequestMapping("/enderecos")
//    public ResponseEntity criarEndereco(@RequestBody EnderecoForm enderecoForm){
//        ResponseEntity violacoesToMap = validar(enderecoForm);
//        if(violacoesToMap != null) return violacoesToMap;
//
//        Endereco endereco = enderecoForm.toEndereco();
//        //return  ResponseEntity.status(HttpStatus.CREATED).body(endereco);
//        return ResponseEntity.ok("Endereço cadastrado com sucesso!");
//    }
//
//    private <T>ResponseEntity<Map<Path, String>> validar(T form) {
//        Set<ConstraintViolation<T>> violacoes = validator.validate(form);
//        Map<Path, String> violacoesToMap = violacoes.stream()
//                .collect(Collectors.toMap(
//                        violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));
//        if(!violacoesToMap.isEmpty()){
//            return ResponseEntity.badRequest().body(violacoesToMap);
//        }
//        return null;
//    }


}
