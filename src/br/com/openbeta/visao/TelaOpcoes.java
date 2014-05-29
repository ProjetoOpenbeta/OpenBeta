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

import br.com.openbeta.modelo.Endereco;
import br.com.openbeta.modelo.Graduacao;
import br.com.openbeta.modelo.Pessoa;
import br.com.openbeta.modelo.TelefoneResidencial;
import br.com.openbeta.utilitarios.HibernateUtil;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Date;

public class TelaOpcoes extends JDialog {
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
	private JTextField txtLogradouro;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtCep;
	private JTextField txtResidencial;
	private JTextField txtNome;
	private JComboBox comboUF;
	private JComboBox comboGrad;
	
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
		setBounds(100, 100, 838, 486);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 145, 566);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAlteraGraduao = new JButton("Altera Gradua\u00E7\u00E3o");
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
		/*
		panelDados = new JPanel();
		panelDados.setBorder(new TitledBorder(null, "Altera Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDados.setBounds(155, 0, 728, 356);
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
		});
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCodigo.setBounds(113, 18, 133, 20);
		panelDados.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblSituacao = new JLabel("* Situa\u00E7\u00E3o:");
		lblSituacao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSituacao.setBounds(291, 21, 59, 15);
		panelDados.add(lblSituacao);
		
		final JComboBox comboSituacao = new JComboBox();
		comboSituacao.setFont(new Font("Arial", Font.PLAIN, 12));
		comboSituacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "EM EXERC\u00CDCIO", "READAPTADO", "AFASTADO DA FUN\u00C7\u00C3O", "LICEN\u00C7A M\u00C9DICA", "LICEN\u00C7A PR\u00CAMIO"}));
		comboSituacao.setBounds(358, 18, 150, 20);
		panelDados.add(comboSituacao);
		
		JLabel lblEmail = new JLabel("* Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(60, 264, 43, 15);
		panelDados.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setBounds(113, 261, 235, 20);
		panelDados.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("* Estado Civil:");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstadoCivil.setBounds(518, 21, 76, 15);
		panelDados.add(lblEstadoCivil);
		
		final JComboBox comboCivil = new JComboBox();
		comboCivil.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "SOLTEIRO", "CASADO", "DIVORCIADO", "VI\u00DAVO"}));
		comboCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		comboCivil.setBounds(604, 18, 100, 20);
		panelDados.add(comboCivil);
		
		JLabel lbltelCeluar = new JLabel("*Tel Celular:");
		lbltelCeluar.setFont(new Font("Arial", Font.PLAIN, 12));
		lbltelCeluar.setBounds(35, 238, 68, 15);
		panelDados.add(lbltelCeluar);
		
		txtcelular = new JTextField();
		txtcelular.setFont(new Font("Arial", Font.PLAIN, 12));
		txtcelular.setColumns(10);
		txtcelular.setBounds(113, 235, 86, 20);
		panelDados.add(txtcelular);
		
		JButton btnLimparDados = new JButton("Limpar");
		btnLimparDados.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimparDados.setBounds(10, 312, 89, 23);
		panelDados.add(btnLimparDados);
		
		JButton btnSalvarDados = new JButton("Salvar");
		btnSalvarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String situacao;
				String estadocivil;
				String uf;
				Pessoa pessoa = new Pessoa();
				pessoa.setid_pessoa(Integer.valueOf(txtCodigo.getText()));
				pessoa.setnome(txtNome.getText());
				pessoa.setemail_principal(txtEmail.getText());
				pessoa.settelefone_celular(String.valueOf(txtcelular.getText()));
				Endereco endereco = new Endereco();
				endereco.setid_endereco(Integer.valueOf(txtEndereco.getText()));
				endereco.setlogradouro(String.valueOf(txtLogradouro.getText()));
				endereco.setcidade(String.valueOf(txtCidade.getText()));
				endereco.setbairro(String.valueOf(txtBairro.getText()));
				endereco.setnumero(String.valueOf(txtNumero.getText()));
				endereco.setcep(BigDecimal.valueOf(Double.valueOf(txtCep.getText())));
				TelefoneResidencial telresidencial = new TelefoneResidencial();
				telresidencial.setTelefone_res(String.valueOf(txtResidencial.getText()));
				comboSituacao.getSelectedItem().toString();			
				comboCivil.getSelectedItem().toString();
				comboUF.getSelectedItem().toString();					
								
				Session sessao = HibernateUtil.getSession();
				Transaction t = sessao.beginTransaction();
				sessao.update(pessoa);
				t.commit();
				sessao.clear();
				sessao.close();
			}
		});
		btnSalvarDados.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvarDados.setBounds(101, 312, 89, 23);
		panelDados.add(btnSalvarDados);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 92, 82, 14);
		panelDados.add(lblEndereo);
		
		JLabel lblLogradouro = new JLabel("* Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLogradouro.setBounds(28, 117, 75, 15);
		panelDados.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Arial", Font.PLAIN, 12));
		txtLogradouro.setBounds(113, 120, 86, 20);
		panelDados.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblEndereco = new JLabel("* Endere\u00E7o:");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereco.setBounds(218, 120, 71, 14);
		panelDados.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEndereco.setBounds(291, 120, 229, 20);
		panelDados.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("* N\u00FAmero:");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumero.setBounds(552, 123, 56, 15);
		panelDados.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNumero.setColumns(10);
		txtNumero.setBounds(618, 117, 86, 20);
		panelDados.add(txtNumero);
		
		JLabel lblCidade = new JLabel("* Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setBounds(52, 149, 51, 15);
		panelDados.add(lblCidade);
		
		JLabel lblBairro = new JLabel("* Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBairro.setBounds(59, 175, 44, 15);
		panelDados.add(lblBairro);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		txtCidade.setBounds(113, 146, 417, 20);
		panelDados.add(txtCidade);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		txtBairro.setBounds(113, 172, 417, 20);
		panelDados.add(txtBairro);
		
		JLabel lblUF = new JLabel("* UF:");
		lblUF.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUF.setBounds(577, 149, 27, 15);
		panelDados.add(lblUF);
		
		JComboBox comboUF = new JComboBox();
		comboUF.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		comboUF.setFont(new Font("Arial", Font.PLAIN, 12));
		comboUF.setBounds(618, 142, 86, 20);
		panelDados.add(comboUF);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCep.setColumns(10);
		txtCep.setBounds(618, 167, 86, 20);
		panelDados.add(txtCep);
		
		JLabel lblCEP = new JLabel("* CEP:");
		lblCEP.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCEP.setBounds(572, 173, 36, 15);
		panelDados.add(lblCEP);
		
		JLabel lblResidencial = new JLabel("* Tel Residencial:");
		lblResidencial.setFont(new Font("Arial", Font.PLAIN, 12));
		lblResidencial.setBounds(10, 207, 97, 15);
		panelDados.add(lblResidencial);
		
		txtResidencial = new JTextField();
		txtResidencial.setFont(new Font("Arial", Font.PLAIN, 12));
		txtResidencial.setColumns(10);
		txtResidencial.setBounds(113, 204, 231, 20);
		panelDados.add(txtResidencial);
		
		JLabel lblNome = new JLabel("* Nome :");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(52, 55, 68, 14);
		panelDados.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(113, 52, 445, 20);
		panelDados.add(txtNome);
		txtNome.setColumns(10);
		panelDados.setVisible(false);
		*/
		panelFun = new JPanel();
		panelFun.setBorder(new TitledBorder(null, "Altera Função", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFun.setBounds(155, 11, 719, 176);
		getContentPane().add(panelFun);
		panelFun.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "PROFESSOR", "FUNCION\u00C1RIO", "PEDAGOGIA"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox.setBounds(71, 19, 127, 20);
		panelFun.add(comboBox);
		
		JLabel lblFuncao = new JLabel("* Fun\u00E7\u00E3o:");
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFuncao.setBounds(18, 22, 46, 14);
		panelFun.add(lblFuncao);
		
		JLabel label_1 = new JLabel("* Setor ou Curso:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 11));
		label_1.setBounds(292, 22, 83, 14);
		panelFun.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ENSINO FUNDAMENTAL", "ENSINO M\u00C9DIO", "T\u00C9C. SUBSEQUENTE - ADMINISTRA\u00C7\u00C3O ", "T\u00C9C. SUBSEQUENTE - SECRETARIADO ", "T\u00C9C. SUBSEQUENTE - INFORM\u00C1TICA ", "T\u00C9C. INTEGRAL - ADMINISTRA\u00C7\u00C3O", "T\u00C9C. INTEGRAL - INFORM\u00C1TICA", "CELEM", "SALA DE RECURSOS", "SALA DE APOIO", "ESPORTE E LAZER", "AULAS ESPECIALIZADAS", "ARTE E CULTURA"}));
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_1.setBounds(385, 19, 222, 20);
		panelFun.add(comboBox_1);
		
		JLabel lblTurno = new JLabel("* Turno:");
		lblTurno.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTurno.setBounds(18, 62, 38, 14);
		panelFun.add(lblTurno);
		
		JComboBox comboTurno = new JComboBox();
		comboTurno.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "MATUTINO", "VESPERTINO", "NOTURNO"}));
		comboTurno.setFont(new Font("Arial", Font.PLAIN, 11));
		comboTurno.setBounds(71, 59, 127, 20);
		panelFun.add(comboTurno);
		
		JLabel lblDiciplina = new JLabel("* Sub-Setor ou Disciplina:");
		lblDiciplina.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDiciplina.setBounds(253, 62, 122, 14);
		panelFun.add(lblDiciplina);
		
		JComboBox comboDiciplina = new JComboBox();
		comboDiciplina.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ARTE", "CI\u00CANCIAS", "EDUCA\u00C7\u00C3O F\u00CDSICA", "GEOGRAFIA", "HIST\u00D3RIA", "L\u00CDNGUA PORTUGUESA", "MATEM\u00C1TICA", "L.E.M - INGL\u00CAS", "ENSINO RELIGIOSO", "BIOLOGIA", "FILOSOFIA", "F\u00CDSICA", "QU\u00CDMICA", "L.E.M - ESPANHOL", "ADMINISTRA\u00C7\u00C3O DE PROD. E MAT.", "ADM. FINANCEIRA E OR\u00C7AMENT\u00C1RIA", "COMPORTAMENTO ORGANIZACIONAL", "CONTABILIDADE", "ELABORA\u00C7\u00C3O E AN\u00C1LISE PROJETOS", "ESTAT\u00CDSTICA APLICADA", "FUNDAMENTOS DO TRABALHO", "GEST\u00C3O DE PESSOAS", "INFORM\u00C1TICA", "INTRODU\u00C7\u00C3O \u00C0 ECONOMIA"}));
		comboDiciplina.setFont(new Font("Arial", Font.PLAIN, 11));
		comboDiciplina.setBounds(385, 59, 265, 20);
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
			}
		});
		btnSalvarFun.setBounds(109, 124, 89, 23);
		panelFun.add(btnSalvarFun);
		panelFun.setVisible(false);
		/*
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
				String graduacao;
				comboGrad.getSelectedItem().toString();
				Graduacao grad = new Graduacao();
				grad.setInstituicao(String.valueOf(txtInstituicao.getText()));
				grad.setData_conclusao(Date.valueOf(txtDataConclusao.getText()));	
				
				
				Session sessao = HibernateUtil.getSession();
				Transaction t = sessao.beginTransaction();
				sessao.update(grad);
				t.commit();
				sessao.clear();
				sessao.close();
				
				
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
	*/
		
	}
}
