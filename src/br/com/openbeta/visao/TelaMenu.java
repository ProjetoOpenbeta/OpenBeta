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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 150, 600);
		setMinimumSize(new Dimension(150, 600));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("OpenBeta");
		lblTitulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 22));
		lblTitulo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(10, 5, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 15, 0);
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		
		JButton btnIncluir = new JButton("Incluir");
		GridBagConstraints gbc_btnIncluir = new GridBagConstraints();
		gbc_btnIncluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnIncluir.fill = GridBagConstraints.BOTH;
		gbc_btnIncluir.gridx = 0;
		gbc_btnIncluir.gridy = 3;
		contentPane.add(btnIncluir, gbc_btnIncluir);
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TCadastro().setVisible(true);
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar.fill = GridBagConstraints.BOTH;
		gbc_btnConsultar.gridx = 0;
		gbc_btnConsultar.gridy = 4;
		contentPane.add(btnConsultar, gbc_btnConsultar);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TConsulta().setVisible(true);
			}
		});

		JButton btnRelatorios = new JButton("Relat\u00F3rios");
		GridBagConstraints gbc_btnRelatorios = new GridBagConstraints();
		gbc_btnRelatorios.insets = new Insets(0, 0, 5, 0);
		gbc_btnRelatorios.fill = GridBagConstraints.BOTH;
		gbc_btnRelatorios.gridx = 0;
		gbc_btnRelatorios.gridy = 5;
		contentPane.add(btnRelatorios, gbc_btnRelatorios);

		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Runtime.getRuntime().exec("cmd.exe /c start chrome.exe http://localhost/openbeta/site/site02");
		        } catch (IOException a) {}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weighty = 4.0;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 6;
		contentPane.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		GridBagConstraints gbc_btnAlterarSenha = new GridBagConstraints();
		gbc_btnAlterarSenha.insets = new Insets(0, 0, 5, 0);
		gbc_btnAlterarSenha.fill = GridBagConstraints.BOTH;
		gbc_btnAlterarSenha.gridx = 0;
		gbc_btnAlterarSenha.gridy = 7;
		contentPane.add(btnAlterarSenha, gbc_btnAlterarSenha);
		
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAlteracaoSenha().setVisible(true);
				dispose();
			}
		});

		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(Color.RED);
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSair.gridx = 0;
		gbc_btnSair.gridy = 8;
		contentPane.add(btnSair, gbc_btnSair);

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "OpenBeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if (resp == 0) {
		            System.exit(0);
		        }
			}
		});
	}
}