package br.com.openbeta.visao;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class TelaOpcoes extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelGrad;
	private JPanel panelFun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcoes dialog = new TelaOpcoes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public TelaOpcoes() {
		setBounds(100, 100, 623, 486);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 145, 566);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAlteraGraduao = new JButton("Altera Gradua\u00E7\u00E3o");
		btnAlteraGraduao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelFun.setVisible(false);
				panelGrad.setVisible(true);
								
			}
		});
		btnAlteraGraduao.setBounds(10, 11, 119, 45);
		btnAlteraGraduao.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(btnAlteraGraduao);
		
		JButton btnAlteraFuno = new JButton("Altera Fun\u00E7\u00E3o");
		btnAlteraFuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGrad.setVisible(false);
				panelFun.setVisible(true);
			}
		});
		btnAlteraFuno.setBounds(10, 67, 119, 45);
		btnAlteraFuno.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(btnAlteraFuno);
		
		panelFun = new JPanel();
		panelFun.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFun.setBounds(155, 11, 442, 426);
		getContentPane().add(panelFun);
		panelFun.setLayout(null);
		panelFun.setVisible(false);
		
		panelGrad = new JPanel();
		panelGrad.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Altera Gradua\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrad.setBounds(155, 11, 458, 437);
		getContentPane().add(panelGrad);
		panelGrad.setLayout(null);
		panelGrad.setVisible(false);
		
	}
}
