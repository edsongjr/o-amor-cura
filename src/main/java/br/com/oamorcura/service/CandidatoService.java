package br.com.oamorcura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oamorcura.repository.CandidatoRepository;
import br.com.oamorcura.repository.entity.Candidato;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepostory;
	
	public Candidato realizarInscricao(Candidato candidato) {
		candidatoRepostory.save(candidato);
		return candidato;
	}

	public List<Candidato> listarTodosCandidatos() {
		return candidatoRepostory.findAll();
	}


}
