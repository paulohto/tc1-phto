package com.tc1.tc1phto.controller.form;

import com.tc1.tc1phto.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class UsuarioPessoaForm {
    private Long id;

    @NotBlank(message = "Username não pode estar em branco e não pode ser nulo.")
    private String username;
    @NotBlank(message = "Password não pode estar em branco e não pode ser nulo.")
    @Size(min = 6, message = "A senha deve ter pelo menos {min} caracteres")
    private String password;
    private PessoaForm pessoa;

    public UsuarioPessoaForm() {
    }

    public UsuarioPessoaForm(Long id, String username, String password, PessoaForm pessoa) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.pessoa = pessoa;
    }

    public static UsuarioPessoaForm fromEntity(Usuario usuario) {
        return new UsuarioPessoaForm(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getPessoa() != null ? new PessoaForm(usuario.getPessoa()) : null
        );
    }


}
