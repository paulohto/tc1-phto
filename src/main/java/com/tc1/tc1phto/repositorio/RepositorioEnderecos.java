package com.tc1.tc1phto.repositorio;

import com.tc1.tc1phto.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEnderecos extends JpaRepository<Endereco, Long> {
}
