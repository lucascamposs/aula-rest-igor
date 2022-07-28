package br.edu.unicesumar.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unicesumar.aula.domain.CursoNovo;

public interface CursoNovoRepository extends JpaRepository<CursoNovo, Long> {
    
}
