package br.com.openbeta.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.openbeta.modelo.Pessoa;

/*
 * Classe criada com o intuito de facilitar a manutenção do 
 * OpenBeta por quem não possui conhecimento em hibernate.
 * Autor: Eduardo H.
 * Data: 10.05.2014
 * 
 */
public class JDBC {
	private Connection con;			//Se voce não sabe o que são essas variáveis tire a mão daqui e vá estudar....
	private PreparedStatement stmt;
	
	//Método responsável por abrir as conexões com banco.
	private void abreConexao() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/openbeta","root","");
	}
	
	//Método responsavel por fechar as conexões com o banco
	private void fechaConexao() throws SQLException{
		con.close();
	}
	
	//Este metodo esta sendo utilizado na tela 'TelaAlteracaoSenha' como exemplo.
	public void alteraSenha(Pessoa p) throws ClassNotFoundException, SQLException{
		//Chamando metodo abreConexao
		abreConexao();
		
		stmt = con.prepareStatement("UPDATE pessoa SET senha=? WHERE cpf=?");
		
		//Este comando substitui o 1º '?' pela nova senha trazida pelo metodo 'getsenha' da classe 'Pessoa'
		stmt.setString(1, p.getsenha());
		
		//Este comando substitui o 2º '?' pelo cpf da pessoa que tera sua senha alterada, trazida pelo metodo 'getcpf' da classe 'Pessoa'
		stmt.setString(2, p.getcpf());
		
		//Metodo que esxecuta a query no banco
		stmt.execute();
		
		JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!","SENHA ALTERADA",JOptionPane.INFORMATION_MESSAGE);
		
		stmt.close();
		
		//Chamando metodo fechaConexao
		fechaConexao();
	}
}
