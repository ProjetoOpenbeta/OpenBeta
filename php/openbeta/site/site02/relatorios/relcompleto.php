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
	from pessoa as p  
	inner join endereco as end on end.id_endereco = p.id_endereco
	inner join estado as e on e.id_estado = p.id_estado_natal
	inner join atividade as a on a.id_atividade = p.id_atividade
	inner join contratacao as c on c.id_contratacao = p.id_contratacao
	inner join situacao on situacao.id_situacao = p.id_situacao
	inner join estado_civil as civil on civil.id_estado_civil = p.id_estado_civil	
	inner join sexo as sexo on sexo.id_sexo = p.id_sexo
	inner join telefone_residencial_pessoa as trp on trp.id_pessoa = p.id_pessoa
	inner join telefone_residencial as tr on tr.id_telefone = trp.id_telefone_residencial
	inner join graduacao_pessoa as gp on gp.id_pessoa = p.id_pessoa
	inner join graduacao as g on g.id_graduacao = gp.id_graduacao
	inner join tipo_graduacao as t on t.id_tipo_graduacao = g.id_tipo_graduacao
	inner join funcao_pessoa on funcao_pessoa.id_pessoa = p.id_pessoa
	inner join funcao as f on f.id_funcao = funcao_pessoa.id_funcao
	inner join cargo as crg on crg.id_cargo = f.id_cargo
	inner join setor as s on s.id_setor = f.id_setor
	inner join sub_setor as ss on ss.id_sub_setor = f.id_sub_setor
	inner join turno on turno.id_turno = f.id_turno
	where p.nome like '%$nome%' and p.id_situacao = '1'";


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