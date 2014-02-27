/*
 Copyright 2013 Vinicius Vasco Pedron, Luiz Gustavo Royer, Gelson Lemes,
    JoÃ£o Ricardo Oliveira, HÃ©lio Campos, Maycon Willian Nunes Prestes
*/

/*
   Este arquivo Ã© parte do programa OpenBeta

    OpenBeta Ã© um software livre; vocÃª pode redistribuÃ­-lo e/ou 
    modificÃ¡-lo dentro dos termos da LicenÃ§a PÃºblica Geral GNU como 
    publicada pela FundaÃ§Ã£o do Software Livre (FSF); na versÃ£o 2 da 
    LicenÃ§a, ou (na sua opiniÃ£o) qualquer versÃ£o.

    Este programa Ã© distribuÃ­do na esperanÃ§a de que possa ser  Ãºtil, 
    mas SEM NENHUMA GARANTIA; sem uma garantia implÃ­cita de ADEQUAÃ‡ÃƒO a qualquer
    MERCADO ou APLICAÃ‡ÃƒO EM PARTICULAR. Veja a
    LicenÃ§a PÃºblica Geral GNU para maiores detalhes.

    VocÃª deve ter recebido uma cÃ³pia da LicenÃ§a PÃºblica Geral GNU
    junto com este programa, se nÃ£o, escreva para a FundaÃ§Ã£o do Software
    Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

package br.com.openbeta.visao;

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

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

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
 
/**
 *
 * @author gelson / vinicius
 */

public class TCadastro extends javax.swing.JFrame {
    
    private EAO                         pessoaEAO                       = new EAO(Pessoa.class);
    private EAO                         graduacaoEAO                    = new EAO(Graduacao.class);
    private EAO                         funcaoEAO                       = new EAO(Funcao.class);
    private EAO                         graduacaoPessoaEAO              = new EAO(GraduacaoPessoa.class);
    private EAO                         funcaoPessoaEAO                 = new EAO(FuncaoPessoa.class);
    private EAO                         telefoneResidencialPessoaEAO    = new EAO(TelefoneResidencialPessoa.class);
    private GraduacoesTableModel2       modelGraduacao                  = new GraduacoesTableModel2();
    private FuncoesTableModel2          modelFuncao                     = new FuncoesTableModel2();
//    private Pessoa                      pessoa                          = new Pessoa();
//    private Situacao                    situacao                        = new Situacao();
//    private EstadoCivil                 estado_civil                    = new EstadoCivil();
//    private Sexo                        sexo                            = new Sexo();
//    private Estado                      estado                          = new Estado();
//    private Endereco                    endereco                        = new Endereco();
//    private TelefoneResidencial         telefone_residencial            = new TelefoneResidencial();
//    private Atividade                   atividade                       = new Atividade();
//    private Contratacao                 contratacao                     = new Contratacao();
//    private TipoGraduacao               tipo_graduacao                  = new TipoGraduacao(); 
//    private Cargo                       cargo                           = new Cargo();
//    private Setor                       setor                           = new Setor();
//    private SubSetor                    sub_setor                       = new SubSetor();
//    private Turno                       turno                           = new Turno();
//    private TelefoneResidencialPessoa   telefone_residencial_pessoa     = new TelefoneResidencialPessoa();
//    private List<GraduacaoPessoa>       graduacao_pessoa                = new ArrayList<GraduacaoPessoa>();
//    private FuncaoPessoa                funcao_pessoa                   = new FuncaoPessoa();
//    private int i = 0;
//    private int j = 0;
    
