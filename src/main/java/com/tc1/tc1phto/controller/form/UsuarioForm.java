package com.tc1.tc1phto.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tc1.tc1phto.dominio.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class UsuarioForm {

    private Long id;

    @NotBlank(message = "Username não pode estar em branco e não pode ser nulo.")
    private String username;
    @NotBlank(message = "Password não pode estar em branco e não pode ser nulo.")
    @Size(min = 6, message = "A senha deve ter pelo menos {min} caracteres")
    private String password;

    public UsuarioForm(){}

    public UsuarioForm(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UsuarioForm(Usuario usuario) {
        this(usuario.getId(), usuario.getUsername(), usuario.getPassword());
    }

    public  static  UsuarioForm deDominio(Usuario usuario) {
        return new UsuarioForm(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getPassword()
        );
    }

    public static Usuario paraDominio(UsuarioForm usuarioForm) {
        return  new Usuario(usuarioForm.username, usuarioForm.password);
    }

    public static  Usuario mapperFormParaDominio(
            UsuarioForm usuarioForm,
            Usuario usuario
    ) {
        usuario.setUsername(usuarioForm.username);
        usuario.setPassword(usuarioForm.password);
        return usuario;
    }

}
