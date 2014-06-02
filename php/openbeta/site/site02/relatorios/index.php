

<?php session_start();include "cabecalho.php";
	
	$usuario = $_POST['usuario'];
	$senha   = md5($_POST['senha']);
	  
	$result = ("select * from pessoa where cpf = '$usuario' and senha = '$senha' ");
	$query = mysql_query($result) or die(mysql_error());	
	$qtda  = mysql_num_rows($query);
		if ($qtda == 0){
			echo '<br>';
			echo '<br>';
			echo '<br>';
			echo '<center><font color="red" size="5">ERRO: USUÁRIO OU SENHA INVÁLIDOS</font></center>';
			
		}else{
				$_SESSION['usuario'] = $usuario;
				$_SESSION['senha'] = $senha;
				header("Location: admin.php");   /*  ../ significa uma pasta antes*/
				
			}		 
	   /*	while ($linha = mysql_fetch_array($result))
	   	{
		if( $linha['cpf']==$usuario && ($linha['senha'])==$senha) {
				//session_start();
				//$_SESSION['usuario'];
				echo 'deu certo';
			}else{
				echo 'deu errado';
				}
		}   
		
		//copiado
/*if(isset($_REQUEST['enviar'])){
$usuario = $_REQUEST['usuario'];
$senha   = $_REQUEST['senha'];
 
$sql = "select * from pessoa where usuario ='$usuario' and senha = '$senha' ";
$query = mysql_query($sql) or die(mysql_error());
$qtda  = mysql_num_rows($query);
if($qtda == 0){
	echo 'Erro ao logar';	
	}else{		
		$_SESSION['usuario'] = $usuario;
		$_SESSION['senha']   = $senha;		
		header("Location: cabecalho.php");	
		}
}
	*/
   /*session_status — Returns the current session status	
      //verificar se houve postagem no formulário caso contrário
	 // mandá lo para a página index.html //
if (!empty($_POST) AND (empty($_POST['usuario']) OR empty($_POST['senha']))) 
	{
	header("Location: index.html"); exit;
	}
			//conecta ao servidor
			mysql_connect("192.168.1.10","openbeta","wheezy$2014") 			
			    or trigger_error(mysql_error());
		
		 //conecta ao 
	mysql_select_db('pessoa') or trigger_error(mysql_error());
		
		// esse comando é para evitar erros no mysql
	$usuario = mysql_real_escape_string($_POST['usuario']);
	$senha = mysql_real_escape_string($POST['senha']);
		
		//validação do usuário e senha digitados     SHA1 senha criptografada.
	$sql = "SELECT  `nome`, `cpf` FROM `pessoas` WHERE 		   
	  (`usuario` = '". $usuario ."') AND (`senha` = '". sha1($senha)."') AND (`ativo` = 1) LIMIT 1";
		$querry = mysql_query($sql);
		if (mysql_num_rows($query) != 1) {
	
    	// Mensagem de erro quando os dados são inválidos e/ou o suário não foi encontrado

    	echo "Login inválido!"; exit;
		} else {
    	// Salva os dados encontados na variável $resultado
    	$resultado = mysql_fetch_assoc($query);
		}
		
		*/
		


?>

		





