package com.tc1.tc1phto.repositorio;

import com.tc1.tc1phto.dominio.Pessoa;
import com.tc1.tc1phto.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioUsuario extends JpaRepository<Usuario, Long> {
}