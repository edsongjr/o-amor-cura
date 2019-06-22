package br.com.oamorcura.controller.dto;

import br.com.oamorcura.repository.entity.Candidato;
import lombok.Getter;

@Getter
public class CandidatoInscricaoResponseDTO {

	private Long id;
	private String nome;

	public CandidatoInscricaoResponseDTO(Candidato candidatoInscrito) {
		this.id = candidatoInscrito.getId();
		this.nome = candidatoInscrito.getNome();
	}
}
