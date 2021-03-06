package br.com.openbeta.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.openbeta.modelo.Pessoa;

/*
 * Classe criada com o intuito de facilitar a manuten��o do 
 * OpenBeta por quem n�o possui conhecimento em hibernate.
 * Autor: Eduardo H.
 * Data: 10.05.2014
 * 
 */
public class JDBC {
	private Connection con;			//Se voce n�o sabe o que s�o essas vari�veis tire a m�o daqui e v� estudar....
	private PreparedStatement stmt;
	
	//M�todo respons�vel por abrir as conex�es com banco.
	private void abreConexao() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://192.168.1.10/openbeta","root","wheezy$2014");
	}
	
	//M�todo responsavel por fechar as conex�es com o banco
	private void fechaConexao() throws SQLException{
		con.close();
	}
	
	//Este metodo esta sendo utilizado na tela 'TelaAlteracaoSenha' como exemplo.
	public void alteraSenha(Pessoa p) throws ClassNotFoundException, SQLException{
		//Chamando metodo abreConexao
		abreConexao();
		
		stmt = con.prepareStatement("UPDATE pessoa SET senha=? WHERE cpf=?");
		
		//Este comando substitui o 1� '?' da query pela nova senha trazida pelo metodo 'getsenha' da classe 'Pessoa'
		stmt.setString(1, p.getsenha());
		
		//Este comando substitui o 2� '?' da query pelo cpf da pessoa que tera sua senha alterada, trazida pelo metodo 'getcpf' da classe 'Pessoa'
		stmt.setString(2, p.getcpf());
		
		//Metodo que executa a query no banco
		stmt.execute();
		
		JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!","SENHA ALTERADA",JOptionPane.INFORMATION_MESSAGE);
		
		stmt.close();
		
		//Chamando metodo fechaConexao
		fechaConexao();
	}
	
	//Metodo utilizado na classe "TelaConsulta". O parametro tipo pesuisa � definido pelo rediobutton utilizado na tela tendo, at� agora,
	
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
						+ " where pessoa.registro=?;");

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

	public void insereGraduacao(String graduacao) throws ClassNotFoundException, SQLException{
		abreConexao();
		
		stmt = con.prepareStatement("INSERT INTO tipo_graduacao (tipo_graduacao)VALUES(?);");
		
		stmt.setString(1, graduacao);
		
		stmt.execute();
		
		JOptionPane.showMessageDialog(null, "Gradua��o inserida com sucesso!");
		
		stmt.close();
		
		fechaConexao();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscaGraducoes(JComboBox cb) throws ClassNotFoundException, SQLException{
		abreConexao();
		stmt = con.prepareStatement("SELECT tipo_graduacao FROM tipo_graduacao;");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			cb.addItem(rs.getString("tipo_graduacao"));
		}
		fechaConexao();
	}
	
	public ArrayList<Object> buscaPessoaParaAlterar(String id) throws ClassNotFoundException, SQLException{
		ArrayList<Object> p = new ArrayList<Object>();
		
		abreConexao();
		
		stmt = con.prepareStatement("SELECT * FROM pessoa WHERE registro=?;");
		
		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			
			p.add(rs.getString("nome"));
			p.add(rs.getInt("rg"));
			p.add(rs.getDate("data_nascto"));
			p.add(rs.getString("nome_mae"));
			p.add(rs.getString("email_principal"));
			p.add(rs.getString("email_adicional"));
			p.add(rs.getString("telefone_celular"));
			p.add(rs.getString("telefone_celular_2"));
			p.add(rs.getString("cidade_natal"));
			p.add(rs.getString("outros"));
			
		}
		rs.close();
		stmt.close();
		fechaConexao();
		return p;
		
	}
	
	public void alterDados(ArrayList<String> lista) throws ClassNotFoundException, SQLException{
		abreConexao();
		stmt = con.prepareStatement("UPDATE pessoa SET nome=?, rg=?, data_nascto=?, nome_mae=?, email_principal=?, email_adicional=?, telefone_celular=?, telefone_celular_2=?, cidade_natal=?, outros=? "
				+ "WHERE registro=?;");
		
		
		stmt.setString(1, lista.get(0));
		stmt.setString(2, lista.get(1));
		stmt.setString(3, lista.get(2));
		stmt.setString(4, lista.get(3));
		stmt.setString(5, lista.get(4));
		stmt.setString(6, lista.get(5));
		stmt.setString(7, lista.get(6));
		stmt.setString(8, lista.get(7));
		stmt.setString(9, lista.get(8));
		stmt.setString(10, lista.get(9));
		stmt.setString(11, lista.get(10));
		
		stmt.execute();
		
		JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
		
		stmt.close();
		fechaConexao();
	}
}
