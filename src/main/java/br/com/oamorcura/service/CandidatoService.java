package br.com.oamorcura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oamorcura.repository.CandidatoRepository;
import br.com.oamorcura.repository.entity.Candidato;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepostory;
	
	@Autowired
	private ContatoService contatoService;
	
	public Candidato realizarInscricao(Candidato candidato) {
		candidatoRepostory.save(candidato);
		return candidato;
	}

	public List<Candidato> listarTodosCandidatos() {
		return candidatoRepostory.findAll();
	}

	public Candidato detalharCandidato(Long id) {
		Optional<Candidato> candidatoEncontrado = candidatoRepostory.findById(id);
		if(candidatoEncontrado.isPresent()) {
			 Candidato candidato = candidatoEncontrado.get();
			 candidato.getEndereco();
			 candidato.setContatos(contatoService.buscarContatosPorCandidato(candidato.getId()));
			 return candidato;
		}return null;
	}

}
