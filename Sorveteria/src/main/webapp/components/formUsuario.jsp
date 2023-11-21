<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Consultar Endereço</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#cep").blur( function(){
				
				var url = "https://viacep.com.br/ws/"+$("#cep").val()+"/json/";
				$.get( url, function( response ){
					$("#logradouro").val(response.logradouro);
					$("#complemento").val(response.complemento);
					$("#bairro").val(response.bairro);
					$("#localidade").val(response.localidade);
					$("#uf").val(response.uf);
				}, "json");
			} );
		});
	</script>
	
</head>
<body style="background-color: lightgray;">

<form id="frmEndereco">
<div class="container">
	<div class="row">
		<div class="col-4">
		</div>
		<div class="col-4">
			<div class="mb-3 mt-3">
		    	<label for="cep" class="form-label">CEP:</label>
		    	<input type="text" class="form-control" name="cep" id="cep" placeholder="Enter CEP">
		  	</div>
		  	<div class="mb-3 mt-3">
		    	<label for="logradouro" class="form-label">Logradouro:</label>
		    	<input type="text" class="form-control" name="logradouro" id="logradouro" placeholder="Enter logradouro">
		  	</div>
		  	<div class="mb-3 mt-3">
		    	<label for="complemento" class="form-label">Complemento:</label>
		    	<input type="text" class="form-control" name="complemento" id="complemento" placeholder="Enter complemento">
		  	</div>
		  		<div class="mb-3 mt-3">
		    	<label for="bairro" class="form-label">Bairro:</label>
		    	<input type="text" class="form-control" name="cep" id="bairro" placeholder="Enter bairro">
		  	</div>
		  	<div class="mb-3 mt-3">
		    	<label for="localidade" class="form-label">Cidade:</label>
		    	<input type="text" class="form-control" name="localidade" id="localidade" placeholder="Enter localidade">
		  	</div>
			<div class="mb-3 mt-3">
		    	<label for="uf" class="form-label">UF:</label>
		    	<input type="text" class="form-control" name="uf" id="uf" placeholder="Enter uf">
		  	</div>
		</div>
		<div class="col-4"></div>	
	</div>
</div>



</form>


</body>
</html>