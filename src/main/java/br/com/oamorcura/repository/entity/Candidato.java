package br.com.oamorcura.repository.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private Double rendaMensal;
	
	private LocalDate dataNascimento;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Endereco endereco;
	
	@Setter
	@OneToMany(mappedBy="candidato", cascade=CascadeType.PERSIST)
	private List<Contato> contatos;
	
	private String descricaoDoenca;
	
	private String motivoConsulta;
	

}
