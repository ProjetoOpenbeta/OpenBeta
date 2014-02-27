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
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "contratacao")

public class Contratacao implements Serializable {
    
    private Integer id_contratacao;
    private String  tipo_contratacao;
    private Set<Pessoa> pessoa = new HashSet<Pessoa>(0);
    
    public Contratacao() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_contratacao", unique = true, nullable = false)
    public Integer getid_contratacao() {
        return this.id_contratacao;
    }

    public void setid_contratacao(Integer id_contratacao) {
        this.id_contratacao = id_contratacao;
    }
    
    @Column(name = "tipo_contratacao")
    public String gettipo_contratacao() {
        return this.tipo_contratacao;
    }

    public void settipo_contratacao(String tipo_contratacao) {
        this.tipo_contratacao = tipo_contratacao;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contratacao")
    public Set<Pessoa> getpessoa() {
        return this.pessoa;
    }

    public void setpessoa(Set<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }
    
}
