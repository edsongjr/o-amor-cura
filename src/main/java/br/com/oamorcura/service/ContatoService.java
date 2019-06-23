package br.com.oamorcura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oamorcura.repository.ContatoRepository;
import br.com.oamorcura.repository.entity.Contato;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;

	public List<Contato> buscarContatosPorCandidato(Long candidatoId) {
		return contatoRepository.findByCandidatoId(candidatoId);
	}

}
