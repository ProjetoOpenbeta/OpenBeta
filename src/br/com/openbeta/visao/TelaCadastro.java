package br.com.openbeta.visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.openbeta.controle.EAO;
import br.com.openbeta.controle.JDBC;
import br.com.openbeta.modelo.Atividade;
import br.com.openbeta.modelo.Cargo;
import br.com.openbeta.modelo.Contratacao;
import br.com.openbeta.modelo.Endereco;
import br.com.openbeta.modelo.Estado;
import br.com.openbeta.modelo.EstadoCivil;
import br.com.openbeta.modelo.Funcao;
import br.com.openbeta.modelo.FuncaoPessoa;
import br.com.openbeta.modelo.Graduacao;
import br.com.openbeta.modelo.GraduacaoPessoa;
import br.com.openbeta.modelo.Pessoa;
import br.com.openbeta.modelo.Setor;
import br.com.openbeta.modelo.Sexo;
import br.com.openbeta.modelo.Situacao;
import br.com.openbeta.modelo.SubSetor;
import br.com.openbeta.modelo.TelefoneResidencial;
import br.com.openbeta.modelo.TelefoneResidencialPessoa;
import br.com.openbeta.modelo.TipoGraduacao;
import br.com.openbeta.modelo.Turno;
import br.com.openbeta.renderers.FuncoesTableModel2;
import br.com.openbeta.renderers.GraduacoesTableModel2;
import br.com.openbeta.utilitarios.Md5;
import br.com.openbeta.utilitarios.ValidaCPF;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTCodigo;
	private JTextField jTNome;
	private JTextField jTNomeMae;
	private JTextField jTCPF;
	private JTextField jTRG;
	private JTextField jTCidadeNatal;
	private JTextField jTDataNascimento;
	private JTextField jTEnderecoLogradouro;
	private JTextField jTEnderecoNumero;
	private JTextField jTEnderecoRua;
	private JTextField jTEnderecoCidade;
	private JTextField jTEnderecoBairro;
	private JTextField jTEnderecoCEP;
	private JTextField jTTelefoneResidencial;
	private JTextField jTCelular1;
	private JTextField jTCelular2;
	private JTextField jTEmail1;
	private JTextField jTEmail2;
	private JTextField jTDataConclusaoGraduacao;
	private JTextField jTNomeInstituicao1;
	private JTable jTableGraduacoes;
	private JTable jTableFuncoes;
	private JButton jBGravar;
	private JButton jBLimpar;
	private JButton jBFechar;
	private JButton jBAdicionarGraduacao;
	private JButton jBAdicionarFuncao;
	private JComboBox jComboBoxContratacao;
	private JComboBox jComboBoxSituacao;
    private JComboBox jComboBoxEstadoCivil;
	private JComboBox jComboBoxSexo;
	private JComboBox jComboBoxUFNatal;
	private JComboBox jComboBoxUFEndereco;
	public JComboBox jComboBoxGraduacao;
	private JComboBox jComboBoxFuncao;
	private JComboBox jComboBoxSetor;
	private JComboBox jComboBoxTurno;
	private JComboBox jComboBoxSubSetor;
	private JTextPane jTExtras;
	
	
	private EAO                         pessoaEAO                       = new EAO(Pessoa.class);
    private EAO                         graduacaoEAO                    = new EAO(Graduacao.class);
    private EAO                         funcaoEAO                       = new EAO(Funcao.class);
    private EAO                         graduacaoPessoaEAO              = new EAO(GraduacaoPessoa.class);
    private EAO                         funcaoPessoaEAO                 = new EAO(FuncaoPessoa.class);
    private EAO                         telefoneResidencialPessoaEAO    = new EAO(TelefoneResidencialPessoa.class);
    private GraduacoesTableModel2       modelGraduacao                  = new GraduacoesTableModel2();
    private FuncoesTableModel2          modelFuncao                     = new FuncoesTableModel2();
    private JPasswordField jTSenha;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setResizable(false);
		setTitle("Cadastro");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{105, 0, 0};
		gbl_contentPane.rowHeights = new int[]{10, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{77, 0};
		gbl_panel.rowHeights = new int[]{85, 60, 60, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		jBGravar = new JButton("Gravar");
		jBGravar.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jBGravar = new GridBagConstraints();
		gbc_jBGravar.fill = GridBagConstraints.BOTH;
		gbc_jBGravar.insets = new Insets(25, 10, 5, 10);
		gbc_jBGravar.gridx = 0;
		gbc_jBGravar.gridy = 0;
		panel.add(jBGravar, gbc_jBGravar);
		
		jBLimpar = new JButton("Limpar");
		jBLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jBLimpar = new GridBagConstraints();
		gbc_jBLimpar.fill = GridBagConstraints.BOTH;
		gbc_jBLimpar.insets = new Insets(0, 10, 5, 10);
		gbc_jBLimpar.gridx = 0;
		gbc_jBLimpar.gridy = 1;
		panel.add(jBLimpar, gbc_jBLimpar);
		
		jBFechar = new JButton("Fechar");
		jBFechar.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jBFechar = new GridBagConstraints();
		gbc_jBFechar.fill = GridBagConstraints.BOTH;
		gbc_jBFechar.insets = new Insets(0, 10, 5, 10);
		gbc_jBFechar.gridx = 0;
		gbc_jBFechar.gridy = 2;
		panel.add(jBFechar, gbc_jBFechar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		JPanel dados_pessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, dados_pessoais, null);
		GridBagLayout gbl_dados_pessoais = new GridBagLayout();
		gbl_dados_pessoais.columnWidths = new int[]{0, 0};
		gbl_dados_pessoais.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_dados_pessoais.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_dados_pessoais.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		dados_pessoais.setLayout(gbl_dados_pessoais);
		
		JPanel linha_0 = new JPanel();
		GridBagConstraints gbc_linha_0 = new GridBagConstraints();
		gbc_linha_0.anchor = GridBagConstraints.NORTH;
		gbc_linha_0.insets = new Insets(10, 10, 5, 10);
		gbc_linha_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_linha_0.gridx = 0;
		gbc_linha_0.gridy = 0;
		dados_pessoais.add(linha_0, gbc_linha_0);
		GridBagLayout gbl_linha_0 = new GridBagLayout();
		gbl_linha_0.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_linha_0.rowHeights = new int[]{0, 0, 0};
		gbl_linha_0.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_linha_0.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_0.setLayout(gbl_linha_0);
		
		JLabel lblNewLabel = new JLabel("* C\u00F3digo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		linha_0.add(lblNewLabel, gbc_lblNewLabel);
		
		jTCodigo = new JTextField();
		jTCodigo.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jTCodigo = new GridBagConstraints();
		gbc_jTCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_jTCodigo.fill = GridBagConstraints.BOTH;
		gbc_jTCodigo.gridx = 1;
		gbc_jTCodigo.gridy = 0;
		linha_0.add(jTCodigo, gbc_jTCodigo);
		jTCodigo.setColumns(10);
		
		JLabel lblContratao = new JLabel("* Contrata\u00E7\u00E3o");
		lblContratao.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblContratao = new GridBagConstraints();
		gbc_lblContratao.anchor = GridBagConstraints.EAST;
		gbc_lblContratao.insets = new Insets(0, 0, 5, 5);
		gbc_lblContratao.gridx = 2;
		gbc_lblContratao.gridy = 0;
		linha_0.add(lblContratao, gbc_lblContratao);
		
		jComboBoxContratacao = new JComboBox();
		jComboBoxContratacao.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxContratacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ESTADO", "PSS"}));
		GridBagConstraints gbc_jComboBoxContratacao = new GridBagConstraints();
		gbc_jComboBoxContratacao.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxContratacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxContratacao.gridx = 3;
		gbc_jComboBoxContratacao.gridy = 0;
		linha_0.add(jComboBoxContratacao, gbc_jComboBoxContratacao);
		
		JLabel lblSituao = new JLabel("* Situa\u00E7\u00E3o");
		lblSituao.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSituao = new GridBagConstraints();
		gbc_lblSituao.anchor = GridBagConstraints.EAST;
		gbc_lblSituao.insets = new Insets(0, 0, 5, 5);
		gbc_lblSituao.gridx = 4;
		gbc_lblSituao.gridy = 0;
		linha_0.add(lblSituao, gbc_lblSituao);
		
		jComboBoxSituacao = new JComboBox();
		jComboBoxSituacao.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxSituacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "EM EXERC\u00CDCIO", "READAPTADO", "AFASTADO DA FUN\u00C7\u00C3O", "LICEN\u00C7A M\u00C9DICA", "LICEN\u00C7A PR\u00CAMIO"}));
		GridBagConstraints gbc_jComboBoxSituacao = new GridBagConstraints();
		gbc_jComboBoxSituacao.insets = new Insets(0, 0, 5, 0);
		gbc_jComboBoxSituacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxSituacao.gridx = 5;
		gbc_jComboBoxSituacao.gridy = 0;
		linha_0.add(jComboBoxSituacao, gbc_jComboBoxSituacao);
		
		JPanel linha_1 = new JPanel();
		GridBagConstraints gbc_linha_1 = new GridBagConstraints();
		gbc_linha_1.insets = new Insets(0, 0, 5, 0);
		gbc_linha_1.fill = GridBagConstraints.BOTH;
		gbc_linha_1.gridx = 0;
		gbc_linha_1.gridy = 1;
		dados_pessoais.add(linha_1, gbc_linha_1);
		GridBagLayout gbl_linha_1 = new GridBagLayout();
		gbl_linha_1.columnWidths = new int[]{85, 0, 0};
		gbl_linha_1.rowHeights = new int[]{0, 0, 0};
		gbl_linha_1.columnWeights = new double[]{0.0, 2.0, Double.MIN_VALUE};
		gbl_linha_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_1.setLayout(gbl_linha_1);
		
		JLabel lblNome = new JLabel("* Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 10, 5, 4);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		linha_1.add(lblNome, gbc_lblNome);
		
		jTNome = new JTextField();
		jTNome.setFont(new Font("Arial", Font.PLAIN, 11));
		jTNome.setColumns(10);
		GridBagConstraints gbc_jTNome = new GridBagConstraints();
		gbc_jTNome.weighty = 1.1;
		gbc_jTNome.fill = GridBagConstraints.BOTH;
		gbc_jTNome.insets = new Insets(0, 2, 5, 10);
		gbc_jTNome.gridx = 1;
		gbc_jTNome.gridy = 0;
		linha_1.add(jTNome, gbc_jTNome);
		
		JPanel linha_2 = new JPanel();
		GridBagConstraints gbc_linha_2 = new GridBagConstraints();
		gbc_linha_2.insets = new Insets(0, 0, 5, 0);
		gbc_linha_2.fill = GridBagConstraints.BOTH;
		gbc_linha_2.gridx = 0;
		gbc_linha_2.gridy = 2;
		dados_pessoais.add(linha_2, gbc_linha_2);
		GridBagLayout gbl_linha_2 = new GridBagLayout();
		gbl_linha_2.columnWidths = new int[]{85, 0, 0};
		gbl_linha_2.rowHeights = new int[]{0, 0, 0};
		gbl_linha_2.columnWeights = new double[]{0.0, 2.0, Double.MIN_VALUE};
		gbl_linha_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_2.setLayout(gbl_linha_2);
		
		JLabel lblNomeMe = new JLabel("* Nome M\u00E3e:");
		lblNomeMe.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNomeMe = new GridBagConstraints();
		gbc_lblNomeMe.anchor = GridBagConstraints.EAST;
		gbc_lblNomeMe.insets = new Insets(0, 10, 5, 5);
		gbc_lblNomeMe.gridx = 0;
		gbc_lblNomeMe.gridy = 0;
		linha_2.add(lblNomeMe, gbc_lblNomeMe);
		
		jTNomeMae = new JTextField();
		jTNomeMae.setFont(new Font("Arial", Font.PLAIN, 11));
		jTNomeMae.setColumns(10);
		GridBagConstraints gbc_jTNomeMae = new GridBagConstraints();
		gbc_jTNomeMae.weighty = 1.1;
		gbc_jTNomeMae.fill = GridBagConstraints.BOTH;
		gbc_jTNomeMae.insets = new Insets(0, 2, 5, 10);
		gbc_jTNomeMae.gridx = 1;
		gbc_jTNomeMae.gridy = 0;
		linha_2.add(jTNomeMae, gbc_jTNomeMae);
		
		JPanel linha_3 = new JPanel();
		GridBagConstraints gbc_linha_3 = new GridBagConstraints();
		gbc_linha_3.insets = new Insets(0, 0, 5, 0);
		gbc_linha_3.fill = GridBagConstraints.BOTH;
		gbc_linha_3.gridx = 0;
		gbc_linha_3.gridy = 3;
		dados_pessoais.add(linha_3, gbc_linha_3);
		GridBagLayout gbl_linha_3 = new GridBagLayout();
		gbl_linha_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_linha_3.rowHeights = new int[]{0, 0, 0};
		gbl_linha_3.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_linha_3.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_3.setLayout(gbl_linha_3);
		
		JLabel lblCpf = new JLabel("* CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.insets = new Insets(0, 38, 5, 6);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 0;
		linha_3.add(lblCpf, gbc_lblCpf);
		
		jTCPF = new JTextField();
		jTCPF.setFont(new Font("Arial", Font.PLAIN, 11));
		jTCPF.setColumns(10);
		GridBagConstraints gbc_jTCPF = new GridBagConstraints();
		gbc_jTCPF.fill = GridBagConstraints.BOTH;
		gbc_jTCPF.insets = new Insets(0, 2, 5, 5);
		gbc_jTCPF.gridx = 1;
		gbc_jTCPF.gridy = 0;
		linha_3.add(jTCPF, gbc_jTCPF);
		
		JLabel lblRg = new JLabel("* RG:");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblRg = new GridBagConstraints();
		gbc_lblRg.anchor = GridBagConstraints.EAST;
		gbc_lblRg.insets = new Insets(0, 0, 5, 5);
		gbc_lblRg.gridx = 2;
		gbc_lblRg.gridy = 0;
		linha_3.add(lblRg, gbc_lblRg);
		
		jTRG = new JTextField();
		jTRG.setFont(new Font("Arial", Font.PLAIN, 11));
		jTRG.setColumns(10);
		GridBagConstraints gbc_jTRG = new GridBagConstraints();
		gbc_jTRG.insets = new Insets(0, 0, 5, 5);
		gbc_jTRG.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTRG.gridx = 3;
		gbc_jTRG.gridy = 0;
		linha_3.add(jTRG, gbc_jTRG);
		
		JLabel lblEstadoCivil = new JLabel("* Estado Civil:");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEstadoCivil = new GridBagConstraints();
		gbc_lblEstadoCivil.anchor = GridBagConstraints.EAST;
		gbc_lblEstadoCivil.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoCivil.gridx = 4;
		gbc_lblEstadoCivil.gridy = 0;
		linha_3.add(lblEstadoCivil, gbc_lblEstadoCivil);
		
		jComboBoxEstadoCivil = new JComboBox();
		jComboBoxEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "SOLTEIRO", "CASADO", "DIVORCIADO", "VI\u00DAVO"}));
		GridBagConstraints gbc_jComboBoxEstadoCivil = new GridBagConstraints();
		gbc_jComboBoxEstadoCivil.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxEstadoCivil.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxEstadoCivil.gridx = 5;
		gbc_jComboBoxEstadoCivil.gridy = 0;
		linha_3.add(jComboBoxEstadoCivil, gbc_jComboBoxEstadoCivil);
		
		JLabel lblSexo = new JLabel("* Sexo:");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 6;
		gbc_lblSexo.gridy = 0;
		linha_3.add(lblSexo, gbc_lblSexo);
		
		jComboBoxSexo = new JComboBox();
		jComboBoxSexo.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "MASCULINO", "FEMININO"}));
		GridBagConstraints gbc_jComboBoxSexo = new GridBagConstraints();
		gbc_jComboBoxSexo.insets = new Insets(0, 0, 5, 10);
		gbc_jComboBoxSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxSexo.gridx = 7;
		gbc_jComboBoxSexo.gridy = 0;
		linha_3.add(jComboBoxSexo, gbc_jComboBoxSexo);
		
		JPanel linha_4 = new JPanel();
		GridBagConstraints gbc_linha_4 = new GridBagConstraints();
		gbc_linha_4.insets = new Insets(0, 0, 5, 0);
		gbc_linha_4.fill = GridBagConstraints.BOTH;
		gbc_linha_4.gridx = 0;
		gbc_linha_4.gridy = 4;
		dados_pessoais.add(linha_4, gbc_linha_4);
		GridBagLayout gbl_linha_4 = new GridBagLayout();
		gbl_linha_4.columnWidths = new int[]{85, 243, 0, 0, 0};
		gbl_linha_4.rowHeights = new int[]{0, 0, 0};
		gbl_linha_4.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_linha_4.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_4.setLayout(gbl_linha_4);
		
		JLabel lblSenha = new JLabel("* Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 10, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 0;
		linha_4.add(lblSenha, gbc_lblSenha);
		
		jTSenha = new JPasswordField();
		GridBagConstraints gbc_jTSenha = new GridBagConstraints();
		gbc_jTSenha.insets = new Insets(0, 0, 5, 5);
		gbc_jTSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTSenha.gridx = 1;
		gbc_jTSenha.gridy = 0;
		linha_4.add(jTSenha, gbc_jTSenha);
		
		JPanel linha_5 = new JPanel();
		linha_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Natural de", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_linha_5 = new GridBagConstraints();
		gbc_linha_5.insets = new Insets(0, 10, 5, 10);
		gbc_linha_5.fill = GridBagConstraints.BOTH;
		gbc_linha_5.gridx = 0;
		gbc_linha_5.gridy = 5;
		dados_pessoais.add(linha_5, gbc_linha_5);
		GridBagLayout gbl_linha_5 = new GridBagLayout();
		gbl_linha_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_linha_5.rowHeights = new int[]{0, 0, 0};
		gbl_linha_5.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_linha_5.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_5.setLayout(gbl_linha_5);
		
		JLabel lblCidade = new JLabel("* Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 18, 5, 5);
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 0;
		linha_5.add(lblCidade, gbc_lblCidade);
		
		jTCidadeNatal = new JTextField();
		jTCidadeNatal.setFont(new Font("Arial", Font.PLAIN, 11));
		jTCidadeNatal.setColumns(10);
		GridBagConstraints gbc_jTCidadeNatal = new GridBagConstraints();
		gbc_jTCidadeNatal.fill = GridBagConstraints.BOTH;
		gbc_jTCidadeNatal.insets = new Insets(0, 0, 5, 5);
		gbc_jTCidadeNatal.gridx = 1;
		gbc_jTCidadeNatal.gridy = 0;
		linha_5.add(jTCidadeNatal, gbc_jTCidadeNatal);
		
		JLabel lblUf = new JLabel("* UF:");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.EAST;
		gbc_lblUf.insets = new Insets(0, 10, 5, 5);
		gbc_lblUf.gridx = 2;
		gbc_lblUf.gridy = 0;
		linha_5.add(lblUf, gbc_lblUf);
		
		jComboBoxUFNatal = new JComboBox();
		jComboBoxUFNatal.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxUFNatal.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		GridBagConstraints gbc_jComboBoxUFNatal = new GridBagConstraints();
		gbc_jComboBoxUFNatal.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxUFNatal.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxUFNatal.gridx = 3;
		gbc_jComboBoxUFNatal.gridy = 0;
		linha_5.add(jComboBoxUFNatal, gbc_jComboBoxUFNatal);
		
		JLabel lblDataDe = new JLabel("* Data de Nascimento:");
		lblDataDe.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDataDe = new GridBagConstraints();
		gbc_lblDataDe.anchor = GridBagConstraints.EAST;
		gbc_lblDataDe.insets = new Insets(0, 10, 5, 5);
		gbc_lblDataDe.gridx = 4;
		gbc_lblDataDe.gridy = 0;
		linha_5.add(lblDataDe, gbc_lblDataDe);
		
		jTDataNascimento = new JTextField();
		jTDataNascimento.setFont(new Font("Arial", Font.PLAIN, 11));
		jTDataNascimento.setColumns(10);
		GridBagConstraints gbc_jTDataNascimento = new GridBagConstraints();
		gbc_jTDataNascimento.insets = new Insets(0, 0, 5, 0);
		gbc_jTDataNascimento.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTDataNascimento.gridx = 5;
		gbc_jTDataNascimento.gridy = 0;
		linha_5.add(jTDataNascimento, gbc_jTDataNascimento);
		
		JPanel linha_6 = new JPanel();
		linha_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_linha_6 = new GridBagConstraints();
		gbc_linha_6.insets = new Insets(0, 10, 5, 10);
		gbc_linha_6.fill = GridBagConstraints.BOTH;
		gbc_linha_6.gridx = 0;
		gbc_linha_6.gridy = 6;
		dados_pessoais.add(linha_6, gbc_linha_6);
		GridBagLayout gbl_linha_6 = new GridBagLayout();
		gbl_linha_6.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_linha_6.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_linha_6.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_linha_6.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		linha_6.setLayout(gbl_linha_6);
		
		JLabel lblLogradouro = new JLabel("* Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLogradouro = new GridBagConstraints();
		gbc_lblLogradouro.anchor = GridBagConstraints.EAST;
		gbc_lblLogradouro.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogradouro.gridx = 0;
		gbc_lblLogradouro.gridy = 0;
		linha_6.add(lblLogradouro, gbc_lblLogradouro);
		
		jTEnderecoLogradouro = new JTextField();
		jTEnderecoLogradouro.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEnderecoLogradouro.setColumns(10);
		GridBagConstraints gbc_jTEnderecoLogradouro = new GridBagConstraints();
		gbc_jTEnderecoLogradouro.fill = GridBagConstraints.BOTH;
		gbc_jTEnderecoLogradouro.insets = new Insets(0, 0, 5, 5);
		gbc_jTEnderecoLogradouro.gridx = 1;
		gbc_jTEnderecoLogradouro.gridy = 0;
		linha_6.add(jTEnderecoLogradouro, gbc_jTEnderecoLogradouro);
		
		JLabel lblEndereo = new JLabel("* Endere\u00E7o:");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 10, 5, 5);
		gbc_lblEndereo.gridx = 2;
		gbc_lblEndereo.gridy = 0;
		linha_6.add(lblEndereo, gbc_lblEndereo);
		
		jTEnderecoRua = new JTextField();
		jTEnderecoRua.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEnderecoRua.setColumns(10);
		GridBagConstraints gbc_jTEnderecoRua = new GridBagConstraints();
		gbc_jTEnderecoRua.insets = new Insets(0, 0, 5, 5);
		gbc_jTEnderecoRua.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTEnderecoRua.gridx = 3;
		gbc_jTEnderecoRua.gridy = 0;
		linha_6.add(jTEnderecoRua, gbc_jTEnderecoRua);
		
		JLabel lblNmero = new JLabel("* N\u00FAmero:");
		lblNmero.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNmero = new GridBagConstraints();
		gbc_lblNmero.anchor = GridBagConstraints.EAST;
		gbc_lblNmero.insets = new Insets(0, 10, 5, 5);
		gbc_lblNmero.gridx = 4;
		gbc_lblNmero.gridy = 0;
		linha_6.add(lblNmero, gbc_lblNmero);
		
		jTEnderecoNumero = new JTextField();
		jTEnderecoNumero.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEnderecoNumero.setColumns(10);
		GridBagConstraints gbc_jTEnderecoNumero = new GridBagConstraints();
		gbc_jTEnderecoNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTEnderecoNumero.insets = new Insets(0, 0, 5, 0);
		gbc_jTEnderecoNumero.gridx = 5;
		gbc_jTEnderecoNumero.gridy = 0;
		linha_6.add(jTEnderecoNumero, gbc_jTEnderecoNumero);
		
		JLabel lblCidade_1 = new JLabel("* Cidade:");
		lblCidade_1.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCidade_1 = new GridBagConstraints();
		gbc_lblCidade_1.anchor = GridBagConstraints.EAST;
		gbc_lblCidade_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade_1.gridx = 0;
		gbc_lblCidade_1.gridy = 1;
		linha_6.add(lblCidade_1, gbc_lblCidade_1);
		
		jTEnderecoCidade = new JTextField();
		jTEnderecoCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEnderecoCidade.setColumns(10);
		GridBagConstraints gbc_jTEnderecoCidade = new GridBagConstraints();
		gbc_jTEnderecoCidade.gridwidth = 3;
		gbc_jTEnderecoCidade.insets = new Insets(0, 0, 5, 5);
		gbc_jTEnderecoCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTEnderecoCidade.gridx = 1;
		gbc_jTEnderecoCidade.gridy = 1;
		linha_6.add(jTEnderecoCidade, gbc_jTEnderecoCidade);
		
		JLabel label = new JLabel("* UF:");
		label.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 4;
		gbc_label.gridy = 1;
		linha_6.add(label, gbc_label);
		
		jComboBoxUFEndereco = new JComboBox();
		jComboBoxUFEndereco.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxUFEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		GridBagConstraints gbc_jComboBoxUFEndereco = new GridBagConstraints();
		gbc_jComboBoxUFEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_jComboBoxUFEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxUFEndereco.gridx = 5;
		gbc_jComboBoxUFEndereco.gridy = 1;
		linha_6.add(jComboBoxUFEndereco, gbc_jComboBoxUFEndereco);
		
		JLabel lblBairro = new JLabel("* Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.EAST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 0;
		gbc_lblBairro.gridy = 2;
		linha_6.add(lblBairro, gbc_lblBairro);
		
		jTEnderecoBairro = new JTextField();
		jTEnderecoBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEnderecoBairro.setColumns(10);
		GridBagConstraints gbc_jTEnderecoBairro = new GridBagConstraints();
		gbc_jTEnderecoBairro.gridwidth = 3;
		gbc_jTEnderecoBairro.insets = new Insets(0, 0, 5, 5);
		gbc_jTEnderecoBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTEnderecoBairro.gridx = 1;
		gbc_jTEnderecoBairro.gridy = 2;
		linha_6.add(jTEnderecoBairro, gbc_jTEnderecoBairro);
		
		JLabel lblCep = new JLabel("* CEP:");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCep = new GridBagConstraints();
		gbc_lblCep.anchor = GridBagConstraints.EAST;
		gbc_lblCep.insets = new Insets(0, 0, 5, 5);
		gbc_lblCep.gridx = 4;
		gbc_lblCep.gridy = 2;
		linha_6.add(lblCep, gbc_lblCep);
		
		jTEnderecoCEP = new JTextField();
		jTEnderecoCEP.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEnderecoCEP.setColumns(10);
		GridBagConstraints gbc_jTEnderecoCEP = new GridBagConstraints();
		gbc_jTEnderecoCEP.insets = new Insets(0, 0, 5, 0);
		gbc_jTEnderecoCEP.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTEnderecoCEP.gridx = 5;
		gbc_jTEnderecoCEP.gridy = 2;
		linha_6.add(jTEnderecoCEP, gbc_jTEnderecoCEP);
		
		JPanel linha_7 = new JPanel();
		GridBagConstraints gbc_linha_7 = new GridBagConstraints();
		gbc_linha_7.insets = new Insets(0, 0, 5, 0);
		gbc_linha_7.fill = GridBagConstraints.BOTH;
		gbc_linha_7.gridx = 0;
		gbc_linha_7.gridy = 7;
		dados_pessoais.add(linha_7, gbc_linha_7);
		GridBagLayout gbl_linha_7 = new GridBagLayout();
		gbl_linha_7.columnWidths = new int[]{85, 243, 0};
		gbl_linha_7.rowHeights = new int[]{0, 0, 0};
		gbl_linha_7.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_linha_7.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_7.setLayout(gbl_linha_7);
		
		JLabel lblTelResidencial = new JLabel("Tel Residencial:");
		lblTelResidencial.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTelResidencial = new GridBagConstraints();
		gbc_lblTelResidencial.anchor = GridBagConstraints.EAST;
		gbc_lblTelResidencial.insets = new Insets(0, 10, 5, 5);
		gbc_lblTelResidencial.gridx = 0;
		gbc_lblTelResidencial.gridy = 0;
		linha_7.add(lblTelResidencial, gbc_lblTelResidencial);
		
		jTTelefoneResidencial = new JTextField();
		jTTelefoneResidencial.setFont(new Font("Arial", Font.PLAIN, 11));
		jTTelefoneResidencial.setColumns(10);
		GridBagConstraints gbc_jTTelefoneResidencial = new GridBagConstraints();
		gbc_jTTelefoneResidencial.weighty = 1.1;
		gbc_jTTelefoneResidencial.fill = GridBagConstraints.BOTH;
		gbc_jTTelefoneResidencial.insets = new Insets(0, 2, 5, 10);
		gbc_jTTelefoneResidencial.gridx = 1;
		gbc_jTTelefoneResidencial.gridy = 0;
		linha_7.add(jTTelefoneResidencial, gbc_jTTelefoneResidencial);
		
		JPanel linha_8 = new JPanel();
		GridBagConstraints gbc_linha_8 = new GridBagConstraints();
		gbc_linha_8.insets = new Insets(0, 0, 5, 0);
		gbc_linha_8.fill = GridBagConstraints.BOTH;
		gbc_linha_8.gridx = 0;
		gbc_linha_8.gridy = 8;
		dados_pessoais.add(linha_8, gbc_linha_8);
		GridBagLayout gbl_linha_8 = new GridBagLayout();
		gbl_linha_8.columnWidths = new int[]{85, 243, 0, 0, 0};
		gbl_linha_8.rowHeights = new int[]{0, 0, 0};
		gbl_linha_8.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_linha_8.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_8.setLayout(gbl_linha_8);
		
		JLabel lblTelCelular = new JLabel("* Tel Celular:");
		lblTelCelular.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTelCelular = new GridBagConstraints();
		gbc_lblTelCelular.anchor = GridBagConstraints.EAST;
		gbc_lblTelCelular.insets = new Insets(0, 21, 5, 5);
		gbc_lblTelCelular.gridx = 0;
		gbc_lblTelCelular.gridy = 0;
		linha_8.add(lblTelCelular, gbc_lblTelCelular);
		
		jTCelular1 = new JTextField();
		jTCelular1.setFont(new Font("Arial", Font.PLAIN, 11));
		jTCelular1.setColumns(10);
		GridBagConstraints gbc_jTCelular1 = new GridBagConstraints();
		gbc_jTCelular1.weighty = 1.1;
		gbc_jTCelular1.fill = GridBagConstraints.BOTH;
		gbc_jTCelular1.insets = new Insets(0, 2, 5, 10);
		gbc_jTCelular1.gridx = 1;
		gbc_jTCelular1.gridy = 0;
		linha_8.add(jTCelular1, gbc_jTCelular1);
		
		JLabel lblCelularOpcional = new JLabel("Celular Opcional:");
		lblCelularOpcional.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCelularOpcional = new GridBagConstraints();
		gbc_lblCelularOpcional.anchor = GridBagConstraints.EAST;
		gbc_lblCelularOpcional.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelularOpcional.gridx = 2;
		gbc_lblCelularOpcional.gridy = 0;
		linha_8.add(lblCelularOpcional, gbc_lblCelularOpcional);
		
		jTCelular2 = new JTextField();
		jTCelular2.setFont(new Font("Arial", Font.PLAIN, 11));
		jTCelular2.setColumns(10);
		GridBagConstraints gbc_jTCelular2 = new GridBagConstraints();
		gbc_jTCelular2.insets = new Insets(0, 0, 5, 10);
		gbc_jTCelular2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTCelular2.gridx = 3;
		gbc_jTCelular2.gridy = 0;
		linha_8.add(jTCelular2, gbc_jTCelular2);
		
		JPanel linha_9 = new JPanel();
		GridBagConstraints gbc_linha_9 = new GridBagConstraints();
		gbc_linha_9.insets = new Insets(0, 0, 5, 0);
		gbc_linha_9.fill = GridBagConstraints.BOTH;
		gbc_linha_9.gridx = 0;
		gbc_linha_9.gridy = 9;
		dados_pessoais.add(linha_9, gbc_linha_9);
		GridBagLayout gbl_linha_9 = new GridBagLayout();
		gbl_linha_9.columnWidths = new int[]{85, 0, 0};
		gbl_linha_9.rowHeights = new int[]{0, 0, 0};
		gbl_linha_9.columnWeights = new double[]{0.0, 2.0, Double.MIN_VALUE};
		gbl_linha_9.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_9.setLayout(gbl_linha_9);
		
		JLabel lblEmail = new JLabel("* E-Mail:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 40, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 0;
		linha_9.add(lblEmail, gbc_lblEmail);
		
		jTEmail1 = new JTextField();
		jTEmail1.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEmail1.setColumns(10);
		GridBagConstraints gbc_jTEmail1 = new GridBagConstraints();
		gbc_jTEmail1.weighty = 1.1;
		gbc_jTEmail1.fill = GridBagConstraints.BOTH;
		gbc_jTEmail1.insets = new Insets(0, 5, 5, 10);
		gbc_jTEmail1.gridx = 1;
		gbc_jTEmail1.gridy = 0;
		linha_9.add(jTEmail1, gbc_jTEmail1);
		
		JPanel linha_10 = new JPanel();
		GridBagConstraints gbc_linha_10 = new GridBagConstraints();
		gbc_linha_10.insets = new Insets(0, 0, 5, 0);
		gbc_linha_10.fill = GridBagConstraints.BOTH;
		gbc_linha_10.gridx = 0;
		gbc_linha_10.gridy = 10;
		dados_pessoais.add(linha_10, gbc_linha_10);
		GridBagLayout gbl_linha_10 = new GridBagLayout();
		gbl_linha_10.columnWidths = new int[]{85, 0, 0};
		gbl_linha_10.rowHeights = new int[]{0, 0, 0};
		gbl_linha_10.columnWeights = new double[]{0.0, 2.0, Double.MIN_VALUE};
		gbl_linha_10.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		linha_10.setLayout(gbl_linha_10);
		
		JLabel lblEmailOpcional = new JLabel("E-Mail Opcional:");
		lblEmailOpcional.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEmailOpcional = new GridBagConstraints();
		gbc_lblEmailOpcional.anchor = GridBagConstraints.EAST;
		gbc_lblEmailOpcional.insets = new Insets(0, 5, 5, 5);
		gbc_lblEmailOpcional.gridx = 0;
		gbc_lblEmailOpcional.gridy = 0;
		linha_10.add(lblEmailOpcional, gbc_lblEmailOpcional);
		
		jTEmail2 = new JTextField();
		jTEmail2.setFont(new Font("Arial", Font.PLAIN, 11));
		jTEmail2.setColumns(10);
		GridBagConstraints gbc_jTEmail2 = new GridBagConstraints();
		gbc_jTEmail2.weighty = 1.1;
		gbc_jTEmail2.fill = GridBagConstraints.BOTH;
		gbc_jTEmail2.insets = new Insets(0, 5, 5, 10);
		gbc_jTEmail2.gridx = 1;
		gbc_jTEmail2.gridy = 0;
		linha_10.add(jTEmail2, gbc_jTEmail2);
		
		JPanel linha_11 = new JPanel();
		GridBagConstraints gbc_linha_11 = new GridBagConstraints();
		gbc_linha_11.fill = GridBagConstraints.BOTH;
		gbc_linha_11.gridx = 0;
		gbc_linha_11.gridy = 11;
		dados_pessoais.add(linha_11, gbc_linha_11);
		GridBagLayout gbl_linha_11 = new GridBagLayout();
		gbl_linha_11.columnWidths = new int[]{85, 0, 0};
		gbl_linha_11.rowHeights = new int[]{0, 0, 0};
		gbl_linha_11.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_linha_11.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		linha_11.setLayout(gbl_linha_11);
		
		JLabel lblExtras = new JLabel("Extras:");
		lblExtras.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblExtras = new GridBagConstraints();
		gbc_lblExtras.anchor = GridBagConstraints.EAST;
		gbc_lblExtras.insets = new Insets(0, 5, 5, 5);
		gbc_lblExtras.gridx = 0;
		gbc_lblExtras.gridy = 0;
		linha_11.add(lblExtras, gbc_lblExtras);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 5, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 0;
		linha_11.add(scrollPane_1, gbc_scrollPane_1);
		
		jTExtras = new JTextPane();
		jTExtras.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane_1.setViewportView(jTExtras);
		
		JLabel lblCamposDe = new JLabel("* Campos de Preenchimento Obrigat\u00F3rio    ");
		GridBagConstraints gbc_lblCamposDe = new GridBagConstraints();
		gbc_lblCamposDe.anchor = GridBagConstraints.EAST;
		gbc_lblCamposDe.gridwidth = 2;
		gbc_lblCamposDe.gridx = 0;
		gbc_lblCamposDe.gridy = 1;
		linha_11.add(lblCamposDe, gbc_lblCamposDe);
		
		JPanel graduacoes = new JPanel();
		tabbedPane.addTab("Gradua\u00E7\u00F5es", null, graduacoes, null);
		GridBagLayout gbl_graduacoes = new GridBagLayout();
		gbl_graduacoes.columnWidths = new int[]{0, 0};
		gbl_graduacoes.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_graduacoes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_graduacoes.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		graduacoes.setLayout(gbl_graduacoes);
		
		JPanel panel_0 = new JPanel();
		GridBagConstraints gbc_panel_0 = new GridBagConstraints();
		gbc_panel_0.insets = new Insets(10, 10, 5, 10);
		gbc_panel_0.fill = GridBagConstraints.BOTH;
		gbc_panel_0.gridx = 0;
		gbc_panel_0.gridy = 0;
		graduacoes.add(panel_0, gbc_panel_0);
		GridBagLayout gbl_panel_0 = new GridBagLayout();
		gbc_panel_0.insets = new Insets(10, 10, 5, 10);
		gbl_panel_0.columnWidths = new int[]{0, 113, 0, 0, 0};
		gbl_panel_0.rowHeights = new int[]{0, 0};
		gbl_panel_0.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_0.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_0.setLayout(gbl_panel_0);
		
		JLabel lblGraduao = new JLabel("* Gradua\u00E7\u00E3o:");
		lblGraduao.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblGraduao = new GridBagConstraints();
		gbc_lblGraduao.insets = new Insets(0, 30, 0, 5);
		gbc_lblGraduao.anchor = GridBagConstraints.EAST;
		gbc_lblGraduao.gridx = 0;
		gbc_lblGraduao.gridy = 0;
		panel_0.add(lblGraduao, gbc_lblGraduao);
		
		jComboBoxGraduacao = new JComboBox();
		jComboBoxGraduacao.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxGraduacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		GridBagConstraints gbc_jComboBoxGraduacao = new GridBagConstraints();
		gbc_jComboBoxGraduacao.insets = new Insets(0, 0, 0, 5);
		gbc_jComboBoxGraduacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxGraduacao.gridx = 1;
		gbc_jComboBoxGraduacao.gridy = 0;
		panel_0.add(jComboBoxGraduacao, gbc_jComboBoxGraduacao);
		
		JLabel lblDataDe_1 = new JLabel("* Data de Conclus\u00E3o:");
		lblDataDe_1.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDataDe_1 = new GridBagConstraints();
		gbc_lblDataDe_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblDataDe_1.anchor = GridBagConstraints.EAST;
		gbc_lblDataDe_1.gridx = 2;
		gbc_lblDataDe_1.gridy = 0;
		panel_0.add(lblDataDe_1, gbc_lblDataDe_1);
		
		jTDataConclusaoGraduacao = new JTextField();
		jTDataConclusaoGraduacao.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jTDataConclusaoGraduacao = new GridBagConstraints();
		gbc_jTDataConclusaoGraduacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTDataConclusaoGraduacao.gridx = 3;
		gbc_jTDataConclusaoGraduacao.gridy = 0;
		panel_0.add(jTDataConclusaoGraduacao, gbc_jTDataConclusaoGraduacao);
		jTDataConclusaoGraduacao.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 10, 5, 10);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		graduacoes.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblInstituiocurso = new JLabel("* Institui\u00E7\u00E3o/Curso:");
		lblInstituiocurso.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblInstituiocurso = new GridBagConstraints();
		gbc_lblInstituiocurso.anchor = GridBagConstraints.EAST;
		gbc_lblInstituiocurso.insets = new Insets(0, 0, 0, 5);
		gbc_lblInstituiocurso.gridx = 0;
		gbc_lblInstituiocurso.gridy = 0;
		panel_1.add(lblInstituiocurso, gbc_lblInstituiocurso);
		
		jTNomeInstituicao1 = new JTextField();
		jTNomeInstituicao1.setFont(new Font("Arial", Font.PLAIN, 11));
		jTNomeInstituicao1.setColumns(10);
		GridBagConstraints gbc_jTNomeInstituicao1 = new GridBagConstraints();
		gbc_jTNomeInstituicao1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTNomeInstituicao1.gridx = 1;
		gbc_jTNomeInstituicao1.gridy = 0;
		panel_1.add(jTNomeInstituicao1, gbc_jTNomeInstituicao1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		graduacoes.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		jBAdicionarGraduacao = new JButton("Adicionar");
		jBAdicionarGraduacao.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jBAdicionarGraduacao = new GridBagConstraints();
		gbc_jBAdicionarGraduacao.fill = GridBagConstraints.BOTH;
		gbc_jBAdicionarGraduacao.insets = new Insets(10, 10, 5, 440);
		gbc_jBAdicionarGraduacao.gridx = 0;
		gbc_jBAdicionarGraduacao.gridy = 0;
		panel_2.add(jBAdicionarGraduacao, gbc_jBAdicionarGraduacao);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 10, 0, 10);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		graduacoes.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 10, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_3.add(scrollPane, gbc_scrollPane);
		
		jTableGraduacoes = new JTable();
		jTableGraduacoes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Tipo de gradua\u00E7\u00E3o", "Institui\u00C3\u00A7\u00C3\u00A3o", "Data de conclus\u00C3\u00A3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTableGraduacoes);
		
		JPanel funcoes = new JPanel();
		tabbedPane.addTab("Fun\u00E7\u00F5es", null, funcoes, null);
		tabbedPane.setEnabledAt(2, true);
		GridBagLayout gbl_funcoes = new GridBagLayout();
		gbl_funcoes.columnWidths = new int[]{0, 0};
		gbl_funcoes.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_funcoes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_funcoes.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		funcoes.setLayout(gbl_funcoes);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(10, 10, 5, 10);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		funcoes.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 132, 180, 120, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblFuno = new JLabel("* Fun\u00E7\u00E3o:");
		lblFuno.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFuno = new GridBagConstraints();
		gbc_lblFuno.anchor = GridBagConstraints.EAST;
		gbc_lblFuno.insets = new Insets(0, 30, 0, 5);
		gbc_lblFuno.gridx = 0;
		gbc_lblFuno.gridy = 0;
		panel_5.add(lblFuno, gbc_lblFuno);
		
		jComboBoxFuncao = new JComboBox();
		jComboBoxFuncao.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxFuncao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "PROFESSOR", "FUNCION\u00C1RIO", "PEDAGOGIA"}));
		GridBagConstraints gbc_jComboBoxFuncao = new GridBagConstraints();
		gbc_jComboBoxFuncao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxFuncao.insets = new Insets(0, 0, 0, 5);
		gbc_jComboBoxFuncao.gridx = 1;
		gbc_jComboBoxFuncao.gridy = 0;
		panel_5.add(jComboBoxFuncao, gbc_jComboBoxFuncao);
		
		JLabel lblSetorOu = new JLabel("* Setor ou Curso:");
		lblSetorOu.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSetorOu = new GridBagConstraints();
		gbc_lblSetorOu.anchor = GridBagConstraints.EAST;
		gbc_lblSetorOu.insets = new Insets(0, 0, 0, 5);
		gbc_lblSetorOu.gridx = 2;
		gbc_lblSetorOu.gridy = 0;
		panel_5.add(lblSetorOu, gbc_lblSetorOu);
		
		jComboBoxSetor = new JComboBox();
		jComboBoxSetor.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxSetor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ENSINO FUNDAMENTAL", "ENSINO M\u00C9DIO", "T\u00C9C. SUBSEQUENTE - ADMINISTRA\u00C7\u00C3O ", "T\u00C9C. SUBSEQUENTE - SECRETARIADO ", "T\u00C9C. SUBSEQUENTE - INFORM\u00C1TICA ", "T\u00C9C. INTEGRAL - ADMINISTRA\u00C7\u00C3O", "T\u00C9C. INTEGRAL - INFORM\u00C1TICA", "CELEM", "SALA DE RECURSOS", "SALA DE APOIO", "ESPORTE E LAZER", "AULAS ESPECIALIZADAS", "ARTE E CULTURA"}));
		GridBagConstraints gbc_jComboBoxSetor = new GridBagConstraints();
		gbc_jComboBoxSetor.anchor = GridBagConstraints.EAST;
		gbc_jComboBoxSetor.gridx = 3;
		gbc_jComboBoxSetor.gridy = 0;
		panel_5.add(jComboBoxSetor, gbc_jComboBoxSetor);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 10, 5, 10);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		funcoes.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 132, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblTurno = new JLabel("* Turno:");
		lblTurno.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTurno = new GridBagConstraints();
		gbc_lblTurno.anchor = GridBagConstraints.EAST;
		gbc_lblTurno.insets = new Insets(0, 36, 0, 5);
		gbc_lblTurno.gridx = 0;
		gbc_lblTurno.gridy = 0;
		panel_6.add(lblTurno, gbc_lblTurno);
		
		jComboBoxTurno = new JComboBox();
		jComboBoxTurno.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxTurno.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "MATUTINO", "VERPERTINO", "NOTURNO"}));
		GridBagConstraints gbc_jComboBoxTurno = new GridBagConstraints();
		gbc_jComboBoxTurno.insets = new Insets(0, 0, 0, 5);
		gbc_jComboBoxTurno.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxTurno.gridx = 1;
		gbc_jComboBoxTurno.gridy = 0;
		panel_6.add(jComboBoxTurno, gbc_jComboBoxTurno);
		
		JLabel lblSubsetorOu = new JLabel("* Sub-Setor ou Disciplina:");
		lblSubsetorOu.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSubsetorOu = new GridBagConstraints();
		gbc_lblSubsetorOu.insets = new Insets(0, 0, 0, 5);
		gbc_lblSubsetorOu.anchor = GridBagConstraints.EAST;
		gbc_lblSubsetorOu.gridx = 2;
		gbc_lblSubsetorOu.gridy = 0;
		panel_6.add(lblSubsetorOu, gbc_lblSubsetorOu);
		
		jComboBoxSubSetor = new JComboBox();
		jComboBoxSubSetor.setFont(new Font("Arial", Font.PLAIN, 11));
		jComboBoxSubSetor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "ARTE", "CI\u00CANCIAS", "EDUCA\u00C7\u00C3O F\u00CDSICA", "GEOGRAFIA", "HIST\u00D3RIA", "L\u00CDNGUA PORTUGUESA", "MATEM\u00C1TICA", "L.E.M - INGL\u00CAS", "ENSINO RELIGIOSO", "BIOLOGIA", "FILOSOFIA", "F\u00CDSICA", "QU\u00CDMICA", "L.E.M - ESPANHOL", "ADMINISTRA\u00C7\u00C3O DE PROD. E MAT.", "ADM. FINANCEIRA E OR\u00C7AMENT\u00C1RIA", "COMPORTAMENTO ORGANIZACIONAL", "CONTABILIDADE", "ELABORA\u00C7\u00C3O E AN\u00C1LISE PROJETOS", "ESTAT\u00CDSTICA APLICADA", "FUNDAMENTOS DO TRABALHO", "GEST\u00C3O DE PESSOAS", "INFORM\u00C1TICA", "INTRODU\u00C7\u00C3O \u00C0 ECONOMIA", "MARKETING", "MATEM\u00C1TICA FINANCEIRA", "NO\u00C7\u00D5ES DE DIREITO - LEG. TRABALHO", "ORGANIZA\u00C7\u00C3O, SISTEMAS E M\u00C9TODOS", "PR\u00C1TICA DISCURSIVA E LINGUAGEM", "TEORIA GERAL DA ADMINISTRA\u00C7\u00C3O", "ADMINISTRA\u00C7\u00C3O", "CERIMONIAL E PROTOCOLO", "ESPANHOL T\u00C9CNICO", "INGL\u00C3\u0160S T\u00C9CNICO", "INTRODU\u00C7\u00C3O \u00C0S FINAN\u00C7AS", "METODOLOGIA CIENT\u00CDFICA", "NO\u00C7\u00D5ES DE DIR. E LEG. SOC. TRAB.", "PSICOLOGIA ORGANIZACIONAL ", "REDA\u00C7\u00C3O EMPRESARIAL", "T\u00C9CNICAS DE SECRETARIADO", "AN\u00C1LISE DE PROJETOS", "BANCO DE DADOS", "FUND. E ARQUITETURA DE COMPUT.", "INFORM\u00C1TICA INSTRUMENTAL", "INTERNET E PROGRAMA\u00C7\u00C3O WEB", "LINGUAGEM DE PROGRAMA\u00C7\u00C3O", "MATEM\u00C1TICA APLICADA", "REDES E SISTEMAS OPERACIONAIS", "SUPORTE T\u00C9CNICO", "L\u00CDNGUA PORT. E LITERATURA", "ITALIANO - CELEM", "ESPANHOL - CELEM", "FRANC\u00CAS - CELEM", "SALA DE RECURSOS", "SALA DE APOIO", "HORA TREINAMENTO", "FUTSAL E ATLETISMO", "TREINAMENTO ESPORTIVO", "TEATRO"}));
		GridBagConstraints gbc_jComboBoxSubSetor = new GridBagConstraints();
		gbc_jComboBoxSubSetor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jComboBoxSubSetor.gridx = 3;
		gbc_jComboBoxSubSetor.gridy = 0;
		panel_6.add(jComboBoxSubSetor, gbc_jComboBoxSubSetor);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 2;
		funcoes.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		jBAdicionarFuncao =    new JButton("Adicionar");
		jBAdicionarFuncao.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jBAdicionarFuncao = new GridBagConstraints();
		gbc_jBAdicionarFuncao.insets = new Insets(10, 10, 5, 440);
		gbc_jBAdicionarFuncao.fill = GridBagConstraints.BOTH;
		gbc_jBAdicionarFuncao.gridx = 0;
		gbc_jBAdicionarFuncao.gridy = 0;
		panel_7.add(jBAdicionarFuncao, gbc_jBAdicionarFuncao);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 10, 0, 10);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 3;
		funcoes.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 10, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		panel_8.add(scrollPane_2, gbc_scrollPane_2);
		
		jTableFuncoes = new JTable();
		jTableFuncoes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cargo", "Setor", "Sub-Setor", "Turno"
			}
		));
		scrollPane_2.setViewportView(jTableFuncoes);
		
		/////////////////////////////////////////////////////
		
        setLocationRelativeTo(null);
        setListeners();
        jTCodigo.requestFocus();
        jTableGraduacoes.setModel(modelGraduacao);
        jTableFuncoes.setModel(modelFuncao);
	}
	
	private void setListeners() {
        jBGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos() == true) {
                    salvar();
                    JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
                    dispose();
                    main(null);
                }           
            }
         });
        jBLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro().setVisible(true);
                dispose();
            }
         });
        jBFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
         });
        jBAdicionarGraduacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adicionaGraduacao();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
        });
        jBAdicionarFuncao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionaFuncao();
            }    
        });
    }

    /**
     * Adiciona as graduacoes na tabela
     */
    private void adicionaGraduacao() throws ParseException {
        TipoGraduacao tipo_graduacao  = new TipoGraduacao();
        tipo_graduacao.setId_tipo_graduacao(jComboBoxGraduacao.getSelectedIndex());
        tipo_graduacao.setTipo_graduacao(jComboBoxGraduacao.getSelectedItem().toString());

        Graduacao     graduacao       = new Graduacao();
        graduacao.setInstituicao(jTNomeInstituicao1.getText());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        graduacao.setData_conclusao(format.parse(jTDataConclusaoGraduacao.getText()));
        graduacao.setTipo_graduacao(tipo_graduacao);

        modelGraduacao.addGraduacao(graduacao);
    }    

    /**
     * Adiciona uma funcao a tabela
     */
    private void adicionaFuncao() {
          Cargo cargo = new Cargo();
          cargo.setid_cargo(jComboBoxFuncao.getSelectedIndex());
          cargo.setnome_cargo(jComboBoxFuncao.getSelectedItem().toString());
          
          Setor setor = new Setor();
          setor.setId_setor(jComboBoxSetor.getSelectedIndex());
          setor.setNome_setor(jComboBoxSetor.getSelectedItem().toString());
          
          SubSetor sub_setor = new SubSetor();
          sub_setor.setId_sub_setor(jComboBoxSubSetor.getSelectedIndex());
          sub_setor.setNome_sub_setor(jComboBoxSubSetor.getSelectedItem().toString());
          
          Turno turno = new Turno();
          turno.setId_turno(jComboBoxTurno.getSelectedIndex());
          turno.setTurno(jComboBoxTurno.getSelectedItem().toString());
          
          Funcao funcao = new Funcao();
          funcao.setCargo(cargo);
          funcao.setSetor(setor);
          funcao.setSubSetor(sub_setor);
          funcao.setTurno(turno);
          
          modelFuncao.addFuncao(funcao);
    }
      
    private boolean validarCampos() {
        
        if (jComboBoxContratacao.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(null, "Informe modo de contratação", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jComboBoxSituacao.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(null, "Informe situação", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTNomeMae.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome da mãe", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma senha", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTCPF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o CPF", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (ValidaCPF.isCPF(jTCPF.getText().toString()) == false) {
            JOptionPane.showMessageDialog(null, "CPF Incoreto", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;            
        } else if (jTRG.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o RG", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;                        
        } else if (jTCidadeNatal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a cidade natal", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;                        
        } else if (jTRG.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o RG", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;                        
         } else if (jTDataNascimento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a data de nascimento", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;                                    
         } else if (jTEnderecoLogradouro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o logradouro", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;                                    
        } else
        
        return true;
    }
    
    private void salvar() {
        Pessoa pessoa = salvarPessoa();
        salvarGraduacoes();
        salvarFuncoes();
        salvarGraduacaoPessoa(pessoa);
        salvarFuncaoPessoa(pessoa);
    }
    
    @SuppressWarnings("deprecation")
	private Pessoa salvarPessoa() {
        Pessoa pessoa = new Pessoa();

        Contratacao contratacao = new Contratacao();
        contratacao.setid_contratacao(jComboBoxContratacao.getSelectedIndex());
        
        Atividade atividade = new Atividade();
        atividade.setid_atividade(1);
        
        Situacao situacao = new Situacao();
        situacao.setId_situacao(jComboBoxSituacao.getSelectedIndex());
            
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil.setId_estado_civil(jComboBoxEstadoCivil.getSelectedIndex());
        
        Sexo sexo = new Sexo();
        sexo.setid_sexo(jComboBoxSexo.getSelectedIndex());
             
        Estado estadoNatal = new Estado();
        estadoNatal.setId_estado(jComboBoxUFNatal.getSelectedIndex());
                
        Estado estadoEndereco = new Estado();
        estadoEndereco.setId_estado(jComboBoxUFEndereco.getSelectedIndex());
        
        Endereco endereco = new Endereco();
        endereco.setlogradouro(jTEnderecoLogradouro.getText().toUpperCase());
        endereco.setrua(jTEnderecoRua.getText().toUpperCase());
        endereco.setnumero(jTEnderecoNumero.getText());
        endereco.setcidade(jTEnderecoCidade.getText().toUpperCase());
        endereco.setestado(estadoEndereco);
        endereco.setbairro(jTEnderecoBairro.getText().toUpperCase()); 
        endereco.setcep(new BigDecimal(jTEnderecoCEP.getText()));

        TelefoneResidencial telefoneResidencial = new TelefoneResidencial();
        telefoneResidencial.setTelefone_res(jTTelefoneResidencial.getText());

        pessoa.settelefone_celular(jTCelular1.getText());
        pessoa.settelefone_celular_2(jTCelular2.getText());
        pessoa.setemail_principal(jTEmail1.getText());
        pessoa.setemail_adicional(jTEmail2.getText());
        pessoa.setoutros(jTExtras.getText().toUpperCase());
        pessoa.setestadoNatal(estadoNatal);
        pessoa.setestadoCivil(estadoCivil);
        pessoa.setsexo(sexo);
        pessoa.setatividade(atividade);
        pessoa.setcontratacao(contratacao);
        pessoa.setsituacao(situacao);
        pessoa.setendereco(endereco);
        
        pessoa.setregistro(Integer.parseInt(jTCodigo.getText()));
        pessoa.setnome(jTNome.getText().toUpperCase());
        pessoa.setnome_mae(jTNomeMae.getText().toUpperCase());
  
        String md5 = Md5.setMd5(jTSenha.getText());      
        pessoa.setsenha(md5);
        pessoa.setcpf(jTCPF.getText());
        pessoa.setrg(Integer.parseInt(jTRG.getText()));
        pessoa.setcidade_natal(jTCidadeNatal.getText().toUpperCase());
        pessoa.setdata_nascto(new Date(jTDataNascimento.getText()));
        
        pessoaEAO.insertUpdate(endereco);
        pessoaEAO.insertUpdate(telefoneResidencial);
        pessoaEAO.insertUpdate(pessoa);
        
        TelefoneResidencialPessoa telefoneResidencialPessoa = new TelefoneResidencialPessoa();
        telefoneResidencialPessoa.setPessoa(pessoa);
        telefoneResidencialPessoa.setTelefone_residencial(telefoneResidencial);
        telefoneResidencialPessoaEAO.insertUpdate(telefoneResidencialPessoa);
                
        return pessoa;
    }

    private void salvarGraduacoes() {
        graduacaoEAO.bulkInsert(modelGraduacao.getGradoacoes());
    }

    private void salvarFuncoes() {
        funcaoEAO.bulkInsert(modelFuncao.getFuncoes());
    }

    private void salvarGraduacaoPessoa(Pessoa pessoa) {
        List<GraduacaoPessoa> list = new ArrayList<>();
        for(Graduacao graduacao : modelGraduacao.getGradoacoes()) {
            GraduacaoPessoa graduacaoPessoa = new GraduacaoPessoa();
            graduacaoPessoa.setPessoa(pessoa);
            graduacaoPessoa.setGraduacao(graduacao);
            list.add(graduacaoPessoa);
        }
        graduacaoPessoaEAO.bulkInsert(list);
    }

    private void salvarFuncaoPessoa(Pessoa pessoa) {
        List<FuncaoPessoa> list = new ArrayList<>();
        for(Funcao funcao : modelFuncao.getFuncoes()) {
            FuncaoPessoa funcaoPessoa = new FuncaoPessoa();
            funcaoPessoa.setPessoa(pessoa);
            funcaoPessoa.setfuncao(funcao);
            list.add(funcaoPessoa);
        }
        funcaoPessoaEAO.bulkInsert(list);
    }
       
    
//    private void setAutoValues() {
//        contratacao.setid_contratacao(1);
//        pessoa.setcontratacao(contratacao);
//        
//        atividade.setid_atividade(1);
//        pessoa.setatividade(atividade);
//                
//        situacao.setId_situacao(1);
//        pessoa.setsituacao(situacao);
//        
//        pessoa.setregistro(1234);
//        pessoa.setnome("TESTE");
//        pessoa.setnome_mae("TESTE");
//        pessoa.setsenha("TESTE");
//        pessoa.setcpf("TESTE");
//        pessoa.setrg(1234);
//        pessoa.setcidade_natal("TESTE");
//        pessoa.setdata_nascto(new Date("12/12/1992"));
//                
//        estado_civil.setId_estado_civil(1);
//        pessoa.setestadoCivil(estado_civil);
//        
//        sexo.setid_sexo(1);
//        pessoa.setsexo(sexo);
//             
//        estado.setId_estado(1);
//        pessoa.setestadoNatal(estado);
//                
//        endereco.setlogradouro("TESTE");
//        endereco.setrua("TESTE");
//        endereco.setnumero("1234");
//        endereco.setcidade("TESTE");
//        estado.setId_estado(1);
//        endereco.setestado(estado);
//        endereco.setbairro("TESTE"); 
//        endereco.setcep(new BigDecimal(12345678));
//        pessoa.setendereco(endereco);
//        
//        telefone_residencial.setTelefone_res("TESTE");
//
//        pessoa.settelefone_celular("TESTE");
//        pessoa.settelefone_celular_2("TESTE");
//        pessoa.setemail_principal("TESTE");
//        pessoa.setemail_adicional("TESTE");
//        pessoa.setoutros("TESTE");
//        
//        graduacao.setData_conclusao(new Date("12/12/1999"));
//        graduacao.setInstituicao("TESTE");
//        tipo_graduacao.setId_tipo_graduacao(1);
//        graduacao.setTipo_graduacao(tipo_graduacao);
//        
//        cargo.setid_cargo(1);
//        funcao.setCargo(cargo);
//        setor.setId_setor(1);
//        funcao.setSetor(setor);
//        sub_setor.setId_sub_setor(1);
//        funcao.setSubSetor(sub_setor);
//        turno.setId_turno(1);
//        funcao.setTurno(turno);
//
//        funcao_pessoa.setfuncao(funcao);
//        funcao_pessoa.setpessoa(pessoa);
//
//        graduacao_pessoa.setGraduacao(graduacao);
//        graduacao_pessoa.setPessoa(pessoa);
//
//        telefone_residencial_pessoa.setTelefone_residencial(telefone_residencial);
//        telefone_residencial_pessoa.setPessoa(pessoa);
//
//        pessoaEAO.insertUpdate(funcao);
//        pessoaEAO.insertUpdate(graduacao);
////        eao.bulkInsert(grad);
//        pessoaEAO.insertUpdate(endereco);
//        pessoaEAO.insertUpdate(telefone_residencial);
//        pessoaEAO.insertUpdate(pessoa); 
//        pessoaEAO.insertUpdate(funcao_pessoa);
//        pessoaEAO.insertUpdate(graduacao_pessoa);
//        pessoaEAO.insertUpdate(telefone_residencial_pessoa);
//        
//        pessoaEAO.fecharSessao();
//    }       

}
