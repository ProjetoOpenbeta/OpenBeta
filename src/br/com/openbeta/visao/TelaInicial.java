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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import br.com.openbeta.utilitarios.Md5;
import br.com.openbeta.utilitarios.ValidaCPF;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JPasswordField passwordField;
	private JButton btnCancelar, btnAcessar;
	private JLabel lblNotificacao;
	
    private String usuario;
    private String senha;
    private boolean cpfCorreto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setResizable(false);
		setTitle("OpenBeta - Vers\u00E3o 1.0");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(450, 300));
		
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
		gbl_panel_4.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
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
		
		textFieldCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				usuario = textFieldCPF.getText();
				
				switch (evt.getKeyCode()) {
				case KeyEvent.VK_ENTER:
				case KeyEvent.VK_TAB:
		            if (usuario.equals("")) { 
		                java.awt.Toolkit.getDefaultToolkit().beep();  
		                JOptionPane.showMessageDialog(null, "Informe um CPF válido", "ERRO", JOptionPane.ERROR_MESSAGE);
		            } else {                  
		                cpfCorreto = ValidaCPF.isCPF(usuario);
		                if (cpfCorreto) {
		                    passwordField.requestFocus(true); 
		                    textFieldCPF.setText(ValidaCPF.imprimeCPF(usuario)); 
		                } else {   
		                    java.awt.Toolkit.getDefaultToolkit().beep();
		                    JOptionPane.showMessageDialog(null, "CPF Inválido!", "ERRO", JOptionPane.ERROR_MESSAGE);
		                    textFieldCPF.requestFocus(true);
		                }
		            }	
					break;
				}		        
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				usuario = textFieldCPF.getText();
			    String tira = usuario.replaceAll ("[^0-9 ]", null);
			    textFieldCPF.setText(tira);		

				super.keyReleased(arg0);
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracter = "0987654321";
				
				if(!caracter.contains(arg0.getKeyChar()+"")){
					arg0.consume();
				}
			}
		});

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 1;
		panel_4.add(lblSenha, gbc_lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Digite sua senha");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 5, 5, 20);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		panel_4.add(passwordField, gbc_passwordField);
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
		        String sen = (passwordField.getText()); 
		        String cpf = (textFieldCPF.getText()); 
		        
		        switch (evt.getKeyCode()) {
		        case KeyEvent.VK_ENTER:
		        case KeyEvent.VK_TAB:
		        	if (cpf.equals("")) {
		                lblNotificacao.setText("* Campos obrigatórios");
		                textFieldCPF.requestFocus();
		            } else if (sen.equals("")) {
		                java.awt.Toolkit.getDefaultToolkit().beep();  //BEEP
		                lblNotificacao.setText("* Informe a Senha");
		                passwordField.requestFocus();
		            } else {
		                btnAcessar.requestFocus();
		            }		
					break;
		        }
			}
		});

		lblNotificacao = new JLabel(" ");
		lblNotificacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotificacao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNotificacao = new GridBagConstraints();
		gbc_lblNotificacao.insets = new Insets(0, 8, 0, 0);
		gbc_lblNotificacao.anchor = GridBagConstraints.WEST;
		gbc_lblNotificacao.gridx = 1;
		gbc_lblNotificacao.gridy = 2;
		panel_4.add(lblNotificacao, gbc_lblNotificacao);
		
		//Botão Cancelar
		btnCancelar = new JButton("CANCELAR");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.weighty = 0.2;
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(5, 20, 10, 5);
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 3;
		panel_4.add(btnCancelar, gbc_btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		//Botão Acessar
		btnAcessar = new JButton("ACESSAR");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		/*btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textFieldCPF.getText().replace("-", "").replace(".", "");
				JOptionPane.showMessageDialog(null, usuario);
			}
		});*/
		GridBagConstraints gbc_btnAcessar = new GridBagConstraints();
		gbc_btnAcessar.weightx = 1.2;
		gbc_btnAcessar.insets = new Insets(5, 5, 10, 20);
		gbc_btnAcessar.fill = GridBagConstraints.BOTH;
		gbc_btnAcessar.gridx = 1;
		gbc_btnAcessar.gridy = 3;
		panel_4.add(btnAcessar, gbc_btnAcessar);
		
		btnAcessar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt) {
				
				String cpf = (textFieldCPF.getText());
		        String senha = (passwordField.getText()); 
		        String cpfSomenteNumeros = "";

		        if (cpf != null && !cpf.equals("")) {
		        	cpfSomenteNumeros = cpf.replace(".", "").replace("-", "");  //retira os pontos e hÃ­fen.
		        }
		        
		        if (cpf.equals("")) {
		            java.awt.Toolkit.getDefaultToolkit().beep();
		            lblNotificacao.setText("Os campos são obrigatórios");
		            textFieldCPF.requestFocus();

		        } else {

		            usuario = cpfSomenteNumeros;
		            senha = passwordField.getText();
		            cpfCorreto = ValidaCPF.isCPF(usuario);

		            if (cpfCorreto && senha.equals("")) {
		                lblNotificacao.setText("* Informe a Senha!");
		                passwordField.requestFocus();
		            } else if (cpfCorreto) {
		                Md5.md5(usuario, senha);
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, " Informe um CPF válido!", "ERRO!", JOptionPane.ERROR_MESSAGE);
		                textFieldCPF.requestFocus();
		                passwordField.setText("");
		            }
		        }
			}
		});
		
		btnAcessar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
		        if (evt.getKeyCode() == 10) {
		            String cpf;
		            usuario = textFieldCPF.getText();
		            senha = passwordField.getText();
		            cpf = usuario.replaceAll(".", "").replaceAll("-", "");
		            cpfCorreto = ValidaCPF.isCPF(cpf);
		            if (cpfCorreto) {
		                Md5.md5(cpf, senha);
		                dispose();
		            }
		        }
			}
		});
		
		textFieldCPF.requestFocus();
	}
}