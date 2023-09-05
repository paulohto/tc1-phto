package com.tc1.tc1phto.repositorio;

import com.tc1.tc1phto.dominio.Endereco;
import com.tc1.tc1phto.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioEndereco extends JpaRepository<Endereco, Long> {
}