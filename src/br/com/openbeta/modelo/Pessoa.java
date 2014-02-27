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

    Este programa é distribuído na esperança de que possa ser  útil, 
    mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer
    MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
    Licença Pública Geral GNU para maiores detalhes.

    Você deve ter recebido uma cópia da Licença Pública Geral GNU
    junto com este programa, se não, escreva para a Fundação do Software
    Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

package br.com.openbeta.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "pessoa")

public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "id_pessoa", unique = true, nullable = false)
    private     Integer             id_pessoa;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_endereco", nullable = false)
    private     Endereco            endereco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_natal", nullable = false)
    private     Estado              estadoNatal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atividade", nullable = false)
    private     Atividade           atividade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contratacao", nullable = false)
    private     Contratacao         contratacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacao", nullable = false)
    private     Situacao            situacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_civil", nullable = false)
    private     EstadoCivil         estadoCivil;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sexo", nullable = false)
    private     Sexo                sexo;

    @Column(name = "nome")
    private     String              nome;
    @Column(name = "registro")
    private     Integer             registro;
    @Column(name = "rg")
    private     Integer             rg;
    @Column(name = "cpf")
    private     String              cpf;
    @Temporal(TemporalType.DATE)
    @Column(name = "date", unique = true, nullable = false)
    private     Date                data_nascto;
    @Column(name = "nome_mae")
    private     String              nome_mae;
    @Column(name = "senha")
    private     String              senha;
    @Column(name = "email_principal")
    private     String              email_principal;
    @Column(name = "email_adicional")
    private     String              email_adicional;
    @Column(name = "telefone_celular")
    private     String              telefone_celular;
    @Column(name = "telefone_celular_2")
    private     String              telefone_celular_2;
    @Column(name = "cidade_natal")
    private     String              cidade_natal;
    @Column(name = "outros")
    private     String              outros;  
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "graduacao_pessoa")
    private     Set<GraduacaoPessoa> graduacao_pessoa           = new HashSet<GraduacaoPessoa>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "telefone_residencial_pessoa")
    private     Set<TelefoneResidencialPessoa> telefone_residencial_pessoa = new HashSet<TelefoneResidencialPessoa>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "funcao_pessoa")
    private     Set<FuncaoPessoa> funcao_pessoa              = new HashSet<FuncaoPessoa>(0);

    public Pessoa() {
    }
    
    //construtor
    public Pessoa(Integer id_pessoa) {
        this.id_pessoa = 0;
    }

    public Integer getid_pessoa() {
        return this.id_pessoa;
    }

    public void setid_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
    public Endereco getendereco() {
        return this.endereco;
    }

    public void setendereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Estado getestadoNatal() {
        return this.estadoNatal;
    }

    public void setestadoNatal(Estado estadoNatal) {
        this.estadoNatal = estadoNatal;
    }
    
    public Atividade getatividade() {
        return this.atividade;
    }

    public void setatividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    public Contratacao getcontratacao() {
        return this.contratacao;
    }

    public void setcontratacao(Contratacao contratacao) {
        this.contratacao = contratacao;
    }
    
    public Situacao getsituacao() {
        return this.situacao;
    }

    public void setsituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    public EstadoCivil getestadoCivil() {
        return this.estadoCivil;
    }

    public void setestadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public Sexo getsexo() {
        return this.sexo;
    }

    public void setsexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public String getcidade_natal() {
        return this.cidade_natal;
    }

    public void setcidade_natal(String cidade_natal) {
        this.cidade_natal = cidade_natal;
    }

    public String getcpf() {
        return this.cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Date getdata_nascto() {
        return this.data_nascto;
    }

    public void setdata_nascto(Date data_nascto) {
        this.data_nascto = data_nascto;
    }
    
    public String getemail_adicional() {
        return this.email_adicional;
    }

    public void setemail_adicional(String email_adicional) {
        this.email_adicional = email_adicional;
    }

    public String getemail_principal() {
        return this.email_principal;
    }

    public void setemail_principal(String email_principal) {
        this.email_principal = email_principal;
    }
    
        public String getnome() {
        return this.nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

        public String getnome_mae() {
        return this.nome_mae;
    }

    public void setnome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

        public String getoutros() {
        return this.outros;
    }

    public void setoutros(String outros) {
        this.outros = outros;
    }

        public Integer getregistro() {
        return this.registro;
    }

    public void setregistro(Integer registro) {
        this.registro = registro;
    }

        public Integer getrg() {
        return this.rg;
    }

    public void setrg(Integer rg) {
        this.rg = rg;
    }

    public String getsenha() {
        return this.senha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }

    public String gettelefone_celular_2() {
        return this.telefone_celular_2;
    }

    public void settelefone_celular_2(String telefone_celular_2) {
        this.telefone_celular_2 = telefone_celular_2;
    }

        public String gettelefone_celular() {
        return this.telefone_celular;
    }

    public void settelefone_celular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }

    public Set<GraduacaoPessoa> getgraduacao_pessoa() {
        return this.graduacao_pessoa;
    }

    public void setgraduacao_pessoa(Set<GraduacaoPessoa> graduacao_pessoa) {
        this.graduacao_pessoa = graduacao_pessoa;
    }

    public Set<TelefoneResidencialPessoa> gettelefone_residencial_pessoa() {
        return this.telefone_residencial_pessoa;
    }

    public void settelefone_residencial_pessoa(Set<TelefoneResidencialPessoa> telefone_residencial_pessoa) {
        this.telefone_residencial_pessoa = telefone_residencial_pessoa;
    }

    public Set<FuncaoPessoa> getfuncao_pessoa() {
        return this.funcao_pessoa;
    }

    public void setfuncao_pessoa(Set<FuncaoPessoa> funcoes_pessoas) {
        this.funcao_pessoa = funcao_pessoa;
    }

}
