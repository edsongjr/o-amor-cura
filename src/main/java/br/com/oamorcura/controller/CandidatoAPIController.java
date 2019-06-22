package br.com.oamorcura.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.oamorcura.controller.dto.CandidatoInscricaoDTO;
import br.com.oamorcura.controller.dto.CandidatoInscricaoResponseDTO;
import br.com.oamorcura.controller.dto.CandidatoResponseDTO;
import br.com.oamorcura.repository.entity.Candidato;
import br.com.oamorcura.service.CandidatoService;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoAPIController {
	
	@Autowired
	private CandidatoService candidatoService;
	
	@PostMapping
	public ResponseEntity<CandidatoInscricaoResponseDTO> realizarInscricao(@RequestBody @Valid CandidatoInscricaoDTO dto, UriComponentsBuilder uriBuilder){
		Candidato candidatoInscrito = candidatoService.realizarInscricao(dto.toEntity());
		URI location = uriBuilder.path("/candidatos/{id}").buildAndExpand(candidatoInscrito.getId()).toUri();
		return ResponseEntity.created(location).body(new CandidatoInscricaoResponseDTO(candidatoInscrito));
	} 
	
	@GetMapping
	public ResponseEntity<List<CandidatoResponseDTO>> listarTodosCandidatos(){
		List<Candidato> candidatos = candidatoService.listarTodosCandidatos();
		return ResponseEntity.ok(CandidatoResponseDTO.toEntityList(candidatos));
	}
}
