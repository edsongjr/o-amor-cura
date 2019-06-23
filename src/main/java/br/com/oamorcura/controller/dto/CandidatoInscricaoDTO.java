package br.com.oamorcura.controller.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.oamorcura.repository.entity.Candidato;
import br.com.oamorcura.repository.entity.Contato;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CandidatoInscricaoDTO {
	
	@NotBlank
	@Size(min=5)
	private String nome;
	
	@NotBlank
	private String cpf;
	
	private String rg;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@NotNull
	@Valid
	private EnderecoCandidatoDTO endereco;
	
	@NotEmpty
	@Size(min=2, max=2)
	@Valid
	private List<ContatoInscricaoDTO> contatos;
	
	private String descricaoDoenca;
	
	@NotBlank
	@Size(min=5)
	private String motivoConsulta;
	
	@NotNull
	private String rendaMensal;
	
	public Candidato toEntity() {
		Candidato candidato = new Candidato(null, nome, cpf, rg, rendaMensal, dataNascimento, endereco.toEntiy(), null, descricaoDoenca, motivoConsulta);
		List<Contato> contatos = ContatoInscricaoDTO.toEntityList(this.contatos, candidato);
		candidato.setContatos(contatos);
		return candidato;
	}
}
