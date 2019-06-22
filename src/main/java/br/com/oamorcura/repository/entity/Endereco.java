package br.com.oamorcura.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Endereco {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String rua;
	
	@Column(nullable=false)
	private Integer numero;
	
	@Column(nullable=false)
	private String bairro;
	

	public Endereco(String rua, Integer numero, String bairro) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
	}
}
