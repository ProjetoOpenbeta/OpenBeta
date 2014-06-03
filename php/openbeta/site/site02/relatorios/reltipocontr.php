<?php
include "cabecalho.php";
  
   $contratacao = $_POST['contratacao'];
    
  $query = "select  * from pessoa 
   			inner join contratacao on contratacao.id_contratacao = pessoa.id_contratacao
			where contratacao.tipo_contratacao like '%$contratacao%' and pessoa.id_atividade = '1'";
	 if ($situacao) 
	 {
       echo "Pesquisa por contracao que contenham : " . $contratacao . "<br>";
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
	   	echo  "<u>Tipo de Contrata&ccedil&atildeo: </u>".$linha['tipo_contratacao'];
		echo "<br>";
		echo "<hr>";
		echo "Nome: ".$linha ['nome'];
		echo "<br>";
		echo "<b>RG: </b>".$linha ['rg'];
		echo "<br>";
		echo "<b>CPF: </b>".$linha ['cpf'];
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
<html>
<head>
<title></title>
</head>
<body>
<p><a href="reltipocontr.html"> <img src="../../../imagens/voltar.jpg" width="110" height="36"></a>

</body>
</html>