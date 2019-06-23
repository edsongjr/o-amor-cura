package br.com.oamorcura.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.oamorcura.domain.TipoContato;
import br.com.oamorcura.repository.entity.Contato;
import lombok.Getter;

@Getter
public class ContatoCandidatoDetalheDTO {
	
	private TipoContato tipoContato;
	
	private String descricao;
	
	public ContatoCandidatoDetalheDTO(Contato contato) {
		this.tipoContato = contato.getTipoContato();
		this.descricao = contato.getDescricao();
	}

	public static List<ContatoCandidatoDetalheDTO> toDTOList(List<Contato> contatos) {
		return contatos.stream().map(ContatoCandidatoDetalheDTO::new).collect(Collectors.toList());
	}
}
