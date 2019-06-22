package br.com.oamorcura.controller.dto;

import br.com.oamorcura.repository.entity.Endereco;
import lombok.Getter;

@Getter
public class EnderecoResponseDTO {
	
	private String rua;
	private Integer numero;
	private String bairro;

	public EnderecoResponseDTO(Endereco endereco) {
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
	}

}
