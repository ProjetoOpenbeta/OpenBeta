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
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "endereco")

public class Endereco implements Serializable{
    
    private Integer         id_endereco;
    private String          logradouro;
    private String          rua;
    private String          numero;
    private String          bairro;
    private BigDecimal      cep;
    private String          cidade;
    private Estado          estado;
    private Set<Pessoa>     pessoas = new HashSet<>();
    
    
    
    
    public Endereco() {
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_endereco", unique = true, nullable = false)
    public Integer getid_endereco() {
        return this.id_endereco;
    }

    public void setid_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

    @Column(name = "logradouro")
    public String getlogradouro() {
        return this.logradouro;
    }

    public void setlogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    @Column(name = "rua")
    public String getrua() {
        return this.rua;
    }

    public void setrua(String rua) {
        this.rua = rua;
    }
    
    @Column(name = "numero")
    public String getnumero() {
        return this.numero;
    }

    public void setnumero(String numero) {
        this.numero = numero;
    }
    
    @Column(name = "bairro")
    public String getbairro() {
        return this.bairro;
    }

    public void setbairro(String bairro) {
        this.bairro = bairro;
    }
    
    @Column(name = "cep")
    public BigDecimal getcep() {
        return this.cep;
    }

    public void setcep(BigDecimal cep) {
        this.cep = cep;
    }
    
    @Column(name = "cidade")
    public String getcidade() {
        return this.cidade;
    }

    public void setcidade(String cidade) {
        this.cidade = cidade;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    public Estado getestado() {
        return this.estado;
    }

    public void setestado(Estado estado) {
        this.estado = estado;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
    public Set<Pessoa> getpessoa() {
        return this.pessoas;
    }
    
    public void setpessoa(Set<Pessoa> pessoa) {
        this.pessoas = pessoa;
    }
    
}