    public TCadastro() {
        initComponents();
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
                }           
            }
         });
        jBAdicionarGraduacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adicionaGraduacao();
                } catch (ParseException ex) {
                    Logger.getLogger(TCadastro.class.getName()).log(Level.SEVERE, null, ex);
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
            JOptionPane.showMessageDialog(null, "Informe modo de contrataÃ§Ã£o", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jComboBoxSituacao.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(null, "Informe situaÃ§Ã£o", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTNomeMae.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome da mÃ£e", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma senha", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (jTCPF1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o CPF", "ERRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (ValidaCPF.isCPF(jTCPF1.getText().toString()) == false) {
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
/*    
      if (evt.getKeyCode() == 10) {
            if (cpf.equals("")) { // se campo CPF estiver em branco.
                java.awt.Toolkit.getDefaultToolkit().beep();  //Beep
                JOptionPane.showMessageDialog(null, "Informe um CPF vÃ¡lido", "ERRO", JOptionPane.ERROR_MESSAGE);

            } else if (evt.getKeyCode() == 10) {// senÃ£o, verifica se CPF informado Ã© valido.                  

                usuario = jTCpfLogin.getText();
                cpfCorreto = ValidaCPF.isCPF(usuario);
                if (cpfCorreto) {
                    jTSenha.requestFocus(true); //se correto passa o foco para o campo SENHA.
                    
*/
//    private void setValues() {
//        Pessoa pessoa = new Pessoa();
//
//        Contratacao contratacao = new Contratacao();
//        contratacao.setid_contratacao(jComboBoxContratacao.getSelectedIndex());
//        
//        Atividade atividade = new Atividade();
//        atividade.setid_atividade(1);
//        
//        Situacao situacao = new Situacao();
//        situacao.setId_situacao(jComboBoxSituacao.getSelectedIndex());
//            
//        EstadoCivil estadoCivil = new EstadoCivil();
//        estadoCivil.setId_estado_civil(jComboBoxEstadoCivil.getSelectedIndex());
//        
//        Sexo sexo = new Sexo();
//        sexo.setid_sexo(jComboBoxSexo.getSelectedIndex());
//             
//        Estado estadoNatal = new Estado();
//        estadoNatal.setId_estado(jComboBoxUFNatal.getSelectedIndex());
//                
//        Estado estadoEndereco = new Estado();
//        estadoEndereco.setId_estado(jComboBoxUFEndereco.getSelectedIndex());
//        
//        Endereco endereco = new Endereco();
//        endereco.setlogradouro(jTEnderecoLogradouro.getText().toUpperCase());
//        endereco.setrua(jTEnderecoRua.getText().toUpperCase());
//        endereco.setnumero(jTEnderecoNumero.getText());
//        endereco.setcidade(jTEnderecoCidade.getText().toUpperCase());
//        endereco.setestado(estadoEndereco);
//        endereco.setbairro(jTEnderecoBairro.getText().toUpperCase()); 
//        endereco.setcep(new BigDecimal(jTEnderecoCEP.getText()));
//
//        TelefoneResidencial telefoneResidencial = new TelefoneResidencial();
//        telefoneResidencial.setTelefone_res(jTTelefoneResidencial.getText());
//
//        pessoa.settelefone_celular(jTCelular1.getText());
//        pessoa.settelefone_celular_2(jTCelular2.getText());
//        pessoa.setemail_principal(jTEmail1.getText());
//        pessoa.setemail_adicional(jTEmail2.getText());
//        pessoa.setoutros(jTExtras.getText().toUpperCase());
//        pessoa.setestadoNatal(estadoNatal);
//        pessoa.setestadoCivil(estadoCivil);
//        pessoa.setsexo(sexo);
//        pessoa.setatividade(atividade);
//        pessoa.setcontratacao(contratacao);
//        pessoa.setsituacao(situacao);
//        pessoa.setendereco(endereco);
//        
//        pessoa.setregistro(Integer.parseInt(jTCodigo.getText()));
//        pessoa.setnome(jTNome.getText().toUpperCase());
//        pessoa.setnome_mae(jTNomeMae.getText().toUpperCase());
//  
//        String md5 = Md5.setMd5(jTSenha.getText());      
//        pessoa.setsenha(md5);
//        pessoa.setcpf(jTCPF1.getText());
//        pessoa.setrg(Integer.parseInt(jTRG.getText()));
//        pessoa.setcidade_natal(jTCidadeNatal.getText().toUpperCase());
//        pessoa.setdata_nascto(new Date(jTDataNascimento.getText()));
//        
//        for(Graduacao graduacao : grad) {
//            GraduacaoPessoa graduacao_pessoa = new GraduacaoPessoa();
//            graduacao_pessoa.setGraduacao(graduacao);
//            graduacao_pessoa.setPessoa(pessoa);            
//        }
//       
//        for (Funcao f : modelFuncao.getFuncaoLista()) {
//            funcao_pessoa = new FuncaoPessoa();
//
//            
//            funcao_pessoa.setfuncao(funcao);
//            funcao_pessoa.setpessoa(pessoa);
//            fp.add(funcao_pessoa);
//              
//        }
//        pessoa.setfuncao_pessoa(fp);
//        
//        graduacao.setData_conclusao(new Date(jTDataConclusaoGraduacao.getText()));
//        graduacao.setInstituicao(jTNomeInstituicao1.getText().toUpperCase());
//        tipo_graduacao.setId_tipo_graduacao(jComboBoxGraduacao.getSelectedIndex());
//        graduacao.setTipo_graduacao(tipo_graduacao);
//        
//        cargo.setid_cargo(jComboBoxFuncao.getSelectedIndex());
//        funcao.setCargo(cargo);
//        setor.setId_setor(jComboBoxSetor.getSelectedIndex());
//        funcao.setSetor(setor);
//        sub_setor.setId_sub_setor(jComboBoxSubSetor.getSelectedIndex());
//        funcao.setSubSetor(sub_setor);
//        turno.setId_turno(jComboBoxTurno.getSelectedIndex());
//        funcao.setTurno(turno);
//
//        funcao_pessoa.setfuncao(funcao);
//        funcao_pessoa.setpessoa(pessoa);
//
//        graduacao_pessoa.setGraduacao(graduacao);
//        graduacao_pessoa.setPessoa(pessoa);
//
//        telefone_residencial_pessoa.setTelefone_residencial(telefoneResidencial);
//        telefone_residencial_pessoa.setPessoa(pessoa);
//
////        eao.insertUpdate(funcao);
//        pessoaEAO.bulkInsert(func);
////        eao.insertUpdate(graduacao);
//        pessoaEAO.bulkInsert(grad);
//        pessoaEAO.insertUpdate(endereco);
//        pessoaEAO.insertUpdate(telefoneResidencial);
//        pessoaEAO.insertUpdate(pessoa); 
//        pessoaEAO.insertUpdate(funcao_pessoa);
//        pessoaEAO.insertUpdate(graduacao_pessoa);
//        pessoaEAO.insertUpdate(telefone_residencial_pessoa);
//        
//        pessoaEAO.fecharSessao();
//    }
    
    private void salvar() {
        Pessoa pessoa = salvarPessoa();
        salvarGraduacoes();
        salvarFuncoes();
        salvarGraduacaoPessoa(pessoa);
        salvarFuncaoPessoa(pessoa);
    }
    
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
        pessoa.setcpf(jTCPF1.getText());
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

    public static void main(String args[]) throws UnsupportedLookAndFeelException {

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    javax.swing.UIManager.setLookAndFeel(new MetalLookAndFeel());
                    break;
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TCadastro().setVisible(true);
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jBGravar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jBFechar2 = new javax.swing.JButton();
        jTabprof1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jTCodigo = new javax.swing.JTextField();
        jTRG = new javax.swing.JTextField();
        jTNome = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox();
        jLabel144 = new javax.swing.JLabel();
        jTCelular2 = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxEstadoCivil = new javax.swing.JComboBox();
        jTSenha = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jTCidadeNatal = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        jComboBoxUFNatal = new javax.swing.JComboBox();
        jLabel151 = new javax.swing.JLabel();
        jTDataNascimento = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jTEnderecoRua = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jTEnderecoLogradouro = new javax.swing.JTextField();
        jTEnderecoNumero = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jTEnderecoBairro = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jTEnderecoCidade = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jTEnderecoCEP = new javax.swing.JTextField();
        jComboBoxUFEndereco = new javax.swing.JComboBox();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabel157 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jTTelefoneResidencial = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jTEmail1 = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jTEmail2 = new javax.swing.JTextField();
        jTCelular1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTExtras = new javax.swing.JTextPane();
        jLabel163 = new javax.swing.JLabel();
        jComboBoxContratacao = new javax.swing.JComboBox();
        jLabel164 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jTNomeMae = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        jTCPF1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jTDataConclusaoGraduacao = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jComboBoxGraduacao = new javax.swing.JComboBox();
        jBAdicionarGraduacao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGraduacoes = new javax.swing.JTable();
        jTNomeInstituicao1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jComboBoxSubSetor = new javax.swing.JComboBox();
        jBAdicionarFuncao = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFuncoes = new javax.swing.JTable();
        jLabel165 = new javax.swing.JLabel();
        jComboBoxFuncao = new javax.swing.JComboBox();
        jLabel166 = new javax.swing.JLabel();
        jComboBoxSetor = new javax.swing.JComboBox();
        jLabel167 = new javax.swing.JLabel();
        jComboBoxTurno = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(155, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jPanel10.setBackground(new java.awt.Color(0, 0, 102));
        jPanel10.setForeground(new java.awt.Color(0, 0, 102));
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 800));

        jBGravar.setBackground(new java.awt.Color(204, 204, 204));
        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });
        jBGravar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBGravarFocusGained(evt);
            }
        });
        jBGravar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBGravarKeyPressed(evt);
            }
        });

        jBLimpar.setBackground(new java.awt.Color(204, 204, 204));
        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });
        jBLimpar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBLimparFocusGained(evt);
            }
        });
        jBLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBLimparKeyPressed(evt);
            }
        });

        jBFechar2.setBackground(new java.awt.Color(204, 204, 204));
        jBFechar2.setText("Fechar");
        jBFechar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFechar2ActionPerformed(evt);
            }
        });
        jBFechar2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBFechar2FocusGained(evt);
            }
        });
        jBFechar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBFechar2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(jBFechar2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBFechar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabprof1.setForeground(new java.awt.Color(0, 0, 51));
        jTabprof1.setMaximumSize(new java.awt.Dimension(800, 800));
        jTabprof1.setMinimumSize(new java.awt.Dimension(800, 800));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setAlignmentX(150.0F);
        jPanel6.setFocusCycleRoot(true);
        jPanel6.setMaximumSize(new java.awt.Dimension(847, 847));
        jPanel6.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel6.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCodigojTextField11ActionPerformed(evt);
            }
        });
        jPanel6.add(jTCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 100, -1));

        jTRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTRGActionPerformed(evt);
            }
        });
        jPanel6.add(jTRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 100, -1));

        jTNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeActionPerformed(evt);
            }
        });
        jPanel6.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 610, -1));

        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel137.setText("* CÃ³digo:");
        jPanel6.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 20));

        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel138.setText("* RG:");
        jPanel6.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 30, 20));

        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel141.setText("* Senha:");
        jLabel141.setToolTipText("");
        jPanel6.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 20));

        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel142.setText("* SituaÃ§Ã£o:");
        jPanel6.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 70, 20));

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "EM EXERCÃ�CIO", "READAPTADO", "AFASTADO DA FUNÃ‡ÃƒO", "LICENÃ‡A MÃ‰DICA", "LICENÃ‡A PRÃŠMIO" }));
        jComboBoxSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSituacaoActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 170, -1));

        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel144.setText("* Celular ObrigatÃ³rio:");
        jPanel6.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 110, 20));
        jPanel6.add(jTCelular2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 220, -1));

        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel148.setText(" Extras:");
        jPanel6.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 50, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("* Estado Civil:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 80, 20));

        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "SOLTEIRO", "CASADO", "DIVORCIADO", "VIÃšVO" }));
        jComboBoxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoCivilActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 90, -1));

        jTSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSenhaActionPerformed(evt);
            }
        });
        jPanel6.add(jTSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 270, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("*   Campos de preenchimento obrigatÃ³rio");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, -1, 20));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "  Natual de  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel149.setText("* Cidade:");

        jTCidadeNatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCidadeNataljTextField4ActionPerformed(evt);
            }
        });

        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel150.setText(" * UF:");
        jLabel150.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBoxUFNatal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));
        jComboBoxUFNatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUFNataljComboBox3ActionPerformed(evt);
            }
        });

        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel151.setText("* Data de Nascimento:");

        jTDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDataNascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTCidadeNatal, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel150)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxUFNatal, 0, 69, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jLabel151)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCidadeNatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel150)
                    .addComponent(jComboBoxUFNatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel149)
                    .addComponent(jTDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 680, 60));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "  EndereÃ§o  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        jLabel153.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel153.setText("* EndereÃ§o:");

        jTEnderecoRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEnderecoRuajTextField4ActionPerformed(evt);
            }
        });

        jLabel154.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel154.setText("* UF:");
        jLabel154.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel155.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel155.setText("* Logradouro:");

        jTEnderecoLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEnderecoLogradouroActionPerformed(evt);
            }
        });

        jTEnderecoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEnderecoNumeroActionPerformed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("* NÂº:");

        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel139.setText("* Bairro:");

        jTEnderecoBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEnderecoBairroActionPerformed(evt);
            }
        });

        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel136.setText("* Cidade:");

        jTEnderecoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEnderecoCidadeActionPerformed(evt);
            }
        });

        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel143.setText("* CEP:");

        jTEnderecoCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEnderecoCEPActionPerformed(evt);
            }
        });

        jComboBoxUFEndereco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));
        jComboBoxUFEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUFEnderecojComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel155)
                    .addComponent(jLabel136)
                    .addComponent(jLabel139))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTEnderecoCidade)
                        .addComponent(jTEnderecoBairro)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addGap(155, 155, 155)
                            .addComponent(jTEnderecoRua, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jTEnderecoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel153)))
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTEnderecoNumero))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel143)
                            .addComponent(jLabel154))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTEnderecoCEP)
                            .addComponent(jComboBoxUFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTEnderecoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel153)
                    .addComponent(jTEnderecoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEnderecoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEnderecoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel154)
                    .addComponent(jComboBoxUFEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEnderecoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEnderecoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 680, 120));

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "MASCULINO", "FEMININO" }));
        jPanel6.add(jComboBoxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 100, -1));

        jLabel157.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel157.setText("* Sexo:");
        jPanel6.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 40, 20));

        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel146.setText("* ContrataÃ§Ã£o:");
        jPanel6.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 20));

        jTTelefoneResidencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTelefoneResidencialActionPerformed(evt);
            }
        });
        jPanel6.add(jTTelefoneResidencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 220, 20));

        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel147.setText(" Celular Opcional:");
        jPanel6.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 90, 20));

        jLabel156.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel156.setText("* E-Mail ObrigatÃ³rio:");
        jPanel6.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 110, 20));

        jTEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEmail1ActionPerformed(evt);
            }
        });
        jPanel6.add(jTEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 560, -1));

        jLabel158.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel158.setText(" E-Mail Opcional:");
        jPanel6.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 110, 20));
        jPanel6.add(jTEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 560, -1));

        jTCelular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCelular1ActionPerformed(evt);
            }
        });
        jPanel6.add(jTCelular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 220, -1));

        jScrollPane1.setViewportView(jTExtras);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 560, 90));

        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel163.setText(" Telefone Residencial:");
        jPanel6.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, 20));

        jComboBoxContratacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "ESTADO", "PSS" }));
        jComboBoxContratacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxContratacaojComboBox3ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxContratacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 130, 20));

        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel164.setText("* Nome MÃ£e:");
        jPanel6.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 20));

        jLabel168.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel168.setText("* Nome:");
        jPanel6.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, 20));

        jTNomeMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeMaeActionPerformed(evt);
            }
        });
        jPanel6.add(jTNomeMae, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 610, -1));

        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel145.setText("* CPF:");
        jLabel145.setToolTipText("");
        jPanel6.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 20));

        jTCPF1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTCPF1ComponentAdded(evt);
            }
        });
        jTCPF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCPF1ActionPerformed(evt);
            }
        });
        jPanel6.add(jTCPF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 100, -1));

        jTabprof1.addTab("Dados Pessoais", jPanel6);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel159.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel159.setText("* GraduaÃ§Ã£o:");
        jPanel8.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 20));

        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel160.setText("* InstituiÃ§Ã£o:");
        jPanel8.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 20));

        jTDataConclusaoGraduacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDataConclusaoGraduacaoActionPerformed(evt);
            }
        });
        jPanel8.add(jTDataConclusaoGraduacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 100, -1));

        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel161.setText("* Data de ConclusÃ£o:");
        jPanel8.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 110, 20));

        jComboBoxGraduacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "BACHARELADO", "LICENCIATURA", "TECNÃ“LOGO", "PÃ“S-GRADUAÃ‡ÃƒO", "MESTRADO", "DOUTORADO" }));
        jComboBoxGraduacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGraduacaoActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBoxGraduacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 140, -1));

        jBAdicionarGraduacao.setBackground(new java.awt.Color(204, 204, 204));
        jBAdicionarGraduacao.setText("Adicionar");
        jBAdicionarGraduacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarGraduacaoActionPerformed(evt);
            }
        });
        jBAdicionarGraduacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBAdicionarGraduacaoFocusGained(evt);
            }
        });
        jBAdicionarGraduacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBAdicionarGraduacaoKeyPressed(evt);
            }
        });
        jPanel8.add(jBAdicionarGraduacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, 30));

        jTableGraduacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableGraduacoes.setRowHeight(25);
        jTableGraduacoes.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTableGraduacoes);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 680, 480));

        jTNomeInstituicao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeInstituicao1ActionPerformed(evt);
            }
        });
        jPanel8.add(jTNomeInstituicao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 610, -1));

        jTabprof1.addTab("GraduaÃ§Ãµes", jPanel8);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel162.setText("* FunÃ§Ã£o:");
        jPanel9.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        jComboBoxSubSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "ARTE", "CIÃŠNCIAS", "EDUCAÃ‡ÃƒO FÃ�SICA", "GEOGRAFIA", "HISTÃ“RIA", "LÃ�NGUA PORTUGUESA", "MATEMÃ�TICA", "L.E.M - INGLÃŠS", "ENSINO RELIGIOSO", "BIOLOGIA", "FILOSOFIA", "FÃ�SICA", "QUÃ�MICA", "L.E.M - ESPANHOL", "ADMINISTRÃ‡ÃƒO DE PROD. E MAT.", "ADM. FINANCEIRA E ORÃ‡AMENTÃ�RIA", "COMPORTAMENTO ORGANIZACIONAL", "CONTABILIDADE", "ELABORAÃ‡ÃƒO E ANÃ�LISE PROJETOS", "ESTATÃ�STICA APLICADA", "FUNDAMENTOS DO TRABALHO", "GESTÃƒO DE PESSOAS", "INFORMÃ�TICA", "INTRODUÃ‡ÃƒO Ã€ ECONOMIA", "MARKETING", "MATEMÃ�TICA FINANCEIRA", "NOÃ‡Ã•ES DE DIREITO - LEG. TRABALHO", "ORGANIZAÃ‡ÃƒO, SISTEMAS E MÃ‰TODOS", "PRÃ�TICA DISCURSIVA E LINGUAGEM", "TEORIA GERAL DA ADMINISTRAÃ‡ÃƒO", "ADMINISTRAÃ‡ÃƒO", "CERIMONIAL E PROTOCOLO", "ESPANHOL TÃ‰CNICO", "INGLÃŠS TÃ‰CNICO", "INTRODUÃ‡ÃƒO Ã€S FINANÃ‡AS", "METODOLOGIA CIENTÃ�FICA", "NOÃ‡Ã•ES DE DIR. E LEG. SOC. TRAB.", "PSICOLOGIA ORGANIZACIONAL ", "REDAÃ‡ÃƒO EMPRESARIAL", "TÃ‰CNICAS DE SECRETARIADO", "ANÃ�LISE DE PROJETOS", "BANCO DE DADOS", "FUND. E ARQUITETURA DE COMPUT.", "INFORMÃ�TICA INSTRUMENTAL", "INTERNET E PROGRAMAÃ‡ÃƒO WEB", "LINGUAGEM DE PROGRAMAÃ‡ÃƒO", "MATEMÃ�TICA APLICADA", "REDES E SISTEMAS OPERACIONAIS", "SUPORTE TÃ‰CNICO", "LÃ�NGUA PORT. E LITERATURA", "ITALIANO - CELEM", "ESPANHOL - CELEM", "FRANCÃŠS - CELEM", "SALA DE RECURSOS", "SALA DE APOIO", "HORA TREINAMENTO", "FUTSAL E ATLETISMO", "TREINAMENTO ESPORTIVO", "TEATRO" }));
        jComboBoxSubSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSubSetorActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBoxSubSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 280, -1));

        jBAdicionarFuncao.setBackground(new java.awt.Color(204, 204, 204));
        jBAdicionarFuncao.setText("Adicionar");
        jBAdicionarFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarFuncaoActionPerformed(evt);
            }
        });
        jBAdicionarFuncao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBAdicionarFuncaoFocusGained(evt);
            }
        });
        jBAdicionarFuncao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBAdicionarFuncaoKeyPressed(evt);
            }
        });
        jPanel9.add(jBAdicionarFuncao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, 30));

        jTableFuncoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableFuncoes.setRowHeight(25);
        jTableFuncoes.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(jTableFuncoes);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 680, 480));

        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel165.setText("* Sub-setor ou Disciplina:");
        jPanel9.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 140, 20));

        jComboBoxFuncao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "PROFESSOR", "FUNCIONÃ�RIO", "PEDAGOGIA" }));
        jComboBoxFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFuncaoActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBoxFuncao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 150, -1));

        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel166.setText("* Setor ou Curso: ");
        jPanel9.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 100, 20));

        jComboBoxSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "ENSINO FUNDAMENTAL", "ENSINO MÃ‰DIO", "TÃ‰C. SUBSEQUENTE - ADMINISTRAÃ‡ÃƒO ", "TÃ‰C. SUBSEQUENTE - SECRETARIADO ", "TÃ‰C. SUBSEQUENTE - INFORMÃ�TICA ", "TÃ‰C. INTEGRAL - ADMINISTRAÃ‡ÃƒO", "TÃ‰C. INTEGRAL - INFORMÃ�TICA", "CELEM", "SALA DE RECURSOS", "SALA DE APOIO", "ESPORTE E LAZER", "AULAS ESPECIALIZADAS", "ARTE E CULTURA" }));
        jComboBoxSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSetorActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBoxSetor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 280, 20));

        jLabel167.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel167.setText("* Turno:");
        jPanel9.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 20));

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "MATUTINO", "VERPERTINO", "NOTURNO" }));
        jComboBoxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurnoActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBoxTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 150, -1));

        jTabprof1.addTab("FunÃ§Ãµes", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabprof1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jTabprof1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCodigojTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCodigojTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCodigojTextField11ActionPerformed

    private void jTRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTRGActionPerformed

    private void jTNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeActionPerformed

    private void jComboBoxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoCivilActionPerformed

    private void jTEnderecoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEnderecoNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoNumeroActionPerformed

    private void jTCidadeNataljTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCidadeNataljTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCidadeNataljTextField4ActionPerformed

    private void jComboBoxUFNataljComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUFNataljComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUFNataljComboBox3ActionPerformed

    private void jTDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataNascimentoActionPerformed

    private void jTEnderecoRuajTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEnderecoRuajTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoRuajTextField4ActionPerformed

    private void jTEnderecoLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEnderecoLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoLogradouroActionPerformed

    private void jComboBoxUFEnderecojComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUFEnderecojComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUFEnderecojComboBox3ActionPerformed

    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jBGravarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBGravarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBGravarFocusGained

    private void jBGravarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBGravarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBGravarKeyPressed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        TCadastro.this.dispose();
        new TCadastro().setVisible(true);
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBLimparFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBLimparFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBLimparFocusGained

    private void jBLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBLimparKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBLimparKeyPressed

    private void jTDataConclusaoGraduacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDataConclusaoGraduacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataConclusaoGraduacaoActionPerformed

    private void jComboBoxGraduacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGraduacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGraduacaoActionPerformed

    private void jBAdicionarGraduacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarGraduacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAdicionarGraduacaoActionPerformed

    private void jBAdicionarGraduacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBAdicionarGraduacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAdicionarGraduacaoFocusGained

    private void jBAdicionarGraduacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBAdicionarGraduacaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAdicionarGraduacaoKeyPressed

    private void jComboBoxSubSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSubSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubSetorActionPerformed

    private void jBAdicionarFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAdicionarFuncaoActionPerformed

    private void jBAdicionarFuncaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBAdicionarFuncaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAdicionarFuncaoFocusGained

    private void jBAdicionarFuncaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBAdicionarFuncaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAdicionarFuncaoKeyPressed

    private void jComboBoxFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFuncaoActionPerformed

    private void jComboBoxSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSetorActionPerformed

    private void jComboBoxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTurnoActionPerformed

    private void jComboBoxSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSituacaoActionPerformed

    private void jBFechar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFechar2ActionPerformed
        this.dispose();       
    }//GEN-LAST:event_jBFechar2ActionPerformed

    private void jBFechar2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBFechar2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBFechar2FocusGained

    private void jBFechar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFechar2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBFechar2KeyPressed

    private void jTEnderecoBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEnderecoBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoBairroActionPerformed

    private void jTEnderecoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEnderecoCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoCidadeActionPerformed

    private void jTEnderecoCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEnderecoCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoCEPActionPerformed

    private void jTTelefoneResidencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTelefoneResidencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTelefoneResidencialActionPerformed

    private void jTCelular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCelular1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCelular1ActionPerformed

    private void jTEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmail1ActionPerformed

    private void jComboBoxContratacaojComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxContratacaojComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxContratacaojComboBox3ActionPerformed

    private void jTNomeMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeMaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeMaeActionPerformed

    private void jTSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSenhaActionPerformed

    private void jTCPF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCPF1ActionPerformed
        ///
    }//GEN-LAST:event_jTCPF1ActionPerformed
    
    private void jTNomeInstituicao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeInstituicao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeInstituicao1ActionPerformed

    private void jTCPF1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTCPF1ComponentAdded

        ///
    }//GEN-LAST:event_jTCPF1ComponentAdded
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdicionarFuncao;
    private javax.swing.JButton jBAdicionarGraduacao;
    private javax.swing.JButton jBFechar2;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JComboBox jComboBoxContratacao;
    private javax.swing.JComboBox jComboBoxEstadoCivil;
    private javax.swing.JComboBox jComboBoxFuncao;
    private javax.swing.JComboBox jComboBoxGraduacao;
    private javax.swing.JComboBox jComboBoxSetor;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JComboBox jComboBoxSituacao;
    private javax.swing.JComboBox jComboBoxSubSetor;
    private javax.swing.JComboBox jComboBoxTurno;
    private javax.swing.JComboBox jComboBoxUFEndereco;
    private javax.swing.JComboBox jComboBoxUFNatal;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTCPF1;
    private javax.swing.JTextField jTCelular1;
    private javax.swing.JTextField jTCelular2;
    private javax.swing.JTextField jTCidadeNatal;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JTextField jTDataConclusaoGraduacao;
    private javax.swing.JTextField jTDataNascimento;
    private javax.swing.JTextField jTEmail1;
    private javax.swing.JTextField jTEmail2;
    private javax.swing.JTextField jTEnderecoBairro;
    private javax.swing.JTextField jTEnderecoCEP;
    private javax.swing.JTextField jTEnderecoCidade;
    private javax.swing.JTextField jTEnderecoLogradouro;
    private javax.swing.JTextField jTEnderecoNumero;
    private javax.swing.JTextField jTEnderecoRua;
    private javax.swing.JTextPane jTExtras;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTNomeInstituicao1;
    private javax.swing.JTextField jTNomeMae;
    private javax.swing.JTextField jTRG;
    private javax.swing.JTextField jTSenha;
    private javax.swing.JTextField jTTelefoneResidencial;
    private javax.swing.JTable jTableFuncoes;
    private javax.swing.JTable jTableGraduacoes;
    private javax.swing.JTabbedPane jTabprof1;
    // End of variables declaration//GEN-END:variables

}
