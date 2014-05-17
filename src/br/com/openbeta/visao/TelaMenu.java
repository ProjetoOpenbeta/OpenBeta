/*
 Copyright 2013 Vinicius Vasco Pedron, Luiz Gustavo Royer, Gelson Lemes,
    Jo�o Ricardo Oliveira, H�lio Campos, Maycon Willian Nunes Prestes
*/

/*
   Este arquivo � parte do programa OpenBeta

    OpenBeta � um software livre; voc� pode redistribu�-lo e/ou 
    modific�-lo dentro dos termos da Licen�a P�blica Geral GNU como 
    publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da 
    Licen�a, ou (na sua opini�o) qualquer vers�o.

    Este programa � distribu�do na esperan�a de que possa ser �til, 
    mas SEM NENHUMA GARANTIA; sem uma garantia impl�cita de ADEQUA��O a qualquer
    MERCADO ou APLICA��O EM PARTICULAR. Veja a
    Licen�a P�blica Geral GNU para maiores detalhes.

    Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
    junto com este programa, se n�o, escreva para a Funda��o do Software
    Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

package br.com.openbeta.visao;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eduardo\\git\\OpenBeta\\src\\colegio.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 132, 750);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaConsulta().setVisible(true);
			}
		});
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
		lblTitulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTitulo.insets = new Insets(10, 5, 5, 0);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 15, 0);
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		
		JLabel btnIncluir = new JLabel("");
		btnIncluir.setToolTipText("Incluir registro!");
		int handCursor = extracted();
		btnIncluir.setCursor(new Cursor(handCursor));
		btnIncluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaCadastro().setVisible(true);
			}
		});
		btnIncluir.setIcon(new ImageIcon("C:\\Users\\Eduardo\\git\\OpenBeta\\src\\inclusao.png"));
		GridBagConstraints gbc_btnIncluir = new GridBagConstraints();
		gbc_btnIncluir.insets = new Insets(0, 0, 5, 0);
		gbc_btnIncluir.gridx = 0;
		gbc_btnIncluir.gridy = 3;
		contentPane.add(btnIncluir, gbc_btnIncluir);
		
		JLabel btnConsultar = new JLabel("");
		btnConsultar.setToolTipText("Consultar registro!");
		btnConsultar.setCursor(new Cursor(handCursor));
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaConsulta().setVisible(true);
			}
		});
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\Eduardo\\git\\OpenBeta\\src\\consultar.png"));
		GridBagConstraints gbc_btnConsultar = new GridBagConstraints();
		gbc_btnConsultar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConsultar.gridx = 0;
		gbc_btnConsultar.gridy = 4;
		contentPane.add(btnConsultar, gbc_btnConsultar);
		
		JLabel btnRelatorio = new JLabel("");
		btnRelatorio.setToolTipText("Acessar relat�rios!");
		btnRelatorio.setCursor(new Cursor(handCursor));
		btnRelatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
		            Runtime.getRuntime().exec("cmd.exe /c start chrome.exe http://localhost/openbeta/site/site02");
		        } catch (IOException a) {}
			}
		});
		btnRelatorio.setIcon(new ImageIcon("C:\\Users\\Eduardo\\git\\OpenBeta\\src\\relatorio.png"));
		GridBagConstraints gbc_btnRelatorio = new GridBagConstraints();
		gbc_btnRelatorio.insets = new Insets(0, 0, 5, 0);
		gbc_btnRelatorio.gridx = 0;
		gbc_btnRelatorio.gridy = 5;
		contentPane.add(btnRelatorio, gbc_btnRelatorio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weighty = 4.0;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 6;
		contentPane.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel btnTrocaSenha = new JLabel("");
		btnTrocaSenha.setToolTipText("Trocar senha!");
		btnTrocaSenha.setCursor(new Cursor(handCursor));
		btnTrocaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaAlteracaoSenha().setVisible(true);
			}
		});
		btnTrocaSenha.setIcon(new ImageIcon("C:\\Users\\Eduardo\\git\\OpenBeta\\src\\trocasenha.png"));
		GridBagConstraints gbc_btnTrocaSenha = new GridBagConstraints();
		gbc_btnTrocaSenha.insets = new Insets(0, 0, 5, 0);
		gbc_btnTrocaSenha.gridx = 0;
		gbc_btnTrocaSenha.gridy = 7;
		contentPane.add(btnTrocaSenha, gbc_btnTrocaSenha);
		
		JLabel btnSair = new JLabel("");
		btnSair.setToolTipText("Sair!");
		btnSair.setCursor(new Cursor(handCursor));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object con[] = new Object[]{"Sim", "N�o"};
				int r = JOptionPane.showOptionDialog(null, "Realmente deseja sair?", "Confirme!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, con, null);
				if(r==0){
					dispose();
				}
			}
		});
		btnSair.setIcon(new ImageIcon("C:\\Users\\Eduardo\\git\\OpenBeta\\src\\saindo.png"));
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.gridx = 0;
		gbc_btnSair.gridy = 8;
		contentPane.add(btnSair, gbc_btnSair);
	}

	private int extracted() {
		return HAND_CURSOR;
	}
}