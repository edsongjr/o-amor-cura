$(document).ready(function(){
	
	$('#dataNascimento').mask('00/00/0000');
	$('#celular').mask('(00) 00000-0000');
	$('#cpf').mask('000.000.000-00', {reverse: false});
	$('#rendaMensal').mask('00.000,00', {reverse: true})
	
	$("#appointment-form").submit(function(event){ 
		event.preventDefault();
		inscrever(getCandidato())
	});
	
	$(".close").click(function(){
		$(this).parents("div:eq(0)").hide();
	});
	
	$("#dataNascimento").change(function(){ 
		var dataNascimento = $(this).val();
		var dataNascimentoMoment = moment([dataNascimento.substr(6) , dataNascimento.substr(3,2) -1, dataNascimento.substr(0, 2)]);
		if(!dataNascimentoMoment.isValid() || dataNascimentoMoment.isAfter(moment())){
			$("#mensagensValidacao span:eq(0)").text("");
			$("#mensagensValidacao span:eq(0)").text("Digite uma data de nascimento válida");
			$("#mensagensValidacao").show();
			$(this).val("");
			window.scroll({
				top: 0,
				behavior: 'smooth'
			});
		}
	});
});


function getCandidato(){
	return {
		"nome": $("#nome").val(),
		"cpf": $("#cpf").val(),
		"rg": $("#rg").val(),
		"dataNascimento": $("#dataNascimento").val(),
		"rendaMensal": $("#rendaMensal").val().replace(/\./g, '').replace(/,/, "."),
		"endereco": {
			"rua": $("#rua").val(),
			"numero": $("#numero").val(),
			"bairro": $("#bairro").val(),
			"complemento": $("#complemento").val(),
			"cidade": $("#cidade").val(),
			"estado": $("#estado").val()
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


function inscrever(candidato){
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "/api/candidatos", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.onreadystatechange = function() {
		if ( this.readyState == 4) {
			if(this.status == 201 ){
				window.scroll({
					top: 0,
					behavior: 'smooth'
				});
				$("#mensagemSucesso").show();
				$("#appointment-form input:not([type='submit'])").val("");
				$("#appointment-form textarea").val("");
				$("#mensagensValidacao").hide()
			}else{
				tratarErrosRequisicao(this)
			}
		}
	};
	  
	  xhttp.send(JSON.stringify(candidato));
}


function tratarErrosRequisicao(xhttpErros){
	var $mensagensValidacao = $("#mensagensValidacao");
	$mensagensValidacao.find("span:eq(0)").text("");
	var errosForm = JSON.parse(xhttpErros.responseText);
	errosForm.forEach(function(erroForm){
		$mensagensValidacao.find("span:eq(0)").html($mensagensValidacao.find("span:eq(0)").html() + erroForm.erro + "<br>")
	});
	$mensagensValidacao.show();
	window.scroll({
		top: 0,
		behavior: 'smooth'
	});
}
	
