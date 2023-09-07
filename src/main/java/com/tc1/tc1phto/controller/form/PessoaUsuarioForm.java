package com.tc1.tc1phto.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tc1.tc1phto.dominio.Pessoa;
import com.tc1.tc1phto.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class PessoaUsuarioForm {
    private Long id;
    @JsonProperty
    @NotBlank(message = "Nome não pode estar em branco e não pode ser nulo.")
    private String nome;
    @JsonProperty
    @NotBlank(message = "Data de Nascimento não pode estar em branco e não pode ser nulo.")
    private String data_nascimento;
    @JsonProperty
    @NotBlank(message = "Sexo não pode estar em branco e não pode ser nulo.")
    private String sexo;
    @JsonProperty
    @NotBlank(message = "Parentesco não pode estar em branco e não pode ser nulo.")
    private String parentesco;

    private UsuarioForm usuario;

    public PessoaUsuarioForm(){}

    public PessoaUsuarioForm(Long id, String nome, String data_nascimento, String sexo, String parentesco, UsuarioForm usuario) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
        this.usuario = usuario;
    }


    public static Pessoa toEntity(PessoaUsuarioForm form, Usuario usuario) {
        return new Pessoa(form, usuario);
    }

    public static PessoaUsuarioForm fromEntity(Pessoa pessoa) {
        return new PessoaUsuarioForm(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getData_nascimento(),
                pessoa.getSexo(),
                pessoa.getParentesco(),
                pessoa.getUsuario() != null ? new UsuarioForm(pessoa.getUsuario()) : null
        );
    }

    public static Pessoa mapperFormToEntity(
            PessoaUsuarioForm form,
            Pessoa pessoa,
            Usuario usuario
    ) {
        pessoa.setNome(form.getNome());
        pessoa.setData_nascimento(form.getData_nascimento());
        pessoa.setSexo(form.getSexo());
        pessoa.setParentesco(form.getParentesco());
        pessoa.setUsuario(usuario);
        return pessoa;
    }


}
