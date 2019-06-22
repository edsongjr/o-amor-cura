package br.com.oamorcura.controller.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.oamorcura.domain.TipoContato;
import br.com.oamorcura.repository.entity.Candidato;
import br.com.oamorcura.repository.entity.Contato;
import lombok.Getter;

@Getter
public class ContatoInscricaoDTO {
	
	@NotEmpty
	private String descricao;
	
	@NotNull
	private TipoContato tipoContato;
	

	public static List<Contato> toEntityList(List<ContatoInscricaoDTO> contatosDTO, Candidato candidato) {
		List<Contato> contatos = new ArrayList<>();
		contatosDTO.forEach(contatoDTO -> {
			contatos.add(new Contato(null, contatoDTO.getTipoContato(), contatoDTO.getDescricao(), candidato));
		});
		return contatos;
	}

}
