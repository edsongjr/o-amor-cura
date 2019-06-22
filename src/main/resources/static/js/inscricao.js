$(document).ready(function(){
	
	$('#dataNascimento').mask('00/00/0000');
	$('#celular').mask('(00) 00000-0000');
	$('#cpf').mask('000.000.000-00', {reverse: false});
	
	$("#appointment-form").submit(function(event){ 
		event.preventDefault();
		
		var candidato = getCandidato();
		if(validarCampos(candidato)){
			inscrever(candidato)
		}
	});
	
	$(".close").click(function(){
		$("#mensagemSucesso").hide();
	});
});


function getCandidato(){
	return {
		"nome": $("#nome").val(),
		"cpf": $("#cpf").val(),
		"rg": $("#rg").val(),
		"dataNascimento": $("#dataNascimento").val(),
		"endereco": {
			"rua": $("#rua").val(),
			"numero": $("#numero").val(),
			"bairro": $("#bairro").val()
		},
		"contatos": getContatos(),
		
		"descricaoDoenca": $("#descricaoDoenca").val(),
		"motivoConsulta": $("#motivoConsulta").val()
	}
}


function getContatos(){
	var contatos = [];
	var email = $("#email").val();
	if(email) {
		contatos.push({"descricao": email,
			          "tipoContato": "EMAIL"});
	}
	
	var celular = $("#celular").val();
	if(celular) {
		contatos.push({"descricao": celular,
			          "tipoContato": "CELULAR"});
	}
	return contatos;
 }

function validarCampos(candidato){
	return true;
}

function inscrever(candidato){
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "/api/candidatos", true);
	xhttp.setRequestHeader("Content-type", "application/json")
	xhttp.onreadystatechange = function() {
		if ( this.status == 201) {
			window.scroll({
				  top: 0,
				  behavior: 'smooth'
				});
			$("#mensagemSucesso").show();
			$("#appointment-form input:not([type='submit'])").val("");
			$("#appointment-form textarea").val("");
		}else{
			alert("Erro: " + this.status)
		}
	};
	  
	  xhttp.send(JSON.stringify(candidato));
}
	
