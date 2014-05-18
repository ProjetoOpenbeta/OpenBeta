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

public class TelaOpcoes extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelGrad;
	private JPanel panelFun;
	private JPanel panelDados;
	private JTextField txtCodigo;
	private JTextField txtLogradouro;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtCEP;
	private JTextField txtResidencial;
	private JTextField txEmail;
	private JTextField txtInstituicao;
	private JTextField txtecelular;
	private JTextField txtDataGraduacao;
	
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
		setBounds(100, 100, 867, 486);
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
				panelDados.setVisible(false);
								
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
				panelDados.setVisible(false);
			}
			
		});
		btnAlteraFuno.setBounds(10, 67, 119, 45);
		btnAlteraFuno.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(btnAlteraFuno);
		
		JButton btnAlteraDados = new JButton("Altera Dados");
		btnAlteraDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGrad.setVisible(false);
				panelFun.setVisible(false);
				panelDados.setVisible(true);
				
			}
		});
		btnAlteraDados.setBounds(10, 123, 119, 45);
		panel.add(btnAlteraDados);
				
		panelDados = new JPanel();
		panelDados.setBounds(160, 11, 690, 426);
		getContentPane().add(panelDados);
		panelDados.setLayout(null);
		
		JLabel lblCodigo = new JLabel("* C\u00F3digo:");
		lblCodigo.setBounds(10, 11, 65, 14);
		panelDados.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(74, 8, 133, 20);
		panelDados.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblSituacao = new JLabel("* Situa\u00E7\u00E3o:");
		lblSituacao.setBounds(267, 11, 65, 14);
		panelDados.add(lblSituacao);
		
		JComboBox comboSituacao = new JComboBox();
		comboSituacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "EM EXERC\u00CDCIO", "READAPTADO", "AFASTADO DA FUN\u00C7\u00C3O", "LICEN\u00C7A M\u00C9DICA", "LICEN\u00C7A PR\u00CAMIO"}));
		comboSituacao.setBounds(342, 8, 90, 20);
		panelDados.add(comboSituacao);
		
		JPanel paneAlteraDados = new JPanel();
		paneAlteraDados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		paneAlteraDados.setBounds(0, 36, 668, 98);
		panelDados.add(paneAlteraDados);
		GridBagLayout gbl_paneAlteraDados = new GridBagLayout();
		gbl_paneAlteraDados.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_paneAlteraDados.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_paneAlteraDados.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_paneAlteraDados.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		paneAlteraDados.setLayout(gbl_paneAlteraDados);
		
		JLabel lblLogradouro = new JLabel("* Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLogradouro = new GridBagConstraints();
		gbc_lblLogradouro.anchor = GridBagConstraints.EAST;
		gbc_lblLogradouro.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogradouro.gridx = 0;
		gbc_lblLogradouro.gridy = 0;
		paneAlteraDados.add(lblLogradouro, gbc_lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Arial", Font.PLAIN, 11));
		txtLogradouro.setColumns(10);
		GridBagConstraints gbc_txtLogradouro = new GridBagConstraints();
		gbc_txtLogradouro.anchor = GridBagConstraints.NORTH;
		gbc_txtLogradouro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogradouro.insets = new Insets(0, 0, 5, 5);
		gbc_txtLogradouro.gridx = 1;
		gbc_txtLogradouro.gridy = 0;
		paneAlteraDados.add(txtLogradouro, gbc_txtLogradouro);
		
		JLabel lblEndereco = new JLabel("* Endere\u00E7o:");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
		gbc_lblEndereco.anchor = GridBagConstraints.EAST;
		gbc_lblEndereco.insets = new Insets(0, 10, 5, 5);
		gbc_lblEndereco.gridx = 2;
		gbc_lblEndereco.gridy = 0;
		paneAlteraDados.add(lblEndereco, gbc_lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEndereco.setColumns(10);
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndereco.gridx = 3;
		gbc_txtEndereco.gridy = 0;
		paneAlteraDados.add(txtEndereco, gbc_txtEndereco);
		
		JLabel lblNumero = new JLabel("* N\u00FAmero:");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.insets = new Insets(0, 10, 5, 5);
		gbc_lblNumero.gridx = 4;
		gbc_lblNumero.gridy = 0;
		paneAlteraDados.add(lblNumero, gbc_lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNumero.setColumns(10);
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero.gridx = 5;
		gbc_txtNumero.gridy = 0;
		paneAlteraDados.add(txtNumero, gbc_txtNumero);
		
		JLabel lblCidade = new JLabel("* Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 1;
		paneAlteraDados.add(lblCidade, gbc_lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCidade.setColumns(10);
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.gridwidth = 3;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 1;
		paneAlteraDados.add(txtCidade, gbc_txtCidade);
		
		JLabel lblUF = new JLabel("* UF:");
		lblUF.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblUF = new GridBagConstraints();
		gbc_lblUF.anchor = GridBagConstraints.EAST;
		gbc_lblUF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUF.gridx = 4;
		gbc_lblUF.gridy = 1;
		paneAlteraDados.add(lblUF, gbc_lblUF);
		
		JComboBox comboUF = new JComboBox();
		comboUF.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		comboUF.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_comboUF = new GridBagConstraints();
		gbc_comboUF.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboUF.insets = new Insets(0, 0, 5, 0);
		gbc_comboUF.gridx = 5;
		gbc_comboUF.gridy = 1;
		paneAlteraDados.add(comboUF, gbc_comboUF);
		
		JLabel lblBairro = new JLabel("* Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.EAST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 0;
		gbc_lblBairro.gridy = 2;
		paneAlteraDados.add(lblBairro, gbc_lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		txtBairro.setColumns(10);
		GridBagConstraints gbc_txtBairro = new GridBagConstraints();
		gbc_txtBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBairro.gridwidth = 3;
		gbc_txtBairro.insets = new Insets(0, 0, 5, 5);
		gbc_txtBairro.gridx = 1;
		gbc_txtBairro.gridy = 2;
		paneAlteraDados.add(txtBairro, gbc_txtBairro);
		
		JLabel lblCEP = new JLabel("* CEP:");
		lblCEP.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCEP = new GridBagConstraints();
		gbc_lblCEP.anchor = GridBagConstraints.EAST;
		gbc_lblCEP.insets = new Insets(0, 0, 5, 5);
		gbc_lblCEP.gridx = 4;
		gbc_lblCEP.gridy = 2;
		paneAlteraDados.add(lblCEP, gbc_lblCEP);
		
		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCEP.setColumns(10);
		GridBagConstraints gbc_txtCEP = new GridBagConstraints();
		gbc_txtCEP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCEP.insets = new Insets(0, 0, 5, 0);
		gbc_txtCEP.gridx = 5;
		gbc_txtCEP.gridy = 2;
		paneAlteraDados.add(txtCEP, gbc_txtCEP);
		
		JPanel paneAlteraDados1 = new JPanel();
		paneAlteraDados1.setBounds(0, 145, 690, 25);
		panelDados.add(paneAlteraDados1);
		GridBagLayout gbl_paneAlteraDados1 = new GridBagLayout();
		gbl_paneAlteraDados1.columnWidths = new int[]{85, 243, 0};
		gbl_paneAlteraDados1.rowHeights = new int[]{0, 0, 0};
		gbl_paneAlteraDados1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_paneAlteraDados1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		paneAlteraDados1.setLayout(gbl_paneAlteraDados1);
		
		JLabel lblResidencial = new JLabel("* Tel Residencial:");
		lblResidencial.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblResidencial = new GridBagConstraints();
		gbc_lblResidencial.anchor = GridBagConstraints.EAST;
		gbc_lblResidencial.insets = new Insets(0, 10, 5, 5);
		gbc_lblResidencial.gridx = 0;
		gbc_lblResidencial.gridy = 0;
		paneAlteraDados1.add(lblResidencial, gbc_lblResidencial);
		
		txtResidencial = new JTextField();
		txtResidencial.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResidencial.setColumns(10);
		GridBagConstraints gbc_txtResidencial = new GridBagConstraints();
		gbc_txtResidencial.weighty = 1.1;
		gbc_txtResidencial.fill = GridBagConstraints.BOTH;
		gbc_txtResidencial.insets = new Insets(0, 2, 5, 10);
		gbc_txtResidencial.gridx = 1;
		gbc_txtResidencial.gridy = 0;
		paneAlteraDados1.add(txtResidencial, gbc_txtResidencial);
		
		JLabel lblEmail = new JLabel("* Email:");
		lblEmail.setBounds(10, 211, 46, 14);
		panelDados.add(lblEmail);
		
		txEmail = new JTextField();
		txEmail.setBounds(74, 208, 235, 20);
		panelDados.add(txEmail);
		txEmail.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("* Estado Civil:");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEstadoCivil.setBounds(461, 11, 65, 14);
		panelDados.add(lblEstadoCivil);
		
		JComboBox comboCivil = new JComboBox();
		comboCivil.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "SOLTEIRO", "CASADO", "DIVORCIADO", "VI\u00DAVO"}));
		comboCivil.setFont(new Font("Arial", Font.PLAIN, 11));
		comboCivil.setBounds(536, 8, 100, 20);
		panelDados.add(comboCivil);
		
		JLabel lbltelCeluar = new JLabel("*Tel Celular:");
		lbltelCeluar.setBounds(10, 186, 100, 14);
		panelDados.add(lbltelCeluar);
		
		txtecelular = new JTextField();
		txtecelular.setFont(new Font("Arial", Font.PLAIN, 11));
		txtecelular.setColumns(10);
		txtecelular.setBounds(85, 181, 86, 20);
		panelDados.add(txtecelular);
		
		JButton btnLimparDados = new JButton("Limpar");
		btnLimparDados.setBounds(10, 253, 89, 23);
		panelDados.add(btnLimparDados);
		
		JButton btnSalvarDados = new JButton("Salvar");
		btnSalvarDados.setBounds(110, 253, 89, 23);
		panelDados.add(btnSalvarDados);
		panelDados.setVisible(false);
		
		panelFun = new JPanel();
		panelFun.setBorder(new TitledBorder(null, "Altera Função", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFun.setBounds(155, 11, 686, 426);
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
		comboTurno.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "MATUTINO", "VERPERTINO", "NOTURNO"}));
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
			
		panelGrad = new JPanel();
		panelGrad.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Altera Gradua\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrad.setBounds(157, 11, 684, 126);
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
		lblDataConclusao.setBounds(291, 21, 101, 14);
		panelGrad.add(lblDataConclusao);
		lblDataConclusao.setFont(new Font("Arial", Font.PLAIN, 11));
		
		txtDataGraduacao = new JTextField();
		txtDataGraduacao.setBounds(406, 15, 118, 20);
		panelGrad.add(txtDataGraduacao);
		txtDataGraduacao.setColumns(10);
		panelGrad.setVisible(false);

		
	}
}
