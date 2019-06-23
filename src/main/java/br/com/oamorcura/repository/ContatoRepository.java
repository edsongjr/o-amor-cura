package br.com.oamorcura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oamorcura.repository.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	List<Contato> findByCandidatoId(Long candidatoId);

}
