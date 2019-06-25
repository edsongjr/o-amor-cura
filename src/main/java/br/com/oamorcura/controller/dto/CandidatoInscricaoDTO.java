package br.com.oamorcura.controller.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.oamorcura.repository.entity.Candidato;
import br.com.oamorcura.repository.entity.Contato;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CandidatoInscricaoDTO {
	
	@NotBlank
	@Size(min=5, message = "Nome deve ter pelo menos 5 caracteres")
	private String nome;
	
	@NotBlank
	@CPF
	private String cpf;
	
	private String rg;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	@Past(message = "Data deve ser anterior a data de hoje")
	private LocalDate dataNascimento;
	
	@NotNull
	@Valid
	private EnderecoCandidatoDTO endereco;
	
	@NotEmpty(message = "Informe um email ou um celular")
	@Valid
	private List<ContatoInscricaoDTO> contatos;
	
	private String descricaoDoenca;
	
	@NotBlank
	@Size(min=5, message = "Descreva melhor por que você merece a consulta")
	private String motivoConsulta;
	
	@NotNull
	private Double rendaMensal;
	
	public Candidato toEntity() {
		Candidato candidato = new Candidato(null, nome, cpf, rendaMensal, dataNascimento, endereco.toEntiy(), null, descricaoDoenca, motivoConsulta);
		List<Contato> contatos = ContatoInscricaoDTO.toEntityList(this.contatos, candidato);
		candidato.setContatos(contatos);
		return candidato;
	}
}
