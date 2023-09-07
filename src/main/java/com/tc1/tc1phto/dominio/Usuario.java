package com.tc1.tc1phto.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name="tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // CRIANDO RELACIONAMENTO: UM PARA UM
    @OneToOne(mappedBy = "usuario")
    private Pessoa pessoa;

    public Usuario(){}

    public Usuario( String username, String password){
         this.username = username;
        this.password = password;
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username=" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
