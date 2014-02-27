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
@Table(name = "graduacao")

public class Graduacao implements Serializable {
    
    private Integer         id_graduacao;
    private Date            data_conclusao;
    private String          instituicao;
    private TipoGraduacao   tipo_graduacao;
    private Set<GraduacaoPessoa> graduacao_pessoas = new HashSet<GraduacaoPessoa>(0);
    
    public Graduacao() {
        
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_graduacao", unique = true, nullable = false)
    public Integer getid_graduacao() {
        return this.id_graduacao;
    }

    public void setid_graduacao(Integer id_graduacao) {
        this.id_graduacao = id_graduacao;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_conclusao", unique = true, nullable = false)
    public Date getData_conclusao() {
        return this.data_conclusao;
    }

    public void setData_conclusao(Date data_conclusao) {
        this.data_conclusao = data_conclusao;
    }
    
    @Column(name = "instituicao")
    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_graduacao", nullable = false)
    public TipoGraduacao getTipo_graduacao() {
        return this.tipo_graduacao;
    }

    public void setTipo_graduacao(TipoGraduacao tipo_graduacao) {
        this.tipo_graduacao = tipo_graduacao;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "graduacao")
    public Set<GraduacaoPessoa> getGraduacao_pessoas() {
        return this.graduacao_pessoas;
    }

    public void setGraduacao_pessoas(Set<GraduacaoPessoa> graduacao_pessoas) {
        this.graduacao_pessoas = graduacao_pessoas;
    }
    
}
