package br.com.openbeta.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		
		//Este comando substitui o 1º '?' da query pela nova senha trazida pelo metodo 'getsenha' da classe 'Pessoa'
		stmt.setString(1, p.getsenha());
		
		//Este comando substitui o 2º '?' da query pelo cpf da pessoa que tera sua senha alterada, trazida pelo metodo 'getcpf' da classe 'Pessoa'
		stmt.setString(2, p.getcpf());
		
		//Metodo que executa a query no banco
		stmt.execute();
		
		JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!","SENHA ALTERADA",JOptionPane.INFORMATION_MESSAGE);
		
		stmt.close();
		
		//Chamando metodo fechaConexao
		fechaConexao();
	}
	
	public void consultaRegistros(Pessoa p, Integer tipodePesquisa, JTable t) throws ClassNotFoundException, SQLException{
		abreConexao();
		switch (tipodePesquisa){
			case 1:
				stmt = con.prepareStatement("select pessoa.id_pessoa, "
						+ "pessoa.nome, "
						+ "pessoa.cpf, "
						+ "pessoa.telefone_celular, "
						+ "pessoa.telefone_celular_2, "
						+ "pessoa.outros, "
						+ "tipo_graduacao.tipo_graduacao from pessoa "
						+ "inner join graduacao_pessoa on graduacao_pessoa.id_pessoa=pessoa.id_pessoa "
						+ "inner join graduacao on graduacao.id_graduacao=graduacao_pessoa.id_graduacao "
						+ "inner join tipo_graduacao on tipo_graduacao.id_tipo_graduacao=graduacao.id_tipo_graduacao"
						+ " where pessoa.id_pessoa=?;");
			case 2:
			
			case 3:
				
			case 4:
		}
		
		DefaultTableModel tabela = (DefaultTableModel) t.getModel();
		
		tabela.setNumRows(0);
		
		stmt.setInt(1, p.getid_pessoa());
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			tabela.addRow(new Object[]{
					rs.getInt("id_pessoa"),
					rs.getString("nome"),
					rs.getString("cpf"),
					rs.getString("telefone_celular"),
					rs.getString("telefone_celular_2"),
					rs.getString("outros"),
					rs.getString("tipo_graduacao")
			});
		}
		rs.close();
		stmt.close();
		fechaConexao();
	}
}
