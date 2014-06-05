<?php
include "cabecalho.php";
 include "verificacao2.php"; 
   $subsetor  = $_POST['sub_setor'];
   $query = "select * from pessoa
   inner join funcao_pessoa on funcao_pessoa.id_pessoa = pessoa.id_pessoa
   inner join funcao on funcao.id_funcao = funcao_pessoa.id_funcao
   inner join sub_setor on sub_setor.id_sub_setor = funcao.id_sub_setor
   where sub_setor.nome_sub_setor like '%$subsetor%' and pessoa.id_atividade = '1'";     

       echo "Pesquisa por sub-setor que contenham : " . $subsetor . "<br>";
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
	   	echo "<b>Sub-setor ou Disciplina: </b>" . $linha['nome_sub_setor'];
		echo "<br>";
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
<p><a href="relfunsubsetor.html"> <img src="../../../imagens/voltar.jpg" width="110" height="36"></a>

</body>
</html>