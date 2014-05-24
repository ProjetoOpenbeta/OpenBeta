<?php
include "cabecalho.php";
  
   $pessoa  = $_POST['nome'];
   
   $query = "select * from pessoa  
	inner join endereco on endereco.id_endereco = pessoa.id_endereco 
	inner join estado on estado.id_estado = pessoa.id_estado_natal
	inner join estado_civil on estado_civil.id_estado_civil = pessoa.id_estado_civil
	where pessoa.nome like '%$pessoa%'";

       echo "Pesquisa por Dados que contenham : " . $pessoa . "<br>";
  //   }else
//	 {
//	   echo "Pesquisa por todas as funcoes<br>";
//	 }
	  	$resultado = mysql_query($query,$con);
        if (!mysql_query($query, $con))
          {
		   die('Error: ' . mysql_error($con));
          }
		if(mysql_num_rows($resultado)){ 
	   	while ($linha = mysql_fetch_array($resultado))
	   	{
	    echo "<hr>";
		echo "<b>Nome: </b>" . $linha['nome'];
		echo "<br>";
		echo "<b>RG: </b>".$linha['rg'];
		echo "<br>";
		echo "<b>CPF: </b>".$linha['cpf'];
		echo "<br>";
		echo "<b>Data de Nascimento: </b>".$linha['data_nascto'];
		echo "<br>";
		echo "<b>M&atildee: </b>".$linha['nome_mae'];
		echo "<br>";
		echo "<b>Email Principal: </b>".$linha['email_principal'];
		echo "<br>";
		echo "<b>Email Adicional: </b>".$linha['email_adicional'];
		echo "<br>";
		echo "<b>Telefone Celular: </b>".$linha['telefone_celular'];
		echo "<br>";
		echo "<b>Telefone Adicional: </b>".$linha['telefone_celular2'];
		echo "<br>";
		echo "<b>Cidade Natal: </b>".$linha['cidade_natal'];
		echo "<br>";
		echo "<b>Outros: </b>".$linha['outros'];
		echo "<br>";
		echo "<b>Lougradouro: </b>".$linha['logradouro'];
		echo "<br>";
		echo "<b>Rua: </b>".$linha['rua'];
		echo "<br>";
		echo "<b>Numero: </b>".$linha['numero'];
		echo "<br>";
		echo "<b>Cidade: </b>".$linha['cidade'];
		echo "<br>";
		echo "<b>Estado: </b>".$linha['nome_estado_inteiro'];
		echo "<br>";
		echo "<b>Estado Civil: </b>".$linha['estado_civil'];

	   echo "<hr>";
	   }
	  }else{
	    echo "Dados n&atilde;o encontrados...";
	  }

?>