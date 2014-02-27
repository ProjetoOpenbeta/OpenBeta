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
import javax.persistence.*;

@Entity
@Table(name = "funcao_pessoa")

public class FuncaoPessoa implements Serializable {
    
    private Integer id_funcao_pessoa;
    private Funcao  funcao;
    private Pessoa  pessoa;
    
    public FuncaoPessoa() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_funcao_pessoa")
    public Integer getid_funcao_pessoa() {
        return this.id_funcao_pessoa;
    }

    public void setid_funcao_pessoa(Integer id_funcao_pessoa) {
        this.id_funcao_pessoa = id_funcao_pessoa;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcao", nullable = false)
    public Funcao getfuncao() {
        return this.funcao;
    }

    public void setfuncao(Funcao funcao) {
        this.funcao = funcao;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false)
    public Pessoa getpessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
