<?php 
	session_start();
	echo $_SESSION['usuario'];
	
	if (!isset($_SESSION['usuario']) || (!isset($_SESSION['senha']))){
		
		header("Location: relatorios/index.html");
	}
?>