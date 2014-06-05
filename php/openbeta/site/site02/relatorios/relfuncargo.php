<?php
include "cabecalho.php";
include "verificacao2.php"; 
  
   $funcao  = $_POST['funcao'];
   
   $query = "select * from pessoa  
	inner join funcao_pessoa 
	on funcao_pessoa.id_pessoa = pessoa.id_pessoa 
	inner join funcao
	 on funcao.id_funcao = funcao_pessoa.id_funcao 
	inner join cargo 
	on  cargo.id_cargo = funcao.id_cargo
	where cargo.nome_cargo like '%$funcao%'";

       echo "Pesquisa por funcao que contenham : " . $funcao . "<br>";
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
	echo"<b>Cargo: </b>". $linha['nome_cargo'];
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
		echo "<b>Telefone Adicional: </b>".$linha['telefone_celular2'];
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
<p><a href="relfuncargo.html"> <img src="../../../imagens/voltar.jpg" width="110" height="36"></a>

</body>
</html>