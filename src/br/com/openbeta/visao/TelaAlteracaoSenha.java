/*
 Copyright 2013 Vinicius Vasco Pedron, Luiz Gustavo Royer, Gelson Lemes,
    João Ricardo Oliveira, Hélio Campos, Maycon Willian Nunes Prestes
*/

/*
   Este arquivo é parte do programa OpenBeta

    OpenBeta é um software livre; você pode redistribuí-lo e/ou 
    modificá-lo dentro dos termos da Licença Pública Geral GNU como 
    publicada pela Fundação do Software Livre (FSF); na versão 2 da 
    Licença, ou (na sua opinião) qualquer versão.

    Este programa é distribuí­do na esperança de que possa ser útil, 
    mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer
    MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
    Licença Pública Geral GNU para maiores detalhes.

    Você deve ter recebido uma cópia da Licença Pública Geral GNU
    junto com este programa, se não, escreva para a Fundação do Software
    Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

package br.com.openbeta.visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import br.com.openbeta.modelo.Pessoa;
import br.com.openbeta.utilitarios.Md5;
import br.com.openbeta.utilitarios.ValidaCPF;

public class TelaAlteracaoSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField newPasswordField_2;
	private JButton btnCancelar, btnAlterar;
	private JLabel lblNotificacao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlteracaoSenha frame = new TelaAlteracaoSenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAlteracaoSenha() {
		setResizable(false);
		setTitle("OpenBeta - Vers\u00E3o 1.0");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		setMinimumSize(new Dimension(450, 350));
		
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel("OpenBeta");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 46));
		lblTitulo.setForeground(new Color(255, 255, 255));
		panel_1.add(lblTitulo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		contentPane.add(panel_3, gbc_panel_3);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		contentPane.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {0, 0};
		gbl_panel_4.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblCPF = new JLabel("CPF (somente n\u00FAmeros):");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.insets = new Insets(10, 0, 5, 5);
		gbc_lblCPF.anchor = GridBagConstraints.EAST;
		gbc_lblCPF.gridx = 0;
		gbc_lblCPF.gridy = 0;
		panel_4.add(lblCPF, gbc_lblCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setToolTipText("Digite o seu CPF");
		textFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_textFieldCPF = new GridBagConstraints();
		gbc_textFieldCPF.insets = new Insets(10, 5, 5, 20);
		gbc_textFieldCPF.fill = GridBagConstraints.BOTH;
		gbc_textFieldCPF.gridx = 1;
		gbc_textFieldCPF.gridy = 0;
		panel_4.add(textFieldCPF, gbc_textFieldCPF);
		textFieldCPF.setColumns(10);
		

		JLabel lblSenha = new JLabel("Senha anterior:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 1;
		panel_4.add(lblSenha, gbc_lblSenha);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setToolTipText("Digite sua senha");
		oldPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_oldPasswordField = new GridBagConstraints();
		gbc_oldPasswordField.insets = new Insets(0, 5, 5, 20);
		gbc_oldPasswordField.fill = GridBagConstraints.BOTH;
		gbc_oldPasswordField.gridx = 1;
		gbc_oldPasswordField.gridy = 1;
		panel_4.add(oldPasswordField, gbc_oldPasswordField);
				
		JLabel lblNovaSenha = new JLabel("Nova senha:");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNovaSenha = new GridBagConstraints();
		gbc_lblNovaSenha.anchor = GridBagConstraints.EAST;
		gbc_lblNovaSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblNovaSenha.gridx = 0;
		gbc_lblNovaSenha.gridy = 2;
		panel_4.add(lblNovaSenha, gbc_lblNovaSenha);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setToolTipText("Digite sua senha");
		newPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_newPasswordField = new GridBagConstraints();
		gbc_newPasswordField.insets = new Insets(0, 5, 5, 20);
		gbc_newPasswordField.fill = GridBagConstraints.BOTH;
		gbc_newPasswordField.gridx = 1;
		gbc_newPasswordField.gridy = 2;
		panel_4.add(newPasswordField, gbc_newPasswordField);
		
		JLabel lblRepitaANova = new JLabel("Repita a nova senha:");
		lblRepitaANova.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblRepitaANova = new GridBagConstraints();
		gbc_lblRepitaANova.anchor = GridBagConstraints.EAST;
		gbc_lblRepitaANova.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepitaANova.gridx = 0;
		gbc_lblRepitaANova.gridy = 3;
		panel_4.add(lblRepitaANova, gbc_lblRepitaANova);
		
		newPasswordField_2 = new JPasswordField();
		newPasswordField_2.setToolTipText("Digite sua senha");
		newPasswordField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_newPasswordField_2 = new GridBagConstraints();
		gbc_newPasswordField_2.insets = new Insets(0, 5, 5, 20);
		gbc_newPasswordField_2.fill = GridBagConstraints.BOTH;
		gbc_newPasswordField_2.gridx = 1;
		gbc_newPasswordField_2.gridy = 3;
		panel_4.add(newPasswordField_2, gbc_newPasswordField_2);

		lblNotificacao = new JLabel(" ");
		lblNotificacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotificacao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNotificacao = new GridBagConstraints();
		gbc_lblNotificacao.insets = new Insets(0, 8, 5, 0);
		gbc_lblNotificacao.anchor = GridBagConstraints.WEST;
		gbc_lblNotificacao.gridx = 1;
		gbc_lblNotificacao.gridy = 4;
		panel_4.add(lblNotificacao, gbc_lblNotificacao);
		
		//Botão Cancelar
		btnCancelar = new JButton("CANCELAR");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.weighty = 0.2;
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(5, 20, 10, 5);
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 5;
		panel_4.add(btnCancelar, gbc_btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaMenu().setVisible(true);
		            dispose();
			}
		});
				
		//Botão Acessar
		btnAlterar = new JButton("ALTERAR");
		GridBagConstraints gbc_btnAlterar = new GridBagConstraints();
		gbc_btnAlterar.weightx = 1.2;
		gbc_btnAlterar.insets = new Insets(5, 5, 10, 20);
		gbc_btnAlterar.fill = GridBagConstraints.BOTH;
		gbc_btnAlterar.gridx = 1;
		gbc_btnAlterar.gridy = 5;
		panel_4.add(btnAlterar, gbc_btnAlterar);

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        String cpf = textFieldCPF.getText();
		        String senha_anterior = oldPasswordField.getText();
		        String senha_nova = newPasswordField.getText();
		        String senha_nova_confirmacao = newPasswordField_2.getText();    
		        
		        System.out.println(Md5.usuario_principal);
		        System.out.println(Md5.senha_principal);
		        
		        boolean cpfCorreto = ValidaCPF.isCPF(cpf);
		        
		        if (cpfCorreto) {
		            if (!(cpf.equals(Md5.usuario_principal))) {
		                JOptionPane.showMessageDialog(null,"CPF não confere!","CPF INCORRETO",JOptionPane.ERROR_MESSAGE);
		            } else if (!(senha_anterior.equals(Md5.senha_principal))) {
		                JOptionPane.showMessageDialog(null,"Senha anterior não confere!","SENHA INCORRETA",JOptionPane.ERROR_MESSAGE);
		            } else if (!(senha_nova_confirmacao.equals(senha_nova))) {
		                JOptionPane.showMessageDialog(null,"Senhas não conferem!","SENHA INCORRETA",JOptionPane.ERROR_MESSAGE);
		            } else if ((senha_nova_confirmacao.equals(senha_anterior)) || (senha_nova.equals(senha_anterior))) {
		                JOptionPane.showMessageDialog(null,"Nova senha precisa ser diferente da senha anterior!","NOVA SENHA INVÁLIDA",JOptionPane.ERROR_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!","SENHA ALTERADA",JOptionPane.INFORMATION_MESSAGE);
		                new TelaMenu().setVisible(true);
		                Pessoa pessoa = new Pessoa();
		                pessoa.setsenha(senha_nova);
		                dispose();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "CPF Inválido!", "ERRO", JOptionPane.ERROR_MESSAGE);
		        }
		    }  
		});
			
		textFieldCPF.requestFocus();
	}
}