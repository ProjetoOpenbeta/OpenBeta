package br.com.openbeta.visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
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

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TelaConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTableConsulta;
	private JButton jBPesquisar;
	private JButton jBLimpar;
	private JButton jBFechar;
	private int tipoPesq1;
	private int tipoPesq2;
	
	
	private EAO                         pessoaEAO                       = new EAO(Pessoa.class);
    private EAO                         graduacaoEAO                    = new EAO(Graduacao.class);
    private EAO                         funcaoEAO                       = new EAO(Funcao.class);
    private EAO                         graduacaoPessoaEAO              = new EAO(GraduacaoPessoa.class);
    private EAO                         funcaoPessoaEAO                 = new EAO(FuncaoPessoa.class);
    private EAO                         telefoneResidencialPessoaEAO    = new EAO(TelefoneResidencialPessoa.class);
    private GraduacoesTableModel2       modelGraduacao                  = new GraduacoesTableModel2();
    private FuncoesTableModel2          modelFuncao                     = new FuncoesTableModel2();
    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtSetCurso;
    private JTextField txtSubDisciplina;
    private ButtonGroup bg1;
    private ButtonGroup bg2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaConsulta() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Cadastro");
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
		
		bg1 = new ButtonGroup();
		bg2 = new ButtonGroup();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
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
		
		jBPesquisar = new JButton("Pesquisar");
		jBPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (tipoPesq1){
					case 1:
						
					case 2:
						
					default:
						JOptionPane.showMessageDialog(null, "Pesquisa inválida por favor insira ou o código ou o nome do registro!");
				}
			}
		});
		jBPesquisar.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_jBPesquisar = new GridBagConstraints();
		gbc_jBPesquisar.fill = GridBagConstraints.BOTH;
		gbc_jBPesquisar.insets = new Insets(25, 10, 5, 10);
		gbc_jBPesquisar.gridx = 0;
		gbc_jBPesquisar.gridy = 0;
		panel.add(jBPesquisar, gbc_jBPesquisar);
		
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
		jBFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
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
		
		JPanel consulta = new JPanel();
		tabbedPane.addTab("Consulta", null, consulta, null);
		GridBagLayout gbl_consulta = new GridBagLayout();
		gbl_consulta.columnWidths = new int[]{0, 0};
		gbl_consulta.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_consulta.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_consulta.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		consulta.setLayout(gbl_consulta);
		
		JPanel panel_0 = new JPanel();
		GridBagConstraints gbc_panel_0 = new GridBagConstraints();
		gbc_panel_0.insets = new Insets(10, 10, 5, 10);
		gbc_panel_0.fill = GridBagConstraints.BOTH;
		gbc_panel_0.gridx = 0;
		gbc_panel_0.gridy = 0;
		consulta.add(panel_0, gbc_panel_0);
		GridBagLayout gbl_panel_0 = new GridBagLayout();
		gbc_panel_0.insets = new Insets(10, 10, 5, 10);
		gbl_panel_0.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_0.rowHeights = new int[]{0, 0};
		gbl_panel_0.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_0.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_0.setLayout(gbl_panel_0);
		
		JRadioButton rdbtnCodigo = new JRadioButton("C\u00F3digo");
		rdbtnCodigo.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setEditable(true);
				txtNome.setEditable(false);
				tipoPesq1 = 1;
			}
		});
		GridBagConstraints gbc_rdbtnCodigo = new GridBagConstraints();
		gbc_rdbtnCodigo.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnCodigo.gridx = 0;
		gbc_rdbtnCodigo.gridy = 0;
		panel_0.add(rdbtnCodigo, gbc_rdbtnCodigo);
		bg1.add(rdbtnCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";
				if(!caracteres.contains(arg0.getKeyChar()+"")){
					arg0.consume();
				}
			}
		});
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCodigo.setEditable(false);
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.insets = new Insets(0, 0, 0, 5);
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 0;
		panel_0.add(txtCodigo, gbc_txtCodigo);
		txtCodigo.setColumns(10);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setEditable(true);
				txtCodigo.setEditable(false);
				tipoPesq1 = 2;
			}
		});
		GridBagConstraints gbc_rdbtnNome = new GridBagConstraints();
		gbc_rdbtnNome.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNome.gridx = 2;
		gbc_rdbtnNome.gridy = 0;
		panel_0.add(rdbtnNome, gbc_rdbtnNome);
		bg1.add(rdbtnNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNome.setEditable(false);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 3;
		gbc_txtNome.gridy = 0;
		panel_0.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 10, 5, 10);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		consulta.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JRadioButton rdbtnSetorCurso = new JRadioButton("Setor ou Curso");
		rdbtnSetorCurso.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnSetorCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSetCurso.setEditable(true);
				txtSubDisciplina.setEditable(false);
				tipoPesq2 = 1;
			}
		});
		GridBagConstraints gbc_rdbtnSetorCurso = new GridBagConstraints();
		gbc_rdbtnSetorCurso.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnSetorCurso.gridx = 0;
		gbc_rdbtnSetorCurso.gridy = 0;
		panel_1.add(rdbtnSetorCurso, gbc_rdbtnSetorCurso);
		bg2.add(rdbtnSetorCurso);
		
		txtSetCurso = new JTextField();
		txtSetCurso.setFont(new Font("Arial", Font.PLAIN, 11));
		txtSetCurso.setEditable(false);
		txtSetCurso.setColumns(10);
		GridBagConstraints gbc_txtSetCurso = new GridBagConstraints();
		gbc_txtSetCurso.insets = new Insets(0, 0, 0, 5);
		gbc_txtSetCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSetCurso.gridx = 1;
		gbc_txtSetCurso.gridy = 0;
		panel_1.add(txtSetCurso, gbc_txtSetCurso);
		
		JRadioButton rdbtnSubsetorDisciplina = new JRadioButton("Sub-setor ou Disciplina");
		rdbtnSubsetorDisciplina.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnSubsetorDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSubDisciplina.setEditable(true);
				txtSetCurso.setEditable(false);
				tipoPesq2 = 2;
			}
		});
		GridBagConstraints gbc_rdbtnSubsetorDisciplina = new GridBagConstraints();
		gbc_rdbtnSubsetorDisciplina.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnSubsetorDisciplina.gridx = 2;
		gbc_rdbtnSubsetorDisciplina.gridy = 0;
		panel_1.add(rdbtnSubsetorDisciplina, gbc_rdbtnSubsetorDisciplina);
		bg2.add(rdbtnSubsetorDisciplina);
		
		txtSubDisciplina = new JTextField();
		txtSubDisciplina.setFont(new Font("Arial", Font.PLAIN, 11));
		txtSubDisciplina.setEditable(false);
		txtSubDisciplina.setColumns(10);
		GridBagConstraints gbc_txtSubDisciplina = new GridBagConstraints();
		gbc_txtSubDisciplina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubDisciplina.gridx = 3;
		gbc_txtSubDisciplina.gridy = 0;
		panel_1.add(txtSubDisciplina, gbc_txtSubDisciplina);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		consulta.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 10, 0, 10);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		consulta.add(panel_3, gbc_panel_3);
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
		
		jTableConsulta = new JTable();
		jTableConsulta.setFont(new Font("Arial", Font.PLAIN, 11));
		jTableConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF", "Telefone 1", "Telefone 2", "Outros", "Tipo de gradua\u00E7\u00E3o", "Institui\u00E7\u00E3o/Curso", "Data de conclus\u00E3o"
			}
		));
		jTableConsulta.getColumnModel().getColumn(0).setPreferredWidth(49);
		jTableConsulta.getColumnModel().getColumn(1).setPreferredWidth(184);
		scrollPane.setViewportView(jTableConsulta);
		
		/////////////////////////////////////////////////////
		
	}
	
}
