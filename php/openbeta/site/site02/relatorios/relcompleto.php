<?php
include "cabecalho.php";
  
   $nome = $_POST['nome'];

   $query = "SELECT
	p.nome,
	p.registro, 	
	p.rg, 
	p.cpf,
	p.data_nascto,
	p.nome_mae, 
	p.senha, 
	p.email_principal,
	p.email_adicional, 
	p.telefone_celular, 
	p.telefone_celular_2,
	p.cidade_natal,
	p.outros, 
	end.logradouro,
	end.rua,
	end.numero,
	end.bairro,
	end.cep,
	end.cidade,
	e.nome_estado,
	e.nome_estado_inteiro,
	a.tipo_atividade,
	c.tipo_contratacao,	
	situacao.tipo_situacao,
	civil.estado_civil,
	sexo.sexo,
	tr.telefone_res,
	g.data_conclusao,
	g.instituicao,
	t.tipo_graduacao,
	crg.nome_cargo,
	s.nome_setor,
	ss.nome_sub_setor,
	turno.turno
	FROM PESSOA AS P  
	INNER JOIN ENDERECO AS END ON END.ID_ENDERECO = P.ID_ENDERECO
	INNER JOIN ESTADO AS E ON E.ID_ESTADO = P.ID_ESTADO_NATAL
	INNER JOIN ATIVIDADE AS A ON A.ID_ATIVIDADE = P.ID_ATIVIDADE
	INNER JOIN CONTRATACAO AS C ON C.ID_CONTRATACAO = P.ID_CONTRATACAO
	INNER JOIN SITUACAO ON SITUACAO.ID_SITUACAO = P.ID_SITUACAO
	INNER JOIN ESTADO_CIVIL AS CIVIL ON CIVIL.ID_ESTADO_CIVIL = P.ID_ESTADO_CIVIL	
	INNER JOIN SEXO AS SEXO ON SEXO.ID_SEXO = P.ID_SEXO
	INNER JOIN TELEFONE_RESIDENCIAL_PESSOA AS TRP ON TRP.ID_PESSOA = P.ID_PESSOA
	INNER JOIN TELEFONE_RESIDENCIAL AS TR ON TR.ID_TELEFONE = TRP.ID_TELEFONE_RESIDENCIAL
	INNER JOIN GRADUACAO_PESSOA AS GP ON GP.ID_PESSOA = P.ID_PESSOA
	INNER JOIN GRADUACAO AS G ON G.ID_GRADUACAO = GP.ID_GRADUACAO
	INNER JOIN TIPO_GRADUACAO AS T ON T.ID_TIPO_GRADUACAO = G.ID_TIPO_GRADUACAO
	INNER JOIN FUNCAO_PESSOA ON FUNCAO_PESSOA.ID_PESSOA = P.ID_PESSOA
	INNER JOIN FUNCAO AS F ON F.ID_FUNCAO = FUNCAO_PESSOA.ID_FUNCAO
	INNER JOIN CARGO AS CRG ON CRG.ID_CARGO = F.ID_CARGO
	INNER JOIN SETOR AS S ON S.ID_SETOR = F.ID_SETOR
	INNER JOIN SUB_SETOR AS SS ON SS.ID_SUB_SETOR = F.ID_SUB_SETOR
	INNER JOIN TURNO ON TURNO.ID_TURNO = F.ID_TURNO
	WHERE P.NOME LIKE '%$nome%' AND P.ID_SITUACAO = '1'";

	echo "Pesquisa por funcao que contenham : " . $funcao . "<br>";
	  	$resultado = mysql_query($query,$con);
        if (!mysql_query($query, $con))
          {
		   die('Error: ' . mysql_error($con));
          }
		if(mysql_num_rows($resultado)){ 
	   	while ($linha = mysql_fetch_array($resultado))
	   	{
	echo "<hr>";
	echo "<b>Nome: </b>".$linha['nome'];
	echo "<br>";
	echo "<b>Registro: </b>".$linha['registro'];
	echo "<br>";
	echo"<b>RG: </b>". $linha['rg'];
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
	echo "<br>";
	echo "<b>Tipo de Atividade: </b>".$linha['tipo_atividade'];
	echo "<br>";
	echo "<b>Contrata&ccedil&atildeo: </b>".$linha['tipo_contratacao'];
	echo "<br>";	
	echo "<b>Situa&ccedil&atildeo: </b>".$linha['situacao.tipo_situacao'];
	echo "<br>";
	echo "<b>Sexo: </b>".$linha['sexo'];
	echo "<br>";
	echo "<b>Telefone Residencial: </b>".$linha['telefone_res'];
	echo "<br>";
	echo $linha['g.data_conclusao'];
	echo "<br>";
	echo $linha['g.instituicao'];
	echo "<br>";
	echo $linha['t.tipo_graduacao'];
	echo "<br>";
	echo $linha['crg.nome_cargo'];
	echo "<br>";
	echo $linha['s.nome_setor'];
	echo "<br>";
	echo $linha['ss.nome_sub_setor'];
	echo "<br>";
	echo $linha['turno.turno'];
	echo "<br>";
//	   echo "<center>".$linha['funcao']."</center>";
//	   echo "p..........: ". $linha['p']."<br>"; 
	   echo "<hr>";
	   }
	  }else{
	    echo "Dados n&atilde;o encontrado...";
	  }
    
?>