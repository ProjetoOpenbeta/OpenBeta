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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JDesktopPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.openbeta.controle.JDBC;
import br.com.openbeta.modelo.Endereco;
import br.com.openbeta.modelo.Funcao;
import br.com.openbeta.modelo.Graduacao;
import br.com.openbeta.modelo.Pessoa;
import br.com.openbeta.modelo.TelefoneResidencial;
import br.com.openbeta.utilitarios.HibernateUtil;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JEditorPane;

import java.awt.ComponentOrientation;

import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

public class TelaAlteração extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelGrad;
	private JPanel panelFun;
	private JPanel panelDados;
	private JTextField txtCodigo;
	private JTextField txtEmail;
	private JTextField txtInstituicao;
	private JTextField txtcelular;
	private JTextField txtDataConclusao;
	private JTextField txtNome;
	private JComboBox comboUF;
	private JComboBox comboGrad;
	private JComboBox comboFuncao;
	private JTextField txtRG;
	private JTextField txtCelularOpcional;
	private JTextField txtNomedaMae;
	private JTextField txtEmailOpcional;
	private JTextField txtDataNascimento;
	private JTextField txtCidadeNatal;
	private JTextPane txtOutros;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlteração dialog = new TelaAlteração();
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
	public TelaAlteração() {
		setTitle("Tela Altera\u00E7\u00E3o de Dados");
		setBounds(100, 100, 883, 504);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 145, 566);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAlteraGraduao = new JButton("Altera Gradua\u00E7\u00E3o");
		btnAlteraGraduao.setVisible(false);
		btnAlteraGraduao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				panelFun.setVisible(false);
				panelGrad.setVisible(true);
				panelDados.setVisible(false);
								
			}
		});
		btnAlteraGraduao.setBounds(10, 123, 119, 45);
		btnAlteraGraduao.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(btnAlteraGraduao);
		
		JButton btnAlteraFuno = new JButton("Altera Fun\u00E7\u00E3o");
		btnAlteraFuno.setVisible(false);
		btnAlteraFuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGrad.setVisible(false);
				panelFun.setVisible(true);
				panelDados.setVisible(false);
			}
			
		});
		btnAlteraFuno.setBounds(10, 67, 119, 45);
		btnAlteraFuno.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(btnAlteraFuno);
		
		JButton btnAlteraDados = new JButton("Altera Dados");
		btnAlteraDados.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAlteraDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGrad.setVisible(false);
				panelFun.setVisible(false);
				panelDados.setVisible(true);
				
			}
		});
		btnAlteraDados.setBounds(10, 11, 119, 45);
		panel.add(btnAlteraDados);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(82, 151, 1, 1);
		panel.add(desktopPane);
		
		panelDados = new JPanel();
		panelDados.setBorder(new TitledBorder(null, "Altera Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDados.setBounds(155, 0, 728, 455);
		getContentPane().add(panelDados);
		panelDados.setLayout(null);
		
		JLabel lblCodigo = new JLabel("* C\u00F3digo:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setBounds(52, 21, 51, 15);
		panelDados.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String num = "0987654321";
				if(!num.contains(arg0.getKeyChar()+"")){
					arg0.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER ){
					
					if (txtCodigo.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Por favor inserir um código! ");
					}else{
						JDBC banco = new JDBC();
						
						try {
							ArrayList<Object> pessoa = new ArrayList<Object>();
							pessoa = banco.buscaPessoaParaAlterar(txtCodigo.getText());
							
							txtNome.setText(String.valueOf(pessoa.get(0)));
							txtRG.setText(String.valueOf(pessoa.get(1)));
							txtDataNascimento.setText(String.valueOf(pessoa.get(2)));
							txtNomedaMae.setText(String.valueOf(pessoa.get(3)));
							txtEmail.setText(String.valueOf(pessoa.get(4)));
							txtEmailOpcional.setText(String.valueOf(pessoa.get(5)));						
							txtcelular.setText(String.valueOf(pessoa.get(6)));
							txtCelularOpcional.setText(String.valueOf(pessoa.get(7)));						
							txtCidadeNatal.setText(String.valueOf(pessoa.get(8)));
							txtOutros.setText(String.valueOf(pessoa.get(9)));
							
							/*
							for (int c=0; c <= pessoa.size();c++){
								JOptionPane.showMessageDialog(null, String.valueOf(c) + ' ' + pessoa.get(c));
							}
							*/
							
						} catch (ClassNotFoundException | SQLException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
					}
					
				};	
			}
		});
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodigo.setBounds(113, 18, 133, 20);
		panelDados.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblEmail = new JLabel("* Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(62, 238, 43, 15);
		panelDados.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setBounds(115, 235, 235, 20);
		panelDados.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lbltelCeluar = new JLabel("*Tel Celular:");
		lbltelCeluar.setFont(new Font("Arial", Font.PLAIN, 12));
		lbltelCeluar.setBounds(41, 178, 68, 15);
		panelDados.add(lbltelCeluar);
		
		txtcelular = new JTextField();
		txtcelular.setFont(new Font("Arial", Font.PLAIN, 12));
		txtcelular.setColumns(10);
		txtcelular.setBounds(115, 175, 86, 20);
		panelDados.add(txtcelular);
		
		JButton btnLimparDados = new JButton("Limpar");
		btnLimparDados.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtCodigo.setText("");
				txtNome.setText("");
				txtRG.setText("");
				txtNomedaMae.setText("");
				txtCelularOpcional.setText("");
				txtcelular.setText("");
				txtDataNascimento.setText("");
				txtEmail.setText("");
				txtEmailOpcional.setText("");
				txtOutros.setText("");
				txtCidadeNatal.setText("");
				
			}
		});
		btnLimparDados.setBounds(0, 421, 89, 23);
		panelDados.add(btnLimparDados);
		
		JButton btnSalvarDados = new JButton("Salvar");
		btnSalvarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> l = new ArrayList<String>();
				
				l.add(txtNome.getText());
				l.add(txtRG.getText());
				l.add(txtDataNascimento.getText());
				l.add(txtNomedaMae.getText());
				l.add(txtEmail.getText());
				l.add(txtEmailOpcional.getText());
				l.add(txtcelular.getText());
				l.add(txtCelularOpcional.getText());
				l.add(txtCidadeNatal.getText());
				l.add(txtOutros.getText());
				l.add(txtCodigo.getText());
				
				
				JDBC j = new JDBC();
				
				try {
					
					j.alterDados(l);
					
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
				}

			}
		});
		btnSalvarDados.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvarDados.setBounds(96, 421, 89, 23);
		panelDados.add(btnSalvarDados);
		
		JLabel lblNome = new JLabel("* Nome :");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(52, 55, 68, 14);
		panelDados.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(113, 52, 417, 20);
		panelDados.add(txtNome);
		txtNome.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRG.setColumns(10);
		txtRG.setBounds(113, 148, 97, 20);
		panelDados.add(txtRG);
		
		JLabel lblRG = new JLabel("* RG:");
		lblRG.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRG.setBounds(72, 151, 25, 14);
		panelDados.add(lblRG);
		
		txtCelularOpcional = new JTextField();
		txtCelularOpcional.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCelularOpcional.setColumns(10);
		txtCelularOpcional.setBounds(113, 204, 247, 20);
		panelDados.add(txtCelularOpcional);
		
		JLabel lblCelularOpcional = new JLabel("* Celular Opcional:");
		lblCelularOpcional.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCelularOpcional.setBounds(0, 204, 139, 15);
		panelDados.add(lblCelularOpcional);
		
		JLabel lblNomedaMae = new JLabel("* Nome da M\u00E3e:");
		lblNomedaMae.setBounds(0, 89, 103, 14);
		panelDados.add(lblNomedaMae);
		
		txtNomedaMae = new JTextField();
		txtNomedaMae.setColumns(10);
		txtNomedaMae.setBounds(113, 87, 417, 20);
		lblNomedaMae.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDados.add(txtNomedaMae);
		
		txtEmailOpcional = new JTextField();
		txtEmailOpcional.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEmailOpcional.setColumns(10);
		txtEmailOpcional.setBounds(115, 264, 235, 20);
		panelDados.add(txtEmailOpcional);
		
		JLabel lblEmailOpcional = new JLabel("* Email Opcional:");
		lblEmailOpcional.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmailOpcional.setBounds(10, 267, 97, 15);
		panelDados.add(lblEmailOpcional);
		
		JLabel lblDataNascimento = new JLabel("* Data de Nascimento: ");
		lblDataNascimento.setBounds(0, 123, 139, 14);
		panelDados.add(lblDataNascimento);
		
		txtDataNascimento = new JTextField();
		lblDataNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(134, 117, 97, 20);
		panelDados.add(txtDataNascimento);
		
		JLabel lblOutros = new JLabel("Outros:");
		lblOutros.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOutros.setBounds(57, 334, 46, 14);
		panelDados.add(lblOutros);
		
		JLabel lblCidadeNatal = new JLabel("Cidade Natal:");
		lblCidadeNatal.setBounds(20, 296, 83, 14);
		panelDados.add(lblCidadeNatal);
		
		txtCidadeNatal = new JTextField();
		lblCidadeNatal.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidadeNatal.setBounds(113, 295, 237, 20);
		panelDados.add(txtCidadeNatal);
		txtCidadeNatal.setColumns(10);
		
		txtOutros = new JTextPane();
		txtOutros.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtOutros.setBounds(113, 334, 343, 76);
		panelDados.add(txtOutros);
		panelDados.setVisible(false);
		
		panelFun = new JPanel();
		panelFun.setBorder(new TitledBorder(null, "Altera Função", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFun.setBounds(155, 11, 719, 176);
		getContentPane().add(panelFun);
		panelFun.setLayout(null);
		
		final JComboBox comboFuncao = new JComboBox();
		comboFuncao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "PROFESSOR", "FUNCION\u00C1RIO", "PEDAGOGIA"}));
		comboFuncao.setFont(new Font("Arial", Font.PLAIN, 11));
		comboFuncao.setBounds(71, 19, 127, 20);
		panelFun.add(comboFuncao);
		
		JLabel lblFuncao = new JLabel("* Fun\u00E7\u00E3o:");
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFuncao.setBounds(18, 22, 46, 14);
		panelFun.add(lblFuncao);
		
		JLabel label_1 = new JLabel("* Setor ou Curso:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 11));
		label_1.setBounds(292, 22, 83, 14);
		panelFun.add(label_1);
		
		final JComboBox comboSetorCurso = new JComboBox();
		comboSetorCurso.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ENSINO FUNDAMENTAL", "ENSINO M\u00C9DIO", "T\u00C9C. SUBSEQUENTE - ADMINISTRA\u00C7\u00C3O ", "T\u00C9C. SUBSEQUENTE - SECRETARIADO ", "T\u00C9C. SUBSEQUENTE - INFORM\u00C1TICA ", "T\u00C9C. INTEGRAL - ADMINISTRA\u00C7\u00C3O", "T\u00C9C. INTEGRAL - INFORM\u00C1TICA", "CELEM", "SALA DE RECURSOS", "SALA DE APOIO", "ESPORTE E LAZER", "AULAS ESPECIALIZADAS", "ARTE E CULTURA"}));
		comboSetorCurso.setFont(new Font("Arial", Font.PLAIN, 11));
		comboSetorCurso.setBounds(385, 19, 222, 20);
		panelFun.add(comboSetorCurso);
		
		JLabel lblTurno = new JLabel("* Turno:");
		lblTurno.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTurno.setBounds(18, 62, 38, 14);
		panelFun.add(lblTurno);
		
		final JComboBox comboTurno = new JComboBox();
		comboTurno.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "MATUTINO", "VESPERTINO", "NOTURNO"}));
		comboTurno.setFont(new Font("Arial", Font.PLAIN, 11));
		comboTurno.setBounds(71, 59, 127, 20);
		panelFun.add(comboTurno);
		
		JLabel lblDiciplina = new JLabel("* Sub-Setor ou Disciplina:");
		lblDiciplina.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDiciplina.setBounds(253, 62, 122, 14);
		panelFun.add(lblDiciplina);
		
		final JComboBox comboDiciplina = new JComboBox();
		comboDiciplina.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ARTE", "CI\u00CANCIAS", "EDUCA\u00C7\u00C3O F\u00CDSICA", "GEOGRAFIA", "HIST\u00D3RIA", "L\u00CDNGUA PORTUGUESA", "MATEM\u00C1TICA", "L.E.M - INGL\u00CAS", "ENSINO RELIGIOSO", "BIOLOGIA", "FILOSOFIA", "F\u00CDSICA", "QU\u00CDMICA", "L.E.M - ESPANHOL", "ADMINISTRA\u00C7\u00C3O DE PROD. E MAT.", "ADM. FINANCEIRA E OR\u00C7AMENT\u00C1RIA", "COMPORTAMENTO ORGANIZACIONAL", "CONTABILIDADE", "ELABORA\u00C7\u00C3O E AN\u00C1LISE PROJETOS", "ESTAT\u00CDSTICA APLICADA", "FUNDAMENTOS DO TRABALHO", "GEST\u00C3O DE PESSOAS", "INFORM\u00C1TICA", "INTRODU\u00C7\u00C3O \u00C0 ECONOMIA"}));
		comboDiciplina.setFont(new Font("Arial", Font.PLAIN, 11));
		comboDiciplina.setBounds(385, 59, 222, 20);
		panelFun.add(comboDiciplina);
		
		JButton btnLimparFun = new JButton("Limpar");
		btnLimparFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimparFun.setBounds(18, 124, 89, 23);
		panelFun.add(btnLimparFun);
		
		JButton btnSalvarFun = new JButton("Salvar");
		btnSalvarFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Funcao fun = new Funcao();
				comboFuncao.getSelectedItem().toString();
				comboTurno.getSelectedItem().toString();
				comboSetorCurso.getSelectedItem().toString();
				comboDiciplina.getSelectedItem().toString();
				
				Session sessao = HibernateUtil.getSession();
				Transaction t = sessao.beginTransaction();
				sessao.update(fun);
				t.commit();
				sessao.clear();
				sessao.close();		*/				
			}
		});
		btnSalvarFun.setBounds(109, 124, 89, 23);
		panelFun.add(btnSalvarFun);
		panelFun.setVisible(false);
		
		panelGrad = new JPanel();
		panelGrad.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Altera Gradua\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrad.setBounds(157, 11, 663, 126);
		getContentPane().add(panelGrad);
		panelGrad.setLayout(null);
		
		JPanel panelAlteraGra1 = new JPanel();
		panelAlteraGra1.setBounds(0, 46, 654, 20);
		panelGrad.add(panelAlteraGra1);
		GridBagLayout gbl_panelAlteraGra1 = new GridBagLayout();
		gbl_panelAlteraGra1.columnWidths = new int[]{0, 0, 0};
		gbl_panelAlteraGra1.rowHeights = new int[]{0, 0};
		gbl_panelAlteraGra1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAlteraGra1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelAlteraGra1.setLayout(gbl_panelAlteraGra1);
		
		JLabel lblInstituicao = new JLabel("* Institui\u00E7\u00E3o/Curso:");
		lblInstituicao.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblInstituicao = new GridBagConstraints();
		gbc_lblInstituicao.anchor = GridBagConstraints.EAST;
		gbc_lblInstituicao.insets = new Insets(0, 0, 0, 5);
		gbc_lblInstituicao.gridx = 0;
		gbc_lblInstituicao.gridy = 0;
		panelAlteraGra1.add(lblInstituicao, gbc_lblInstituicao);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setFont(new Font("Arial", Font.PLAIN, 11));
		txtInstituicao.setColumns(10);
		GridBagConstraints gbc_txtInstituicao = new GridBagConstraints();
		gbc_txtInstituicao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInstituicao.gridx = 1;
		gbc_txtInstituicao.gridy = 0;
		panelAlteraGra1.add(txtInstituicao, gbc_txtInstituicao);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(10, 92, 89, 23);
		panelGrad.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*String graduacao;
				comboGrad.getSelectedItem().toString();
				Graduacao grad = new Graduacao();
				grad.setInstituicao(String.valueOf(txtInstituicao.getText()));
				grad.setData_conclusao(Date.valueOf(txtDataConclusao.getText()));	
				
				
				Session sessao = HibernateUtil.getSession();
				Transaction t = sessao.beginTransaction();
				sessao.update(grad);
				t.commit();
				sessao.clear();
				sessao.close();		*/		
			}
		});
		btnSalvar.setBounds(103, 92, 89, 23);
		panelGrad.add(btnSalvar);
		
		JLabel lblAlteraGrad = new JLabel("* Gradua\u00E7\u00E3o:");
		lblAlteraGrad.setBounds(0, 21, 64, 14);
		panelGrad.add(lblAlteraGrad);
		lblAlteraGrad.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JComboBox comboGrad = new JComboBox();
		comboGrad.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "BACHARELADO", "LICENCIATURA", "TECN\u00D3LOGO", "P\u00D3S-GRADUA\u00C7\u00C3O", "MESTRADO", "DOUTORADO"}));
		comboGrad.setBounds(74, 18, 118, 20);
		panelGrad.add(comboGrad);
		comboGrad.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JLabel lblDataConclusao = new JLabel("* Data de Conclus\u00E3o:");
		lblDataConclusao.setBounds(425, 21, 101, 14);
		panelGrad.add(lblDataConclusao);
		lblDataConclusao.setFont(new Font("Arial", Font.PLAIN, 11));
		
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(536, 18, 118, 20);
		panelGrad.add(txtDataConclusao);
		txtDataConclusao.setColumns(10);
		panelGrad.setVisible(false);
	
		
	}
}
