package br.com.oamorcura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oamorcura.repository.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
