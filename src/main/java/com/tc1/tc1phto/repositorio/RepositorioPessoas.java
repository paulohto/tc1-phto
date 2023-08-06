package com.tc1.tc1phto.repositorio;

import com.tc1.tc1phto.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RepositorioPessoas extends JpaRepository<Pessoa, Long> {
}
