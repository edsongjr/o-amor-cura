package br.com.oamorcura.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.oamorcura.repository.entity.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnderecoInscricaoDTO {
	
	@NotBlank
	private String rua;
	
	@NotNull
	private Integer numero;
	
	@NotBlank
	private String bairro;

	public EnderecoInscricaoDTO(Endereco endereco) {
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
	}

	public Endereco toEntiy() {
		return new Endereco(rua, numero, bairro);
	}

}
