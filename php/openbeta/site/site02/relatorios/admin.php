

<?php session_start();  

if(!isset($_SESSION['usuario']) && (!isset($_SESSION['senha']))){	
header("Location: ../index.html");	
	}
?>
<?php
$secao_usuario = $_SESSION['usuario'];
$secao_senha   = $_SESSION['senha'];
?>
<?php  echo $secao_usuario;   ?>
<?php
if(isset($_REQUEST['sair'])){	
	session_destroy();
	header("Location:index.html");	
	}
?>
<html>
	<head>
    	<title> ADMIN </title>
    </head>
    <body link="#000034"> 
    	<a href="../principal.htm"></a>
    </body>
</html>

