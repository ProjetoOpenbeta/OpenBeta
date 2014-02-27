<?php
include "cabecalho.php";
  
   $sexo  = $_POST['sexo'];
    
  $query = "select * from pessoa 
   			inner join situacao on situacao.id_situacao = pessoa.id_situacao
			where situacao.tipo_situacao like '%$situacao%' and pessoa.id_atividade = '1'";

	 if ($situacao) 
	 {
       echo "Pesquisa por situacao que contenham : " . $situacao . "<br>";
     }else
	 {
	   echo "Pesquisa por todos os nomes<br>";
	 }
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
	   	echo "<b>Situa&ccedil&atildeo: </b>".$linha['tipo_situacao'];
		echo "<br>";
		echo "<b>Nome: </b>".$linha['nome'];
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
		echo "<b>Telefone Celular 2: </b>".$linha['telefone_celular2'];
		echo "<br>";
		echo "<b>Cidade Natal: </b>".$linha['cidade_natal'];
		echo "<br>";
		echo "<b>Outros: </b>".$linha['outros'];

//	   echo "<center>".$linha['funcao']."</center>";
//	   echo "p..........: ". $linha['p']."<br>"; 
	   echo "<hr>";
	   }
	  }else{
	    echo "Dados n&atilde;o encontrado...";
	  }
    
?>