

<CENTER>
<p><img src="colegio.jpg"align="center" width="137" height="156" alt="colegio" /> <strong> </p>
<p>COL&EacuteGIO ESTADUAL PADRE CARMELO PERRONE<br>
  ENSINO FUNDAMENTAL, M&EacuteDIO E PROFISSIONAL<br />
  Av. Assun&ccedil&atildeo, 725 - Bairro Alto Alegre - Cascavel/PR<br />
  Telefone/Fax(045) 3226-2824<br />
</p>
<?php
#error_reporting(E_ERROR | E_WARNING | E_PARSE | E_NOTICE);
  error_reporting(E_ERROR |  E_PARSE );
  $con = mysql_connect("127.0.0.1","root","");
    	if (mysqli_connect_error())
          {
                  echo "Erro ao conectar ao Banco de Dados: " .   mysqli_connect_error();
          }
        mysql_select_db("openbeta",$con);
		?>		</CENTER>
