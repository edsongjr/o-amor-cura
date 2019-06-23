package br.com.oamorcura.controller.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.oamorcura.repository.entity.Candidato;
import lombok.Getter;

@Getter
public class CandidatoDetalheDTO {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private EnderecoCandidatoDTO endereco;
	
	private List<ContatoCandidatoDetalheDTO> contatos;
	
	private String descricaoDoenca;
	
	private String motivoConsulta;

	public CandidatoDetalheDTO(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.cpf = candidato.getCpf();
		this.rg = candidato.getRg();
		this.dataNascimento = candidato.getDataNascimento();
		this.endereco = new EnderecoCandidatoDTO(candidato.getEndereco());
		this.contatos = ContatoCandidatoDetalheDTO.toDTOList(candidato.getContatos());
		this.descricaoDoenca = candidato.getDescricaoDoenca();
		this.motivoConsulta = candidato.getMotivoConsulta();
	}

}
