package br.com.oamorcura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/candidatos")
public class CandidatoAPPController {
	
	@GetMapping
	public String index() {
		return "candidato/inscricao";
	}

}
