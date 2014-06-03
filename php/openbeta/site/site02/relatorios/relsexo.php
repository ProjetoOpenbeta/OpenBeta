<?php
include "cabecalho.php";
  
   $sexo  = $_POST['sexo'];
   
   
   
   $query = "select * from pessoa 
   			inner join sexo on sexo.id_sexo = pessoa.id_sexo
			where sexo.sexo like '%$sexo%' and pessoa.id_atividade = '1'"; 

	 if ($sexo) 
	 {
       echo "Pesquisa por sexo que contenham : " . $sexo . "<br>";
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
	   	echo $linha['sexo'];
		echo "<br>";
		echo $linha['nome'];
		echo "<br>";
		echo $linha['rg'];
		echo "<br>";
		echo $linha['cpf'];
        echo $linha['data_nascto'];
		echo "<br>";
		echo $linha['nome_mae'];
		echo "<br>";
		echo $linha['email_principal'];
		echo "<br>";
		echo $linha['email_adicional'];
		echo "<br>";
		echo $linha['telefone_celular'];
		echo "<br>";
		echo $linha['telefone_celular2'];
		echo "<br>";
		echo $linha['cidade_natal'];
		echo "<br>";
		echo $linha['outros'];
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
<p><a href="relsexo.html"> <img src="../../../imagens/voltar.jpg" width="110" height="36"></a>

</body>
</html>