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
	private JTextField txEmail;
	private JTextField txtInstituicao;
	private JTextField txtecelular;
	private JTextField txtDataGraduacao;
	private JTextField txtLogradouro;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtCEP;
	private JTextField txtResidencial;
	
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
		setBounds(100, 100, 877, 486);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 145, 566);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAlteraGraduao = new JButton("Altera"
				+ " Gradua\u00E7\u00E3o");
		btnAlteraGraduao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
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
		panelDados.setBorder(new TitledBorder(null, "Altera Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDados.setBounds(146, 0, 715, 437);
		getContentPane().add(panelDados);
		panelDados.setLayout(null);
		
		JLabel lblCodigo = new JLabel("* C\u00F3digo:");
		lblCodigo.setBounds(11, 21, 65, 14);
		panelDados.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(75, 18, 133, 20);
		panelDados.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblSituacao = new JLabel("* Situa\u00E7\u00E3o:");
		lblSituacao.setBounds(264, 21, 65, 14);
		panelDados.add(lblSituacao);
		
		JComboBox comboSituacao = new JComboBox();
		comboSituacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "EM EXERC\u00CDCIO", "READAPTADO", "AFASTADO DA FUN\u00C7\u00C3O", "LICEN\u00C7A M\u00C9DICA", "LICEN\u00C7A PR\u00CAMIO"}));
		comboSituacao.setBounds(339, 18, 90, 20);
		panelDados.add(comboSituacao);
		
		JLabel lblEmail = new JLabel("* Email:");
		lblEmail.setBounds(10, 264, 46, 14);
		panelDados.add(lblEmail);
		
		txEmail = new JTextField();
		txEmail.setBounds(74, 261, 235, 20);
		panelDados.add(txEmail);
		txEmail.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("* Estado Civil:");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEstadoCivil.setBounds(463, 21, 65, 14);
		panelDados.add(lblEstadoCivil);
		
		JComboBox comboCivil = new JComboBox();
		comboCivil.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "SOLTEIRO", "CASADO", "DIVORCIADO", "VI\u00DAVO"}));
		comboCivil.setFont(new Font("Arial", Font.PLAIN, 11));
		comboCivil.setBounds(539, 18, 100, 20);
		panelDados.add(comboCivil);
		
		JLabel lbltelCeluar = new JLabel("*Tel Celular:");
		lbltelCeluar.setBounds(10, 239, 100, 14);
		panelDados.add(lbltelCeluar);
		
		txtecelular = new JTextField();
		txtecelular.setFont(new Font("Arial", Font.PLAIN, 11));
		txtecelular.setColumns(10);
		txtecelular.setBounds(86, 236, 86, 20);
		panelDados.add(txtecelular);
		
		JButton btnLimparDados = new JButton("Limpar");
		btnLimparDados.setBounds(10, 312, 89, 23);
		panelDados.add(btnLimparDados);
		
		JButton btnSalvarDados = new JButton("Salvar");
		btnSalvarDados.setBounds(101, 312, 89, 23);
		panelDados.add(btnSalvarDados);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 92, 82, 14);
		panelDados.add(lblEndereo);
		
		JLabel lblLogradouro = new JLabel("* Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLogradouro.setBounds(10, 123, 66, 14);
		panelDados.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(86, 120, 86, 20);
		panelDados.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblEndereco = new JLabel("* Endere\u00E7o:");
		lblEndereco.setBounds(218, 120, 71, 14);
		panelDados.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(291, 120, 229, 20);
		panelDados.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("* N\u00FAmero:");
		lblNumero.setBounds(548, 123, 65, 14);
		panelDados.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNumero.setColumns(10);
		txtNumero.setBounds(618, 117, 86, 20);
		panelDados.add(txtNumero);
		
		JLabel lblCidade = new JLabel("* Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCidade.setBounds(10, 148, 43, 14);
		panelDados.add(lblCidade);
		
		JLabel lblBairro = new JLabel("* Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBairro.setBounds(10, 173, 39, 14);
		panelDados.add(lblBairro);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCidade.setColumns(10);
		txtCidade.setBounds(86, 145, 434, 20);
		panelDados.add(txtCidade);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		txtBairro.setColumns(10);
		txtBairro.setBounds(86, 170, 434, 20);
		panelDados.add(txtBairro);
		
		JLabel lblUF = new JLabel("* UF:");
		lblUF.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUF.setBounds(590, 145, 23, 14);
		panelDados.add(lblUF);
		
		JComboBox comboUF = new JComboBox();
		comboUF.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		comboUF.setFont(new Font("Arial", Font.PLAIN, 11));
		comboUF.setBounds(618, 142, 72, 20);
		panelDados.add(comboUF);
		
		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCEP.setColumns(10);
		txtCEP.setBounds(618, 167, 72, 20);
		panelDados.add(txtCEP);
		
		JLabel lblCEP = new JLabel("* CEP:");
		lblCEP.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCEP.setBounds(584, 173, 29, 14);
		panelDados.add(lblCEP);
		
		JLabel lblResidencial = new JLabel("* Tel Residencial:");
		lblResidencial.setFont(new Font("Arial", Font.PLAIN, 11));
		lblResidencial.setBounds(10, 198, 82, 14);
		panelDados.add(lblResidencial);
		
		txtResidencial = new JTextField();
		txtResidencial.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResidencial.setColumns(10);
		txtResidencial.setBounds(97, 195, 231, 20);
		panelDados.add(txtResidencial);
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
