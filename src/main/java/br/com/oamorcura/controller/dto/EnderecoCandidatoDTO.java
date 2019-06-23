package br.com.oamorcura.controller.dto;

import br.com.oamorcura.repository.entity.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnderecoCandidatoDTO {
	
	private String rua;
	
	private Integer numero;
	
	private String bairro;
	
	private String complemento;
	
	private String cidade;
	
	private String estado;

	public EnderecoCandidatoDTO(Endereco endereco) {
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.complemento = endereco.getComplemento();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
	}

	public Endereco toEntiy() {
		return new Endereco(null, rua, numero, complemento, bairro, cidade, estado);
	}

}
