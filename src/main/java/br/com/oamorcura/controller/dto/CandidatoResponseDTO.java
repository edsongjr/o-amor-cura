package br.com.oamorcura.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.oamorcura.repository.entity.Candidato;
import lombok.Getter;

@Getter
public class CandidatoResponseDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	public CandidatoResponseDTO(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.cpf = candidato.getCpf();
		this.dataNascimento = candidato.getDataNascimento();
	}

	public static List<CandidatoResponseDTO> toDTOList(List<Candidato> candidatos) {
		return candidatos.stream().map(CandidatoResponseDTO::new).collect(Collectors.toList());
	}
}
